package me.samcefalo.challenge.alura.adapters.in.controller.mapper;

import me.samcefalo.challenge.alura.adapters.in.controller.request.ReviewRequest;
import me.samcefalo.challenge.alura.adapters.in.controller.response.ReviewResponse;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "author" , ignore = true)
    Review toReview(ReviewRequest reviewRequest);

    @Mapping(target = "author", source = "author.name")
    @Mapping(target = "imageUrl", source = "author.imageUrl")
    ReviewResponse toResponse(Review review);

}
