package br.com.sfc.restspu.resources;

import br.com.sfc.restspu.repository.UserRepository;
import br.com.sfc.restspu.security.AccountCredentialsVO;
import br.com.sfc.restspu.security.jwt.JwtTokenProvider;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/signin", produces = { "application/json", "application/xml", "application/x-yaml"},
            consumes = { "application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity signin(@RequestBody AccountCredentialsVO data) {
        try {
            var username = data.getUsername();
            var password = data.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            var user = userRepository.findByUserName(username);
            var token = "";

            if (user != null) {
                token = jwtTokenProvider.createToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("Username " + username + " not found");
            }

            Map<Object, Object> model = new HashedMap();
            model.put("username", username);
            model.put("token", token);

            return ok(model);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password suplied");
        }
    }

}
