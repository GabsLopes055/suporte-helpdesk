package br.com.sicoob.helpdesk.secutiry;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").
                allowedOrigins("*").
                allowedMethods("*").
                allowedHeaders("*").
                allowCredentials(true);
    }


//    @Override
//    public void configure(HttpSecurity security) throws Exception {
//        security.csrf().disable()
//                .authorizeRequests()
//                .anyRequest().permitAll();
//    }

}
