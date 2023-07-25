package me.samcefalo.challenge.alura.adapters.in.controller;

import jakarta.validation.Valid;
import me.samcefalo.challenge.alura.adapters.in.controller.mapper.ReviewMapper;
import me.samcefalo.challenge.alura.adapters.in.controller.request.ReviewRequest;
import me.samcefalo.challenge.alura.adapters.in.controller.response.ReviewResponse;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.ports.in.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final ReviewMapper reviewMapper;
    private final FindReviewByIdInputPort findReviewByIdInputPort;
    private final FindLastReviewsInputPort findLastReviewsInputPort;
    private final InsertReviewInputPort insertReviewInputPort;
    private final UpdateReviewInputPort updateReviewInputPort;
    private final DeleteReviewByIdInputPort deleteReviewByIdInputPort;

    @Autowired
    public ReviewController(ReviewMapper reviewMapper, FindReviewByIdInputPort findReviewByIdInputPort, FindLastReviewsInputPort findLastReviewsInputPort, InsertReviewInputPort insertReviewInputPort, UpdateReviewInputPort updateReviewInputPort, DeleteReviewByIdInputPort deleteReviewByIdInputPort) {
        this.reviewMapper = reviewMapper;
        this.findReviewByIdInputPort = findReviewByIdInputPort;
        this.findLastReviewsInputPort = findLastReviewsInputPort;
        this.insertReviewInputPort = insertReviewInputPort;
        this.updateReviewInputPort = updateReviewInputPort;
        this.deleteReviewByIdInputPort = deleteReviewByIdInputPort;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ReviewResponse> findById(@PathVariable("id") String id) {
        Review review = findReviewByIdInputPort.findById(id);
        return ResponseEntity.ok(reviewMapper.toResponse(review));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/last")
    public ResponseEntity<Page<ReviewResponse>> findLast(Pageable pageable) {
        List<Review> reviews = findLastReviewsInputPort.findLastReview();
        List<ReviewResponse> reviewResponses = reviews.stream().map(reviewMapper::toResponse).toList();
        Page<ReviewResponse> reviewResponsePage = new PageImpl<>(reviewResponses, pageable, reviews.size());

        return ResponseEntity.ok(reviewResponsePage);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> insert(@Valid @RequestBody ReviewRequest reviewRequest) {
        insertReviewInputPort.insert(reviewMapper.toReview(reviewRequest), reviewRequest.getAuthorId());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> update(@PathVariable("id") String id, @Valid @RequestBody ReviewRequest reviewRequest) {
        Review review = reviewMapper.toReview(reviewRequest);
        review.setId(id);

        updateReviewInputPort.update(review, reviewRequest.getAuthorId());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        deleteReviewByIdInputPort.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
