package com.axa.productmanagement.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// import static org.springframework.security.oauth2.core.authorization.OAuth2AuthorizationManagers.hasScope;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration {
//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(authorize -> authorize
//                 .requestMatchers("/messages/**").access(hasScope("message:read"))
//                 .anyRequest().authenticated()
//             )
//             .oauth2ResourceServer(oauth2 -> oauth2
//                 .jwt(jwt -> jwt
//                     .jwtAuthenticationConverter(myConverter())
//                 )
//             );
//         return http.build();
//     }
// }