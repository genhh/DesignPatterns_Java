package create.abstract_factory;

//创建型:创建和使用分离
//工厂模式:引用抽象产品和抽象工厂
public interface AbstractFactory {
    HttpDocument createHtml(String md);
    WordDocument createWord(String md);
}
