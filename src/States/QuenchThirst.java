package States;

import Farmers.Entity;

public class QuenchThirst implements IState<Entity>{
    private static QuenchThirst instance = null;
    private QuenchThirst(){}
    public static QuenchThirst getInstance(){
        if (instance == null){
            instance = new QuenchThirst();
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
