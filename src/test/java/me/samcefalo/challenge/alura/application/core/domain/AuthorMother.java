package me.samcefalo.challenge.alura.application.core.domain;

public class AuthorMother {

    public static Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        author.setEmail(name + "@mail.com");
        author.setImageUrl("http://image.com/" + name);
        return author;
    }

}