package structer.bridge;

public class TinyCar extends Car{
    public TinyCar(Engine engine){
        super(engine);
    }
    @Override
    public String getBrand() {
        return "Tiny";
    }
}
