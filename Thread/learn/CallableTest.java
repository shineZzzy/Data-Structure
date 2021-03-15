package ThreadHigh;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task=new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return "Called...";
            }
        });
        new Thread(task).start();
        System.out.println(task.get());
        System.out.println("main");
    }
}
