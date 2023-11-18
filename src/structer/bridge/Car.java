package structer.bridge;

public abstract class Car {
    protected Engine engine;//引用引擎
    public Car(Engine engine){
        this.engine = engine;
    }

    public  void drive(){
        this.engine.start();
        System.out.println("Drive "+getBrand()+" car...");
    }

    public abstract String getBrand();//获取对应品牌
}
