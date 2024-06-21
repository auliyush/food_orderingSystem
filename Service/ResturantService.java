package Service;

import Model.FoodItem;
import Model.Restaurant;

import java.util.List;

public interface ResturantService {
    List<Restaurant> getListOfAllResturant();

    boolean findResturantByResturantName(String resturantName);

    boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber);

    boolean addResturant(String resturantId, String ownerId, String resturantName, String resturantAddress, String resturantPhoneNUmber);

    Restaurant findRestaurantByOwnerId(String ownerId);

    Restaurant getResturantByResturantId(String resturantId);

    List<FoodItem> getListOfFoodItem(String restaurantId);
}
