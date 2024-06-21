package Service.ServiceImpl;

import Model.FoodItem;
import Model.Restaurant;
import Repository.RepositoryImpl.RestaurantRepositoryImpl;
import Service.RestaurantService;

import java.util.List;


public class RestaurantServiceImpl implements RestaurantService {

    private static RestaurantServiceImpl instance;
    public static synchronized RestaurantServiceImpl getInstance(){
        if(instance == null){
            instance = new RestaurantServiceImpl();
        }
        return instance;
    }
    RestaurantRepositoryImpl resturantRepository = RestaurantRepositoryImpl.getInstance();

    @Override
    public List<Restaurant> getListOfAllRestaurant() {
      return resturantRepository.getListOfAllRestaurant();
    }

    @Override
    public boolean findRestaurantByRestaurantName(String restaurantName) {
        return resturantRepository.findRestaurantByRestaurantName(restaurantName);
    }

    @Override
    public boolean checkPhoneNumberAlreadyExistsOrNot(String restaurantPhoneNUmber) {
        return resturantRepository.checkPhoneNumberAlreadyExistsOrNot(restaurantPhoneNUmber);
    }

    @Override
    public boolean addRestaurant(String restaurantId, String ownerId, String restaurantName,
                                 String restaurantAddress, String restaurantPhoneNUmber) {
        Restaurant newRestaurant = new Restaurant(restaurantId, ownerId, restaurantName,
                restaurantAddress, restaurantPhoneNUmber);
       return resturantRepository.addRestaurant(newRestaurant);
    }

    @Override
    public Restaurant getRestaurantByOwnerId(String ownerId) {
        return resturantRepository.findRestaurantByOwnerId(ownerId);
    }

    @Override
    public Restaurant getRestaurantByRestaurantId(String restaurantId) {
        return resturantRepository.findRestaurantByRestaurantId(restaurantId);
    }

    @Override
    public List<FoodItem> getListOfFoodItem(String restaurantId) {
       return resturantRepository.findRestaurantByRestaurantId(restaurantId).getFoodItemsList();
    }
}
