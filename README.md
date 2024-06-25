# food_orderingSystem
second project of coding age


#Code Layout

 1 Model

       A. User
       
            //attributes

             String id;
             String userName;
             String userPassword;
             String userEmail;
             String userRole;
             List<Order>;   ----> list of orders of Customer User

             //constructor  using - id,userName,userPassword,userEmail,userRole
             //getter and setter  - id,userName,userPassword,userEmail,userRole,List<Order>


       B. Restaurant

            //attributes

             String id;
             String ownerId;
             String restaurantName;
             String address;
             String phoneNumber;
             List<Order>;   ----> list of orders from Customer User to restaurant
             List<FoodItem>;   ----> list of foodItems of restaurant

             //constructor  using - id,ownerId,restaurantName,address,phoneNumber
             //getter and setter  - id,ownerId,restaurantName,address,phoneNumber,List<Order>,List<FoodItem>


       C. FoodItem

            //attributes

             String id;
             String restaurantId;
             String foodName;
             String foodDescription;
             int foodPrice;
             boolean foodAvailability;

             //constructor  using - id,restaurantId,restaurantName,foodName,foodDescription,foodPrice,foodAvailability
             //getter and setter  - id,restaurantId,restaurantName,foodName,foodDescription,foodPrice,foodAvailability


       D. Order

            //attributes

             String id;
             String customerId;
             String restaurantId;
             String foodItemId;
             String orderStatus;

             //constructor  using - id,customerId,restaurantId,foodItemId,orderStatus
             //getter and setter  - id,customerId,restaurantId,foodItemId,orderStatus


2 Repository

       A. FoodItemRepository
       
            //methods();

             boolean addDeletedFoodItem(FoodItem foodItem);
             --->  this method is use for add those foodItem in FoodItemRepository which
                    is deleted by restaurant in their list

             List<FoodItem> getDeletedFoodItem();
             ---> this method is use for get list of deleted food Item 


       B. OrderRepository
       
            //methods();

             boolean addOrder(Order newOrder);
             --->  this method is use for add new Order in Order repository

             Order findOrderByCustomerId(String customerId);
             ---> this method is use for find Order by using Customer Id

             Order findOrderByRestaurantId(String restaurantId);
             ---> this method is use for find Order by using Restaurant Id


       C. RestaurantRepository
       
            //methods();

             boolean findResturantByResturantName(String resturantName);
             ---> this method is use for find Restaurant already exists or not

             boolean checkPhoneNumberAlreadyExistsOrNot(String resturantPhoneNUmber);
             ---> this method is use for check New restaurant's phone number already exists or not

             boolean addRestaurant(Restaurant newRestaurant);
             ---> this method is use for add New Restaurant in Restaurant repository's List

             Restaurant findRestaurantByOwnerId(String ownerId);
             ---> this method is use for get Restaurant by OwnerId

             Restaurant findRestaurantByRestaurantId(String restaurantId);
             ---> this method is use for get Restaurant by RestaurantId

             List<Restaurant> getListOfAllRestaurant();
             ---> this method is use for get list of all restaurant.


       D. UserRepository
       
            //methods();

             User getUserByUserName(String userName)
             ---> this method use is for get user by user's name for check existing of User

             boolean addUser(User user)
             ---> this method is use for add new user in user repository

             User getUserByUserId(String userId)
             ---> this method is use for get User by user's Id

             boolean checkEmailAlreadyExistsOrNot(String userEmail)
             ---> this method is use for check Email already exists or not


3 Service

       A. FoodItemService          
       
            //methods();

             boolean addFoodItem(String foodItemId, String resturantId, String foodName,
                                  String foodDescription, int foodPrice, boolean foodAvailabilty);
             --->  this method is use for add food item in  given restaurantId's Restaurant's fooditem List

             List<FoodItem> getFoodItemListByResturantId(String resturantId);
             ---> this method is use for get list of foodItem of given restaurntId's restaurant

             boolean updateFoodItem(String foodItemId, String resturantId, String foodName, 
                                      String foodDescription, int foodPrice, boolean foodAvailability);
             ---> this method is use for Update food item of given restaurantId's restaurant

             boolean deleteFoodItem(String foodItemId, String resturantId);
             ---> this method is use for delete food item of given restaurantId's restaurant

             FoodItem getFoodItemById(String foodItemId, String restaurantId);
             ---> this method is use for get foodItem from given foodItemId from given restaurantId's restaurant

             boolean addDeletedFoodItem(FoodItem foodItem);
             --->  this method is use for add those foodItem in FoodItemRepository which
                    is deleted by restaurant in their list

             List<FoodItem> getDeletedFoodItem();
             ---> this method is use for get list of deleted food Item 


       B. OrderService         
       
            //methods();

             boolean orderFood(String orderId, String customerId, String resturantId, String foodItemId);
             --->  this method is use for placeOrder

             List<Order> getOrderListOfCustomerByUserName(String userName);
             ---> this method is use for get list of Customer's all Order by customer's Id 

             List<Order> getOrderListOfRestaurantByRestaurantId(String restaurantId);
             ---> this method is use for get list of Restaurant's all Order by Restaurant's Id


       C. RestaurantService      
       
            //methods();

             List<Restaurant> getListOfAllRestaurant();
             --->  this method is use for get list of all Rstaurants

             boolean findRestaurantByRestaurantName(String restaurantName);
             ---> this method is use for find Restaurant already exists or not

             boolean checkPhoneNumberAlreadyExistsOrNot(String restaurantPhoneNUmber);
             ---> this method is use for check New restaurant's phone number already exists or not

             boolean addRestaurant(String restaurantId, String ownerId, String restaurantName, 
                                     String restaurantAddress, String restaurantPhoneNUmber);
             ---> this method is use for create and save restaurant in repository

             Restaurant findRestaurantByOwnerId(String ownerId);
             ---> this method is use for get restaurant by Owner Id

             Restaurant getRestaurantByRestaurantId(String restaurantId);
             ---> this method is use for get restaurant by Restaurant Id

             List<FoodItem> getListOfFoodItem(String restaurantId);
             ---> this method is use for get list of all FoodItem of restaurantId's Restaurant


       D. UserService      
       
            //methods();

             User getUserByUserName(String userName);
             --->  this method use is for get user by user's name for check existing of User

             User getUserByUserId(String customerId);
             ---> this method is use for get User by user's Id 

             boolean signUp(String toString, String username, String userEmail, String userPassword,
                               String userRole);
             ---> this method is use for create a User and save in User Repository

             boolean checkEmailAlreadyExistsOrNot(String userEmail);
             ---> this method is use for check Email already exists or not 


4 Controller

       A. FoodItemController      
       
            //methods();

             boolean addFoodItem(String foodItemId, String restaurantId, String foodName, String foodDescription,
                                 int foodPrice, boolean foodAvailabilty);
             --->  this method is use for add foodItem

             List<FoodItem> getFoodItemListByResturantId(String resturantId);
             ---> this method is use for get list of foodItem of given restaurntId's restaurant

             boolean updateFoodItem(String foodItemId, String resturantId, String foodName, 
                                      String foodDescription, int foodPrice, boolean foodAvailability);
             ---> this method is use for Update food item of given restaurantId's restaurant

             boolean deleteFoodItem(String foodItemId, String resturantId);
             ---> this method is use for delete food item of given restaurantId's restaurant

             FoodItem getFoodItemById(String foodItemId, String restaurantId);
             ---> this method is use for get foodItem from given foodItemId from given restaurantId's restaurant

             boolean addDeletedFoodItem(FoodItem foodItem);
             --->  this method is use for add those foodItem in FoodItemRepository which
                    is deleted by restaurant in their list

             List<FoodItem> getDeletedFoodItem();
             ---> this method is use for get list of deleted food Item 

       B. OrderController          
       
            //methods();

             boolean orderFood(String orderId, String customerId, String resturantId, String foodItemId);
             --->  this method is use for placeOrder

             List<Order> getOrderListOfCustomerByUserName(String userName);
             ---> this method is use for get list of Customer's all Order by customer's Id 

             List<Order> getOrderListOfRestaurantByRestaurantId(String restaurantId);
             ---> this method is use for get list of Restaurant's all Order by Restaurant's Id


       C. RestaurantController    
       
            //methods();

             List<Restaurant> getListOfAllRestaurant();
             --->  this method is use for get list of all Rstaurants

             boolean findRestaurantByRestaurantName(String restaurantName);
             ---> this method is use for find Restaurant already exists or not

             boolean checkPhoneNumberAlreadyExistsOrNot(String restaurantPhoneNUmber);
             ---> this method is use for check New restaurant's phone number already exists or not

             boolean addRestaurant(String restaurantId, String ownerId, String restaurantName, 
                                     String restaurantAddress, String restaurantPhoneNUmber);
             ---> this method is use for create and save restaurant in repository

             Restaurant getRestaurantByOwnerId(String ownerId);
             ---> this method is use for get restaurant by Owner Id

             Restaurant getRestaurantByRestaurantId(String restaurantId);
             ---> this method is use for get restaurant by Restaurant Id

             List<FoodItem> getListOfFoodItem(String restaurantId);
             ---> this method is use for get list of all FoodItem of restaurantId's Restaurant


       D. UserController    
       
            //methods();

             User getUserByUserName(String userName);
             --->  this method use is for get user by user's name for check existing of User

             User getUserByUserId(String customerId);
             ---> this method is use for get User by user's Id 

             boolean signUp(String toString, String username, String userEmail, String userPassword,
                               String userRole);
             ---> this method is use for create a User and save in User Repository 

             boolean checkEmailAlreadyExistsOrNot(String userEmail);
             ---> this method is use for check Email already exists or not