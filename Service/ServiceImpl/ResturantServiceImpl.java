package Service.ServiceImpl;

import Model.FoodItem;
import Model.Restaurant;
import Repository.RepositoryImpl.ResturantRepositoryImpl;
import Service.ResturantService;

import java.util.List;


public class ResturantServiceImpl implements ResturantService {

    private static ResturantServiceImpl instance;
    public static synchronized ResturantServiceImpl getInstance(){
        if(instance == null){
            instance = new ResturantServiceImpl();
        }
        return instance;
    }
    ResturantRepositoryImpl resturantRepository = ResturantRepositoryImpl.getInstance();

    @Override
    public List<Restaurant> getListOfAllResturant() {
      return resturantRepository.getListOfAllResturant();
    }

    @Override
    public boolean findResturantByResturantName(String resturantName) {
        return resturantRepository.findResturantByResturantName(resturantName);
    }

    @Override
    public boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber) {
        return resturantRepository.checkPhoneNumberAlreadyExistsOrNot(resturantPhoneNUmber);
    }

    @Override
    public boolean addResturant(String resturantId, String ownerId, String resturantName,
                                String resturantAddress, String resturantPhoneNUmber) {
        Restaurant newRestaurant = new Restaurant(resturantId, ownerId, resturantName,
                resturantAddress, resturantPhoneNUmber);
       return resturantRepository.addResturantInList(newRestaurant);
    }

    @Override
    public Restaurant findRestaurantByOwnerId(String ownerId) {
        return resturantRepository.findRestaurantByOwnerId(ownerId);
    }

    @Override
    public Restaurant getResturantByResturantId(String resturantId) {
        return resturantRepository.findResturantByResturantId(resturantId);
    }

    @Override
    public List<FoodItem> getListOfFoodItem(String restaurantId) {
       return resturantRepository.findResturantByResturantId(restaurantId).getFoodItemsList();
    }
}
