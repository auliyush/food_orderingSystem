package Model;

public class FoodItem {
    private String id;
    private String resturantId;
    private String foodName;
    private String foodDescription;
    private int foodPrice;
    private boolean foodAvailability;

    public FoodItem(String id, String resturantId, String foodName, String foodDescription,
                    int foodPrice, boolean foodAvailability) {
        this.id = id;
        this.resturantId = resturantId;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodPrice = foodPrice;
        this.foodAvailability = foodAvailability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResturantId() {
        return resturantId;
    }

    public void setResturantId(String resturantId) {
        this.resturantId = resturantId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public boolean isFoodAvailability() {
        return foodAvailability;
    }

    public void setFoodAvailability(boolean foodAvailability) {
        this.foodAvailability = foodAvailability;
    }
}
