import Controller.FoodItemController;
import Controller.OrderController;
import Controller.RestaurantController;
import Controller.UserController;
import Model.FoodItem;
import Model.Order;
import Model.Restaurant;
import Model.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UiClient {
    HelperForValidating helperForValidatingObj = HelperForValidating.getInstance();
    UserController userController = UserController.getInstance();
    RestaurantController restaurantController = RestaurantController.getInstance();
    FoodItemController foodItemController = FoodItemController.getInstance();
    OrderController orderController = OrderController.getInstance();

    //    for Id variables
    static int orders = 1;
    static int users = 1;
    static int foodItem = 1;
    static int restaurant = 1;

    Scanner sc = new Scanner(System.in);

    //    populate Owner
    {
        userController.signUp(Integer.toString(users++), "@deorishi", "@rishi12", "deorishi@gmail.com",
                "owner");
        userController.signUp(Integer.toString(users++), "@abhishekJha", "@jha12", "abhishekjha@gmail.com",
                "owner");
        userController.signUp(Integer.toString(users++), "@gaurav", "@gaurav12", "gaurav@gmail.com",
                "owner");
        userController.signUp(Integer.toString(users++), "@ayushVerma", "@ayush12", "verma@gmail.com",
                "owner");
    }

    //   populate Customer

    {
        userController.signUp(Integer.toString(users++), "@manjit", "@manjit12", "manjit@gmail.com",
                "customer");
        userController.signUp(Integer.toString(users++), "@prince", "@prince12", "prince@gmail.com",
                "customer");
        userController.signUp(Integer.toString(users++), "@ritik", "@ritik12", "ritik@gmail.com",
                "customer");
        userController.signUp(Integer.toString(users++), "@misty", "@misty12", "misty@gmail.com",
                "customer");
        userController.signUp(Integer.toString(users++), "@palak", "@palak12", "palak@gmail.com",
                "customer");
        userController.signUp(Integer.toString(users++), "@aditi", "@aditi12", "aditi@gmail.com",
                "customer");
        userController.signUp(Integer.toString(users++), "@rahul", "@rahul12", "rahul@gmail.com",
                "customer");
        userController.signUp(Integer.toString(users++), "@chhotu", "@chhotu12", "chhotu@gmail.com",
                "customer");
    }


    public static void main(String[] args) {
        do {

            UiClient uiClient = new UiClient();
            Scanner sc = new Scanner(System.in);
            System.out.println("\n\n***************************************************");
            System.out.println("*              Welcome To Zayka                   *");
            System.out.println("***************************************************");

            while (true) {
                System.out.println("\n***************");
                System.out.println("*  HOME PAGE  *");
                System.out.println("***************\n");

                System.out.println("Options:");
                System.out.println("1. SignIn");
                System.out.println("2. SignUp");
                System.out.println("3. Exit\n");

                System.out.print("Enter your option: \n");
                int option = 0;

                try {
                    option = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("Invalid option");
                    sc.nextLine();                           // To remove new Line character from input stream.
                    continue;
                }



                switch (option) {
                    case 1:
                        uiClient.signIn();
                        break;
                    case 2:
                        uiClient.signUp();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Please Enter Valid Option");
                }
            }
        } while (true);

    }     // main method


    public void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n****************");
        System.out.println("* SIGN UP PAGE *");
        System.out.println("****************\n");
        System.out.println("Enter username");
        String username = sc.nextLine();
        if (Objects.equals(username, "q")) {
            return;
        }
        username = helperForValidatingObj.trimmedMethod(username);
        User user = userController.getUserByUserName(username);
        String validateUserName = helperForValidatingObj.validateUserName(username);
        while (!Objects.equals(validateUserName, "valid") || user != null) {
            if (!Objects.equals(validateUserName, "valid")) {
                System.out.println(validateUserName);
            }
            if (user != null) {
                System.out.println("Username already Exists, try another Username");
            }
            username = sc.nextLine();
            if (Objects.equals(username, "q")) {
                return;
            }
            username = helperForValidatingObj.trimmedMethod(username);
            validateUserName = helperForValidatingObj.validateUserName(username);
            user = userController.getUserByUserName(username);

        }
        System.out.println("Enter Your E-mail");
        String userEmail = sc.nextLine();
        if (Objects.equals(userEmail, "q")) {
            return;
        }
        boolean returnValue = userController.checkEmailAlreadyExistsOrNot(userEmail);
        String validateUserEmail = helperForValidatingObj.validateUserEmail(userEmail);
        while (returnValue || !Objects.equals(validateUserEmail, "valid")) {
            if (!Objects.equals(validateUserEmail, "valid")) {
                System.out.println(validateUserEmail);
            }
            if (returnValue) {
                System.out.println("E-mail already Exists");
            }
            userEmail = sc.nextLine();
            if (Objects.equals(userEmail, "q")) {
                return;
            }
            userEmail = helperForValidatingObj.trimmedMethod(userEmail);
            returnValue = userController.checkEmailAlreadyExistsOrNot(userEmail);
        }
        System.out.println("Create Your Password");
        String userPassword = sc.nextLine();
        if (Objects.equals(userPassword, "q")) {
            return;
        }
        userPassword = helperForValidatingObj.trimmedMethod(userPassword);
        while (!Objects.equals(helperForValidatingObj.validateUserPassword(userPassword), "valid")) {
            System.out.println(helperForValidatingObj.validateUserPassword(userPassword));
            userPassword = sc.nextLine();
            if (Objects.equals(userPassword, "q")) {
                return;
            }
            userPassword = helperForValidatingObj.trimmedMethod(userPassword);
        }
        System.out.println("Sign Up as Owner Y/N");
        String userRole = sc.nextLine();
        if (Objects.equals(userRole, "q")) {
            return;
        }
        userRole = helperForValidatingObj.trimmedMethod(userRole);
        while (true) {
            if (userRole.equals("y") || userRole.equals("Y") || userRole.equals("N") || userRole.equals("n")) {
                break;
            }
            System.out.println("Please Enter only Y or N");
            userRole = sc.nextLine();
            if (Objects.equals(userRole, "q")) {
                return;
            }
            userRole = helperForValidatingObj.trimmedMethod(userRole);
        }
        String userId = Integer.toString(users++);
        if (userRole.equals("Y") || userRole.equals("y")) {
            userController.signUp(userId, username, userPassword, userEmail, "owner");
            System.out.println(username + " Successfully Signed Up as Owner");
        } else {
            userController.signUp(userId, username, userPassword, userEmail, "customer");
            System.out.println(username + " Successfully Signed Up as Customer");
        }

    }   // Sign up method

    public void signIn() {
        System.out.println("\n****************");
        System.out.println("* SIGN IN PAGE *");
        System.out.println("****************\n");

        System.out.println("Enter username");
        String username = sc.nextLine();
        if (Objects.equals(username, "q")) {
            return;
        }
        username = helperForValidatingObj.trimmedMethod(username);
        User user = userController.getUserByUserName(username);
        if (user != null) {
            System.out.println("Enter Your Password");
            String userPassword = sc.nextLine();
            if (Objects.equals(userPassword, "q")) {
                return;
            }
            userPassword = helperForValidatingObj.trimmedMethod(userPassword);
            if (user.getUserPassword().equals(userPassword)) {
                if (userController.getUserByUserName(username).getUserRole().equals("owner")) {
                    ownersHomePage(user);
                } else {
                    customerHomePage(user);
                }
            } else {
                System.out.println("Wrong Username or password");
            }
        } else {
            System.out.println("Username not Exists");
        }
    }   // Sign in method


    //    For Customer

    private void customerHomePage(User user) {
        do {

            System.out.println("\n------------------------------");
            System.out.println("* Customer Home Page *");
            System.out.println("------------------------------\n");

            System.out.println("Options:");
            System.out.println("1.Show Restaurant Lists");
            System.out.println("2.My Orders");
            System.out.println("3.Sign out");

            System.out.print("Enter your option: \n");
            int option = 0;

            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid Option");
                sc.nextLine();                           // To remove new Line character from input stream.
                continue;
            }


            switch (option) {
                case 1:
                    showRestaurants(user);
                    break;
                case 2:
                    orderStatusForUser(user);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please Enter Valid Option");
            }
        } while (true);


    }  // this method for customer Home Page

    public void showRestaurants(User user) {
        List<Restaurant> restaurantList = restaurantController.getListOfAllRestaurant();
        if (restaurantList.isEmpty()) {
            System.out.println("\nSorry No one Restaurant available Now");
            return;
        }
        int flagMark = 1;
        for (Restaurant restaurant : restaurantList) {
            System.out.println(flagMark++ + " : " + restaurant.getRestaurantName());
        }

        int chooseOption = 0;
        System.out.println("Choose Restaurant");
        while (chooseOption == 0) {
            try {
                chooseOption = sc.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please Enter Valid Option");
                sc.nextLine();
            }
        }
        flagMark = 1;
        for (Restaurant restaurant : restaurantList) {
            if (flagMark++ == chooseOption) {
                openChooseRestaurant(restaurant, user);
                return;
            }
        }
        System.out.println("Invalid option");

    }       // this method for show restaurant lists

    private void openChooseRestaurant(Restaurant restaurant, User user) {
        do {

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 50; j++) {
                    if (i == 4 || i == 0) {
                        System.out.print("_");
                    } else if (i == 2 && j == 0 || i == 2 && j == 49) {
                        System.out.print("");
                    } else if (j == 0 || j == 49) {
                        System.out.print("|");
                    } else if (i == 2 && j == 15) {
                        System.out.print(restaurant.getRestaurantName());
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

            System.out.println("Options:");
            System.out.println("1. Show Menu");
            System.out.println("2. Order Food");
            System.out.println("3. My orders");
            System.out.println("4. Exit\n");

            System.out.print("Enter your option: \n");
            int option = 0;
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid Option");
                sc.nextLine();
                continue;
            }
            switch (option) {
                case 1:
                    showMenuForCustomer(restaurant);
                    break;
                case 2:
                    orderFoodFromChooseRestaurant(restaurant, user);
                    break;
                case 3:
                    orderStatusForUser(user);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please Enter Valid Option");
            }
        } while (true);
    }  // this method for order and show menu of
    // Choose Restaurant

    public void orderStatusForUser(User user) {
        List<Order> listOfCustomerOrders = orderController.getOrderListOfCustomerByUserName(user.getUserName());
        if (listOfCustomerOrders.isEmpty()) {
            System.out.println("\nNo orders, Go and Order some Food");
            return;
        }
        int totalBill = 0;
        for (Order order : listOfCustomerOrders) {
            System.out.println("Your Order Id : " + order.getId());
            if (order.getOrderStatus().equals("Pending")) {
                System.out.println("Your Order : " + foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " is Pending, please Wait\n");
            } else if (order.getOrderStatus().equals("Progress")) {
                System.out.println("Your Order : " + foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " is in Progress, Please wait little more time\n");
            } else {
                System.out.println("Your Order : " + foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " is Delivered\n");
            }
            if(!Objects.equals(order.getOrderStatus(), "Delivered")){
                totalBill = totalBill + foodItemController.getFoodItemById(
                        order.getFoodItemId(),order.getRestaurantId()).getFoodPrice();
            }
        }
        System.out.println("Your Total Bill is : "+totalBill);
    }    // this method show order Status for Customer

    public void showMenuForCustomer(Restaurant restaurant) {
        List<FoodItem> foodItemList = foodItemController.getFoodItemListByRestaurantId(restaurant.getId());
        if (foodItemList.isEmpty()) {
            System.out.println("Sorry no one foodItem available Now");
        }
        for (FoodItem foodItem : foodItemList) {
            System.out.println("\n* " + foodItem.getFoodName());
            System.out.println("* " + foodItem.getFoodDescription());
            System.out.println("* " + foodItem.getFoodPrice() + "/-");
            if (foodItem.getFoodAvailability()) {
                System.out.println("* Available");
            } else {
                System.out.println("* Not Available");
            }
        }
    }  // this method for Show foodItem of choose restaurant

    public void orderFoodFromChooseRestaurant(Restaurant restaurant, User user) {
        List<FoodItem> restaurantFoodItemLIst = foodItemController.getFoodItemListByRestaurantId(restaurant.getId());
        if (restaurantFoodItemLIst.isEmpty()) {
            System.out.println("No one FoodItem is Available now");
            return;
        }
        int flagMark = 1;
        for (FoodItem foodItem : restaurantFoodItemLIst) {
            System.out.println("\n" + flagMark);
            System.out.println("* " + foodItem.getFoodName());
            System.out.println("* " + foodItem.getFoodDescription());
            System.out.println("* " + foodItem.getFoodPrice() + "/-");
            if (foodItem.getFoodAvailability()) {
                System.out.println("* Available");
            } else {
                System.out.println("* Not Available");
            }
            flagMark++;
        }
        System.out.println("Enter your Order : ");
        int chooseFoodItem = 0;
        while (chooseFoodItem == 0) {
            try {
                chooseFoodItem = sc.nextInt();
                if (chooseFoodItem >= flagMark + 1) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please Enter Valid option");
                sc.nextLine();
            }
        }
        String orderId = Integer.toString(orders++);
        flagMark = 1;
        for (FoodItem foodItem : restaurantFoodItemLIst) {
            if (flagMark++ == chooseFoodItem) {
                if (!foodItem.getFoodAvailability()) {
                    System.out.println("Sorry food is not available now");
                    return;
                }
                orderController.orderFood(orderId, user.getId(), restaurant.getId(), foodItem.getId());
                System.out.println("\nOrdered " + foodItem.getFoodName());
                return;
            }
        }
    } //for Order food from restaurant


    //    FOR Restaurant Owners
    public void ownersHomePage(User user) {
        do {
            System.out.println("\n------------------------------");
            System.out.println("     * Owner Home Page *");
            System.out.println("------------------------------\n");
            System.out.println("Options:");
            System.out.println("1.Create restaurant");
            System.out.println("2.Open restaurant");
            System.out.println("3.sign out\n");
            System.out.println("Enter Your Option : ");
            int chooseOption = 0;
            try {
                chooseOption = sc.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid Option");
                sc.nextLine();
                continue;
            }

            sc.nextLine();                           // To remove new Line character from input stream.

            switch (chooseOption) {
                case 1:
                    createRestaurant(user);
                    break;
                case 2:
                    openRestaurant(user);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please Enter Valid Option");
                    sc.nextLine();

            }
        } while (true);

    }

    public void createRestaurant(User user) {
        Restaurant restaurantObj = restaurantController.getRestaurantByOwnerId(user.getId());
        if (restaurantObj != null) {
            System.out.println("You have already created one restaurant " + restaurantObj.getRestaurantName());
            return;
        }
        System.out.println("Enter Restaurant Name");
        String restaurantName = sc.nextLine();
        if (Objects.equals(restaurantName, "q")) {
            return;
        }
        restaurantName = helperForValidatingObj.trimmedMethod(restaurantName);
        while (restaurantController.findRestaurantByRestaurantName(restaurantName)) {
            System.out.println("this name's Restaurant already exists try another Name");
            restaurantName = sc.nextLine();
            if (Objects.equals(restaurantName, "q")) {
                return;
            }
        }
        System.out.println("Enter Phone Number");
        String restaurantPhoneNUmber = sc.nextLine();
        if (Objects.equals(restaurantPhoneNUmber, "q")) {
            return;
        }
        boolean validatePhoneNumberReturnValue = helperForValidatingObj.validateUserPhoneNUmber(restaurantPhoneNUmber);
        boolean returnValue = restaurantController.checkPhoneNumberAlreadyExistsOrNot(restaurantPhoneNUmber);
        while (returnValue || !validatePhoneNumberReturnValue) {
            if (!validatePhoneNumberReturnValue) {
                System.out.println("Please Enter Valid Phone Number");
            }
            if (returnValue) {
                System.out.println("Number already registered");
            }
            restaurantPhoneNUmber = sc.nextLine();
            if (Objects.equals(restaurantPhoneNUmber, "q")) {
                return;
            }
            validatePhoneNumberReturnValue = helperForValidatingObj.validateUserPhoneNUmber(restaurantPhoneNUmber);
            returnValue = restaurantController.checkPhoneNumberAlreadyExistsOrNot(restaurantPhoneNUmber);
        }
        System.out.println("Enter Address");
        String restaurantAddress = sc.nextLine();
        if (Objects.equals(restaurantAddress, "q")) {
            return;
        }
        String restaurantId = Integer.toString(restaurant++);
        restaurantController.addRestaurant(restaurantId, user.getId(),
                restaurantName, restaurantAddress, restaurantPhoneNUmber);
        System.out.println("\n" + restaurantName + " Successfully Added in Zayka");
    }  // this method For add restaurant in system

    public void openRestaurant(User user) {
        Restaurant restaurant = restaurantController.getRestaurantByOwnerId(user.getId());
        if (restaurant == null) {
            System.out.println("You have Not create restaurant, Please Create Restaurant");
        } else {
            ownerRestaurantPage(restaurant);
        }
    }

    public void ownerRestaurantPage(Restaurant restaurant) {
        do {
            System.out.println("\n--------------------------------------");
            System.out.println("      *  " + restaurant.getRestaurantName() + "  *");
            System.out.println("--------------------------------------\n");
            System.out.println("Options:");
            System.out.println("1.Show restaurant details");
            System.out.println("2.Update restaurant details");
            System.out.println("3.Add FoodItem");
            System.out.println("4.Update FoodItem");
            System.out.println("5.Delete FoodItem");
            System.out.println("6.My Menu");
            System.out.println("7.Show Orders List");
            System.out.println("8.Show Orders Status");
            System.out.println("9.Exit\n");
            System.out.println("Enter Your Option : ");
            int chooseOption = 0;

            try {
                chooseOption = sc.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid option");
                sc.nextLine();
                continue;
            }
            sc.nextLine();                           // To remove new Line character from input stream.

            switch (chooseOption) {
                case 1:
                    showRestaurantDetails(restaurant);
                    break;
                case 2:
                    updateRestaurantDetails(restaurant);
                    break;
                case 3:
                    addFoodItem(restaurant);
                    break;
                case 4:
                    updateFoodItem(restaurant);
                    break;
                case 5:
                    deleteFoodItem(restaurant);
                    break;
                case 6:
                    showMenuForRestaurant(restaurant);
                    break;
                case 7:
                    showOrdersList(restaurant);
                    break;
                case 8:
                    orderStatusForRestaurant(restaurant);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Please Enter Valid Option");
                    sc.nextLine();

            }
        } while (true);
    }

    public void showRestaurantDetails(Restaurant restaurant) {
        System.out.println("\nName :" + restaurant.getRestaurantName());
        System.out.println("Phone :" + restaurant.getPhoneNumber());
        System.out.println("Address :" + restaurant.getAddress());
        System.out.println("Owner username : " + userController.getUserByUserId(restaurant.getOwnerId()).getUserName());
    }

    public void updateRestaurantDetails(Restaurant restaurant) {
        System.out.println("Enter Restaurant Name");
        String restaurantName = sc.nextLine();
        if (Objects.equals(restaurantName, "q")) {
            return;
        }
        restaurantName = helperForValidatingObj.trimmedMethod(restaurantName);
        while (restaurantController.findRestaurantByRestaurantName(restaurantName)) {
            if (Objects.equals(restaurantName, restaurant.getRestaurantName())) {
                break;
            }
            System.out.println("this name's Restaurant already exists try another Name");
            restaurantName = sc.nextLine();
            if (Objects.equals(restaurantName, "q")) {
                return;
            }
        }
        System.out.println("Enter Phone Number");
        String restaurantPhoneNUmber = sc.nextLine();
        if (Objects.equals(restaurantPhoneNUmber, "q")) {
            return;
        }
        boolean validatePhoneNumberReturnValue = helperForValidatingObj.validateUserPhoneNUmber(restaurantPhoneNUmber);
        boolean returnValue = restaurantController.checkPhoneNumberAlreadyExistsOrNot(restaurantPhoneNUmber);
        while (returnValue || !validatePhoneNumberReturnValue) {

            if (!validatePhoneNumberReturnValue) {
                System.out.println("Please Enter Valid Phone Number");
            }
            if (returnValue) {
                if (Objects.equals(restaurantPhoneNUmber, restaurant.getPhoneNumber())) {
                    break;
                }
                System.out.println("Number already registered");
            }
            restaurantPhoneNUmber = sc.nextLine();
            if (Objects.equals(restaurantPhoneNUmber, "q")) {
                return;
            }
            validatePhoneNumberReturnValue = helperForValidatingObj.validateUserPhoneNUmber(restaurantPhoneNUmber);
            returnValue = restaurantController.checkPhoneNumberAlreadyExistsOrNot(restaurantPhoneNUmber);
        }
        System.out.println("Enter Address");
        String restaurantAddress = sc.nextLine();
        if (Objects.equals(restaurantAddress, "q")) {
            return;
        }
        restaurant.setRestaurantName(restaurantName);
        restaurant.setPhoneNumber(restaurantPhoneNUmber);
        restaurant.setAddress(restaurantAddress);
        System.out.println("Update Successfully");
    }  // this method for update restaurant details

    public void addFoodItem(Restaurant restaurant) {
        int foodPrice = 0;
        System.out.println("Enter FoodName");
        String foodName = sc.nextLine();
        foodName = helperForValidatingObj.trimmedMethod(foodName);
        if (Objects.equals(foodName, "q")) {
            return;
        }
        while (!helperForValidatingObj.validateFoodName(foodName)) {
            System.out.println("Please Enter Food name");
            foodName = sc.nextLine();
            foodName = helperForValidatingObj.trimmedMethod(foodName);
        }
        System.out.println("Enter Food Description");
        String foodDescription = sc.nextLine();
        foodDescription = helperForValidatingObj.trimmedMethod(foodDescription);
        if (Objects.equals(foodDescription, "q")) {
            return;
        }
        while (!helperForValidatingObj.validateFoodName(foodDescription)) {
            System.out.println("Please Enter Food Description");
            foodDescription = sc.nextLine();
            foodDescription = helperForValidatingObj.trimmedMethod(foodDescription);

        }
        System.out.println("Enter Food Price");
        while (foodPrice == 0) {
            try {
                foodPrice = sc.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please Enter valid Price");
                sc.nextLine();
            }
        }
        String foodItemId = Integer.toString(foodItem++);
        foodItemController.addFoodItem(foodItemId, restaurant.getId(),
                foodName, foodDescription, foodPrice, true);
        System.out.println("\n" + foodName + " now added in your Menu");
    }     // this method for add food Item

    public void updateFoodItem(Restaurant restaurant) {
        List<FoodItem> restaurantFoodItemLIst = foodItemController.getFoodItemListByRestaurantId(restaurant.getId());
        if (restaurantFoodItemLIst.isEmpty()) {
            System.out.println("\nNo one foodItem In your Menu");
            return;
        }
        int i = 1;
        for (FoodItem foodItem : restaurantFoodItemLIst) {
            System.out.println(i);
            System.out.println("Name : " + foodItem.getFoodName());
            System.out.println("Description : " + foodItem.getFoodDescription());
            System.out.println("Price : " + foodItem.getFoodPrice() + "/-");
            System.out.println("Availability : " + foodItem.getFoodAvailability());
            i++;
        }
        System.out.println("Enter Which Food Item you Want to Update");
        int chooseFoodItem = 0;
        try {
            chooseFoodItem = sc.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Invalid Option");
            sc.nextLine();
            return;
        }

        i = 1;
        sc.nextLine();   // To remove new Line character from input stream.
        for (FoodItem foodItem : restaurantFoodItemLIst) {
            if (i++ == chooseFoodItem) {
                System.out.println("Enter FoodName");
                String foodName = sc.nextLine();
                if (Objects.equals(foodName, "q")) {
                    return;
                }
                System.out.println("Enter Food Description");
                String foodDescription = sc.nextLine();
                if (Objects.equals(foodDescription, "q")) {
                    return;
                }
                System.out.println("Enter Food Price");
                int foodPrice = 0;
                while (foodPrice == 0) {
                    try {
                        foodPrice = sc.nextInt();
                    } catch (InputMismatchException inputMismatchException) {
                        System.out.println("Please Enter valid Price");
                    }
                }
                sc.nextLine();   // To remove new Line character from input stream.
                System.out.println("Enter Food Availability Y/N");
                String foodAvailability = sc.nextLine();
                if (Objects.equals(foodAvailability, "q")) {
                    return;
                }
                while (true) {
                    if (foodAvailability.equals("y") || foodAvailability.equals("Y") ||
                            foodAvailability.equals("N") || foodAvailability.equals("n")) {
                        break;
                    }
                    System.out.println("please enter valid option");
                    foodAvailability = sc.nextLine();
                }
                if (Objects.equals(foodAvailability, "Y") || Objects.equals(foodAvailability, "y")) {
                    foodItemController.updateFoodItem(foodItem.getId(), restaurant.getId(), foodName, foodDescription, foodPrice, true);
                    System.out.println("Updated Successfully");
                } else {
                    foodItemController.updateFoodItem(foodItem.getId(), restaurant.getId(), foodName, foodDescription, foodPrice, false);
                    System.out.println("Updated Successfully");
                }
                return;
            }
        }
    }   //this method for update FoodItem

    public void deleteFoodItem(Restaurant restaurant) {
        List<FoodItem> restaurantFoodItemLIst = foodItemController.getFoodItemListByRestaurantId(restaurant.getId());
        if (restaurantFoodItemLIst.isEmpty()) {
            System.out.println("\nNo one foodItem In your Menu");
            return;
        }
        int i = 1;
        for (FoodItem foodItem : restaurantFoodItemLIst) {
            System.out.println(i + ".");
            System.out.println(foodItem.getFoodName());
            System.out.println(foodItem.getFoodDescription());
            System.out.println(foodItem.getFoodPrice() + "/-");
            System.out.println(foodItem.getFoodAvailability());
            System.out.println();
            i++;
        }
        System.out.println("Which Food Item you Want to Delete");
        int chooseFoodItem = 0;
        while (chooseFoodItem == 0) {
            try {
                chooseFoodItem = sc.nextInt();
                if (chooseFoodItem >= i + 1) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid option");
                sc.nextLine();
                return;
            }
        }
        i = 1;
        for (FoodItem foodItem : restaurantFoodItemLIst) {
            if (i++ == chooseFoodItem) {
                foodItemController.deleteFoodItem(foodItem.getId(), restaurant.getId());
                System.out.println("\n" + foodItem.getFoodName() + " Remove from your Menu");
                return;
            }
        }
    }   //this method for delete FoodItem

    public void showMenuForRestaurant(Restaurant restaurant) {
        List<FoodItem> foodItemList = restaurantController.getListOfFoodItem(restaurant.getId());
        if (foodItemList.isEmpty()) {
            System.out.println("\nNo foodItem In your Menu");
            return;
        }
        for (FoodItem foodItem : foodItemList) {
            System.out.println("\n" + foodItem.getFoodName() + "    " + foodItem.getFoodPrice() + "/-");
            System.out.println(foodItem.getFoodDescription());
        }
    }

    public void showOrdersList(Restaurant restaurant) {
        List<Order> getOrderList = orderController.getOrderListOfRestaurantByRestaurantId(restaurant.getId());
        if (getOrderList.isEmpty()) {
            System.out.println("\nNo Orders Today");
            return;
        }
        for (Order order : getOrderList) {
            System.out.println("Order Id : " + order.getId());
            System.out.println(foodItemController.getFoodItemById(order.getFoodItemId(),
                    order.getRestaurantId()).getFoodName());
            System.out.println(foodItemController.getFoodItemById(order.getFoodItemId(),
                    order.getRestaurantId()).getFoodDescription());
            System.out.println(foodItemController.getFoodItemById(order.getFoodItemId(),
                    order.getRestaurantId()).getFoodPrice() + " /-\n");
        }

    }

    public void orderStatusForRestaurant(Restaurant restaurant) {
        List<Order> getOrderList = orderController.getOrderListOfRestaurantByRestaurantId(restaurant.getId());
        if (getOrderList.isEmpty()) {
            System.out.println("\nNo Orders Today");
            return;
        }
        for (Order order : getOrderList) {
            System.out.println("Order Id : " + order.getId());
            if (order.getOrderStatus().equals("Pending")) {
                System.out.println(foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " is Pending\n");
            } else if (order.getOrderStatus().equals("Process")) {
                System.out.println(foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " in Process\n");
            } else {
                System.out.println("Your Order : " + foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " is Delivered\n");
            }
        }
        System.out.println("If Pending Order is Now Delivered, Then Enter orderId for Change order Status " +
                "else tap Enter button");
        int flagMark = 0;
        while (flagMark == 0) {

            String orderId = sc.nextLine();
            if (Objects.equals(orderId, "") || Objects.equals(orderId, "q")) {
                return;
            } else {
                for (Order order : getOrderList) {
                    if (order.getId().equals(orderId)) {
                        if (order.getOrderStatus().equals("Delivered")) {
                            System.out.println("this Order already Delivered");
                        } else if (order.getOrderStatus().equals("Pending")) {
                            System.out.println("this Order is in Pending, is delivered or in process or not\n" +
                                    "type 'D' if Delivered or 'P' if in Process, else tap enter button");
                            String status = sc.nextLine();
                            if (Objects.equals(status, "")|| Objects.equals(status, "q")) {
                                return;
                            }
                            status = helperForValidatingObj.trimmedMethod(status);
                            while (true) {
                                if (Objects.equals(status, "D")||Objects.equals(status, "P")  ) {
                                    if (status.equals("D")) {
                                        order.setOrderStatus("Delivered");
                                        break;
                                    } else if(status.equals("P")){
                                        order.setOrderStatus("Process");
                                        break;
                                    }
                                } else {
                                    System.out.println("please Enter valid option");
                                    status = sc.nextLine();
                                    status = helperForValidatingObj.trimmedMethod(status);
                                    if (Objects.equals(status, "")|| Objects.equals(status, "q")) {
                                        return;
                                    }

                                }
                            }
                        } else {
                            System.out.println("this Order is in Process, is delivered or not\ntype 'D' if Delivered," +
                                    " else tap enter button");
                            String status = sc.nextLine();
                            if (Objects.equals(orderId, "q") || Objects.equals(orderId, "") || Objects.equals(status, "\n")) {
                                return;
                            }
                            status = helperForValidatingObj.trimmedMethod(status);
                            while (true) {
                                if (Objects.equals(status, "D")) {
                                    order.setOrderStatus("Delivered");
                                    break;
                                } else {
                                    System.out.println("please Enter valid option");
                                    status = sc.nextLine();
                                    status = helperForValidatingObj.trimmedMethod(status);
                                }
                            }
                        }
                        flagMark = 1;
                        break;
                    }
                }
                if (flagMark == 0) {
                    System.out.println("Invalid OrderId");
                } else {
                    System.out.println("Status updated\n");
                    System.out.println("Enter 'Y' for More else tap Enter Button");
                    String moreUpdate = sc.nextLine();
                    if (Objects.equals(moreUpdate, "Y")) {
                        flagMark = 0;
                        System.out.println("Enter Order Id : \n");
                    } else {
                        return;
                    }
                }
            }


        }

    } // this method show order status for restaurant

}
