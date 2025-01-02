package FridgeWizard.backend.Users.Service;

import FridgeWizard.backend.Users.User;
import FridgeWizard.backend.Users.UserDTO;
import FridgeWizard.backend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO convertUserToDTO(User u) {
        UserDTO ret = new UserDTO();

        ret.setUserId(u.getUserId());
        ret.setEmail(u.getEmail());
        ret.setUsername(u.getUsername());

        return ret;
    }

    public UserDTO convertUserIdToDTO(Long userId) throws Exception {
        if (!userRepository.existsByUserId(userId)) throw new Exception("User Not Found");
        return convertUserToDTO(userRepository.getUserByUserId(userId).get());
    }
}
