package FridgeWizard.backend.Food;

public class AddFoodRequest {
    private int userId;
    private Food food;
    public AddFoodRequest(int userId, Food f) {
        this.userId = userId;
        this.food = f;
    }
    public AddFoodRequest() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
