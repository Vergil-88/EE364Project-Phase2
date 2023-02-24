import java.util.ArrayList;
import java.util.Random;

public class ministryofHealth {
    //Delration 

    private ArrayList<Human> Calls = new ArrayList<Human>();
    private ArrayList<Human> PostiveA = new ArrayList<Human>();
    private ArrayList<Human> PostiveB = new ArrayList<Human>();
    private ArrayList<Human> PostiveC = new ArrayList<Human>();
    private ArrayList<Human> Dead = new ArrayList<Human>();
    private ArrayList<Human> Recovered = new ArrayList<Human>();
    private Random rad = new Random();
    //methods

    // genrait Calls in main
    public void CallCenter(Human Newhu){

        this.Calls.add(Newhu) ;

    }



    public void TestCenter(ArrayList <Human> Calls){
        for(Human x : Calls){
            

            if  (x.getCovidInfection_TypeType().equals("A") ){
                if(!(PostiveA.contains(x)))

                PostiveA.add(x);


            }
        


        }

    }

    //////////////////////////////////////////////
    public void Interacted_A_to_B(){

        for(Human x : PostiveA){
            ArrayList <Human>  family =x.getfamily_Arraylist();
            ArrayList <Human>  friends =x.getfriends_Arraylist();
            ArrayList <Human>  coWorkers =x.getcoWorkers_Arraylist();
            ArrayList <Human>  randomIndividuals =x.getrandomIndividuals_Arraylist();
        
            for(Human f : family){
                if( f.getCovidInfection_TypeType().equals("B") ){
                    if(!(PostiveB.contains(f)))
                    PostiveB.add(f);
                }
            }

            for(Human fr : friends){
                if( fr.getCovidInfection_TypeType().equals("B") ){
                    if(!(PostiveB.contains(fr)))

                    PostiveB.add(fr);
                }
            }

            for(Human Co : coWorkers){
                if( Co.getCovidInfection_TypeType().equals("B") ){
                    if(!(PostiveB.contains(Co)))
                    PostiveB.add(Co);
                }
            }

            for(Human r : randomIndividuals){
                if( r.getCovidInfection_TypeType().equals("B") ){
                    if(!(PostiveB.contains(r)))
                    PostiveB.add(r);
                }
            }
            

        }


    }

    //////////////////////////////////////////////
    public void Interacted_B_to_C(){

        for(Human x : PostiveB){
            ArrayList <Human>  family =x.getfamily_Arraylist();
            ArrayList <Human>  friends =x.getfriends_Arraylist();
            ArrayList <Human>  coWorkers =x.getcoWorkers_Arraylist();
            ArrayList <Human>  randomIndividuals =x.getrandomIndividuals_Arraylist();
            
            for(Human f : family){
                if( f.getCovidInfection_TypeType().equals("C") ){
                    if(!(PostiveC.contains(f)))

                    PostiveC.add(f);
                }
            }
    
            for(Human fr : friends){
                if( fr.getCovidInfection_TypeType().equals("C") ){
                    if(!(PostiveC.contains(fr)))

                    PostiveC.add(fr);
                }
            }
    
            for(Human Co : coWorkers){
                if( Co.getCovidInfection_TypeType().equals("C") ){
                    if(!(PostiveC.contains(Co)))

                    PostiveC.add(Co);
                }
            }
    
            for(Human r : randomIndividuals){
                if( r.getCovidInfection_TypeType().equals("C") ){
                    if(!(PostiveC.contains(r)))

                    PostiveC.add(r);
                }
            }  
    
        }

    }

    //////////////////////////////////////////////
    public void A_to_Dead( ArrayList <Human>  WaitingList,int day,ICU icu){
       
        ArrayList<Human> Witing = icu.getWaitingList();
        
        int Counter;

     
           
            
            if(WaitingList.size()!=0){
            
            for (Human B : WaitingList ) {    // gose over the WaitingList Array
                
                covidInfection CovidInf = B.getCovidInfection_Type();
                Counter = CovidInf.getDaysCounter();
                double Ran0= Math.random();
                
            if(B.getVaccine()==true)
            continue;

                if(Counter>=7&&Counter<14 ){
                    
                    if(Ran0 >= 0.98){//2%
                    B.setDead();
                    B.SetStatus("At Day:"+day+" Dead\n");
                    PostiveA.remove(B);
                    Dead.add(B); 
                    //Witing.remove(B);
                    
                    }
                }else if(Counter>=14){
                    if(Ran0 >= 0.96){//4%
                    B.setDead();
                    B.SetStatus("At Day:"+day+" Dead\n");
                    PostiveA.remove(B);
                    Dead.add(B); 
                    //Witing.remove(B);
                   
                    }
                }
            }
        }

        int randomDead = (int) (PostiveA.size()*0.007);
        int randomIndex;
        Human Die;

        for(int i = 0;i < randomDead;i++){
            randomIndex = rad.nextInt(PostiveA.size()-1);
            Die = PostiveA.get(randomIndex);
            Die.setDead();
            Die.SetStatus("At Day:"+day+" Dead\n");
            PostiveA.remove(Die);
            Dead.add(Die); 
            
        }

    }

    //////////////////////////////////////////////
    // public void Recovered(int day,ICU icu){

    //     int numOfRecovered= (int) (PostiveA.size() * 0.05 );
    //     int RecoveredIndex;
    //     Human person;

    //     covidInfection normal = new Normal();
        
    //     while(numOfRecovered != 0){
            
    //         RecoveredIndex = rad.nextInt(PostiveA.size());
    //         person = PostiveA.get(RecoveredIndex);
        
    //         person.setCovidInfection_Type(normal);

    //         person.SetStatus("At Day:"+day+"Normal\n");

    //         PostiveA.remove(person);
    //         icu.getWaitingList().remove(person);
    //         Recovered.add(person);

    //         numOfRecovered--;
            
    //     }




    // }

   
    public void Recovered(int day,ICU icu){

    

        covidInfection normal = new Normal();
        
      
      for (Human human : PostiveA) {
        double ran = Math.random();

        if(ran >= 0.70 && human.getVaccine()==true){
            human.setCovidInfection_Type(normal);
            human.SetStatus("At Day:"+day+"Normal\n");

            
            icu.getWaitingList().remove(human);
            Recovered.add(human);

        }
        else if (ran >= 0.99 && human.getVaccine()==false){
            human.setCovidInfection_Type(normal);
            human.SetStatus("At Day:"+day+"Normal\n");

            
            icu.getWaitingList().remove(human);
            Recovered.add(human);
        }

      }

      PostiveA.removeAll(Recovered);


    }


























    ///////Geters/////////////

    public ArrayList<Human> getCalls() {
        return Calls;
    }

    public ArrayList<Human> getPostiveA() {
        return PostiveA;
    }

    public ArrayList<Human> getPostiveB() {
        return PostiveB;
    }

    public ArrayList<Human> getRecovered() {
        return Recovered;
    }

    public ArrayList<Human> getDead() {
        return Dead;
    }
    public ArrayList<Human> getPostiveC() {
        return PostiveC;
    }

    //////////////////////////////////////////////







}