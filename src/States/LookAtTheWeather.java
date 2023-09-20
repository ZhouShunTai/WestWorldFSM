package States;

import Farmers.Entity;
import Farmers.FarmerBilly;
import Messages.Message;

import java.util.Random;

public class LookAtTheWeather implements IState<FarmerBilly>{
    private static LookAtTheWeather instance = null;
    private LookAtTheWeather(){}
    public static LookAtTheWeather getInstance(){
        if (instance == null){
            instance = new LookAtTheWeather();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBilly billy) {
        billy.setCurrentLocation("Farm");
        billy.say("Acho que vou olhar o tempo...");
        execute(billy);
    }

    @Override
    public void execute(FarmerBilly billy) {
        billy.lookAtWeather();
        var random = new Random();
        if(random.nextInt(5) != 0){
            billy.getStateMachine().changeState(WalkAroundTheFarm.getInstance());
        }
    }

    @Override
    public void exit(FarmerBilly billy) {
        billy.say("Cansei de olhar o tempo...");
    }

    @Override
    public boolean onMessage(FarmerBilly billy, Message msg) {
        return false;
    }
}
