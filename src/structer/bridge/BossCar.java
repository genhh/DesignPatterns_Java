package structer.bridge;

public class BossCar extends Car{
    public BossCar(Engine engine){
        super(engine);
    }
    @Override
    public String getBrand() {
        return "Boss";
    }
}
