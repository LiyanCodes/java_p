
package petcare.system;


public class Order {
    
    private final int ORDER_ID;
    private service[] services;
    private Owner customer;
    private String orderCondition;

    
    
      public Order( service[] services, Owner customer, String orderCondition) {
        this.ORDER_ID = (int) (Math.random() * ((9000 - 1) + 1)) + 1;
        setServices(services);
        setCustomer(customer);
        setOrderCondition(orderCondition);
    }
    
    public Order(){
        
        this(null,null,"");
        
    }
    
    
    public int getOrderId() {
        return ORDER_ID;
    }
    
    
     public service[] getServices() {
        return services;
    }

    public void setServices(service[] services) {
        this.services = services;
    }

    public Owner getCustomer() {
        return customer;
    }

    public void setCustomer(Owner customer) {
        this.customer = customer;
    }

    public String getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(String orderCondition) {
        this.orderCondition = orderCondition;
    }
    
    public double TotalCost() {
    double TC = 0;
    for (service V : services) {
        TC += V.CalcPrice();
    }
    return TC;
}

    public void Orderverification() {
   setOrderCondition("Confirmed");
    System.out.println("The order has been confirmed.");
}
    
    public void Ordercancelation() {
    setOrderCondition("Cancelled");
    System.out.println("The order has been cancelled.");
}
    
    public String ShowOrderedServices() {
      String s = "";
        for (service ser : services) {
            s += ser + "\n-----------------------------------------------------------------\n";
        }
        return s;
    }
    
    
    @Override
    public String toString() {
        return 
   String.format("Order id: %d\nOrderd  Services:\n%sPet Owner:\n%s\nOrder Condition: %s\nTotal: %.2f SAR", getOrderId(),
           ShowOrderedServices() ,getCustomer() , getOrderCondition() , TotalCost());
    }    
}
