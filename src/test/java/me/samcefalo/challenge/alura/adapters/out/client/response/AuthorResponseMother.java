package me.samcefalo.challenge.alura.adapters.out.client.response;

public class AuthorResponseMother {

    public static AuthorResponse create() {
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setName("name");
        authorResponse.setEmail("email");
        authorResponse.setImageUrl("imageUrl");
        return authorResponse;
    }

}