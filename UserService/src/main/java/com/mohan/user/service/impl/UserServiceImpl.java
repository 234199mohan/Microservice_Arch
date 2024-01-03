package com.mohan.user.service.impl;

import com.mohan.user.service.entities.Hotel;
import com.mohan.user.service.entities.Rating;
import com.mohan.user.service.entities.User;
import com.mohan.user.service.feign.HotelService;
import com.mohan.user.service.repo.UserRepository;
import com.mohan.user.service.service.UserService;
import com.mohan.user.service.userexception.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Value("${ratingserviceurl}")
    private String ratingServiceurl;

    @Value("${hotelserviceurl}")
    private String hotelServiceurl;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private WebClient webClient;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        return userRepo.save(user);
    }

    //both way given below to get the list Flux and Mono
    @Override
    public <T> T getUser(T userId) {
        User user = userRepo.findById(String.valueOf(userId)).orElseThrow();
        String ratingurl = ratingServiceurl + "/ratings/users/" + userId;

        List<Rating> userRating = new ArrayList<Rating>();

//        Rating[] fluxResult = webClient.get().uri(inputUri).retrieve().bodyToMono(Rating[].class).block();
//        userRating = Arrays.asList(fluxResult);
//        user.setRatings(userRating);

        Flux<Rating> fluxObj = webClient.get().uri(ratingurl).retrieve().bodyToFlux(Rating.class);
        userRating = fluxObj.collectList().block();
        userRating.stream().map(obj -> {
            String hotelurl = hotelServiceurl+ "/hotels/" + obj.getHotelId();
            //Hotel fluxHotel = webClient.get().uri(hotelurl).retrieve().bodyToMono(Hotel.class).block();
            //obj.setHotel(fluxHotel);
            Hotel hotel = hotelService.getHoteById(obj.getHotelId());
            obj.setHotel(hotel);
            return obj;
        }).collect(Collectors.toList());
        user.setRatings(userRating);


        return (T) user;
    }

    @Override
    public List<?> getAllUser() {
        return userRepo.findAll();
    }

    public <T> List<T> customizeUser() {
        List<?> newList = getAllUser();
        return (List<T>) newList;
    }


}
