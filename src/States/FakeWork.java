package States;

import Farmers.EntityManager;
import Farmers.FarmerBilly;
import Messages.Message;
import Messages.MessageDispatcher;

import java.util.Random;

public class FakeWork implements IState<FarmerBilly>{
    private static FakeWork instance = null;
    private FakeWork(){}
    public static FakeWork getInstance(){
        if (instance == null){
            instance = new FakeWork();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBilly billy) {
        billy.setCurrentLocation("Farm");
        billy.say("Droga, o Bob me mandou trabalhar...");
        execute(billy);
    }

    @Override
    public void execute(FarmerBilly billy) {
        billy.fakeWorking();
        var random = new Random();
        if(random.nextInt(2) == 0){

        }else{
            billy.getStateMachine().changeState(LookAtTheWeather.getInstance());
        }
    }

    @Override
    public void exit(FarmerBilly billy) {
        billy.say("Ai minhas costas... Por hoje já chega Bob!");
        MessageDispatcher.getInstance().dispatchMessage(billy, EntityManager.getInstance().getEntity("Bob"), "JobsDone!", null );
    }

    @Override
    public boolean onMessage(FarmerBilly billy, Message msg) {
        return false;
    }
}
