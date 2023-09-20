package Farmers;

import States.BobGlobalState;
import States.EnterMineAndDigForNugget;
import States.StateMachine;

import java.util.Random;

public class FarmerBob extends Entity{

    // Physiological characteristics
    private int fatigue;
    private int thirst;
    private int pee;

    // Gold variables
    private int goldInPocket;
    private int pocketCapacity;
    private int goldInDay;
    private int goldInBank;


    public FarmerBob(String newName) {
        super(newName);
        this.fatigue = 0;
        this.thirst = 0;
        this.pee = 0;
        this.goldInPocket = 0;
        this.pocketCapacity = 10;
        this.goldInDay = 0;
        this.goldInBank = 0;
        this.currentLocation = "Mine";

        this.stateMachine = new StateMachine<>(this);
        stateMachine.setCurrentState(EnterMineAndDigForNugget.getInstance());
        stateMachine.setGlobalState(BobGlobalState.getInstance());
    }

    @Override
    public void update() {
        stateMachine.update();
    }

    // Action methods
    /** Mine action logic */
    public void mine(){
        System.out.println(say("Estou minerando..."));
        tryToGetNugget();
    }

    /** Rest action logic */
    public void rest(){
        System.out.println(say("Estou dormindo..."));
        fatigue = 0;
        goldInDay = 0;
    }

    /** Drink action logic */
    public void drink(){
        System.out.println(say("Estou bebendo..."));
        thirst = 0;
        gainPee(3);
    }

    /** Deposit gold in the bank action logic */
    public void depositGold(){
        System.out.println(say("Estou depositando o ouro no banco..."));
        goldInBank += goldInPocket;
        goldInPocket = 0;
    }

    public void goToToilet(){
        System.out.println(say("Estou tirando água do joelho..."));
        pee = 0;
    }

    // Helper methods
    /** Returns a string to say */
    private String say(String toSay){
        return this.getName() + ": -" + toSay;
    }

    /** Tries to get a nugget, only if pockets are not full and daily goal not reached */
    private void tryToGetNugget(){
        if(pocketIsFull()) return;
        if(dailyGoalReached()) return;
        var rand = new Random();
        if(rand.nextInt(2) == 0){
           goldInPocket++;
        }
    }

    /** Returns true if pocket is full */
    public boolean pocketIsFull(){
        return goldInPocket >= pocketCapacity;
    }

    /** Returns true if daily goal was reached */
    public boolean dailyGoalReached(){
        return goldInDay >= 10;
    }

    /** Increases the fatigue by one, if possible */
    public void gainFatigue(){
        if(fatigue < 10){
            fatigue++;
        }else{
            fatigue = 10;
        }
    }

    /** Returns true if tired */
    public boolean isTired(){
        return fatigue >= 10;
    }

    /** Retuns true if fatigue is zero */
    public boolean isRested(){
        return fatigue == 0;
    }

    /** Increases thirst by one, if possible */
    public void gainThirst(){
        if(thirst < 10){
            thirst++;
        }else{
            thirst = 10;
        }
    }

    /** Returns true if thirsty */
    public boolean isThirsty(){
        return thirst >= 10;
    }

    /** Returns true if thirst is zero */
    public boolean notThirsty(){
        return thirst == 0;
    }

    public void gainPee(){
        if(pee <= 10){
            pee++;
        }else{
            pee = 10;
        }
    }

    public void gainPee(int valueToIncrease){
        if(pee <= 10){
            pee += valueToIncrease;
        }else{
            pee = 10;
        }
    }

    /** Returns true if needs to use the restroom */
    public boolean needToUseRestroom(){
        return pee >= 10;
    }

    /** Returns true if pee is zero */
    public boolean isRelieved(){
        return pee == 0;
    }

    public void setBillyWorked(FarmerBilly billy, boolean workState){
        billy.setWorked(workState);
    }

    public boolean billyWorked(){
        var billy = EntityManager.getInstance().getEntity("Billyl");

        return ((FarmerBilly) billy).getWorked();
    }

}
