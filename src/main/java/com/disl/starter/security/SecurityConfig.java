package com.disl.starter.security;

import com.disl.starter.constants.SecurityConstants;
import com.disl.starter.exceptions.AuthenticationExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static com.disl.starter.utils.SecurityUtil.FilterChainUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig
    extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

  @Autowired private PasswordEncoder passwordEncoder;

  @Autowired private JwtAuthenticationFilter jwtAuthenticationFilter;

  @Autowired private CustomUserDetailsService customUserDetailsService;

  @Autowired private AuthenticationExceptionHandler authExceptionHandler;

  @Bean
  @Order(1)
  public SecurityFilterChain jwtFilterChain(HttpSecurity http) throws Exception {
    super.configure(http);
    return FilterChainUtil(http, jwtAuthenticationFilter, authExceptionHandler);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
    return new DaoAuthenticationProvider() {
      {
        setUserDetailsService(customUserDetailsService);
        setPasswordEncoder(passwordEncoder);
      }
    };
    }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
      throws Exception {
        return config.getAuthenticationManager();
    }

  @Bean
  public CorsFilter corsConfigurationFilterSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Collections.singletonList("*"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(false);
    configuration.setAllowedHeaders(Collections.singletonList("*"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
    return new CorsFilter(source);
    }
}