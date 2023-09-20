package States;

import Farmers.Entity;
import Farmers.EntityManager;
import Farmers.FarmerBilly;
import Farmers.FarmerBob;
import Messages.Message;
import Messages.MessageDispatcher;

public class GoHomeAndSleepTilRested implements IState<FarmerBob>{
    private static GoHomeAndSleepTilRested instance = null;
    private GoHomeAndSleepTilRested(){}
    public static GoHomeAndSleepTilRested getInstance(){
        if (instance == null){
            instance = new GoHomeAndSleepTilRested();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBob bob) {
        bob.setCurrentLocation("Farm");
        Entity billy = EntityManager.getInstance().getEntity("Billy");
        bob.setBillyWorked(((FarmerBilly) billy), false); // TODO Check
        MessageDispatcher.getInstance().dispatchMessage(bob, billy, "GetToWork!", null);
    }

    @Override
    public void execute(FarmerBob bob) {
        bob.rest();
        if(bob.billyWorked() && bob.isRested()){
            bob.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
        }else if(bob.isRested()){
            // TODO finish this state and slide semana 7 pagina 21
            System.out.println("Esperando o Billy terminar de trabalhar...");
        }
    }

    @Override
    public void exit(FarmerBob bob) {

    }

    @Override
    public boolean onMessage(FarmerBob bob, Message msg) {
        return false;
    }
}
