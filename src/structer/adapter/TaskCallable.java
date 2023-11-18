package structer.adapter;

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        System.out.println("this is callable interface");
        return 1l;
    }
}
