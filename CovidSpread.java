import java.util.ArrayList;
import java.util.Random;

public class CovidSpread {
        
    //Delration 

    private Random rad = new Random() ;

    /// constrictor
    public CovidSpread(){}


    // Covid start

    public void StartCovid(City CityName){

        int numberOfPatients = (int) (CityName.get_Population() *0.05);
        int PatientIndex;
        Human Patient;
        ArrayList<Human> Citizen = CityName.get_Citizen();

        covidInfection TypeA = new A(); 

        for (int i = 0 ; i < numberOfPatients ; i++){

            try{ 
                PatientIndex = rad.nextInt(CityName.get_Population()-1);

                Patient = Citizen.get(PatientIndex);

                Patient.setCovidInfection_Type(TypeA);

                Patient.SetStatus("At Day:"+1+" A\n");
            }catch(Exception e){

                continue;

            }


    
        } 

        CityName.setCitizen(Citizen);

    }


    ////Spreading B Type :

    public void SpreadingB(Human Patient,int day){

        ArrayList<Human> family =  Patient.getfamily_Arraylist();
        ArrayList<Human> friends  = Patient.getfriends_Arraylist();
        ArrayList<Human> coWorkers = Patient.getcoWorkers_Arraylist();
        ArrayList<Human> randomIndividuals = Patient.getrandomIndividuals_Arraylist();
        
        covidInfection TypeB = new B();
        
        //String patient = Patient.getId(); // if we want to add the id of type A to hostry

        // family to TypeB

        for (Human F : family){
            String Type = F.getCovidInfection_TypeType();
            if(!(Type.equals("A")))
                if(!(Type.equals("B")))
                    if(!(Type.equals("C"))){
                        F.setCovidInfection_Type(TypeB);
                        F.SetStatus("At Day:"+day+" B\n");
                    }

        }

        // friends to TypeB

        int numberOfFriends = (int) (friends.size() * 0.50);
        int FriendIndex;
        Human Friend;

        for (int i = 0; i < numberOfFriends; i++) {
            
            try{  
                FriendIndex = rad.nextInt(friends.size()-1);

                Friend = friends.get(FriendIndex);
                String Type = Friend.getCovidInfection_TypeType();
                
                if(!(Type.equals("A")))
                    if(!(Type.equals("B")))
                        if(!(Type.equals("C"))){
                            Friend.setCovidInfection_Type(TypeB);
                            Friend.SetStatus("At Day:"+day+" B\n");
                        }
            }catch(Exception e){
                continue;
            }
        }

        // coWorkers to TypeB

        int numberOfCoWorkers = (int) (coWorkers.size() * 0.75);
        int coWorkerIndex;
        Human coWorker;

        for (int i = 0; i < numberOfCoWorkers; i++) {

            try{  coWorkerIndex = rad.nextInt(coWorkers.size()-1);

                coWorker = coWorkers.get(coWorkerIndex);
                String Type = coWorker.getCovidInfection_TypeType();
                
                if (!(Type.equals("A")))
                    if(!(Type.equals("B")))
                        if(!(Type.equals("C"))){
                            coWorker.setCovidInfection_Type(TypeB);
                            coWorker.SetStatus("At Day:"+day+" B\n");
                        }
            }catch(Exception e){
                continue;
            }
                    
    }

        // randomIndividuals to TypeB

        int numberOfRandomIndividuals = (int) (friends.size() * 0.25);
        int randomIndividualsIndex;
        Human randomIndividual;

        for (int i = 0; i < numberOfRandomIndividuals; i++) {

            try{ randomIndividualsIndex = rad.nextInt(randomIndividuals.size()-1);

                randomIndividual = randomIndividuals.get(randomIndividualsIndex);
                String Type = randomIndividual.getCovidInfection_TypeType();
                if(!(Type.equals("A")))
                    if(!(Type.equals("B")))
                        if(!(Type.equals("C"))){
                            randomIndividual.setCovidInfection_Type(TypeB);
                            randomIndividual.SetStatus("At Day:"+day+" B\n");
                        }
            }catch(Exception e){
                continue;
            }
        }
        
    }
    ////// Spreading C Type 
    public void SpreadingC(Human Patient,int day){

        ArrayList<Human> family =  Patient.getfamily_Arraylist();
        ArrayList<Human> friends  = Patient.getfriends_Arraylist();
        ArrayList<Human> coWorkers = Patient.getcoWorkers_Arraylist();
        ArrayList<Human> randomIndividuals = Patient.getrandomIndividuals_Arraylist();
        covidInfection TypeC = new C();
        
        // family to TypeC

        for (Human F : family) {
            String Type = F.getCovidInfection_TypeType();
            if (!(Type.equals("A")))
                if(!(Type.equals("B")))
                    if(!(Type.equals("C"))){
                        F.setCovidInfection_Type(TypeC);
                        F.SetStatus("At Day:"+day+" C\n");
                }
        }

        // friends to TypeC

        int numberOfFriends = (int) (friends.size() * 0.75);
        int FriendIndex;
        Human Friend;

        for (int i = 0; i < numberOfFriends; i++) {

            try{   FriendIndex = rad.nextInt(friends.size()-1);

                Friend = friends.get(FriendIndex);
                String Type = Friend.getCovidInfection_TypeType();
                
                if (!(Type.equals("A")))
                    if(!(Type.equals("B")))
                        if(!(Type.equals("C"))){
                            Friend.setCovidInfection_Type(TypeC);
                            Friend.SetStatus("At Day:"+day+" C\n");
                }
        }catch(Exception e){
            continue;
        }
        }

        // coWorkers to TypeC

        int numberOfCoWorkers = (int) (coWorkers.size() * 0.50);
        int coWorkerIndex;
        Human coWorker;

        for (int i = 0; i < numberOfCoWorkers; i++) {

            try{  

                coWorkerIndex = rad.nextInt(coWorkers.size()-1);
                coWorker = coWorkers.get(coWorkerIndex);
                String Type = coWorker.getCovidInfection_TypeType();
                
                if (!(Type.equals("A")))
                    if(!(Type.equals("B")))
                        if(!(Type.equals("C"))){
                            coWorker.setCovidInfection_Type(TypeC);
                            coWorker.SetStatus("At Day:"+day+" C\n");
                    }
            }catch(Exception e){
                continue;
            }
        }

        // randomIndividuals to TypeC

        int numberOfRandomIndividuals = (int) (randomIndividuals.size() * 0.25);
        int randomIndividualsIndex;
        Human randomIndividual;

        for (int i = 0; i < numberOfRandomIndividuals; i++) {

          try{  

                randomIndividualsIndex = rad.nextInt(randomIndividuals.size()-1);
                randomIndividual = randomIndividuals.get(randomIndividualsIndex);
                String Type = randomIndividual.getCovidInfection_TypeType();
                if (!(Type.equals("A")))
                    if(!(Type.equals("B")))
                        if(!(Type.equals("C"))){
                            randomIndividual.setCovidInfection_Type(TypeC);
                            randomIndividual.SetStatus("At Day:"+day+" C\n");
                    }
            }catch(Exception e){
                continue;
            }
        }
        
        
        

    }

    //// Chaing B to A by  
    public void B_Becomes_A(Human B,ArrayList <Human> PosB,int day,City city){
        ArrayList <Human> Quarantine = city.getQuarantine_Citizen(); 
       
        if(B.getCovidInfection_TypeType().equals("B")){
            double percentge=Math.random();
            if(percentge>0.80 && !(Quarantine.contains(B)) ){   //20%
           
                

                B.setCovidInfection_Type(new A());
                B.SetStatus("At Day:"+day+" A\n");
               

                
            }
            else if(percentge>0.99 && Quarantine.contains(B)) {//10%



                B.setCovidInfection_Type(new A());
                B.SetStatus("At Day:"+day+" A\n");



            } 
            
            
            else{

                B.setCovidInfection_Type(new Normal());
                B.SetStatus("At Day:"+day+" Normal\n");

            }
            PosB.remove(B);
        }
    }

    //// Chaing C to A 
    public void C_Becomes_A(Human C,ArrayList <Human> PosC ,int day,City city){
        ArrayList <Human> Quarantine = city.getQuarantine_Citizen(); 

        if(C.getCovidInfection_TypeType().equals("C")){
            double percentge=Math.random();
            if(percentge>0.95   ){  //%5
                C.setCovidInfection_Type(new A());
                C.SetStatus("At Day:"+day+" A\n");
            }
            else if(percentge>0.99 && Quarantine.contains(C)) {//3%



                C.setCovidInfection_Type(new A());
                C.SetStatus("At Day:"+day+" A\n");



            } 
            else{
                C.setCovidInfection_Type(new Normal());
                C.SetStatus("At Day:"+day+" Normal\n");
            }
            PosC.remove(C);
        }
    
    }
    ///////////////////////////////////////////////

    public void Count_Types(ArrayList<Human>  C){
        int numOf_A=0;
        int numOf_B=0;
        int numOf_C=0;
        int numOf_Normal=0;

        for (Human H : C) { 
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



    }


}
