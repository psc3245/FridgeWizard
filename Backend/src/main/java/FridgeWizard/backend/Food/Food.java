package FridgeWizard.backend.Food;

import jakarta.persistence.*;


public class Food {
    private Long foodId;

    private String name;

    private Float qty;

    private String unit;

    public Food() {}

    public Food(String name, Float qty, String unit) {
        this.name = name;
        this.qty = qty;
        this.unit = unit;
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
}
