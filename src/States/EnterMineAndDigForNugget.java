package States;

import Farmers.Entity;
import Farmers.FarmerBob;
import Messages.Message;

public class EnterMineAndDigForNugget implements IState<FarmerBob> {
    private static EnterMineAndDigForNugget instance = null;
    private EnterMineAndDigForNugget(){}
    public static EnterMineAndDigForNugget getInstance(){
        if (instance == null){
            instance = new EnterMineAndDigForNugget();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBob bob) {
        bob.setCurrentLocation("Mine");
        bob.say("Estou entrando na mina!");
        execute(bob);
    }

    @Override
    public void execute(FarmerBob bob) {
        bob.mine();
        bob.gainPee();
        bob.gainFatigue();
        bob.gainThirst();

        // TODO Check if this is really necessary here, since its a global state
        /*
        if(bob.needToUseRestroom()){
            bob.getStateMachine().changeState(VisitBathroom.getInstance());
        }
         */

        if(bob.pocketIsFull()){
            bob.getStateMachine().changeState(VisitBankAndDepositGold.getInstance());
        }

        if(bob.isThirsty()){
            bob.getStateMachine().changeState(QuenchThirst.getInstance());
        }

        if(bob.isTired() || bob.dailyGoalReached()){
            bob.getStateMachine().changeState(GoHomeAndSleepTilRested.getInstance());
        }

    }

    @Override
    public void exit(FarmerBob bob) {
        bob.say("Preciso tratar de outros assuntos. Já volto ouro, espere por mim!");
    }

    @Override
    public boolean onMessage(FarmerBob farmerBob, Message msg) {
        return false;
    }
}
