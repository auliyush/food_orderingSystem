package Repository;

import Model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> getListOfAllRestaurant();

    boolean findRestaurantByRestaurantName(String resturantName);

    boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber);

    boolean addRestaurant(Restaurant newRestaurant);

    Restaurant findRestaurantByOwnerId(String ownerId);

    Restaurant findRestaurantByRestaurantId(String restaurantId);
}
