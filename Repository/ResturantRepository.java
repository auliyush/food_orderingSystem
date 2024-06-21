package Repository;

import Model.Restaurant;

import java.util.List;

public interface ResturantRepository {
    List<Restaurant> getListOfAllResturant();

    boolean findResturantByResturantName(String resturantName);

    boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber);

    boolean addResturantInList(Restaurant newRestaurant);

    Restaurant findRestaurantByOwnerId(String ownerId);

    Restaurant findResturantByResturantId(String resturantId);
}
