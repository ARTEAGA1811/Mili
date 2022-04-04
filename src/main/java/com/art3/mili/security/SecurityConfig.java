package com.art3.mili.security;


import com.art3.mili.modelo.servicio.UsuarioDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioDetailService usuarioDetailService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//    //Declaramos el bcrypt
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Con esta forma tengo usuarios definidos por mi
//        auth
//                .inMemoryAuthentication()
//                .withUser("user")
//                .password("123")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .roles("USER", "ADMIN");


        //Con esta forma, accedo a las autenticaciones por medio de los
        //usuarios que tengo en la base de datos
        auth.userDetailsService(usuarioDetailService).passwordEncoder(encoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Las peticiones que entran tienen que estar autenticadas
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
