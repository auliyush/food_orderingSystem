package Service.ServiceImpl;

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
    public boolean orderFood(String orderId, String customerId, String resturantId, String foodItemId) {
        Order newOrder = new Order(orderId, customerId, resturantId, foodItemId, "Pending");
        ResturantServiceImpl.getInstance().getResturantByResturantId(resturantId).getOrdersList().add(newOrder);
        UserServiceImpl.getInstance().getUserByUserName(customerId).getOrdersList().add(newOrder);
        return orderRepository.addOrder(newOrder);
    }

    @Override
    public Order checkOrderStatusFromCustomerByOrderId(String customerId) {
       return orderRepository.findOrderByCustomerId(customerId);
    }

    @Override
    public String checkOrderStatusForRestaurant(String restaurantId) {
        return orderRepository.findOrderByRestaurantId(restaurantId).getOrderStatus();
    }

    @Override
    public List<Order> getOrderListOfCustomer(String userName) {
       return UserServiceImpl.getInstance().getUserByUserName(userName).getOrdersList();
    }

    @Override
    public List<Order> getOrderListOfRestaurant(String restaurantId) {
        return ResturantServiceImpl.getInstance().getResturantByResturantId(restaurantId).getOrdersList();
    }
}
