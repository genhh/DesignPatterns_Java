package structer.bridge;

public class BigCar extends Car{

    public BigCar(Engine engine){
        super(engine);
    }
    @Override
    public String getBrand() {
        return "Big";
    }
}
