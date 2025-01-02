package FridgeWizard.backend.Users.auth;

import FridgeWizard.backend.Users.User;
import FridgeWizard.backend.Users.UserRepository;
import FridgeWizard.backend.Users.auth.DTO.LogInRequest;
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
            throw new Exception("Email Already In Use, Try Logging in.");
        }
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            // Username is already in use
            throw new Exception("Username Already In Use, Try Logging in.");
        }
        // Email and Username are both available
        User u = new User(signUpRequest.getEmail(),
                signUpRequest.getUsername(), signUpRequest.getPassword());

        userRepository.save(u);
    }

    // If 0 is returned, log in failed
    // Otherwise, userId is returned
    public Long logIn(LogInRequest logInRequest) throws Exception {
        // Initialize a variable to hold the user if we can find one
        User u;
        // Check if login was an email
        if (userRepository.existsByEmail(logInRequest.getEmailOrUsername())) {
            u = userRepository.getUserByEmail(logInRequest.getEmailOrUsername()).get();
        }
        // Check if login was a username
        else if (userRepository.existsByUsername(logInRequest.getEmailOrUsername())) {
            u = userRepository.getUserByUsername(logInRequest.getEmailOrUsername()).get();
        }
        // No user found
        else {
            throw new Exception("Log In Attempt Failed");
        }
        // Check password from user against password provided
        // TODO - Store Passwords Safer
        if (u.getPassword().equals(logInRequest.getPassword())) {
            return u.getUserId();
        }
        else {
            throw new Exception("Log In Attempt Failed");
        }

    }



}
