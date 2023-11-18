package structer.bridge.impl;

import structer.bridge.Engine;

public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Start Electric Engine...");
    }
}
