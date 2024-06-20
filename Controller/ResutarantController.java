package Controller;

import Model.Resturant;
import Service.ServiceImpl.ResturantServiceImpl;

import java.util.List;

public class ResutarantController {
    private static ResutarantController instance;
    public static synchronized ResutarantController getInstance(){
        if(instance == null){
            instance = new ResutarantController();
        }
        return instance;
    }

    ResturantServiceImpl resturantService = ResturantServiceImpl.getInstance();



    public List<Resturant> getListOfAllResturant() {
        return resturantService.getListOfAllResturant();
    }

    public boolean fetchResturantByResturantName(String resturantName) {
        return resturantService.fetchResturantByResturantName(resturantName);
    }

    public boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber) {
        return resturantService.checkPhoneNumberAlreadyExistsOrNot(resturantPhoneNUmber);
    }

    public boolean addResturant( String resturantId, String ownerId,  String resturantName,
                                 String resturantAddress, String resturantPhoneNUmber) {
        return resturantService.addResturant(resturantId, ownerId, resturantName, resturantAddress, resturantPhoneNUmber);
    }

    public Resturant findByOwnerId(String ownerId) {
       return resturantService.findByOwnerId(ownerId);
    }
}
