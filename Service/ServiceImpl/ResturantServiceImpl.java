package Service.ServiceImpl;

import Model.Resturant;
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
    public List<Resturant> getListOfAllResturant() {
      return resturantRepository.getListOfAllResturant();
    }

    @Override
    public boolean fetchResturantByResturantName(String resturantName) {
        return resturantRepository.fetchResturantByResturantName(resturantName);
    }

    @Override
    public boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber) {
        return resturantRepository.checkPhoneNumberAlreadyExistsOrNot(resturantPhoneNUmber);
    }

    @Override
    public boolean addResturant(String resturantId, String ownerId, String resturantName,
                                String resturantAddress, String resturantPhoneNUmber) {
        Resturant newResturant = new Resturant(resturantId, ownerId, resturantName,
                resturantAddress, resturantPhoneNUmber);
       return resturantRepository.addResturantInList(newResturant);
    }

    @Override
    public Resturant findByOwnerId(String ownerId) {
        return resturantRepository.findByOwnerId(ownerId);
    }

    @Override
    public Resturant getResturantByResturantId(String resturantId) {
        return resturantRepository.getResturantByResturantId(resturantId);
    }
}
