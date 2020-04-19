package br.com.sfc.restspu.service;

import br.com.sfc.restspu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        var user = userRepository.findByUserName(userName);

        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Username " + userName + " not found!");
        }
    }
}
