
package petcare.system;


public class Item implements Buyable {
    
    private int Item_NO;
    
    private String name;
    
    private double Price;
    
    public Item(int Item_NO, String name, double Price) {
      setItem_NO(Item_NO);
      setName(name);
      setPrice(Price);
    }
    
    public Item(){
        
        this(0,"",0.0);
    }
     
    
       public int getItem_NO() {
        return Item_NO;
    }

    public void setItem_NO(int Item_NO) {
        this.Item_NO = Item_NO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

  @Override
    
    public double CalcPrice() {


double total = getPrice();
        total += (total * TAX_RATE);
        return total;


    }
     
    
    
      @Override
    public String toString() {
        return String.format("Item Number: %d\n Chosen Item Name: %s\n The Item's Price:%.2f",getItem_NO(), getName(),getPrice());
    }

    
}
