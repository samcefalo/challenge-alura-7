package me.samcefalo.challenge.alura.adapters.in.destiny.controller;

import me.samcefalo.challenge.alura.adapters.in.destiny.controller.mapper.DestinyMapper;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.request.DestinyPriceRequest;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.request.DestinyPriceRequestMother;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.request.DestinyRequest;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.request.DestinyRequestMother;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.response.DestinyResponse;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.response.DestinyResponseMother;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import me.samcefalo.challenge.alura.application.ports.in.destiny.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DestinyControllerTest {

    private DestinyMapper destinyMapper;
    private FindDestinyByIdInputPort findDestinyByIdInputPort;
    private FindDestinyByNameInputPort findDestinyByNameInputPort;
    private InsertDestinyInputPort insertDestinyInputPort;
    private UpdateDestinyInputPort updateDestinyInputPort;
    private DeleteDestinyByIdInputPort deleteDestinyByIdInputPort;
    private UpdateDestinyPriceInputPort updateDestinyPriceInputPort;
    private DestinyController destinyController;

    @BeforeEach
    void setup() {
        destinyMapper = mock(DestinyMapper.class);
        findDestinyByIdInputPort = mock(FindDestinyByIdInputPort.class);
        findDestinyByNameInputPort = mock(FindDestinyByNameInputPort.class);
        insertDestinyInputPort = mock(InsertDestinyInputPort.class);
        updateDestinyInputPort = mock(UpdateDestinyInputPort.class);
        deleteDestinyByIdInputPort = mock(DeleteDestinyByIdInputPort.class);
        updateDestinyPriceInputPort = mock(UpdateDestinyPriceInputPort.class);
        destinyController = new DestinyController(destinyMapper, findDestinyByIdInputPort, findDestinyByNameInputPort, insertDestinyInputPort, updateDestinyInputPort, deleteDestinyByIdInputPort, updateDestinyPriceInputPort);
    }

    @Test
    public void should_find_by_id() {
        String id = "id";
        Destiny expected = DestinyMother.createDestiny("test");
        DestinyResponse expectedResponse = DestinyResponseMother.create();

        when(findDestinyByIdInputPort.findById(id)).thenReturn(expected);
        when(destinyMapper.toResponse(expected)).thenReturn(expectedResponse);

        ResponseEntity<DestinyResponse> response = destinyController.findById(id);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(expectedResponse, response.getBody());

        verify(findDestinyByIdInputPort, times(1)).findById(id);
        verify(destinyMapper, times(1)).toResponse(expected);
    }

    @Test
    public void should_find_by_name() {
        Pageable pageable = PageRequest.of(0, 10);
        String name = "name";
        List<Destiny> expected = List.of(DestinyMother.createDestiny("name"),
                DestinyMother.createDestiny("name2"),
                DestinyMother.createDestiny("name3"));
        DestinyResponse expectedResponse = DestinyResponseMother.create();

        when(findDestinyByNameInputPort.findByName(name)).thenReturn(expected);
        when(destinyMapper.toResponse(any(Destiny.class))).thenReturn(expectedResponse);

        ResponseEntity<Page<DestinyResponse>> response = destinyController.findByName(name, pageable);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(expected.size(), Objects.requireNonNull(response.getBody()).getTotalElements());

        verify(findDestinyByNameInputPort, times(1)).findByName(name);
        verify(destinyMapper, times(expected.size())).toResponse(any(Destiny.class));
    }

    @Test
    public void should_insert() {
        Destiny expected = DestinyMother.createDestiny("test");
        DestinyRequest request = DestinyRequestMother.create();

        doNothing().when(insertDestinyInputPort).insert(expected);
        when(destinyMapper.toDestiny(request)).thenReturn(expected);

        ResponseEntity<Void> response = destinyController.insert(request);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());

        verify(insertDestinyInputPort, times(1)).insert(expected);
        verify(destinyMapper, times(1)).toDestiny(request);
    }

    @Test
    public void should_update() {
        String id = "id";
        Destiny expected = DestinyMother.createDestiny("test");
        DestinyRequest request = DestinyRequestMother.create();

        doNothing().when(updateDestinyInputPort).update(expected);
        when(destinyMapper.toDestiny(request)).thenReturn(expected);

        ResponseEntity<Void> response = destinyController.update(id, request);

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode().value());
        assertEquals(id, expected.getId());

        verify(updateDestinyInputPort, times(1)).update(expected);
        verify(destinyMapper, times(1)).toDestiny(request);
    }

    @Test
    public void should_update_price() {
        String id = "id";
        DestinyPriceRequest request = DestinyPriceRequestMother.create();

        doNothing().when(updateDestinyPriceInputPort).updatePrice(id, request.getPrice());

        ResponseEntity<Void> response = destinyController.updatePrice(id, request);

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode().value());

        verify(updateDestinyPriceInputPort, times(1)).updatePrice(id, request.getPrice());
    }

    @Test
    public void should_delete_by_id() {
        String id = "id";

        doNothing().when(deleteDestinyByIdInputPort).deleteById(id);

        ResponseEntity<Void> response = destinyController.deleteById(id);

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode().value());

        verify(deleteDestinyByIdInputPort, times(1)).deleteById(id);
    }

}