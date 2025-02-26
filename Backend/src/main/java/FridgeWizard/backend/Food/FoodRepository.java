package FridgeWizard.backend.Food;

import FridgeWizard.backend.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Boolean existsByFoodId(Long id);
    Optional<Food> getFoodByFoodId(Long id);
}
