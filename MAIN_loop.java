import java.util.ArrayList;
import java.util.Scanner;

public class MAIN_loop {
    static Scanner input = new Scanner(System.in);
    ////////////////////////////////////////////////
















    ////////////////////////////////////////////////
    public static void main(String[] args) {
        int PickedDay=1;
        boolean ON_OFF=true;   
        
        //(Genrating Objects )    
        ///////////////////////Genertings Cites and Regins



        //////////////////////////////////////////////// Region 2 and its Cities 
        Region East = new Region("East");                                
        East.addCity("Dammam", 5000, 0);
        East.addCity("Jubail", 5000, 0);
        East.addCity("Qatif", 5000, 0);
        East.addCity("Ras Tanura", 5000, 0); 
        //Saving them to a Varible
        City East_City_1=East.Cities.get(0);
        City East_City_2=East.Cities.get(1);
        City East_City_3=East.Cities.get(2);
        City East_City_4=East.Cities.get(3);

        //////////////////////////////////////////////// Region 3 and its Cities                                
        Region West = new Region("West");                               
        West.addCity("Jeddah", 5000, 0);
        West.addCity("Mecca", 5000, 0);
        West.addCity("Medina", 5000, 0);
        West.addCity("Taif", 5000, 0);
        //Saving them to a Varible
        City West_City_1=West.Cities.get(0);
        City West_City_2=West.Cities.get(1);
        City West_City_3=West.Cities.get(2);
        City West_City_4=West.Cities.get(3);

//////////////////////////////////////////////// Region 4 and its Cities 


        ////////////////////////////////////////////////////////////// Start Covid just Happens for 1 time for all the Cities
        CovidSpread covid = new CovidSpread();



        covid.StartCovid(East_City_1);
        covid.StartCovid(East_City_2);
        covid.StartCovid(East_City_3);
        covid.StartCovid(East_City_4);

        covid.StartCovid(West_City_1);
        covid.StartCovid(West_City_2);
        covid.StartCovid(West_City_3);
        covid.StartCovid(West_City_4);


        ////////////////////////////////////////////////////////////// 

        ministryofHealth GovR2_C1 = new ministryofHealth();
        ministryofHealth GovR2_C2 = new ministryofHealth();
        ministryofHealth GovR2_C3 = new ministryofHealth();
        ministryofHealth GovR2_C4 = new ministryofHealth();

        ministryofHealth GovR3_C1 = new ministryofHealth();
        ministryofHealth GovR3_C2 = new ministryofHealth();
        ministryofHealth GovR3_C3 = new ministryofHealth();
        ministryofHealth GovR3_C4 = new ministryofHealth();

        ICU icuR2_C1 = new ICU();
        ICU icuR2_C2 = new ICU();
        ICU icuR2_C3 = new ICU();
        ICU icuR2_C4 = new ICU();

        ICU icuR3_C1 = new ICU();
        ICU icuR3_C2 = new ICU();
        ICU icuR3_C3 = new ICU();
        ICU icuR3_C4 = new ICU();


    /////////////////////////////////////////////////////////////////

        Main_Method R2_C1 = new Main_Method();
        Main_Method R2_C2 = new Main_Method();
        Main_Method R2_C3 = new Main_Method();
        Main_Method R2_C4 = new Main_Method();

        Main_Method R3_C1 = new Main_Method();
        Main_Method R3_C2 = new Main_Method();
        Main_Method R3_C3 = new Main_Method();
        Main_Method R3_C4 = new Main_Method();

        ArrayList<City> Cities = new ArrayList<>();

        Cities.addAll(West.getCities());
        Cities.addAll(East.getCities());


        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Clone for Phase 2 and its Requrments          
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    City P2_East_City_1      =   (City) East_City_1.clone();
    City P2_East_City_2      =   (City) East_City_2.clone();
    City P2_East_City_3      =   (City) East_City_3.clone();
    City P2_East_City_4      =   (City) East_City_4.clone();

    City P2_West_City_1      =   (City) West_City_1.clone();
    City P2_West_City_2      =   (City) West_City_2.clone();
    City P2_West_City_3      =   (City) West_City_3.clone();
    City P2_West_City_4      =   (City) West_City_4.clone();

    Region P2_East = new Region("East");
    Region P2_West = new Region("West"); 


    ministryofHealth P2_GovR2_C1 = new ministryofHealth();
    ministryofHealth P2_GovR2_C2 = new ministryofHealth();
    ministryofHealth P2_GovR2_C3 = new ministryofHealth();
    ministryofHealth P2_GovR2_C4 = new ministryofHealth();

    ministryofHealth P2_GovR3_C1 = new ministryofHealth();
    ministryofHealth P2_GovR3_C2 = new ministryofHealth();
    ministryofHealth P2_GovR3_C3 = new ministryofHealth();
    ministryofHealth P2_GovR3_C4 = new ministryofHealth();

    ICU P2_icuR2_C1 = new ICU();
    ICU P2_icuR2_C2 = new ICU();
    ICU P2_icuR2_C3 = new ICU();
    ICU P2_icuR2_C4 = new ICU();

    ICU P2_icuR3_C1 = new ICU();
    ICU P2_icuR3_C2 = new ICU();
    ICU P2_icuR3_C3 = new ICU();
    ICU P2_icuR3_C4 = new ICU();


    covid.StartCovid(P2_East_City_1);
    covid.StartCovid(P2_East_City_2);
    covid.StartCovid(P2_East_City_3);
    covid.StartCovid(P2_East_City_4);

    covid.StartCovid(P2_West_City_1);
    covid.StartCovid(P2_West_City_2);
    covid.StartCovid(P2_West_City_3);
    covid.StartCovid(P2_West_City_4);

    Main_Method P2_R2_C1 = new Main_Method();
    Main_Method P2_R2_C2 = new Main_Method();
    Main_Method P2_R2_C3 = new Main_Method();
    Main_Method P2_R2_C4 = new Main_Method();

    Main_Method P2_R3_C1 = new Main_Method();
    Main_Method P2_R3_C2 = new Main_Method();
    Main_Method P2_R3_C3 = new Main_Method();
    Main_Method P2_R3_C4 = new Main_Method();

    ArrayList<City> P2_Cities = new ArrayList<>();

    P2_Cities.addAll(P2_West.getCities());
    P2_Cities.addAll(P2_East.getCities());



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Start of main loop for phase one and phase two          
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int Porgress=0;
        int days=365;// a year
        int numOfTravle;
        for (int day = 1; day <=days  ; day++) {


        

            R2_C1.City_Activite(day, East_City_1, GovR2_C1, icuR2_C1, covid,false);
            R2_C2.City_Activite(day, East_City_2, GovR2_C2, icuR2_C2, covid,false);
            R2_C3.City_Activite(day, East_City_3, GovR2_C3, icuR2_C3, covid,false);
            R2_C4.City_Activite(day, East_City_4, GovR2_C4, icuR2_C4, covid,false);

            R3_C1.City_Activite(day, West_City_1, GovR3_C1, icuR3_C1, covid,false);
            R3_C2.City_Activite(day, West_City_2, GovR3_C2, icuR3_C2, covid,false);
            R3_C3.City_Activite(day, West_City_3, GovR3_C3, icuR3_C3, covid,false);
            R3_C4.City_Activite(day, West_City_4, GovR3_C4, icuR3_C4, covid,false);





            P2_R2_C1.City_Activite(day, P2_East_City_1, P2_GovR2_C1, P2_icuR2_C1, covid,true);
            P2_R2_C2.City_Activite(day, P2_East_City_2, P2_GovR2_C2, P2_icuR2_C2, covid,true);
            P2_R2_C3.City_Activite(day, P2_East_City_3, P2_GovR2_C3, P2_icuR2_C3, covid,true);
            P2_R2_C4.City_Activite(day, P2_East_City_4, P2_GovR2_C4, P2_icuR2_C4, covid,true);

            P2_R3_C1.City_Activite(day, P2_West_City_1, P2_GovR3_C1, P2_icuR3_C1, covid,true);
            P2_R3_C2.City_Activite(day, P2_West_City_2, P2_GovR3_C2, P2_icuR3_C2, covid,true);
            P2_R3_C3.City_Activite(day, P2_West_City_3, P2_GovR3_C3, P2_icuR3_C3, covid,true);
            P2_R3_C4.City_Activite(day, P2_West_City_4, P2_GovR3_C4, P2_icuR3_C4, covid,true);

















            
            Porgress++;
            System.out.println("day:"+Porgress);
            
            


            numOfTravle = (int) (Math.random()*100);

            for (int i = 0; i < numOfTravle; i++) {
                City.Travel(Cities, day);
            }
            


            

            while(day>=PickedDay){
                ON_OFF=true;
                while  ( ON_OFF==true){


                System.out.println("the Day is:"+day+
                " Pick Regin \n"+
                "1 East:\n"+
                "2 West:\n"+
                "3 Next Day\n"+
                "4 Pick A Day\n");


                int  User_Choice= R2_C1.Switchinput();



                switch (User_Choice){


                //////////////////////////
                case 1:
                System.out.println("East");

                    System.out.println("Pick The City\n"+
                    "1 Dammam:\n"+
                    "2 Jubail:\n"+
                    "3 Qatif:\n"+
                    "4 Ras Tanura:\n");

                    User_Choice= R2_C1.Switchinput();   
                    switch (User_Choice){

                        case 1:
                        R2_C1.CitySwitch(East_City_1,day,icuR2_C1);
                        break;
                        //////
                        case 2:
                        R2_C2.CitySwitch(East_City_2,day,icuR2_C2);
                        break;
                        //////
                        case 3:
                        R2_C3.CitySwitch(East_City_3,day,icuR2_C3);
                        break;
                        //////
                        case 4:
                        R2_C4.CitySwitch(East_City_4,day,icuR2_C4);
                        break;
                    }
                    break;
                    //////////////////////////
                case 2:
                    System.out.println("West");
                    System.out.println("Pick The City\n"+
                    "1 Jeddah:\n"+
                    "2 Mecca:\n"+
                    "3 Medina:\n"+
                    "4 Taif:\n");
                    User_Choice= R3_C1.Switchinput();;   
                    switch (User_Choice){

                        case 1:
                        R3_C1.CitySwitch(West_City_1,day,icuR3_C1);
                        break;
                        //////
                        case 2:
                        R3_C2.CitySwitch(West_City_2,day,icuR3_C2);
                        break;
                        //////
                        case 3:
                        R3_C3.CitySwitch(West_City_3,day,icuR3_C3);
                        break;
                        //////
                        case 4:
                        R3_C4.CitySwitch(West_City_4,day,icuR3_C4);
                        break;
                    }
                    break;
                    ////////////////////////////


                        
                    ///////////////
                case 3:
                        ON_OFF=false;
                        PickedDay++;
                        
                    break;
                    //////////////////////////
                case 4:
                    System.out.println("Pick the Day");
                    PickedDay=User_Choice= R2_C1.Switchinput();
                    ON_OFF=false;
                }

                }
            }

            
        }//end of main loop



    }// end of main 
   
}

