package Controller;

import Model.FoodItem;
import Model.Restaurant;
import Service.ServiceImpl.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {
    private static RestaurantController instance;
    public static synchronized RestaurantController getInstance(){
        if(instance == null){
            instance = new RestaurantController();
        }
        return instance;
    }

    RestaurantServiceImpl restaurantService = RestaurantServiceImpl.getInstance();


    public List<Restaurant> getListOfAllRestaurant() {
        return restaurantService.getListOfAllRestaurant();
    }

    public boolean findRestaurantByRestaurantName(String restaurantName) {
        return restaurantService.findRestaurantByRestaurantName(restaurantName);
    }

    public boolean checkPhoneNumberAlreadyExistsOrNot(String restaurantPhoneNUmber) {
        return restaurantService.checkPhoneNumberAlreadyExistsOrNot(restaurantPhoneNUmber);
    }

    public boolean addRestaurant(String restaurantId, String ownerId, String restaurantName,
                                 String restaurantAddress, String restaurantPhoneNUmber) {
        return restaurantService.addRestaurant(restaurantId, ownerId, restaurantName, restaurantAddress, restaurantPhoneNUmber);
    }

    public Restaurant getRestaurantByOwnerId(String ownerId) {
       return restaurantService.getRestaurantByOwnerId(ownerId);
    }

    public Restaurant getRestaurantByRestaurantId(String restaurantId){
        return restaurantService.getRestaurantByRestaurantId(restaurantId);
    }
    public List<FoodItem> getListOfFoodItem(String restaurantId){
        return restaurantService.getListOfFoodItem(restaurantId);
    }
}
