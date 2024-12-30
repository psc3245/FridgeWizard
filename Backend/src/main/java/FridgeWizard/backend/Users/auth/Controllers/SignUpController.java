package FridgeWizard.backend.Users.auth.Controllers;

import FridgeWizard.backend.Users.auth.AuthService;
import FridgeWizard.backend.Users.auth.DTO.SignUpRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
public class SignUpController {

    @Autowired
    private final AuthService authService;

    public SignUpController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping(path = "/signup")
    public ResponseEntity signUpUser(@RequestBody @Valid SignUpRequest signUpRequest) {

        try {
            authService.signUp(signUpRequest);
            return ResponseEntity.ok("User Registered Successfully");
        } catch (Exception e) {
            return new ResponseEntity("User registration failed", HttpStatus.BAD_REQUEST);
        }
    }

}
