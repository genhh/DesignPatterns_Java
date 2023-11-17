import create.factory.NumberFactory;

public class Main {
    public static void main(String[] args) {
        //简单(静态)工厂: 工厂不抽象,产品可以抽象。一个工厂生产所有商品，不符合开放封闭原则
        //工厂:工厂抽象，产品抽象。对应产品由对应工厂生产
        //抽象工厂:工厂抽象，产品抽象
        //工厂模式和抽象工厂的区别我理解为是具体实现工厂类中的方法数量差异，工厂一般只创建一个对象，抽象工厂创建多个对象

        //简单工厂就是把工厂的抽象去掉，直接用实现类
        //工厂
        NumberFactory factory = NumberFactory.getFactory();
        Number res = factory.parse("123456");
        System.out.println(res);


    }
}