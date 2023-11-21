package structer.proxy;

public class AImpl implements A{

    private  int a;
    public AImpl(int a){
        this.a = a;
    }

    @Override
    public void a(int a) {
        System.out.println(a==this.a);
    }
}
