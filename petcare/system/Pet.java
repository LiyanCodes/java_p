
package petcare.system;


public class Pet {
     
    private String Name;
    
    private String Species;
    
    private String Gender;
    
    
    private int Age;
    
    private Owner owner;
    
    
       public Pet(String Name, String Species, String Gender, int Age, Owner owner) {
       setName(Name);
       setSpecies(Species);
      setGender(Gender);
       setAge(Age);
       setOwner(owner);
    }
    
       
       
       public Pet(){
           
           
           this("","","",0,null);
       }
    
       
         public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String Species) {
        this.Species = Species;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

       
         @Override
    public String toString() {
        return String.format("Pet Name :%s\n Pet Species:%s \n Pet Gender:%s \n Pet Age:%d\n Pet Owner", Name,Species,Gender,Age,owner);
    }
   
}
