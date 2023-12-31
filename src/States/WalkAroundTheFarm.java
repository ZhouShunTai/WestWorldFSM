package States;

import Farmers.Entity;
import Farmers.FarmerBilly;
import Messages.Message;

import java.util.Random;

public class WalkAroundTheFarm implements IState<FarmerBilly>{
    private static WalkAroundTheFarm instance = null;
    private WalkAroundTheFarm(){}
    public static WalkAroundTheFarm getInstance(){
        if (instance == null){
            instance = new WalkAroundTheFarm();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBilly billy) {
        billy.setCurrentLocation("Farm");
        billy.say("Acho que vou passear um pouco... Já trabalhei muito!");
    }

    @Override
    public void execute(FarmerBilly billy) {
        billy.walkAround();
        var random = new Random();
        if(random.nextInt(5) == 1){
            billy.getStateMachine().changeState(LookAtTheWeather.getInstance());
        }
    }

    @Override
    public void exit(FarmerBilly billy) {
        billy.say("Cansei de passear...");
    }

    @Override
    public boolean onMessage(FarmerBilly billy, Message msg) {
        return false;
    }
}
