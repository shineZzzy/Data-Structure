package ThreadHigh.LowThread.PC;


/**
 * 利用join的性质
 */
public class SequencePrint {
    public static void main(String[] args) {
        Thread c=new Thread(new PrintTask("C",null));
        Thread b=new Thread(new PrintTask("B",c));
        Thread a=new Thread(new PrintTask("A",b));


        a.start();
        b.start();
        c.start();
    }

    private static class PrintTask implements Runnable{
        private String content;
        private Thread joinTask;

        public PrintTask(String content, Thread joinTask) {
            this.content = content;
            this.joinTask = joinTask;
        }

        @Override
        public void run() {
            try {
                if (joinTask!=null){
                    joinTask.join();
                }
                System.out.println(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
