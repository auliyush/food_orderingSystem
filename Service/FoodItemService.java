package Service;

import Model.FoodItem;

import java.util.List;

public interface FoodItemService {
    boolean addFoodItem(String foodItemId, String resturantId, String foodName, String foodDescription, int foodPrice, boolean foodAvailabilty);

    List<FoodItem> getFoodItemListByResturantId(String resturantId);

    boolean updateFoodItem(String foodItemId, String resturantId, String foodName, String foodDescription, int foodPrice, boolean foodAvailability);

    boolean deleteFoodItem(String foodItemId, String resturantId);

    FoodItem getFoodItemById(String foodItemId, String restaurantId);
}
