package com.n11graduationproject.UserReviewService.Entity;

import com.n11graduationproject.UserReviewService.Enum.Score;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CUSTOMER_REVIEW")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerReview")
    @SequenceGenerator(name = "CustomerReview", sequenceName = "CUSTOMER_REVIEW_ID_SEQ")
    @Id
    private Long id;

    @Column(name = "RESTAURANT_ID",nullable = false)
    private Long restaurantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID",nullable = false)
    private Customer customerID;

    @Column(name = "COMMENT",length = 500)
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "SCORE",nullable = false,length = 10)
    private Score score;
}
