package create.prototype;

public class Prototype {
    //就是基于现有对象，进行复制或扩展
    private int a;
    private int b;
    public Prototype(int a_, int b_){
        a = a_;
        b = b_;
    }
    public  void setter(int a, int b){
        this.a = a;
        this.b = b;
    }

    public Prototype copy(){
        Prototype demo = new Prototype(1,2);
        demo.a = this.a;
        demo.b = this.b;
        return demo;
    }
    public void show(){
        System.out.println("a:"+a+"b"+b);
    }
}
