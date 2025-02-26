package FridgeWizard.backend.Food;

import FridgeWizard.backend.Users.User;
import FridgeWizard.backend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    public FoodService(UserRepository userRepository, FoodRepository foodRepository) {
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }


    public FoodDTO createNewFood(FoodCreationRequest foodCreationRequest) throws IllegalArgumentException {

        // Check if food ID already exists, so add the new qty to old
        if (foodRepository.existsByFoodId(foodCreationRequest.getFoodId())) {
            // should we check if user is same too?
            Food f = foodRepository.getFoodByFoodId(foodCreationRequest.getFoodId()).get();
            Float qty = f.getQty() + foodCreationRequest.getQty();
            f.setQty(qty);
            foodRepository.save(f);

            return castFoodToDTO(f);
        }
        // Check if user ID does not exist, if so go on get
        if (! userRepository.existsByUserId(foodCreationRequest.getUserId())) throw new IllegalArgumentException("User ID does not exist");

        // No need to null check because we already do
        User u = userRepository.getUserByUserId(foodCreationRequest.getUserId()).get();
        // Now let's build food to save in the repo
        Food f = new Food();
        f.setUser(u);
        f.setFoodId(foodCreationRequest.getFoodId());
        f.setName(foodCreationRequest.getName());
        f.setQty(foodCreationRequest.getQty());
        f.setUnit(foodCreationRequest.getUnit());

        foodRepository.save(f);

        // Return a dto of the food
        return castFoodToDTO(f);
    }

    public List<FoodDTO> getAllFood() {
        List<Food> foods = foodRepository.findAll();
        List<FoodDTO> ret = new ArrayList<>();
        for (Food f : foods) {
            ret.add(castFoodToDTO(f));
        }
        return ret;
    }



    public FoodDTO castFoodToDTO(Food f) {
        FoodDTO ret = new FoodDTO();
        ret.setUserId(f.getUser().getUserId());
        ret.setFoodId(f.getFoodId());
        ret.setName(f.getName());
        ret.setQty(f.getQty());
        ret.setUnit(f.getUnit());
        return ret;
    }
}
