package com.mohan.user.service.entities;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Rating {
private String ratingId;
private String userId;
private String hotelId;
private int rating;
private String feedback;
private Hotel hotel;

}
