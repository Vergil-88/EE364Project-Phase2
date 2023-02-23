import java.util.ArrayList;

public class Region implements Places {
    private String Name;
    private int Population;
    private double Area;
    private double Overpopulation;
    ArrayList <City> Cities = new ArrayList<City>();

    public Region(String Name){
        this.Name = Name;
    }
    
    public void Calc_Overpopulation(){
        // To Calculate the OP of a region we are going to only consider the Cities' OP 
        // meaning we are going to find the mean of the OP in the whole region and use it as overpopulaiton
        int numofCities = Cities.size();
        int totalOP = 0;
        for (City x : Cities){
            numofCities++;
            totalOP += x.get_Overpopulation();
        }
        Overpopulation = totalOP/numofCities;

    }

    public String get_Name(){
        return Name;
    }

    public int get_Population(){
        return Population;
    }

    public double get_Area(){
        return Area;
    }

    public double get_Overpopulation(){
        return Overpopulation;
    }

    public ArrayList get_Cities(){
        return Cities;
    }

    public void addCity(String Name, int Population, double Area){

        City city = new City(Name, Population, Area);
        Cities.add(city);

    }

    public int getNumOfCities(){

        return Cities.size();
    }

    public  ArrayList <City>  getCities(){
        return Cities;
    }

    public void setPopulation(){

        for(City C : Cities){
            Population += C.get_Population();
        }

    }


    public String toString(){
        return Name + " | Population: " + Population + " | Area: " + Area + " | OverPopulation: " + Overpopulation +"\n" ;
 
    }




    

}
