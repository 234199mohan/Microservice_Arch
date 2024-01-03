package com.mohan.user.service.config;

import com.mohan.user.service.entities.User;
import io.netty.resolver.DefaultAddressResolverGroup;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@Configuration
@Getter
@Setter
public class UserConfiguration {

    @Value("${ratingserviceurl}")
    private String ratingServiceurl;

    User userObj;

    @LoadBalanced
    @Bean
    WebClient webClient() {
        return WebClient.builder().baseUrl(ratingServiceurl).build();
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient));
    }

}
