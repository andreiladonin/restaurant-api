package ru.aladonin.restaurantapi.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aladonin.restaurantapi.auth.dto.JwtAuthenticationResponse;
import ru.aladonin.restaurantapi.auth.dto.SignInRequest;
import ru.aladonin.restaurantapi.auth.dto.SignUpRequest;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    //регистрация
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody  SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    // вход
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }

}
