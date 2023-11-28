package behavior.mediator;

//通过引入一个中介对象，把多边关系变成多个双边关系，从而简化系统组件的交互耦合度。
public class Mediator {
    ExampleA exampleA;
    ExampleB exampleB;
    ExampleC exampleC;

    public Mediator(ExampleA exampleA, ExampleB exampleB, ExampleC exampleC){
        this.exampleA = exampleA;
        this.exampleB = exampleB;
        this.exampleC = exampleC;
    }

    public void testAB(){
        exampleA.testA();
        exampleB.testB();
    }

    public void testAC(){
        exampleA.testA();
        exampleC.testC();
    }
    public void testBC(){
        exampleB.testB();
        exampleC.testC();
    }
}
