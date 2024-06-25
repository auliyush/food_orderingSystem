package Repository.RepositoryImpl;

import Model.Restaurant;
import Repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static RestaurantRepositoryImpl instance;
    public static synchronized RestaurantRepositoryImpl getInstance(){
        if(instance == null){
            instance = new RestaurantRepositoryImpl();
        }
        return instance;
    }

    private List<Restaurant> restaurantList = new ArrayList<>();
    @Override
    public List<Restaurant> getListOfAllRestaurant() {
        return restaurantList;
    }

    @Override
    public boolean findRestaurantByRestaurantName(String resturantName) {
        for(Restaurant restaurant : restaurantList){
            if(restaurant.getRestaurantName().equals(resturantName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber) {
        for(Restaurant restaurant : restaurantList){
            if(restaurant.getPhoneNumber().equals(resturantPhoneNUmber)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addRestaurant(Restaurant newRestaurant) {
       return restaurantList.add(newRestaurant);
    }

    @Override
    public Restaurant findRestaurantByOwnerId(String ownerId) {
        for(Restaurant restaurant : restaurantList){
            if(restaurant.getOwnerId().equals(ownerId)){
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public Restaurant findRestaurantByRestaurantId(String restaurantId) {
        for(Restaurant restaurant : restaurantList){
            if(restaurant.getId().equals(restaurantId)){
                return restaurant;
            }
        }
        return null;
    }
}
