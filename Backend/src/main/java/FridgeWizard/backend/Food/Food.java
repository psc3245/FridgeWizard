package FridgeWizard.backend.Food;

import FridgeWizard.backend.Users.User;
import jakarta.persistence.*;

@Entity
public class Food {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Generated value being passed in DTO causes
    private Long foodId;

    @Column
    private String name;

    @Column
    private Float qty;

    @Column
    private String unit;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Food() {}

    public Food(Long id, String name, Float qty, String unit, User u) {
        this.foodId = id;
        this.name = name;
        this.qty = qty;
        this.unit = unit;
        this.user = u;
    }


    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getQty() {
        return qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
