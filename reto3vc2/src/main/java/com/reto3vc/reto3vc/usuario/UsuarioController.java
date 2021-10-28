/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3vc.reto3vc.usuario;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diego.Ramirez
 * Mapea al usuario
 * para el get y solo lleve el dato del login para que no lleve todos los atributos
 */
@RestController
public class UsuarioController {
    @GetMapping("/user")
    public Map<String,Object> user(@AuthenticationPrincipal OAuth2User principal){
        //return principal.getAttributes();
        return Collections.singletonMap("user", principal.getAttribute("login"));
    }

    
}
