import behavior.chain_of_responsibility.HandlerChain;
import behavior.chain_of_responsibility.Request;
import behavior.chain_of_responsibility.impl.CEOHandler;
import behavior.chain_of_responsibility.impl.DirectorHandler;
import behavior.chain_of_responsibility.impl.ManagerHandler;
import behavior.command.AddCommand;
import behavior.command.Command;
import behavior.command.TextEditor;
import behavior.interpreter.Interpreter;
import behavior.iterator.ReverseArrayCollection;
import behavior.mediator.ExampleA;
import behavior.mediator.ExampleB;
import behavior.mediator.ExampleC;
import behavior.mediator.Mediator;
import behavior.memento.Memento;
import behavior.observer.ProductObserver;
import behavior.observer.Store;
import behavior.state.State;
import behavior.state.StateConvert;
import behavior.strategy.DiscountContext;
import behavior.strategy.OverDiscountStrategy;
import behavior.template.AbstractSetting;
import behavior.template.LocalSetting;
import behavior.template.RedisSetting;
import behavior.visitor.FileStructure;
import behavior.visitor.JavaFileVisitor;
import create.abstract_factory.AbstractFactory;
import create.abstract_factory.HttpDocument;
import create.abstract_factory.WordDocument;
import create.abstract_factory.impl.FastFactory;

import create.builder.Builder;
import create.factory.NumberFactory;
import create.prototype.Prototype;
import create.singleton.Singleton;
import org.w3c.dom.Text;
import structer.adapter.TaskCallable;
import structer.adapter.TaskRunnableAdapter;
import structer.bridge.BossCar;
import structer.bridge.Car;
import structer.bridge.impl.HybridEngine;
import structer.composite.Composite;
import structer.composite.Node;
import structer.decorator.TextNode;
import structer.decorator.impl.BoldDecorator;
import structer.decorator.impl.SpanNode;
import structer.facade.Facade;
import structer.flyweight.Student;
import structer.proxy.A;
import structer.proxy.AImpl;
import structer.proxy.AProxy;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
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

        //Structer
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

        //decorator
        TextNode n1 = new SpanNode();
        TextNode n2 = new BoldDecorator(new SpanNode());
        n1.setText("hello");
        n2.setText("hello bold");
        System.out.println(n1.getText());
        System.out.println(n2.getText());

        //Facade
        Facade facade = new Facade();
        facade.openCompany("test");

        //flyweight
        Student stu = Student.create(1,"pp");
        Student stu2 = Student.create(1,"pp");

        //proxy
        A a = new AImpl(1);
        AProxy aProxy = new AProxy(a);
        aProxy.a(1);
        aProxy.a(2);

        //behavior
        //chain
        // 构造责任链:
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());
        // 处理请求:
        chain.process(new Request("Bob", new BigDecimal("123.45")));
        chain.process(new Request("Alice", new BigDecimal("1234.56")));
        chain.process(new Request("Bill", new BigDecimal("12345.67")));
        chain.process(new Request("John", new BigDecimal("123456.78")));

        //command
        TextEditor textEditor = new TextEditor();
        Command command = new AddCommand(textEditor);
        command.execute();

        //interpreter
        Interpreter.log("[{}] start {} at {}...", LocalTime.now().withNano(0), "engine", LocalDate.now());

        //iterator
        var rArray = new ReverseArrayCollection<String>("apple", "pear", "orange", "banana");
        for (String fruit : rArray) {
            System.out.println(fruit);
        }

        //Mediator
        ExampleA exampleA = new ExampleA();
        ExampleB exampleB = new ExampleB();
        ExampleC exampleC = new ExampleC();
        Mediator mediator = new Mediator(exampleA,exampleB,exampleC);
        mediator.testAB();

        //Memento
        Memento memento = new Memento();
        memento.add("hello memento");
        memento.show();
        memento.getState();
        memento.setState("reset memento");
        memento.show();

        // observer
        ProductObserver testa = new ProductObserver();
        ProductObserver testc = new ProductObserver();
        // store:
        Store store = new Store();
        // 注册观察者:
        store.addObserver(testa);
        store.addObserver(testc);
        // 添加新商品并通知观察者
        store.addNewProduct("shopA",100);

        //State
        StateConvert stateConvert = new StateConvert();
        System.out.println(stateConvert.chat("hello"));
        System.out.println(stateConvert.chat("bye"));

        // Strategy
        DiscountContext ctx = new DiscountContext();
        // 默认使用普通会员折扣:
        BigDecimal pay1 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay1);
        // 使用满减折扣:
        ctx.setStrategy(new OverDiscountStrategy());
        BigDecimal pay2 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay2);

        //template
        AbstractSetting setting1 = new LocalSetting();
        AbstractSetting setting2 = new RedisSetting();

        //visitor
        FileStructure fs = new FileStructure(new File("./src/behavior/visitor"));//不是看main位置决定相对路径，而是看根目录位置
        fs.handle(new JavaFileVisitor());
    }
}