import Controller.FoodItemController;
import Controller.OrderController;
import Controller.ResutarantController;
import Controller.UserController;
import Model.FoodItem;
import Model.Order;
import Model.Resturant;
import Model.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UiClient {
    HelperForValidating helperForValidatingObj = HelperForValidating.getInstance();
    UserController userController = UserController.getInstance();
    ResutarantController resutarantController = ResutarantController.getInstance();
    FoodItemController foodItemController = FoodItemController.getInstance();
    OrderController orderController = OrderController.getInstance();

    //    for Id variables
    static int orders = 1;
    static int users = 1;
    static int foodItem = 1;
    static int resturant = 1;

    Scanner sc = new Scanner(System.in);

    //    populate Owner
    {
        String userId = Integer.toString(users++);
        userController.signUp(userId, "@deorishi", "@rishi12", "deorishi@gmail.com",
                "owner");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@abhishekJha", "@jha12", "abhishekjha@gmail.com",
                "owner");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@gaurav", "@gaurav12", "gaurav@gmail.com",
                "owner");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@ayushVerma", "@ayush12", "verma@gmail.com",
                "owner");
    }

    //   populate Customer
    {
        String userId = Integer.toString(users++);
        userController.signUp(userId, "@manjit", "@manjit12", "manjit@gmail.com",
                "customer");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@prince", "@prince12", "prince@gmail.com",
                "customer");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@ritik", "@ritik12", "ritik@gmail.com",
                "customer");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@misty", "@misty12", "misty@gmail.com",
                "customer");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@palak", "@palak12", "palak@gmail.com",
                "customer");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@aditi", "@aditi12", "aditi@gmail.com",
                "customer");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@rahul", "@rahul12", "rahul@gmail.com",
                "customer");
        userId = Integer.toString(users++);
        userController.signUp(userId, "@chhotu", "@chhotu12", "chhotu@gmail.com",
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
                int opt = 0;

                try {
                    opt = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("");
                }

                sc.nextLine();                           // To remove new Line character from input stream.

                switch (opt) {
                    case 1:
                        uiClient.signIn();
                        break;
                    case 2:
                        uiClient.signUp();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid option!");
                        System.out.print("press Enter to go to home page : ");
                        sc.nextLine();
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
        username = helperForValidatingObj.trimmedMethod(username);
        User user = userController.getUserByUserName(username);
        while (!Objects.equals(helperForValidatingObj.validateUserName(username), "valid") || user != null) {
            if (!Objects.equals(helperForValidatingObj.validateUserName(username), "valid")) {
                System.out.println(helperForValidatingObj.validateUserName(username));
            }
            username = sc.nextLine();
            username = helperForValidatingObj.trimmedMethod(username);
            user = userController.getUserByUserName(username);
            if (user != null) {
                System.out.println("Username already Exists");
            }
        }
        System.out.println("Enter Your E-mail");
        String userEmail = sc.nextLine();
        System.out.println(helperForValidatingObj.validateUserEmail(userEmail));
        while (!Objects.equals(helperForValidatingObj.validateUserEmail(userEmail), "valid")) {
            System.out.println(helperForValidatingObj.validateUserEmail(userEmail));
            userEmail = sc.nextLine();
            userEmail = helperForValidatingObj.trimmedMethod(userEmail);

        }
        System.out.println("Create Your Password");
        String userPassword = sc.nextLine();
        userPassword = helperForValidatingObj.trimmedMethod(userPassword);
        while (!Objects.equals(helperForValidatingObj.validateUserPassword(userPassword), "valid")) {
            System.out.println(helperForValidatingObj.validateUserPassword(userPassword));
            userPassword = sc.nextLine();
            userPassword = helperForValidatingObj.trimmedMethod(userPassword);
        }
        System.out.println("Sign Up as Owner Y/N");
        String userRole = sc.nextLine();
        userRole = helperForValidatingObj.trimmedMethod(userRole);
        while (true) {
            if (userRole.equals("y") || userRole.equals("Y") || userRole.equals("N") || userRole.equals("n")) {
                break;
            }
            System.out.println("Please Enter only Y or N");
            userRole = sc.nextLine();
            userRole = helperForValidatingObj.trimmedMethod(userRole);
        }
        String userId = Integer.toString(users++);
        if (userRole.equals("Y")) {

            userController.signUp(userId, username, userPassword, userEmail, "owner");
            System.out.println(username + " Successfully Signed Up");
        } else {
            userController.signUp(userId, username, userPassword, userEmail, "customer");
            System.out.println(username + " Successfully Signed Up");
        }

    }   // Sign up method

    public void signIn() {
        System.out.println("\n****************");
        System.out.println("* SIGN IN PAGE *");
        System.out.println("****************\n");

        System.out.println("Enter username");
        String username = sc.nextLine();
        username = helperForValidatingObj.trimmedMethod(username);
        User user = userController.getUserByUserName(username);
        if (user != null) {
            System.out.println("Enter Your Password");
            String userPassword = sc.nextLine();
            userPassword = helperForValidatingObj.trimmedMethod(userPassword);
            if (user.getUserPassword().equals(userPassword)) {
                if (userController.getUserByUserName(username).getUserRole().equals("owner")) {
                    System.out.println("owner");
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

            System.out.println("If you want to return to previous menu ....please enter 'q' ");
            System.out.println("Options:");
            System.out.println("1.Show Restaurant Lists");
            System.out.println("2.My Orders");
            System.out.println("3.Sign out");

            System.out.print("Enter your option: ");
            int opt = 0;

            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("");
            }
            sc.nextLine();                           // To remove new Line character from input stream.

            switch (opt) {
                case 1:
                    showResturants(user);
                    break;
                case 2:
                    orderStatusForUser(user);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option!");
                    System.out.print("press Enter to go to home page : ");
                    sc.nextLine();
            }
        } while (true);


    }  // this method for customer Home Page TODO complete this

    public void showResturants(User user) {
        List<Resturant> resturantList = resutarantController.getListOfAllResturant();
        int i = 1;
        for (Resturant resturant : resturantList) {
            System.out.println(i++ + resturant.getResturantName());
        }

        int choosedOption = 0;
        System.out.println("Choose Resturant");
        while (choosedOption == 0) {
            try {
                choosedOption = sc.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please Choose valid option");
            }
        }
        i = 1;
        for (Resturant resturant : resturantList) {
            if (i++ == choosedOption) {
                chhoseRestaurant(resturant, user);
                return;
            }
        }

    }       // this method for show restaurant lists

    private void chhoseRestaurant(Resturant resturant, User user) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 50; j++) {
                if (i == 4 || i == 0) {
                    System.out.print("_");
                } else if (i == 2 && j == 0 || i == 2 && j == 49) {
                    System.out.print("");
                } else if (j == 0 || j == 49) {
                    System.out.print("|");
                } else if (i == 2 && j == 15) {
                    System.out.print(resturant.getResturantName());
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("Options:");
        System.out.println("1. Show Menu");
        System.out.println("2. Order Food");
        System.out.println("3. Exit\n");

        System.out.print("Enter your option: ");
        int option = 0;
        while (option == 0) {
            try {
                option = sc.nextInt();
                if (option >= 4) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.print("please choose valid option");
            }
        }
        switch (option) {
            case 1:
                showMenuOfFoodItem(resturant);
                break;
            case 2:
                orderFoodFromChooseRestaurant(resturant, user);
            case 3:
                return;
        }
    }  // this method for order and show menu of
    // Choose Restaurant

    public void showMenuOfFoodItem(Resturant resturant) {
        for (FoodItem foodItem : foodItemController.getFoodItemListByResturantId(resturant.getId())) {
            System.out.println(foodItem.getFoodName());
            System.out.println(foodItem.getFoodDescription());
            System.out.println(foodItem.getFoodPrice());
            System.out.println(foodItem.isFoodAvailability());
        }
    }  // this method for Show foodItem of choose restaurant

    public void orderFoodFromChooseRestaurant(Resturant resturant, User user) {
        List<FoodItem> resturantFoodItemLIst = foodItemController.getFoodItemListByResturantId(resturant.getId());
        int flagMark = 0;
        for (FoodItem foodItem : resturantFoodItemLIst) {
            System.out.println(flagMark);
            System.out.println(foodItem.getFoodName());
            System.out.println(foodItem.getFoodDescription());
            System.out.println(foodItem.getFoodPrice());
            System.out.println(foodItem.isFoodAvailability());
            flagMark++;
        }
        System.out.println("Enter your Order");
        int chhosedFoodItem = 0;
        while (chhosedFoodItem == 0) {
            try {
                chhosedFoodItem = sc.nextInt();
                if (chhosedFoodItem >= flagMark + 1) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please Enter Valid option");
            }
        }
        String orderId = Integer.toString(orders++);
        flagMark = 1;
        for (FoodItem foodItem : resturantFoodItemLIst) {
            if (flagMark++ == chhosedFoodItem) {
                orderController.orderFood(orderId, user.getId(),
                        resturant.getId(), foodItem.getId());
            }
        }
    } //for Order food from restaurant

    public void orderStatusForUser(User user) {
        for (Order order : orderController.getOrderListOfCustomer(user.getId())) {
            System.out.println("Your Order Id : " + order.getId());
            if (order.getOrderStatus().equals("Pending")) {
                System.out.println("Your Order : " + foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " is Pending, please Wait\n");
            } else {
                System.out.println("Your Order : " + foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " is Delivered\n");
            }
        }
    }    // this method show order Status for Customer



    //    FOR Restaurant Owners
    private void ownersHomePage(User user) {
        do {
            System.out.println("\n------------------------------");
            System.out.println("* Owner Home Page *");
            System.out.println("------------------------------\n");

            System.out.println("If you want to return to previous menu ....please enter 'q' ");
            System.out.println("Options:");
            System.out.println("1.Add resturant");
            System.out.println("2.Add FoodItem");
            System.out.println("3.Update FoodItem");
            System.out.println("4.Delete FoodItem");
            System.out.println("5.Show Orders List"); // TODO complete
            System.out.println("6.Show Orders Status");
            System.out.println("7.sign out\n");
            System.out.println("Enter Your Option");
            int chhosedOption = 0;
            while (chhosedOption == 0) {
                try {
                    chhosedOption = sc.nextInt();
                    if (chhosedOption >= 8) {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Please Choose Valid option");
                    chhosedOption = 0;
                }
            }

            sc.nextLine();                           // To remove new Line character from input stream.

            switch (chhosedOption) {
                case 1:
                    addResturant(user);
                    break;
                case 2:
                    addFoodItem(user);
                    break;
                case 3:
                    updateFoodItem(user);
                    break;
                case 4:
                    deleteFoodItem(user);
                    break;
                case 5:

                case 6:
                    orderStatusForRestaurant(resutarantController.findByOwnerId(user.getId()));
                    break;
                case 7:
                    return;
                default:
                    System.out.println("tap enter button for go previous home page");
                    sc.nextLine();

            }
        } while (true);

    }  //  TODO complete

    public void addResturant(User user) {
        System.out.println("Enter Resturant Name");
        String restaurantName = sc.nextLine();
        while (resutarantController.fetchResturantByResturantName(restaurantName)) {
            System.out.println("this name's Resturant already exists try another Name");
            restaurantName = sc.nextLine();
        }
        System.out.println("Enter Phone Number");
        String restaurantPhoneNUmber = sc.nextLine();
        boolean validatephoneNumberReturnValue = helperForValidatingObj.validateUserPhoneNUmber(restaurantPhoneNUmber);
        boolean returnValue = resutarantController.checkPhoneNumberAlreadyExistsOrNot(restaurantPhoneNUmber);
        while (returnValue || !validatephoneNumberReturnValue) {
            if (!validatephoneNumberReturnValue) {
                System.out.println("Please Enter Valid Phone Number");
            }
            if (returnValue) {
                System.out.println("Number already registered");
            }
            restaurantPhoneNUmber = sc.nextLine();
            validatephoneNumberReturnValue = helperForValidatingObj.validateUserPhoneNUmber(restaurantPhoneNUmber);
            returnValue = resutarantController.checkPhoneNumberAlreadyExistsOrNot(restaurantPhoneNUmber);
        }
        System.out.println("Enter Address");
        String restaurantAddress = sc.nextLine();
        String restaurantId = Integer.toString(resturant++);
        resutarantController.addResturant(restaurantId, user.getId(),
                restaurantName, restaurantAddress, restaurantPhoneNUmber);
        System.out.println(restaurantName + " Successfully Added in Zayka");
    }  // this method For add resturant in system

    public void addFoodItem(User user) {
        int foodPrice = 0;
        Resturant resturant = resutarantController.findByOwnerId(user.getId());
        System.out.println("Enter FoodName");
        String foodName = sc.nextLine();
        System.out.println("Enter Food Description");
        String foodDescription = sc.nextLine();
        System.out.println("Enter Food Price");
        foodPrice = sc.nextInt();
        while (foodPrice == 0) {
            try {
                foodPrice = sc.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please Enter valid Price");
            }
        }
        String foodItemId = Integer.toString(foodItem++);
        foodItemController.addFoodItem(foodItemId, resturant.getId(),
                foodName, foodDescription, foodPrice, true);
        System.out.println(foodName + " now added in your Menu");
    }     // this method for add food Item

    public void updateFoodItem(User user) {
        Resturant resturant = resutarantController.findByOwnerId(user.getId());
        List<FoodItem> restaurantFoodItemLIst = foodItemController.getFoodItemListByResturantId(resturant.getId());
        int i = 1;
        for (FoodItem foodItem : restaurantFoodItemLIst) {
            System.out.println(i);
            System.out.println(foodItem.getFoodName());
            System.out.println(foodItem.getFoodDescription());
            System.out.println(foodItem.getFoodPrice());
            System.out.println(foodItem.isFoodAvailability());
            i++;
        }
        System.out.println("Enter Which Food Item you Want to Update");
        int chhosedFoodItem = 0;
        while (chhosedFoodItem == 0) {
            try {
                chhosedFoodItem = sc.nextInt();
                if (chhosedFoodItem >= i + 1) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please Enter Valid option");
            }
        }
        i = 1;
        for (FoodItem foodItem : restaurantFoodItemLIst) {
            if (i++ == chhosedFoodItem) {
                System.out.println("Enter FoodName");
                String foodName = sc.nextLine();
                System.out.println("Enter Food Description");
                String foodDescription = sc.nextLine();
                int foodPrice = 0;
                while (foodPrice == 0) {
                    try {
                        foodPrice = sc.nextInt();
                    } catch (InputMismatchException inputMismatchException) {
                        System.out.println("Please Enter valid Price");
                    }
                }
                System.out.println("Enter Food Availability Y/N");
                String foodavailability = sc.nextLine();
                while (Objects.equals(foodavailability, "Y") || Objects.equals(foodavailability, "N")) {
                    System.out.println("please enter valid option");
                    foodavailability = sc.nextLine();
                }
                if (Objects.equals(foodavailability, "Y")) {
                    foodItemController.updateFoodItem(foodItem.getId(), resturant.getId(), foodName, foodDescription, foodPrice, true);
                } else {
                    foodItemController.updateFoodItem(foodItem.getId(), resturant.getId(), foodName, foodDescription, foodPrice, false);
                }
                return;
            }
        }
    }   //this method for update FoodItem

    public void deleteFoodItem(User user) {
        Resturant resturant = resutarantController.findByOwnerId(user.getId());
        List<FoodItem> resturantFoodItemLIst = foodItemController.getFoodItemListByResturantId(resturant.getId());
        int i = 1;
        for (FoodItem foodItem : resturantFoodItemLIst) {
            System.out.println(i + ".");
            System.out.println(foodItem.getFoodName());
            System.out.println(foodItem.getFoodDescription());
            System.out.println(foodItem.getFoodPrice());
            System.out.println(foodItem.isFoodAvailability());
            i++;
        }
        System.out.println("Which Food Item you Want to Delete");
        int chhosedFoodItem = 0;
        while (chhosedFoodItem == 0) {
            try {
                chhosedFoodItem = sc.nextInt();
                if (chhosedFoodItem >= i + 1) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Please Enter Valid option");
            }
        }
        i = 1;
        for (FoodItem foodItem : resturantFoodItemLIst) {
            if (i++ == chhosedFoodItem) {
                foodItemController.deleteFoodItem(foodItem.getId(), resturant.getId());
                sc.close();
                return;
            }
        }
    }   //this method for delete FoodItem

    public void orderStatusForRestaurant(Resturant restaurant) {
        List<Order> getOrderList = orderController.getOrderListOfRestaurant(restaurant.getId());
        for (Order order : getOrderList) {
            System.out.println("Order Id : " + order.getId());
            if (order.getOrderStatus().equals("Pending")) {
                System.out.println(foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " is Pending\n");
            } else {
                System.out.println("Your Order : " + foodItemController.getFoodItemById(order.getFoodItemId(),
                        order.getRestaurantId()).getFoodName() + " is Delivered\n");
            }
        }
        System.out.println("If Pending Order is Now Delieverd, Then Enter orderId for Change order Status " +
                "else tap Enter button");
        int flagMark = 0;
        while (flagMark == 0) {
            String orderId = sc.nextLine();
            if (orderId == "\n") {
                return;
            } else {
                for (Order order : getOrderList) {
                    if (order.getId().equals(orderId)) {
                        if (order.getOrderStatus().equals("Delivered")) {
                            System.out.println("this Order already Delivered");
                            return;
                        }
                        order.setOrderStatus("Delivered");
                        flagMark = 1;
                        break;
                    }
                }
                if (flagMark == 0) {
                    System.out.println("Please Enter Valid OrderId");
                } else {
                    System.out.println("Status updated\n");
                    System.out.println("Enter 'Y' for More else tap Enter Button");
                    String moreUpdation = sc.nextLine();
                    if (Objects.equals(moreUpdation, "Y")) {
                        flagMark = 0;
                    } else {
                        return;
                    }
                }
            }


        }

    } // this mrthod show order status for restaurant

}