package wsb.threads;

public class Scorpion extends RunnableCounter {
    private void finishHim(){
        System.out.println("YOU ARE POISONED!!!");
    }

    @Override
    public void run() {
        for (int i = START_FROM; i >= 0 ; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finishHim();
    }
}
