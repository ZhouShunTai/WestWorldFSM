package Game;

import Farmers.Entity;
import Farmers.FarmerBilly;
import Farmers.FarmerBob;

public class WestWorld {
    public static void main(String[] args) {
        Entity farmerA = new FarmerBob("Bob");
        Entity farmerB = new FarmerBilly("Billy");

        while (true) {
            farmerA.update();
            farmerB.update();
        }
    }
}
