package FridgeWizard.backend.Users.auth;

import FridgeWizard.backend.Users.Service.UserService;
import FridgeWizard.backend.Users.User;
import FridgeWizard.backend.Users.UserDTO;
import FridgeWizard.backend.Users.UserRepository;
import FridgeWizard.backend.Users.auth.DTO.LogInRequest;
import FridgeWizard.backend.Users.auth.DTO.SignUpRequest;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    @Autowired
    private final AuthService authService;

    @Autowired
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }


    @PostMapping(path = "/signup")
    public ResponseEntity signUpAttempt(@RequestBody @Valid SignUpRequest signUpRequest) {
        try {
            authService.signUp(signUpRequest);
            return ResponseEntity.ok("User Registered Successfully");
        } catch (Exception e) {
            return new ResponseEntity("User registration failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/login")
    public ResponseEntity<UserDTO> loginAttempt(@RequestBody @Valid LogInRequest logInRequest) {
        try {
            Long id = authService.logIn(logInRequest);
            UserDTO userDTO = userService.convertUserIdToDTO(id);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

}
