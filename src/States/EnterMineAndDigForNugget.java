package States;

import Farmers.Entity;

public class EnterMineAndDigForNugget implements IState<Entity> {
    private static EnterMineAndDigForNugget instance = null;
    private EnterMineAndDigForNugget(){}
    public static EnterMineAndDigForNugget getInstance(){
        if (instance == null){
            instance = new EnterMineAndDigForNugget();
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
