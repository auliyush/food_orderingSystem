package Repository.RepositoryImpl;

import Model.Restaurant;
import Repository.ResturantRepository;

import java.util.ArrayList;
import java.util.List;

public class ResturantRepositoryImpl implements ResturantRepository {

    private static ResturantRepositoryImpl instance;
    public static synchronized ResturantRepositoryImpl getInstance(){
        if(instance == null){
            instance = new ResturantRepositoryImpl();
        }
        return instance;
    }

    private List<Restaurant> restaurantList = new ArrayList<>();
    @Override
    public List<Restaurant> getListOfAllResturant() {
        return restaurantList;
    }

    @Override
    public boolean findResturantByResturantName(String resturantName) {
        for(Restaurant restaurant : restaurantList){
            if(restaurant.getResturantName().equals(resturantName)){
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
    public boolean addResturantInList(Restaurant newRestaurant) {
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
    public Restaurant findResturantByResturantId(String resturantId) {
        for(Restaurant restaurant : restaurantList){
            if(restaurant.getId().equals(resturantId)){
                return restaurant;
            }
        }
        return null;
    }
}
