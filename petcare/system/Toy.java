
package petcare.system;


public class Toy extends Item  {

    
    private String size;
    
    
      public Toy(int Item_NO, String name, double Price,String size) {
        super(Item_NO, name, Price);
        setSize(size);
    }

    public Toy() {
        this(0,"",0.0,"");
    }
    
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    
    @Override
    
    public double CalcPrice() {

  double cost;
        switch (size) {
            case "Big":
                cost = 75;
                break;
            case "medium":
                cost = 55;
                break;
            case "small":
                cost =35;
                break;
            default:
                cost = 40;
        }
        cost += (cost * Buyable.TAX_RATE);
        return cost;


    }
    
    
     @Override
    public String toString() {
        return String.format("%s /t Toy Size :\n", super.toString(),size);
    }
    
}
