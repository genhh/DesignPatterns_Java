import create.abstract_factory.AbstractFactory;
import create.abstract_factory.HttpDocument;
import create.abstract_factory.WordDocument;
import create.abstract_factory.impl.FastFactory;

import create.builder.Builder;
import create.factory.NumberFactory;

import java.io.IOException;
import java.nio.file.Paths;

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
    }
}