package States;

import Farmers.Entity;
import Farmers.FarmerBilly;
import Messages.Message;

public class BillyGlobalState implements IState<FarmerBilly>{
    private static BillyGlobalState instance = null;
    private BillyGlobalState(){}
    public static BillyGlobalState getInstance(){
        if (instance == null){
            instance = new BillyGlobalState();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBilly billy) {
        execute(billy);
    }

    @Override
    public void execute(FarmerBilly billy) {
        if(billy.needToUseRestroom()){
            billy.getStateMachine().changeState(VisitBathroom.getInstance());
        }
    }

    @Override
    public void exit(FarmerBilly billy) {
        // TODO há necessidade de deixar o global state null?
    }

    @Override
    public boolean onMessage(FarmerBilly billy, Message msg) {
        if(msg.getMessage().compareTo("GetToWork!") == 0){
            billy.getStateMachine().changeState(FakeWork.getInstance());
            return true;
        }
        return false;
    }
}
