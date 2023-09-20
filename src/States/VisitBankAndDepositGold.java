package States;

import Farmers.Entity;

public class VisitBankAndDepositGold implements IState<Entity>{
    private static VisitBankAndDepositGold instance = null;
    private VisitBankAndDepositGold(){}
    public static VisitBankAndDepositGold getInstance(){
        if (instance == null){
            instance = new VisitBankAndDepositGold();
        }
        return instance;
    }
    @Override
    public void enter(Entity entity) {

    }

    @Override
    public void execute(Entity entity) {

    }

    @Override
    public void exit(Entity entity) {

    }
}
