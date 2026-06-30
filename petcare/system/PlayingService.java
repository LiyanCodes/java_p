
package petcare.system;

public class PlayingService extends service  {
     private int PlayTimeDuration;

    public PlayingService(int SERVICE_NO, String ServiceName, String ServiceType, int PlayTimeDuration) {
        super(SERVICE_NO, ServiceName, ServiceType);

        setPlayTimeDuration(PlayTimeDuration);

    }

    public PlayingService() {

        this(0, "", "", 0);

    }

    public int getPlayTimeDuration() {
        return PlayTimeDuration;
    }

    public void setPlayTimeDuration(int PlayTimeDuration) {
        this.PlayTimeDuration = PlayTimeDuration;
    }

    @Override
    public int expectedDuration() {
        return PlayTimeDuration + 25;

    }

    @Override
    public String acceptableSpecies() {

        return "Cats, Birds, Dogs";

    }

    @Override
    public double CalcPrice() {
        double cost;
        if (PlayTimeDuration > 30 && PlayTimeDuration <= 60) {
            cost = 90;
        } else if (PlayTimeDuration > 10 && PlayTimeDuration <= 30) {
            cost = 60;
        } else {
            cost = 50;
        }

        cost += (cost * Buyable.TAX_RATE);
        return cost;

    }

    public void DisplayGamesList() {
        System.out.println("Available Games:");
        System.out.println("1. Fetch");
        System.out.println("2. Hide and Seek");
        System.out.println("3. Tug of War");
        System.out.println("4. Treasure hunt");
    }

    @Override
    public String toString() {
        return String.format("%s \t Your Choice Of Game %d:\n", super.toString(), PlayTimeDuration);
    }
   
}
