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

    public Order checkOrderStatusFromCustomerByOrderId(String userId) {
       return orderService.checkOrderStatusFromCustomerByOrderId(userId);
    }

    public String checkOrderStatusForRestaurant(String restaurantId) {
        return orderService.checkOrderStatusForRestaurant(restaurantId);
    }

    public List<Order> getOrderListOfCustomer(String userName) {
        return orderService.getOrderListOfCustomer(userName);
    }

    public List<Order> getOrderListOfRestaurant(String restaurantId) {
        return orderService.getOrderListOfRestaurant(restaurantId);
    }
}
