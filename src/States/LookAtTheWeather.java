package States;

import Farmers.Entity;

public class LookAtTheWeather implements IState<Entity>{
    private static LookAtTheWeather instance = null;
    private LookAtTheWeather(){}
    public static LookAtTheWeather getInstance(){
        if (instance == null){
            instance = new LookAtTheWeather();
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
