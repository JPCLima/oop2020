package wsb.threads;

public class SubZero extends RunnableCounter {
    private void finishHim(){
        System.out.println("YOUR FROZEN!!");
    }
    @Override
    public void run() {
        super.run();
        finishHim();
    }

}
