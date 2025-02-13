package FridgeWizard.backend.Fridge;

import FridgeWizard.backend.Food.Food;
import FridgeWizard.backend.Users.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// @Entity
public class Fridge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fridgeId;

    @OneToOne(mappedBy = "fridge")
    private User user;

    @OneToMany(mappedBy = "fridge", cascade = CascadeType.ALL)
    private List<Food> contents = new ArrayList<>();

}
