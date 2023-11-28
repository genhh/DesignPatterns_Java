package behavior.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store implements ProductObservable{
    private List<ProductObserver> observers = new ArrayList<>();//观察者集合
    private Map<String, Product> products = new HashMap<>(); //商品集合


    @Override
    public void addObserver(ProductObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(ProductObserver observer) {
        this.observers.remove(observer);
    }

    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);
        // 通知观察者:
        observers.forEach(o -> o.onPublished(p));//可以通过多线程实现异步处理
    }

    public void setProductPrice(String name, double price) {
        Product p = products.get(name);
        p.setPrice(price);
        // 通知观察者:
        observers.forEach(o -> o.onPriceChanged(p));
    }
}
