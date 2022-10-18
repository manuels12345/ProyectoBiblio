package com.library.library.auth.config;

import com.library.library.auth.filter.JwtRequestFilter;
import com.library.library.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.Duration;
import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration @EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsCustomService userDetailsCustomService;

        @Autowired
        private JwtRequestFilter jwtRequestFilter;

        @Override//indicamos q nosotros detallamos los datos del usuario
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsCustomService);
        }

        @Bean //este componente  permite no encodear la password, solo para practicar
        public PasswordEncoder passwordEncoder(){
            return NoOpPasswordEncoder.getInstance();
        }

        @Override
        @Bean//va a manejar la autenticacion el mismo metodo q provee WebSecurity
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                    .cors(withDefaults())
                    .csrf()
                    .disable()
                    //.authorizeRequests().antMatchers("/lendings/users/{idUser}/books/{idBook}").permitAll()
                    .authorizeRequests()
                    .antMatchers(
                            HttpMethod.GET,
                            "/books/all"
                    )
                    .permitAll()
                    .antMatchers(
                            HttpMethod.POST,
                            "/auth/*"
                    ).permitAll()
                    .anyRequest().authenticated()
                    .and().exceptionHandling()
                    .and().sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            //Security es STATEFULL, pero para que cada endpoint nos pida una validacion nueva, lo seteamos
            //como STATELESS
            httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        }
        @Bean
        CorsConfigurationSource corsConfigurationSource(){
            CorsConfiguration cc = new CorsConfiguration();
            cc.setAllowedHeaders(Arrays.asList("Origin.Accept","X-Request-With","Content-Type", "Access-Control-Request-Method","Access-Control-Request-Headers","Authorization"));
            cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
            cc.setAllowedOrigins(Arrays.asList("/*"));
            cc.setAllowedMethods(Arrays.asList("GET","POST","PUT","OPTIONS","PATCH"));
            cc.addAllowedOrigin("http://localhost:4200");
            cc.setMaxAge(Duration.ZERO);
            cc.setAllowCredentials(Boolean.TRUE);
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", cc);
            return source;
        }
}
