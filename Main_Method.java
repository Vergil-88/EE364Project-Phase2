import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main_Method {
    ArrayList <String>  data     = new ArrayList <String>();
    ArrayList <String>  Dayslist = new ArrayList <String>();
    ArrayList <String>  Govdata  = new ArrayList <String>();
    Scanner in = new Scanner(System.in);
    
    ArrayList <String>  A   = new ArrayList <String>();
    ArrayList <String>  B   = new ArrayList <String>();
    ArrayList <String>  C   = new ArrayList <String>();
    ArrayList <String>  Normal   = new ArrayList <String>();

    ArrayList <String>  govA   = new ArrayList <String>();
    ArrayList <String>  govB   = new ArrayList <String>();
    ArrayList <String>  govDead   = new ArrayList <String>();
    ArrayList <String>  govRecovered   = new ArrayList <String>();
    ArrayList <String>  Beds   = new ArrayList <String>();
    ArrayList <String>  waitingList   = new ArrayList <String>();

    Random rad = new Random();
    int numOf_A=0;
    int numOf_B=0;
    int numOf_C=0;
    int numOf_Normal=0;

    int GOV_A=0;
    int GOV_B=0;
    int GOV_Dead=0;
    int GOV_Recovered=0;    
    int numOf_Beds;
    int numOfinWiting=0;
    int total_Beds;

    public void City_Activite(int day,City city,ministryofHealth MinistryofHealth,ICU icu,CovidSpread covid){



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // First Block         this Block tells us who of Type B and C are Actlly A or Normal                      
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if( day%3==0 ){//Happens Every 3 Days
            /// Changing B to A by Percentiges there rest that we havent made into A will become Normal 

            
            for (Human B: city.get_Citizen() ) {
                if(B.getCovidInfection_TypeType().equals("B"))
                    covid.B_Becomes_A(B,MinistryofHealth.getPostiveB(),day);  
            }


            /// Changing C to A by Percentiges there rest that we havent made into A will become Normal 

            for (Human C: city.get_Citizen() ) {
                if(C.getCovidInfection_TypeType().equals("C"))
                    covid.C_Becomes_A(C,MinistryofHealth.getPostiveC(),day);  
            }
        } 
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 2nd Block Calls Happen Every day
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
        int number_of_A_Calls = (int) (numOf_A * 0.35);
        for (Human H : city.get_Citizen()) {
            if(H.getCovidInfection_TypeType().equals("A")){
                MinistryofHealth.CallCenter(H);
                number_of_A_Calls--; 
                if(number_of_A_Calls <= 0)
                break;
            }
        }   
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 3rd Block Spreding the Covid for the Day Happens Every Day
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
            ///
            if(day%5==0){
            for (Human H : city.get_Citizen()) {                 
                if(H.getCovidInfection_TypeType().equals("A"))
                    covid.SpreadingB(H,day);
                else if(H.getCovidInfection_TypeType().equals("B"))
                    covid.SpreadingC(H,day);   
            } 

            }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 4th Block MinistryofHealth Recives the Calls and Declare who is A and who they interacted with
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            MinistryofHealth.TestCenter(MinistryofHealth.getCalls());
            MinistryofHealth.Interacted_A_to_B();



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 5th Gov declaring type A Recoverd and Dead 
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
        if(day>=7){

            
                
            MinistryofHealth.A_to_Dead(icu.getWaitingList(),day,icu);
            MinistryofHealth.Recovered(day,icu);// add a line to remove the perosn if he exsist in a bed
        


            icu.removeType_Normal_From_ICU();


            ArrayList<Human> Witing = icu.getWaitingList();
            if(Witing.size()!=0)
                for (int i = 0;i<Witing.size();i++) {

                icu.SetBedWithCap(Witing.get(i),day);

                if(icu.getBeds().size() == 1000)
                    break;
                
            }





        
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 6th ICU Beds filing for the the Type Who needs it which is 0.15 of them
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
        int numOfBeds = (int) (MinistryofHealth.getPostiveA().size() *0.15); 
        int typeAIndex; 
        Human person;

        while(numOfBeds != 0){
            
            
            typeAIndex = rad.nextInt(MinistryofHealth.getPostiveA().size()-1);
            ArrayList <Human> ArrayPostiveA= MinistryofHealth.getPostiveA();
            person =  ArrayPostiveA.get(typeAIndex);

            icu.SetBedWithCap(person,day);
            
            numOfBeds--;


        }



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Counting
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int oldNum_A=numOf_A;
        int oldNum_B=numOf_B;
        int oldNum_C=numOf_C;
        int oldNum_Normal=numOf_Normal;


        numOf_A=0;
        numOf_B=0;
        numOf_C=0;
        numOf_Normal=0;

        for (Human H :  city.get_Citizen()) { 
            String Z= H.getCovidInfection_TypeType();
                switch (Z){
                    case "A":
                        numOf_A++;
                        break;
                    case "B":
                        numOf_B++;
                        break;
                    case "C":
                        numOf_C++;
                        break;
                    case "Normal":
                        numOf_Normal++;
                        break;
                }
        }

        oldNum_A=numOf_A-oldNum_A;
        oldNum_B=numOf_B-oldNum_B;
        oldNum_C=numOf_C-oldNum_C;
        oldNum_Normal=numOf_Normal-oldNum_Normal;

        int oldGOV_A=GOV_A;
        int oldGOV_B=GOV_B;
        int oldGOV_Dead=GOV_Dead;
        int oldGOV_Recovered=GOV_Recovered;
        int old_numOfinwiting=numOfinWiting;


        GOV_A=MinistryofHealth.getPostiveA().size();
        GOV_B=MinistryofHealth.getPostiveB().size();
        GOV_Dead=MinistryofHealth.getDead().size();
        GOV_Recovered=MinistryofHealth.getRecovered().size();
        numOfinWiting = icu.getWaitingList().size(); 


        oldGOV_A=GOV_A-oldGOV_A;
        oldGOV_B=GOV_B-oldGOV_B;
        oldGOV_Dead=GOV_Dead-oldGOV_Dead;
        oldGOV_Recovered=GOV_Recovered-oldGOV_Recovered;
        old_numOfinwiting=numOfinWiting-old_numOfinwiting;

        numOf_Beds = icu.getBeds().size();
        total_Beds = icu.getBedCap();

        A.add(numOf_A+"("+oldNum_A+")");
        B.add(numOf_B+"("+oldNum_B+")");
        C.add(numOf_C+"("+oldNum_C+")");
        Normal.add(numOf_Normal+"("+oldNum_Normal+")");

        govA.add(GOV_A+"("+oldGOV_A+")");
        govB.add(GOV_B+"("+oldGOV_B+")");
        govDead.add(GOV_Dead+"("+oldGOV_Dead+")");
        govRecovered.add(GOV_Recovered+"("+oldGOV_Recovered+")");
        Beds.add(numOf_Beds+"/"+total_Beds);
        waitingList.add(numOfinWiting+"("+old_numOfinwiting+")");


        Dayslist.add(String.format("Day:%-5s",day) );
            
        
                    

                    
                
        ///////////////////Clearing the Call history
        MinistryofHealth.getCalls().clear();      

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 7th Clearing the Calls form the day and moveing the Dead Citizins to A diffrant Array and Removing them fomr the Orignal 
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
        ArrayList<Human> Dead = MinistryofHealth.getDead();

        for (Human  h :  city.get_Citizen()) {
            h.updatehuman(day);;
        } // UpdateHistry

            city.setDeadCitizen(Dead);
            city.get_Citizen().removeAll(Dead);
     
    }


    public void City_Output(int day,ICU icu,City city){

        int fullDays = 0;

        for (int i = 0; i < day; i++) {
            if(Beds.get(i).equals("1000/1000")){

                fullDays+=1;
                
            }
            else{
                fullDays=0;
            } 
        }

        String cityStatus;
        double percentageOfA = (double) (GOV_A) / (double)(city.get_Citizen().size()); 
        

        if (percentageOfA < 0.01 || fullDays < 0 )
            cityStatus = "Excellent";
        else if (percentageOfA < 0.03 ||  fullDays<5)
            cityStatus = "Good";
        else if (percentageOfA < 0.06 ||  fullDays < 10)
            cityStatus = "Neutral";
        else if (percentageOfA < 0.09 ||  fullDays<15)
            cityStatus = "Bad";
        else
            cityStatus = "Very Bad";
        
            
        System.out.println("\nThe city status at day "+day+" is: "+cityStatus);
        // TableViewer table = new TableViewer(Dayslist, data);
        System.out.println("Programmer view");
        Table_XYZ(day, A, B, C, Normal);
    
        System.out.println("\n __________________________________________________________________________________________________ \n");
        
        System.out.println("Government view");
        
        Table_XYZ2(day, govA, govB, govDead, govRecovered,Beds,waitingList);
        if(fullDays!=0){
            System.out.println("\n __________________________________________________________________________________________________ \n");
            System.out.println("Warning: the ICU is full for "+fullDays+" continuous days");
        }
    }

        


    public  void CitySwitch(City city,int day, ICU icu){
        

        System.out.println("The City Name "+ city.get_Name());
        System.out.println("\n __________________________________________________________________________________________________ \n");
        City_Output(day,icu,city);
        System.out.println("\n __________________________________________________________________________________________________ \n");
    
    
        System.out.println("Pick the information you want to see\n"+
        "1 Alive Citizens:\n"+
        "2 Dead Citizens:\n"+
        "3 IN ICU:\n"+
        "4 Travelers:\n"+
        "5 Check History of an Individual:\n");
        int User_Choice= Switchinput();
        

        switch (User_Choice){

            case 1:
            System.out.println("The Alive Citizens Are");
            System.out.println(city.get_Citizen());
            break;
            
            case 2:
            System.out.println("The Dead Citizens Are");
            System.out.println(city.getDeadCitizen());
            break;
            
            case 3:
            System.out.println("The  Citizens in ICU Are");
            System.out.println( (icu.getBeds()) ) ;

            break;
            
            case 4:
            System.out.println(city.getTravelers());
            break;
            
            case 5:
            System.out.println("Pick the information you want to see\n"+
            "1 History of Alive Person\n"+
            "2 History of Dead Person\n"+
            "3 History of Traveler Person\n"+
            "4 History of ICU Person\n"+
            "5 History of ID");
            int input = Switchinput();
            int index;
            Human Person;
            String History;
            ArrayList<Human> Citizen;
            switch (input) {

                case 1:
                Citizen = city.get_Citizen();
                    System.out.println("Enter num from 1 to "+Citizen.size()+": ");
                    index = Switchinput();
                    try {
                        Person = Citizen.get(index-1);
                        History = Person.getHistory() ;
                        System.out.println(History);  
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                    }
                    

                    break;

                case 2:
                        Citizen = city.getDeadCitizen();
                        System.out.println("Enter num from 1 to "+Citizen.size()+": ");
                        index = Switchinput();
                    try {
                        Person = Citizen.get(index-1);
                        History = Person.getHistory() ;
                        System.out.println(History);
                        System.out.println(Person.Sumarry());//testing line
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                    }

                        break;

                case 3:
                        Citizen = city.getTravelers();
                        System.out.println("Enter num from 1 to "+Citizen.size()+": ");
                        index = Switchinput();
                        try {
                            Person = Citizen.get(index-1);
                            History = Person.getHistory() ;
                            System.out.println(History);
                        } catch (Exception e) {
                            System.out.println("Wrong input");
                        }

                        
                        break;

                case 4:
                        ArrayList<Human> Beds = icu.getBeds();
                        System.out.println("Enter num from 1 to "+Beds.size()+": ");
                        index = Switchinput();
                    try {
                        Person = Beds.get(index-1);
                        History = Person.getHistory();
                        System.out.println(History);
                        System.out.println(Person.Sumarry());//testing line
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                    }
                    
                        break;

                case 5:
                    Citizen = city.get_Citizen();
                    Citizen.addAll(city.getDeadCitizen());
                    System.out.println("Enter the ID: ");
                    String id = in.next();

                    for (Human human : Citizen) {

                        if(human.getId().equals(id)){

                            System.out.println(human.getHistory());
                            System.out.println(human.Sumarry());

                        }
                    else{
                        System.out.println("Not Found");
                        break;
                    } 
                    }


        


                
            }




        

        }



    }


    public  void Table_XYZ (int day,ArrayList <String> A,ArrayList <String> B,ArrayList <String> C,ArrayList <String> Normal){


        


            Object [][] table = new String[day+1][];
            String a;
            String b;
            String c;
            String normal;

            table[0] = new String[]{"DAY","A","B","C","Normal"};

        for (int i = 1; i < day+1 ; i++) {
            a = A.get(i-1);
            b = B.get(i-1);
            c = C.get(i-1);
            normal = Normal.get(i-1);
            
            table[i] = new String[]{String.valueOf(i),a,b,c,normal};

        }

        for (Object[] row : table) {
            System.out.format("%15s%15s%15s%15s%15s%n", row);
        }
    }

    public  void Table_XYZ2 (int day,ArrayList <String> A,ArrayList <String> B,ArrayList <String> Dead,ArrayList <String> Recoverd,ArrayList <String> Beds ,ArrayList <String> witingList ){


        


        Object [][] table = new String[day+1][];
        String a;
        String b;
        String dead;
        String recoverd;
        String bed;
        String witing ;

        table[0] = new String[]{"DAY","A","B","Dead","Recoverd","ICU","Witing List"};

        for (int i = 1; i < day+1 ; i++) {
            a = A.get(i-1);
            b = B.get(i-1);
            dead = Dead.get(i-1);
            recoverd = Recoverd.get(i-1);
            bed = Beds.get(i-1);
            witing = witingList.get(i-1);
            

            
            table[i] = new String[]{String.valueOf(i),a,b,dead,recoverd,bed,witing};

        }

        for (Object[] row : table) {
            System.out.format("%15s%15s%15s%15s%15s%15s%15s%n", row);
        }
    }


    public  int Switchinput(){
        int User_Choice=0;
        boolean TF=true;
        
        do {
            try {
                        
                User_Choice=in.nextInt();

                TF=false;
            
            }catch(Exception e){	
                System.out.println(" Wrong input ");
                in.nextLine();
                TF=true;
            }
        }while(TF==true);
        return User_Choice;
    }





}












