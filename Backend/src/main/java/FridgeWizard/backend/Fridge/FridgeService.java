package FridgeWizard.backend.Fridge;

import FridgeWizard.backend.Food.AddFoodRequest;
import FridgeWizard.backend.Food.Food;
import FridgeWizard.backend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FridgeService {

    @Autowired
    private UserRepository userRepository;

    public FridgeService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void addFoodRequest(AddFoodRequest addFoodRequest) {

    }
}
