package FridgeWizard.backend.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


}
