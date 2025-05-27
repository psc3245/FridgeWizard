package FridgeWizard.backend.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost", "http://localhost:80", "http://127.0.0.1", "http://127.0.0.1:80"})
@RequestMapping(path = "/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<FoodDTO>> getAllFood() {
        return new ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);
    }

    @GetMapping(path = "/{foodId}")
    public ResponseEntity<FoodDTO> getFoodById(@PathVariable Long foodId) {
        // No need to check for existence, foodService will return null if not found
        FoodDTO f = foodService.getFoodById(foodId);
        // Null check on f and return
        if (f == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<FoodDTO> createNewFood(@RequestBody FoodCreationRequest foodCreationRequest) {
        try {
            FoodDTO dto = foodService.createNewFood(foodCreationRequest);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/new/mass")
    public ResponseEntity<List<FoodDTO>> createNewFoods(@RequestBody List<FoodCreationRequest> foodCreationRequests) {
        List<FoodDTO> ret = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        for (FoodCreationRequest foodCreationRequest : foodCreationRequests) {
            try {
                FoodDTO dto = foodService.createNewFood(foodCreationRequest);
                ret.add(dto);
            } catch (IllegalArgumentException e) {
                errors.add("Failed to process: " + foodCreationRequest.toString());
            }
        }

        if (!errors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.MULTI_STATUS)
                    .body(ret);
        }

        return ResponseEntity.ok(ret);
    }

    @DeleteMapping(path = "/{foodId}")
    public ResponseEntity deleteFoodById(@PathVariable Long foodId) {
        // 400: Not found
        // 204: Successful delete
        return foodService.deleteFood(foodId);
    }


}
