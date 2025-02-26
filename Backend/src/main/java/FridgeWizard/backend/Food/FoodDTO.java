package FridgeWizard.backend.Food;

public class FoodDTO {

    private Long userId;
    private Long foodId;
    private String name;
    private Float qty;
    private String unit;

    public FoodDTO() {}

    public FoodDTO(Long userId, Long foodId, String name, Float qty, String unit) {
        this.userId = userId;
        this.foodId = foodId;
        this.name = name;
        this.qty = qty;
        this.unit = unit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
