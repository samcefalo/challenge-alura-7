package me.samcefalo.challenge.alura.adapters.in.destiny.controller;

import jakarta.validation.Valid;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.mapper.DestinyMapper;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.request.DestinyPriceRequest;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.request.DestinyRequest;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.response.DestinyResponse;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.in.destiny.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destiny")
public class DestinyController {

    private final DestinyMapper destinyMapper;
    private final FindDestinyByIdInputPort findDestinyByIdInputPort;
    private final FindDestinyByNameInputPort findDestinyByNameInputPort;
    private final InsertDestinyInputPort insertDestinyInputPort;
    private final UpdateDestinyInputPort updateDestinyInputPort;
    private final DeleteDestinyByIdInputPort deleteDestinyByIdInputPort;
    private final UpdateDestinyPriceInputPort updateDestinyPriceInputPort;

    @Autowired
    public DestinyController(DestinyMapper destinyMapper, FindDestinyByIdInputPort findDestinyByIdInputPort, FindDestinyByNameInputPort findDestinyByNameInputPort, InsertDestinyInputPort insertDestinyInputPort, UpdateDestinyInputPort updateDestinyInputPort, DeleteDestinyByIdInputPort deleteDestinyByIdInputPort, UpdateDestinyPriceInputPort updateDestinyPriceInputPort) {
        this.destinyMapper = destinyMapper;
        this.findDestinyByIdInputPort = findDestinyByIdInputPort;
        this.findDestinyByNameInputPort = findDestinyByNameInputPort;
        this.insertDestinyInputPort = insertDestinyInputPort;
        this.updateDestinyInputPort = updateDestinyInputPort;
        this.deleteDestinyByIdInputPort = deleteDestinyByIdInputPort;
        this.updateDestinyPriceInputPort = updateDestinyPriceInputPort;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<DestinyResponse> findById(@PathVariable("id") String id) {
        Destiny destiny = findDestinyByIdInputPort.findById(id);
        return ResponseEntity.ok(destinyMapper.toResponse(destiny));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<DestinyResponse>> findByName(@RequestParam String name, Pageable pageable) {
        List<Destiny> destinations = findDestinyByNameInputPort.findByName(name);
        List<DestinyResponse> destinyResponses = destinations.stream().map(destinyMapper::toResponse).toList();
        Page<DestinyResponse> destinyResponsePage = new PageImpl<>(destinyResponses, pageable, destinyResponses.size());

        return ResponseEntity.ok(destinyResponsePage);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> insert(@Valid @RequestBody DestinyRequest destinyRequest) {
        Destiny destiny = destinyMapper.toDestiny(destinyRequest);
        insertDestinyInputPort.insert(destiny);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> update(@PathVariable("id") String id, @Valid @RequestBody DestinyRequest destinyRequest) {
        Destiny destiny = destinyMapper.toDestiny(destinyRequest);
        destiny.setId(id);
        updateDestinyInputPort.update(destiny);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updatePrice/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> updatePrice(@PathVariable("id") String id, @Valid @RequestBody DestinyPriceRequest destinyPriceRequest) {
        updateDestinyPriceInputPort.updatePrice(id, destinyPriceRequest.getPrice());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        deleteDestinyByIdInputPort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
