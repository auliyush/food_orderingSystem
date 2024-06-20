package Service.ServiceImpl;

import Model.FoodItem;
import Service.FoodItemService;

import java.util.List;

public class FoodItemServiceImpl implements FoodItemService {

    private static FoodItemServiceImpl instance;
    public static synchronized FoodItemServiceImpl getInstance(){
        if(instance == null){
            instance = new FoodItemServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean addFoodItem(String foodItemId, String resturantId, String foodName, String foodDescription,
                               int foodPrice, boolean foodAvailabilty) {
        FoodItem newFood = new FoodItem(foodItemId, resturantId, foodName, foodDescription, foodPrice,
                foodAvailabilty);
        return ResturantServiceImpl.getInstance().getResturantByResturantId(resturantId).getFoodItemsList().add(newFood);
    }

    @Override
    public List<FoodItem> getFoodItemListByResturantId(String resturantId) {
        return ResturantServiceImpl.getInstance().getResturantByResturantId(resturantId).getFoodItemsList();
    }

    @Override
    public boolean updateFoodItem(String foodItemId, String resturantId, String foodName, String foodDescription,
                                  int foodPrice, boolean foodAvailability) {
        for(FoodItem foodItem : ResturantServiceImpl.getInstance().getResturantByResturantId(resturantId).
                getFoodItemsList()){
            if(foodItem.getId().equals(foodItemId)){
                foodItem.setFoodName(foodName);
                foodItem.setFoodDescription(foodDescription);
                foodItem.setFoodPrice(foodPrice);
                foodItem.setFoodAvailability(foodAvailability);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteFoodItem(String foodItemId, String resturantId) {
        List<FoodItem> fetchFoodItemList = ResturantServiceImpl.getInstance().getResturantByResturantId(resturantId).
                getFoodItemsList();
        for(FoodItem foodItem : fetchFoodItemList){
            if(foodItem.getId().equals(foodItemId)){
                fetchFoodItemList.remove(foodItem);
                return true;
            }
        }
        return false;
    }

    @Override
    public FoodItem getFoodItemById(String foodItemId, String restaurantId) {
        for(FoodItem foodItem : ResturantServiceImpl.getInstance().getResturantByResturantId(restaurantId).
                getFoodItemsList()){
            if(foodItem.getId().equals(foodItemId)){
                return foodItem;
            }
        }
        return null;
    }
}
