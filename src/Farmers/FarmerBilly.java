package Farmers;

import States.BillyGlobalState;
import States.LookAtTheWeather;
import States.StateMachine;

public class FarmerBilly extends Entity{
    private boolean worked;
    public FarmerBilly(String newName) {
        super(newName);
        this.currentLocation = "Farm";
        this.worked = false;

        this.stateMachine = new StateMachine<>(this);
        stateMachine.setCurrentState(LookAtTheWeather.getInstance());
        stateMachine.setGlobalState(BillyGlobalState.getInstance());
    }

    public void setWorked(boolean newState){
        worked = newState;
    }
    public boolean getWorked(){
        return worked;
    }

    @Override
    public void update() {
        stateMachine.update();
    }
}
