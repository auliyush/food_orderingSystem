package Model;

import java.util.ArrayList;
import java.util.List;

public class Resturant {
    private String id;
    private String ownerId;
    private String resturantName;
    private String address;
    private String phoneNumber;
    private List<FoodItem> foodItemsList = new ArrayList<>();
    private List<Order> ordersList = new ArrayList<>();

    public Resturant(String id, String ownerId, String resturantName, String address, String phoneNumber) {
        this.id = id;
        this.ownerId = ownerId;
        this.resturantName = resturantName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getResturantName() {
        return resturantName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<FoodItem> getFoodItemsList() {
        return foodItemsList;
    }

    public void setFoodItemsList(List<FoodItem> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }
}
