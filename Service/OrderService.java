package Service;

import Model.Order;

import java.util.List;

public interface OrderService {
    boolean orderFood(String orderId, String customerId, String resturantId, String foodItemId);

    List<Order> getOrderListOfCustomerByUserName(String userName);

    List<Order> getOrderListOfRestaurantByRestaurantId(String restaurantId);
}
