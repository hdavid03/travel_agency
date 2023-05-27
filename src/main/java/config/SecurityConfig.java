package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableGlobalAuthentication
@Configuration
public class SecurityConfig extends WebSecurityConfiguration {
    
}
