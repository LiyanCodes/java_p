
package petcare.system;

public class VeterinaryService extends service {
    private String vaccineName;

  
    public VeterinaryService(int SERVICE_NO, String ServiceName, String ServiceType, String vaccineName) {
        super(SERVICE_NO, ServiceName, ServiceType);
        setVaccineName(vaccineName);
    }

    public VeterinaryService() {
        
        this(0,"","","");
    }
   
     public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    @Override
    public int expectedDuration() {
int minutes;
        switch (vaccineName) {
            case "Parvovirus":
            case "Leptospirosis":
                minutes = 25;
                break;
            default:
                minutes = 15;
        }
        return minutes;


    }

    @Override
    public String acceptableSpecies() {
        
        
        
        return" Cats, Bunnies, Dogs ,Birds";
        
    }

    @Override
    public double CalcPrice() {


double cost = 0;
        switch (vaccineName) {
            case "Parvovirus":
                cost = 120;
                break;
            case "Leptospirosis":
                cost = 115;
                break;
            case "Bordetella":
                cost = 100;
                break;
            default:
                cost = 90;
        }
        cost += (cost *Buyable.TAX_RATE);
        return cost;





    }

    public void ListVaccineOptions() {
        System.out.println("Available Vaccine Types :");
        System.out.println("1. Parvovirus Vaccine - 120.00 SAR.");
        System.out.println("2. Leptospirosis Vaccine - 115.00 SAR");
        System.out.println("3. Bordetella Vaccine - 100.00 SAR");
    }
    
    
    
    @Override
    public String toString() {
        return String.format("%s \t Chosen Vaccine Type: %s \n", super.toString(),vaccineName);
    }
    
}
