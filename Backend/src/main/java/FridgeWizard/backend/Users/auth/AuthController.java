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

@CrossOrigin(origins = {"http://localhost", "http://localhost:80", "http://127.0.0.1", "http://127.0.0.1:80"})
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
    public ResponseEntity<UserDTO> signUpAttempt(@RequestBody @Valid SignUpRequest signUpRequest) {
        System.out.println("Attempted signup with credentials: " + signUpRequest.getEmail() + " "
                + signUpRequest.getUsername() + " " + signUpRequest.getPassword());
        try {
            Long id = authService.signUp(signUpRequest);
            UserDTO userDTO = userService.convertUserIdToDTO(id);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity("User registration failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/login")
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
