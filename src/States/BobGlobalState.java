package States;

import Farmers.Entity;
import Farmers.FarmerBob;

public class BobGlobalState implements IState<Entity>{
    private static BobGlobalState instance = null;
    private BobGlobalState(){}
    public static BobGlobalState getInstance(){
        if (instance == null){
            instance = new BobGlobalState();
        }
        return instance;
    }
    @Override
    public void enter(Entity farmerBob) {

    }

    @Override
    public void execute(Entity farmerBob) {

    }

    @Override
    public void exit(Entity farmerBob) {

    }
}
