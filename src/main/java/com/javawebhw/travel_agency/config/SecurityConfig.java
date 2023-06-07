package com.javawebhw.travel_agency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.javawebhw.travel_agency.service.UserService;

import lombok.AllArgsConstructor;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

@ComponentScan({"com.javawebhw.travel_agency"})
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    /*@Autowired
    private DaoAuthenticationProvider authenticationProvider;
    */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/signup")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/welcome")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/all")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/advertisement/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .and()
                .formLogin(login -> login
                        .loginPage("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .failureUrl("/login?error")
                        .defaultSuccessUrl("/welcome", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll())
                .httpBasic(withDefaults())
                .headers(headers -> headers.frameOptions().sameOrigin())
                .build();
    }

    /*@Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity) 
    throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
        httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        return authenticationManagerBuilder.build();
    }
    */    

    @Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
