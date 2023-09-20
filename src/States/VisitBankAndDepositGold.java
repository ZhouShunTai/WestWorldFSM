package States;

import Farmers.Entity;
import Farmers.FarmerBob;
import Messages.Message;

public class VisitBankAndDepositGold implements IState<FarmerBob>{
    private static VisitBankAndDepositGold instance = null;
    private VisitBankAndDepositGold(){}
    public static VisitBankAndDepositGold getInstance(){
        if (instance == null){
            instance = new VisitBankAndDepositGold();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBob bob) {
        bob.setCurrentLocation("Bank");
        bob.say("Chegando no banco. Hora de depositar esse ouro!");
        execute(bob);
    }

    @Override
    public void execute(FarmerBob bob) {
        bob.depositGold();

        if(bob.dailyGoalReached()){
            bob.getStateMachine().changeState(GoHomeAndSleepTilRested.getInstance());
        }else{
            bob.getStateMachine().changeState(EnterMineAndDigForNugget.getInstance());
        }
    }

    @Override
    public void exit(FarmerBob bob) {
        bob.say("Maravilha, estou ainda mais rico!");
    }

    @Override
    public boolean onMessage(FarmerBob farmerBob, Message msg) {
        return false;
    }
}
