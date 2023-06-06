package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@EnableGlobalAuthentication
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfiguration {

    @Autowired
    public void configureAuthentication(AuthenticationManager authentication) {
        // miska
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeHttpRequests()
            .requestMatchers("/").permitAll()
            .requestMatchers("/user/signup").denyAll()
            .and()
            .formLogin(login -> login
                    .loginPage("/login")
                    .failureUrl("/error"));

        return httpSecurity.build();
    }
    
}
