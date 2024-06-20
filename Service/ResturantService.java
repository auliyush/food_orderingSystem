package Service;

import Model.Resturant;

import java.util.List;

public interface ResturantService {
    List<Resturant> getListOfAllResturant();

    boolean fetchResturantByResturantName(String resturantName);

    boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber);

    boolean addResturant(String resturantId, String ownerId, String resturantName, String resturantAddress, String resturantPhoneNUmber);

    Resturant findByOwnerId(String ownerId);

    Resturant getResturantByResturantId(String resturantId);
}
