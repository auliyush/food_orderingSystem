package Repository.RepositoryImpl;

import Model.Order;
import Repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private static OrderRepositoryImpl instance;
    public static synchronized OrderRepositoryImpl getInstance(){
        if(instance == null){
            instance = new OrderRepositoryImpl();
        }
        return instance;
    }

    private List<Order> listOfOrders = new ArrayList<>();

    @Override
    public boolean addOrder(Order newOrder) {
        return listOfOrders.add(newOrder);
    }

    @Override
    public Order findOrderByCustomerId(String customerId) {
        for(Order order : listOfOrders){
            if(order.getCustomerId().equals(customerId)){
                return order;
            }
        }
        return null;
    }

    @Override
    public Order findOrderByRestaurantId(String restaurantId) {
        for(Order order : listOfOrders){
            if(order.getRestaurantId().equals(restaurantId)){
                return order;
            }
        }
        return null;
    }
}
