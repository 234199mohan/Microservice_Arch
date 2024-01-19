package com.mohan.gateway.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    public SecurityWebFilterChain getSecurityFilterChane(ServerHttpSecurity httpSecurity){
        httpSecurity.
                authorizeExchange(obj->obj.anyExchange().authenticated()).
                oauth2ResourceServer(obj -> obj.jwt(jwt->jwt.jwkSetUri("")));

        return httpSecurity.build();
    }


}
