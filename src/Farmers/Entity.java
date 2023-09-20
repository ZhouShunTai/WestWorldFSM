package Farmers;

import Messages.Message;
import States.StateMachine;

public abstract class Entity {
    private String name;
    protected String currentLocation;
    protected StateMachine stateMachine;

    protected int pee;
    public Entity(String newName){
        this.name = newName;
        this.pee = 0;
        EntityManager.getInstance().registerEntity(this);
    }

    public String getName(){
        return name;
    }
    public int getID(){
        return this.hashCode();
    }

    public void setCurrentLocation(String newCurrentLocation){
        currentLocation = newCurrentLocation;
    }

    public boolean handleMessage(Message msg){
        return stateMachine.handleMessage(msg);
    }

    public StateMachine getStateMachine(){
        return stateMachine;
    }

    public String say(String toSay){
        return this.getName() + ": -" + toSay;
    }

    public void goToToilet(){
        System.out.println(say("Estou tirando água do joelho..."));
        pee = 0;
    }

    public void gainPee(){
        if(pee <= 10){
            pee++;
        }else{
            pee = 10;
        }
    }

    /** Increases the pee by a custom amount */
    public void gainPee(int valueToIncrease){
        if(pee <= 10){
            pee += valueToIncrease;
        }else{
            pee = 10;
        }
    }

    /** Returns true if needs to use the restroom */
    public boolean needToUseRestroom(){
        return pee >= 10;
    }

    /** Returns true if pee is zero */
    public boolean isRelieved(){
        return pee == 0;
    }

    public abstract void update();
}
