package States;

import Farmers.Entity;
import Farmers.FarmerBob;
import Messages.Message;

public class BobGlobalState implements IState<FarmerBob>{
    private static BobGlobalState instance = null;
    private BobGlobalState(){}
    public static BobGlobalState getInstance(){
        if (instance == null){
            instance = new BobGlobalState();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBob bob) {
        execute(bob);
    }

    @Override
    public void execute(FarmerBob bob) {
        if(bob.needToUseRestroom()){
            bob.getStateMachine().changeState(VisitBathroom.getInstance());
        }
    }

    @Override
    public void exit(FarmerBob bob) {
        // TODO há necessidade de deixar o global state null?
    }

    @Override
    public boolean onMessage(FarmerBob bob, Message msg) {
        if(msg.getMessage().compareTo("JobsDone!") == 0){
            bob.setBillyWorked(true);
            return true;
        }
        return false;
    }
}
