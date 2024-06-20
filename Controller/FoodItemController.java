package Controller;

import Model.FoodItem;
import Service.ServiceImpl.FoodItemServiceImpl;

import java.util.List;

public class FoodItemController {

    private static FoodItemController instance;
    public static synchronized FoodItemController getInstance(){
        if(instance == null){
            instance = new FoodItemController();
        }
        return instance;
    }

    FoodItemServiceImpl foodItemService = FoodItemServiceImpl.getInstance();
    public boolean addFoodItem(String foodItemId, String resturantId, String foodName, String foodDescription,
                               int foodPrice, boolean foodAvailabilty) {
        return foodItemService.addFoodItem(foodItemId, resturantId, foodName, foodDescription, foodPrice,
                foodAvailabilty);
    }

    public List<FoodItem> getFoodItemListByResturantId(String resturantId) {
        return foodItemService.getFoodItemListByResturantId(resturantId);
    }

    public boolean updateFoodItem(String foodItemId, String resturantId, String foodName, String foodDescription, int foodPrice,
                                  boolean foodAvailability) {
        return foodItemService.updateFoodItem(foodItemId, resturantId, foodName, foodDescription, foodPrice, foodAvailability);
    }

    public boolean deleteFoodItem(String foodItemId, String resturantId) {
        return foodItemService.deleteFoodItem(foodItemId, resturantId);
    }

    public FoodItem getFoodItemById(String foodItemId, String restaurantId) {
        return foodItemService.getFoodItemById(foodItemId, restaurantId);
    }
}
