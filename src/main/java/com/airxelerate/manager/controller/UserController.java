package com.airxelerate.manager.controller;

import com.airxelerate.manager.entity.Flight;
import com.airxelerate.manager.entity.UserAttribute;
import com.airxelerate.manager.service.UserAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserAttributeService userAttributeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping("/user")
    public UserDetails getUser(Authentication authentication) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) authentication;
        Map<String, Object> attributes = token.getTokenAttributes();
        return userDetailsService.loadUserByUsername(attributes.get("username").toString());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/userAttribute")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UserAttribute addNewUserAttribute(@RequestBody @Valid final UserAttribute userAttribute) {
        return userAttributeService.add(userAttribute);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/userAttribute")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Iterable<UserAttribute> getAll() {
        return userAttributeService.getAll();
    }
}
