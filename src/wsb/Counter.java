package wsb;

public class Counter implements Runnable{
    private int counterMax;

    public  Counter(int counterMax){
        this.counterMax = counterMax;
    }

    @Override
    public void run(){
        try{
            for (int i = this.counterMax; i >=  0; i--) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getId() + " : " + i);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



}
