package com.n11graduationproject.UserReviewService.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Score {
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5)  ;

    private final int score;

    public static Score fromValue(int value) {
        for (Score score : Score.values()) {
            if (score.score == value) {
                return score;
            }
        }
        throw new IllegalArgumentException("Invalid score value: " + value);
    }
}
