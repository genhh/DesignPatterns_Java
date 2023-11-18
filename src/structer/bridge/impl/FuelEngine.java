package structer.bridge.impl;

import structer.bridge.Engine;

public class FuelEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Start Fuel Engine...");
    }
}
