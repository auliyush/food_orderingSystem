package Controller;

import Model.Restaurant;
import Service.ServiceImpl.ResturantServiceImpl;

import java.util.List;

public class RestaurantController {
    private static RestaurantController instance;
    public static synchronized RestaurantController getInstance(){
        if(instance == null){
            instance = new RestaurantController();
        }
        return instance;
    }

    ResturantServiceImpl resturantService = ResturantServiceImpl.getInstance();



    public List<Restaurant> getListOfAllResturant() {
        return resturantService.getListOfAllResturant();
    }

    public boolean findResturantByResturantName(String resturantName) {
        return resturantService.findResturantByResturantName(resturantName);
    }

    public boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber) {
        return resturantService.checkPhoneNumberAlreadyExistsOrNot(resturantPhoneNUmber);
    }

    public boolean addResturant( String resturantId, String ownerId,  String resturantName,
                                 String resturantAddress, String resturantPhoneNUmber) {
        return resturantService.addResturant(resturantId, ownerId, resturantName, resturantAddress, resturantPhoneNUmber);
    }

    public Restaurant findRestaurantByOwnerId(String ownerId) {
       return resturantService.findRestaurantByOwnerId(ownerId);
    }

    public Restaurant findRestaurantByRestaurantId(String restaurantId){
        return resturantService.getResturantByResturantId(restaurantId);
    }
}
