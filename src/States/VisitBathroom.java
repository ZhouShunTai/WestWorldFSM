package States;

import Farmers.Entity;
import Farmers.FarmerBob;
import Messages.Message;

public class VisitBathroom implements IState<Entity>{
    private static VisitBathroom instance = null;
    private VisitBathroom(){}
    public static VisitBathroom getInstance(){
        if (instance == null){
            instance = new VisitBathroom();
        }
        return instance;
    }
    @Override
    public void enter(Entity entity) {
        entity.setCurrentLocation("Restroom");
        entity.say("To muito apertado!!!");
        execute(entity);
    }

    @Override
    public void execute(Entity entity) {
        entity.goToToilet();

        if(entity.isRelieved()){
            entity.getStateMachine().revertToPreviousState();
        }

    }

    @Override
    public void exit(Entity entity) {
        entity.say("Agora estou aliviado!");
    }

    @Override
    public boolean onMessage(Entity entity, Message msg) {
        return false;
    }
}
