package behavior.observer;

public interface ProductObservable {
    void addObserver(ProductObserver observer);
    void removeObserver(ProductObserver observer);
}
