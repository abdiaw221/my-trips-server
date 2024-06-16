package com.disl.starter.utils;

import com.disl.starter.constants.SecurityConstants;
import com.disl.starter.exceptions.AuthenticationExceptionHandler;
import com.disl.starter.security.JwtAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityUtil {
    
  public static SecurityFilterChain FilterChainUtil(
      HttpSecurity http,
      JwtAuthenticationFilter jwtAuthenticationFilter,
      AuthenticationExceptionHandler authExceptionHandler)
      throws Exception {
    http.csrf(
            csrf ->
                csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/api/**"))
                    .disable())
        .authorizeHttpRequests(
            authorize ->
                authorize
                    .requestMatchers(SecurityConstants.JWTDisabledAntMatchers)
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .exceptionHandling(
            exceptionHandling -> exceptionHandling.authenticationEntryPoint(authExceptionHandler))
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .requiresChannel(
            channel ->
                channel
                    .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                    .requiresSecure());

    return http.build();
  }
}
