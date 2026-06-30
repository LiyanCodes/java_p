
package petcare.system;

public class Food extends Item {

    private String FoodType;
    
    
     public Food(int Item_NO, String name, double Price,String FoodType) {
        super(Item_NO, name, Price);
        setFoodType(FoodType);
    }

    public Food() {
        this(0,"",0.0,"");
    }
    
    
     public String getFoodType() {
        return FoodType;
    }

    public void setFoodType(String FoodType) {
        this.FoodType = FoodType;
    }
    
    
    
    
    
    @Override
    
    public double CalcPrice() {

  double cost;
        switch (FoodType) {
            case "Dry Food":
                cost = 45;
                break;
            case "Wet Food":
                cost = 65;
                break;
            case "Raw Diet":
                cost =95;
                break;
            default:
                cost = 60;
        }
        cost += (cost * Buyable.TAX_RATE);
        return cost;


    }
 @Override
    public String toString() {
        return String.format("%s /t Selected Food Type :\n", super.toString(),FoodType);
    }
    
}
