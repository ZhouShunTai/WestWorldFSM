package States;

import Farmers.FarmerBob;

public class VisitBathroom implements IState<FarmerBob>{
    private static VisitBathroom instance = null;
    private VisitBathroom(){}
    public static VisitBathroom getInstance(){
        if (instance == null){
            instance = new VisitBathroom();
        }
        return instance;
    }
    @Override
    public void enter(FarmerBob farmerBob) {

    }

    @Override
    public void execute(FarmerBob farmerBob) {
        System.out.println("Hora do banheiro...");

    }

    @Override
    public void exit(FarmerBob farmerBob) {

    }
}
