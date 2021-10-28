/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3vc.reto3vc.seguridad;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diego.Ramirez
 */
@RestController
public class ControlSeguridad extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a.antMatchers("/", "/js/**", "/css/**", "/assets/**", "/image/**","/images/**",
                "/url/**", "/error", "/cmldc/**", "/dist/**","/login**",
                "/webjars/**", "/Reservation/**", "/Client/**", "/Game/**",
                "/Category/**", "/Score/**", "/Message/**").permitAll()
                .anyRequest().authenticated()
        ).exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))                             
        ).oauth2Login();  
        http.cors().and().csrf().disable();
    }

}
