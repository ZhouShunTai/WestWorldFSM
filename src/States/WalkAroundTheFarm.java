package States;

import Farmers.Entity;

public class WalkAroundTheFarm implements IState<Entity>{
    private static WalkAroundTheFarm instance = null;
    private WalkAroundTheFarm(){}
    public static WalkAroundTheFarm getInstance(){
        if (instance == null){
            instance = new WalkAroundTheFarm();
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
