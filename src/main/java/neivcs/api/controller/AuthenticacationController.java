package neivcs.api.controller;

import jakarta.validation.Valid;
import neivcs.api.domain.user.AuthenticationData;
import neivcs.api.domain.user.User;
import neivcs.api.infra.security.TokenJWTData;
import neivcs.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticacationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AuthenticationData data){
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.tokenGenerator((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTData(tokenJWT));
    }
}
