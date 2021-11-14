package com.airxelerate.manager.security;

import com.airxelerate.manager.entity.UserAttribute;
import com.airxelerate.manager.service.UserAttributeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAttributeService userAttributeService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAttribute userAttribute = userAttributeService.getByUsername(username);
        UserDetails user1 = User
                .withUsername(userAttribute.getUsername())
                .authorities(userAttribute.getRole())
                .passwordEncoder(passwordEncoder::encode)
                .password(userAttribute.getPassword())
                .build();
        return user1;
    }
}
