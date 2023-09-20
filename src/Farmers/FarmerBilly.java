package Farmers;

import States.BillyGlobalState;
import States.LookAtTheWeather;
import States.StateMachine;

public class FarmerBilly extends Entity{
    private boolean worked;
    //private int pee;
    public FarmerBilly(String newName) {
        super(newName);
        this.currentLocation = "Farm";
        this.worked = false;
        //this.pee = 0;

        this.stateMachine = new StateMachine<FarmerBilly>(this);
        stateMachine.setCurrentState(LookAtTheWeather.getInstance());
        stateMachine.setGlobalState(BillyGlobalState.getInstance());
    }

    public void setWorked(boolean newState){
        worked = newState;
    }
    public boolean getWorked(){
        return worked;
    }

    public void walkAround(){
        System.out.println(say("Estou passeando pela fazenda..."));
    }

    public void lookAtWeather(){
        System.out.println(say("Estou olhando o tempo..."));
    }

    public void fakeWorking(){
        System.out.println(say("Estou fingindo... cof, cof... trabalhando na fazenda..."));
    }

    //** Increases the pee by one */
    /*
    public void gainPee(){
        if(pee <= 10){
            pee++;
        }else{
            pee = 10;
        }
    }

     */

    /** Returns true if needs to use the restroom */
    public boolean needToUseRestroom(){
        return pee >= 10;
    }

    /** Returns true if pee is zero */
    public boolean isRelieved(){
        return pee == 0;
    }

    @Override
    public void update() {
        stateMachine.update();
    }
}
