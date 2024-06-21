package Service;

import Model.Order;

import java.util.List;

public interface OrderService {
    boolean orderFood(String orderId, String customerId, String resturantId, String foodItemId);

    Order checkOrderStatusFromCustomerByOrderId(String userId);

    String checkOrderStatusForRestaurant(String restaurantId);

    List<Order> getOrderListOfCustomer(String userId);

    List<Order> getOrderListOfRestaurant(String restaurantId);
}
