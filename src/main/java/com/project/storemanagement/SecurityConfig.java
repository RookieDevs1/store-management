package com.project.storemanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static javax.xml.transform.OutputKeys.VERSION;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity https) throws Exception {
     /*   http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated());
*/

        https
                .authorizeRequests()
                .antMatchers("/", "/vendor/**", "/imag/**", "/css/**", "/js/**", "/favicon.ico").permitAll();
/*

        http
                .authorizeRequests()
                .antMatchers( "/favicon.ico").permitAll();
*/

        return https.oauth2Login()
                .and().build();
    }
}
