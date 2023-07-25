package me.samcefalo.challenge.alura.adapters.out.repository.mapper;

import me.samcefalo.challenge.alura.adapters.out.repository.entity.ReviewEntity;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewEntityMapper {

    @Mapping(target = "author" , source = "author.name")
    @Mapping(target = "imageUrl" , source = "author.imageUrl")
    ReviewEntity toReviewEntity(Review review);

    @Mapping(target = "author.name" , source = "author")
    @Mapping(target = "author.imageUrl" , source = "imageUrl")
    Review toReview(ReviewEntity reviewEntity);
}
