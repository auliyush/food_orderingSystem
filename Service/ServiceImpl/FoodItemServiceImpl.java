package Service.ServiceImpl;

import Controller.FoodItemController;
import Controller.RestaurantController;
import Model.FoodItem;
import Repository.RepositoryImpl.FoodItemRepositoryImpl;
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
    public boolean addFoodItem(String foodItemId, String restaurantId, String foodName, String foodDescription,
                               int foodPrice, boolean foodAvailability) {
        FoodItem newFood = new FoodItem(foodItemId, restaurantId, foodName, foodDescription, foodPrice,
                foodAvailability);
        return RestaurantController.getInstance().getRestaurantByRestaurantId(restaurantId).getFoodItemsList().add(newFood);
    }

    @Override
    public List<FoodItem> getFoodItemListByRestaurantId(String restaurantId) {
        return RestaurantController.getInstance().getRestaurantByRestaurantId(restaurantId).getFoodItemsList();
    }

    @Override
    public boolean updateFoodItem(String foodItemId, String restaurantId, String foodName, String foodDescription,
                                  int foodPrice, boolean foodAvailability) {
        for(FoodItem foodItem : RestaurantController.getInstance().getRestaurantByRestaurantId(restaurantId).
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
    public boolean deleteFoodItem(String foodItemId, String restaurantId) {
        List<FoodItem> fetchFoodItemList = RestaurantController.getInstance().getRestaurantByRestaurantId(restaurantId).
                getFoodItemsList();
        for(FoodItem foodItem : fetchFoodItemList){
            if(foodItem.getId().equals(foodItemId)){
                FoodItemController.getInstance().saveDeletedFoodItemInGlobalList(foodItem,restaurantId);
                fetchFoodItemList.remove(foodItem);
                return true;
            }
        }
        return false;
    }

    @Override
    public FoodItem getFoodItemById(String foodItemId, String restaurantId) {
        List<FoodItem> foodItemList = RestaurantController.getInstance().getRestaurantByRestaurantId(restaurantId).
                getFoodItemsList();
        for(FoodItem foodItem : foodItemList){
            if(foodItem.getId().equals(foodItemId)){
                return foodItem;
            }
        }
        foodItemList = FoodItemController.getInstance().getDeletedFoodItem();
        for(FoodItem foodItem : foodItemList){
            if(foodItem.getId().equals(foodItemId)){
                return foodItem;
            }
        }
        return null;
    }

    @Override
    public boolean saveDeletedFoodItemInGlobalList(FoodItem foodItem, String restaurantId) {
        return FoodItemRepositoryImpl.getInstance().addDeletedFoodItem(foodItem);
    }

    @Override
    public List<FoodItem> getDeletedFoodItem() {
        return FoodItemRepositoryImpl.getInstance().getDeletedFoodItem();
    }
}
