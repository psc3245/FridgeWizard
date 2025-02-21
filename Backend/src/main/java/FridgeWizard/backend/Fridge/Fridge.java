package FridgeWizard.backend.Fridge;

import FridgeWizard.backend.Food.Food;
import FridgeWizard.backend.Users.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

public class Fridge {

    @OneToOne(mappedBy = "user_id")
    private User user;

    @Id
    private int fridgeId;

    @Column
    private List<Food> items = new ArrayList<>();

    public Fridge(int fridgeId, List<Food> foods) {
        this.fridgeId = fridgeId;
        this.items = foods;
    }

    public int getFridgeId() {
        return fridgeId;
    }

    public void setFridgeId(int userId) {
        this.fridgeId = userId;
    }

    public List<Food> getItems() {
        return items;
    }

    public void setItems(List<Food> items) {
        this.items = items;
    }
}
