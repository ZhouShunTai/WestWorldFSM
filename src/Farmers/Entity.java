package Farmers;

import Messages.Message;
import States.StateMachine;

public abstract class Entity {
    private String name;
    protected String currentLocation;
    protected StateMachine<Entity> stateMachine;
    public Entity(String newName){
        this.name = newName;
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

    public abstract void update();
}
