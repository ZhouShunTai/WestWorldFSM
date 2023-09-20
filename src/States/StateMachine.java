package States;

import Messages.Message;

public class StateMachine<NPC>{
    private NPC myOwner;
    private IState<NPC> currentState;
    private IState<NPC> previousState;
    private IState<NPC> globalState;
    public StateMachine(NPC owner){
        myOwner = owner;
        currentState = null;
        globalState = null;
        previousState = null;
    }

    public void setCurrentState(IState<NPC> s) {
        currentState = s;
    }
    public void setGlobalState(IState<NPC> s) {
        globalState = s;
    }
    public void setPreviousState(IState<NPC> s) {
        previousState = s;
    }

    public void update() {

        if (globalState != null) {
            globalState.execute(myOwner);
        }
        if (currentState != null) {
            currentState.execute(myOwner);
        }
    }

    public void changeState(IState<NPC> newState) {
        previousState = currentState;
        currentState.exit(myOwner);
        currentState = newState;
        currentState.enter(myOwner);
    }

    public void revertToPreviousState() {
        changeState(previousState);
    }
    public IState<NPC> getCurrentState() {
        return currentState;
    }
    public IState<NPC> getGlobalState() {
        return globalState;
    }
    public IState<NPC> getPreviousState() {
        return previousState;
    }
    public boolean handleMessage(Message msg){
        if(currentState.onMessage(myOwner, msg)){
            return true;
        }

        if(globalState != null && globalState.onMessage(myOwner, msg)){
            return true;
        }

        return false;
    }

}

