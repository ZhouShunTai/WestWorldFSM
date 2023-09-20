package States;

import Farmers.Entity;
import Farmers.FarmerBob;
import Messages.Message;

public class QuenchThirst implements IState<FarmerBob>{
    private static QuenchThirst instance = null;
    private QuenchThirst(){}
    public static QuenchThirst getInstance(){
        if (instance == null){
            instance = new QuenchThirst();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBob bob) {
        bob.setCurrentLocation("Saloon");
        bob.say("Chegando no salão, tô com muita sede!");
        execute(bob);
    }

    @Override
    public void execute(FarmerBob bob) {
        bob.drink();

        if(bob.notThirsty()){
            bob.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void exit(FarmerBob bob) {
        bob.say("Nada como uma boa 'água' para refrescar!");
    }

    @Override
    public boolean onMessage(FarmerBob bob, Message msg) {
        return false;
    }
}
