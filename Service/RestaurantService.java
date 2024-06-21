package Service;

import Model.FoodItem;
import Model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getListOfAllRestaurant();

    boolean findRestaurantByRestaurantName(String restaurantName);

    boolean checkPhoneNumberAlreadyExistsOrNot(String restaurantPhoneNUmber);

    boolean addRestaurant(String restaurantId, String ownerId, String restaurantName, String restaurantAddress, String restaurantPhoneNUmber);

    Restaurant getRestaurantByOwnerId(String ownerId);

    Restaurant getRestaurantByRestaurantId(String restaurantId);

    List<FoodItem> getListOfFoodItem(String restaurantId);
}
