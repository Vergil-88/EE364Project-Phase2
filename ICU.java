import java.util.ArrayList;

public class ICU {
    //Delration 
    
    private int bedCap=1000;
    private  ArrayList <Human> Beds = new ArrayList<Human>();
    
    private ArrayList <Human> waitingList = new ArrayList<Human>();
    private int bedNum = Beds.size() ; // number of availsble beds
    private int inWitingList=0;
    //methods
    







    public void RemoveBedof(Human person){

           for (Human bed : Beds) {

            if(person.equals(bed)){
                bed = null;
                bedNum++;
            }    
        }
    }

   public ArrayList<Human> getBeds() {
       return Beds;
   }

    public ArrayList<Human> getWaitingList() {
        return waitingList;
    }

    public int getBedNum() {
        return bedNum;
    }

    public int getInWitingList() {
        return inWitingList;
    }


    public void SetBedWithCap(Human human,int day){
        if(Beds.size()<bedCap){
            if(!Beds.contains(human)){
                Beds.add(human);
                human.SetStatus("At Day:"+day+" ICU\n");
                waitingList.remove(human);
            }
        }else{
            if(!waitingList.contains(human)){
                if(!Beds.contains(human)){
                waitingList.add(human);                
                human.SetStatus("At Day: "+day+" Waiting List\n");
                }
            }
        }
    }

    

    

    public int getBedCap() {
        return bedCap;
    }

    public void removeType_Normal_From_ICU(){

        for (int i=0; i < Beds.size() ;i++ ) {
            Human person = Beds.get(i);
            if(!(person.getCovidInfection_TypeType().equals("A"))||!(person.getAlive())){
                Beds.remove(i);

            }

        for(int j=0; i<waitingList.size();i++)
            if(waitingList.size()<j){
            if(waitingList.contains(Beds.get(j))){
                waitingList.remove(j);
            }
        }

        }

    }














}