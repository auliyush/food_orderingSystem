package Controller;

import Model.Order;
import Service.ServiceImpl.OrderServiceImpl;

import java.util.List;

public class OrderController {
    private static OrderController instance;
    public static synchronized OrderController getInstance(){
        if(instance == null){
            instance = new OrderController();
        }
        return instance;
    }

    OrderServiceImpl orderService = OrderServiceImpl.getInstance();

    public boolean orderFood(String orderId, String customerId, String resturantId, String foodItemId) {
        return orderService.orderFood(orderId, customerId, resturantId, foodItemId);
    }

    public List<Order> getOrderListOfCustomerByUserName(String userName) {
        return orderService.getOrderListOfCustomerByUserName(userName);
    }

    public List<Order> getOrderListOfRestaurantByRestaurantId(String restaurantId) {
        return orderService.getOrderListOfRestaurantByRestaurantId(restaurantId);
    }
}
