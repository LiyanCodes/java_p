
package petcare.system;

public abstract  class service implements Buyable {
     private final int SERVICE_NO;

    private String ServiceName;

    private String ServiceType;

    private static int Service_Count;

    public service(int SERVICE_NO, String ServiceName, String ServiceType) {
        this.SERVICE_NO = SERVICE_NO;
        setServiceName(ServiceName);
        setServiceType(ServiceType);
      
        Service_Count++;
    }

    public service() {
        this(0, "", "");
    }

    public int getServiceNo() {
        return SERVICE_NO;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String ServiceType) {
        this.ServiceType = ServiceType;
    }

    public static int getService_Count() {
        return Service_Count;
    }

    public static void setService_Count(int Service_Count) {
        service.Service_Count = Service_Count;
    }

   

    public abstract int expectedDuration();

    public abstract String acceptableSpecies();


    
    @Override
    public String toString() {
        return String.format("Service Number: %s \n Service Name: %s \n Service Type:%s \n Number Of Services: %d \n ", getServiceNo(), getServiceName(), getServiceType(), getService_Count());
    }
    
}
