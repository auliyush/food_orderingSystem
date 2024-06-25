package Repository;

import Model.FoodItem;

import java.util.List;

public interface FoodItemRepository {
    boolean addDeletedFoodItem(FoodItem foodItem);

    List<FoodItem> getDeletedFoodItem();
}
