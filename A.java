public class A extends covidInfection{
    
    private int daysCounter=0;

    public  String getType(){
        return "A";
    }

    public void updatedaysCounter() {
        daysCounter++;
    }
    
    public int getDaysCounter() {
        return daysCounter;
    }
        



}
