package com.chootay.services;

import com.chootay.models.User;
import com.chootay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        CustomUserDetails customUserDetails = null;
        if (user != null) {
            customUserDetails = new CustomUserDetails();
            customUserDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User does not exist with name " + username);
        }
        System.out.println("NAME" + customUserDetails.getAuthorities());
        return customUserDetails;
    }
}
