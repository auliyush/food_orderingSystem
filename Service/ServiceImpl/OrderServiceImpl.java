package Service.ServiceImpl;

import Controller.RestaurantController;
import Controller.UserController;
import Model.Order;
import Repository.RepositoryImpl.OrderRepositoryImpl;
import Service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static OrderServiceImpl instance;
    public static synchronized OrderServiceImpl getInstance(){
        if(instance == null){
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    OrderRepositoryImpl orderRepository = OrderRepositoryImpl.getInstance();
    @Override
    public boolean orderFood(String orderId, String customerId, String restaurantId, String foodItemId) {
        Order newOrder = new Order(orderId, customerId, restaurantId, foodItemId, "Pending");
        RestaurantController.getInstance().getRestaurantByRestaurantId(restaurantId).getOrdersList().add(newOrder);
        UserController.getInstance().getUserByUserId(customerId).getOrdersList().add(newOrder);
        return orderRepository.addOrder(newOrder);
    }

    @Override
    public List<Order> getOrderListOfCustomerByUserName(String userName) {
       return UserController.getInstance().getUserByUserName(userName).getOrdersList();
    }

    @Override
    public List<Order> getOrderListOfRestaurantByRestaurantId(String restaurantId) {
        return RestaurantController.getInstance().getRestaurantByRestaurantId(restaurantId).getOrdersList();
    }
}
