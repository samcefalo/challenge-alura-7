package me.samcefalo.challenge.alura.adapters.out.rating.client.response;

public class RatingResponseMother {

    public static RatingResponse createRatingResponse() {
        RatingResponse ratingResponse = new RatingResponse();
        ratingResponse.setTotal(10);
        ratingResponse.setAverage(4.0);
        return ratingResponse;
    }

}