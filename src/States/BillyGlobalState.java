package States;

import Farmers.Entity;

public class BillyGlobalState implements IState<Entity>{
    private static BillyGlobalState instance = null;
    private BillyGlobalState(){}
    public static BillyGlobalState getInstance(){
        if (instance == null){
            instance = new BillyGlobalState();
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