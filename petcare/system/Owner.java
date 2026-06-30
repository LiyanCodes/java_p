
package petcare.system;

public class Owner {

    
    
    private String Name;
    
    private String contactInfo;
    
    
    
    public Owner(String Name, String contactInfo) {
      setName(Name);
      setContactInfo(contactInfo);
    }

     public Owner(){
         
         this("","");
         
     }
    

     public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    
    
    
    
    @Override
    public String toString() {
        
    return String.format("Owner name: %s \n Owner Contact Info", Name,contactInfo);
    }
    
}
