package Repository.RepositoryImpl;

import Model.Resturant;
import Model.User;
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

    private List<Resturant> resturantList = new ArrayList<>();
    @Override
    public List<Resturant> getListOfAllResturant() {
        return resturantList;
    }

    @Override
    public boolean fetchResturantByResturantName(String resturantName) {
        for(Resturant resturant : resturantList){
            if(resturant.getResturantName().equals(resturantName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber) {
        for(Resturant resturant : resturantList){
            if(resturant.getPhoneNumber().equals(resturantPhoneNUmber)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addResturantInList(Resturant newResturant) {
       return resturantList.add(newResturant);
    }

    @Override
    public Resturant findByOwnerId(String ownerId) {
        for(Resturant resturant : resturantList){
            if(resturant.getOwnerId().equals(ownerId)){
                return resturant;
            }
        }
        return null;
    }

    @Override
    public Resturant getResturantByResturantId(String resturantId) {
        for(Resturant resturant : resturantList){
            if(resturant.getId().equals(resturantId)){
                return resturant;
            }
        }
        return null;
    }
}
