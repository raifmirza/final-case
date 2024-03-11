package com.n11graduationproject.UserReviewService.Entity;


import com.n11graduationproject.UserReviewService.Enum.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer")
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    @Id
    private Long id;

    @Column(name="NAME",nullable = false,length = 100)
    private String name;

    @Column(name="SURNAME",nullable = false,length = 100)
    private String surname;

    @Column(name="EMAIL",nullable = false,length = 255)
    private String email;

    @Embedded
    @Column(name="COORDINATE",nullable = false)
    private Coordinate coordinate;

    @OneToMany(mappedBy ="customerID" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS",nullable = false)
    private Status status;
}
