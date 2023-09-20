package States;

import Messages.Message;

public interface IState<NPC> {
    void enter(NPC npc);
    void execute(NPC npc);
    void exit(NPC npc);
    public boolean onMessage(NPC npc, Message msg);
}
