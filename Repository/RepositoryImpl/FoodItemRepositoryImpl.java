package Repository.RepositoryImpl;

import Model.FoodItem;
import Repository.FoodItemRepository;
import Service.ServiceImpl.FoodItemServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FoodItemRepositoryImpl implements FoodItemRepository {
    private static FoodItemRepositoryImpl instance ;
    public static synchronized FoodItemRepositoryImpl getInstance(){
        if(instance == null){
            instance = new FoodItemRepositoryImpl();
        }
        return instance;
    }
    List<FoodItem> listOfDeletedFoodItems = new ArrayList<>();

    public boolean addDeletedFoodItem(FoodItem foodItem){
       return listOfDeletedFoodItems.add(foodItem);
    }

    @Override
    public List<FoodItem> getDeletedFoodItem() {
        return listOfDeletedFoodItems;
    }
}
