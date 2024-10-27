package com.example.googleOAuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .oauth2Login(oauth2 -> oauth2
                        .successHandler(customAuthSuccessHandler()) 
                );

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthSuccessHandler() { 
        return new CustomAuthenticationSuccessHandler();
    }
}
