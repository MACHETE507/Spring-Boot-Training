package com.example.spring_boot_training.user;

import com.example.spring_boot_training.entity.Right;
import com.example.spring_boot_training.entity.Role;
import com.example.spring_boot_training.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Client übergibt Name + Passwort
     * Spring versucht sich einen User zu holen
     * Spring überprüft Passwort
     * Spring überprüft auf Rollenvergabe
     * Zugriff auf den Controller
     **/

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        com.example.spring_boot_training.entity.User user = userRepository.findUserByEmail(email);

        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role : user.getRoles()) {
            for(Right right : role.getRights()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + right.name()));
            }
        }

        return new User(
                user.getEmail(), user.getPassword(), authorities
        );
    }
}

