package Repository;

import Model.Resturant;

import java.util.List;

public interface ResturantRepository {
    List<Resturant> getListOfAllResturant();

    boolean fetchResturantByResturantName(String resturantName);

    boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber);

    boolean addResturantInList(Resturant newResturant);

    Resturant findByOwnerId(String ownerId);

    Resturant getResturantByResturantId(String resturantId);
}
