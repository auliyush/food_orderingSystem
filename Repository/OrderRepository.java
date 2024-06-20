package Repository;

import Model.Order;

public interface OrderRepository {
    boolean addOrder(Order newOrder);

    Order findOrderByCustomerId(String customerId);

    Order findOrderByRestaurantId(String restaurantId);
}
