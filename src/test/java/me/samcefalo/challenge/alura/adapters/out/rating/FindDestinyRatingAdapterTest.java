package me.samcefalo.challenge.alura.adapters.out.rating;

import me.samcefalo.challenge.alura.adapters.out.rating.client.FindDestinyRatingClient;
import me.samcefalo.challenge.alura.adapters.out.rating.client.response.RatingResponse;
import me.samcefalo.challenge.alura.adapters.out.rating.client.response.RatingResponseMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FindDestinyRatingAdapterTest {

    private FindDestinyRatingClient findDestinyRatingClient;
    private FindDestinyRatingAdapter findDestinyRatingAdapter;

    @BeforeEach
    void setup() {
        findDestinyRatingClient = mock(FindDestinyRatingClient.class);
        findDestinyRatingAdapter = new FindDestinyRatingAdapter(findDestinyRatingClient);
    }

    @Test
    public void should_find_destiny_rating() {
        String destinyId = "1";
        RatingResponse expected = RatingResponseMother.createRatingResponse();

        when(findDestinyRatingClient.findById(destinyId)).thenReturn(expected);

        Double result = findDestinyRatingAdapter.findDestinyRating(destinyId);

        assertEquals(expected.getAverage(), result);
        verify(findDestinyRatingClient, times(1)).findById(destinyId);
    }
}