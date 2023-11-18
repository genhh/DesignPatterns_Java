package structer.adapter;

import java.util.concurrent.Callable;

public class TaskRunnableAdapter implements Runnable{
    private Callable<?> callable;
    public TaskRunnableAdapter(Callable<?> callable){
        this.callable = callable;
    }
    //委托转换
    @Override
    public void run() {
        try{
        callable.call();
        System.out.println("this is Runnable interface, convert successful.");
        }catch (Exception a){
            throw new RuntimeException(a);
        }
    }
}
