package structer.proxy;

public class AProxy implements A {
    private A a;
    public AProxy(A a) {
        this.a = a;
    }
    public void a(int b) {
        if (b == 1) {
            this.a.a(b);
        } else {
            System.out.println("Forbidden");//throw error
        }
    }

}
