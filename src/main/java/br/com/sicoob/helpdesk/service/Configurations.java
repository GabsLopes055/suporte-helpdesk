package br.com.sicoob.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableMethodSecurity
public class Configurations {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
////        http.authorizeRequests().requestMatchers("/**").hasRole("USER");
////        return http.build();
//
//       //http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
//
//        return http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth.requestMatchers("*").permitAll().anyRequest().authenticated())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();
//
//
//
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and().authorizeHttpRequests()
////                .dispatcherTypeMatchers(HttpMethod.POST, "/api/sat/login")
////               .permitAll()
////              .anyRequest().authenticated().and().build();
//    }
//
//    @Autowired
//    private AuthenticationConfiguration authenticationConfiguration;
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoderConfiguration() {
//        return new BCryptPasswordEncoder();
//    }


}
