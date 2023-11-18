import create.abstract_factory.AbstractFactory;
import create.abstract_factory.HttpDocument;
import create.abstract_factory.WordDocument;
import create.abstract_factory.impl.FastFactory;

import create.builder.Builder;
import create.factory.NumberFactory;
import create.prototype.Prototype;
import create.singleton.Singleton;
import structer.adapter.TaskCallable;
import structer.adapter.TaskRunnableAdapter;
import structer.bridge.BossCar;
import structer.bridge.Car;
import structer.bridge.impl.HybridEngine;
import structer.composite.Composite;
import structer.composite.Node;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) throws IOException {
        //简单(静态)工厂: 工厂不抽象,产品可以抽象。一个工厂生产所有商品，不符合开放封闭原则
        //工厂:工厂抽象，产品抽象。对应产品由对应工厂生产
        //抽象工厂:工厂抽象，产品抽象
        //工厂模式和抽象工厂的区别我理解为是具体实现工厂类中的方法数量差异，工厂一般只创建一个对象，抽象工厂创建多个对象

        //简单工厂就是把工厂的抽象去掉，直接用实现类
        //工厂
        NumberFactory factory = NumberFactory.getFactory();
        Number res = factory.parse("123456");
        System.out.println(res);

        //抽象工厂
        // 创建AbstractFactory，
        // 实际类型是FastFactory，要换成Good的话直接替换为new GoodFactory即可
        AbstractFactory factory2 = new FastFactory();//或者可以工厂接口写一个静态方法屏蔽在客户端生成工厂
        // 生成Html文档:
        HttpDocument html = factory2.createHtml("#Hello\nHello, http!");
        html.save(Paths.get(".", "fast.html"));
        // 生成Word文档:
        WordDocument word = factory2.createWord("#Hello\nHello, word!");
        word.save(Paths.get(".", "fast.doc"));

        //builder模式，将大型对象拆分成多个builder进行组装
        Builder builder = new Builder();

        //Prototype
        Prototype demo = new Prototype(1,2);
        Prototype demo2 = demo.copy();
        demo.setter(3,4);
        demo.show();
        demo2.show();

        //Singleton
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance2.equals(instance1));

        //Adapter
        Callable<Long> callable = new TaskCallable();
        Thread thread = new Thread(new TaskRunnableAdapter(callable));
        thread.start();

        //bridge
        Car car = new BossCar(new HybridEngine());
        car.drive();

        //composite
        Node root = new Composite("A");
        root.addNode(new Composite("B").addNode(new Composite("c")));
        //举例有点bug,懒得改了,大致意思就是展示组合的层级形式
        while (root.children().size()>0){
            System.out.println(root.getText());
            root = root.children().get(0);
        }

    }
}