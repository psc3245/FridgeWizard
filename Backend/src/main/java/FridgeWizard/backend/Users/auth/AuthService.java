package FridgeWizard.backend.Users.auth;

import FridgeWizard.backend.Users.User;
import FridgeWizard.backend.Users.UserRepository;
import FridgeWizard.backend.Users.auth.DTO.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(SignUpRequest signUpRequest) throws Exception {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            // Email is already in use
            throw new Exception();
        }
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            // Username is already in use
            throw new Exception();
        }
        // Email and Username are both available
        User u = new User(signUpRequest.getEmail(),
                signUpRequest.getUsername(), signUpRequest.getPassword());

        userRepository.save(u);
    }



}
