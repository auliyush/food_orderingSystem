package Model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private String restaurantId;
    private String foodItemId;
    private String orderStatus;

    public Order(String id, String customerId, String restaurantId, String foodItemId, String orderStatus) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.foodItemId = foodItemId;
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
    public String getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(String foodItemId) {
        this.foodItemId = foodItemId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
