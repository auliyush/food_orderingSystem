package Service;

import Model.FoodItem;

import java.util.List;

public interface FoodItemService {
    boolean addFoodItem(String foodItemId, String restaurantId, String foodName, String foodDescription, int foodPrice, boolean foodAvailabilty);

    List<FoodItem> getFoodItemListByRestaurantId(String restaurantId);

    boolean updateFoodItem(String foodItemId, String restaurantId, String foodName, String foodDescription, int foodPrice, boolean foodAvailability);

    boolean deleteFoodItem(String foodItemId, String restaurantId);

    FoodItem getFoodItemById(String foodItemId, String restaurantId);
}
