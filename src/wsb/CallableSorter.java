package wsb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableSorter implements Callable {
    private List<Integer> list;
    private long duration;

    public  CallableSorter(List<Integer> list){
        int n = list.size();
        this.list = new ArrayList<>(n);
        for(Integer i: list){
            this.list.add(i);
        }
    }

    @Override
    public List<Integer> call() {

        int n = this.list.size();

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(list.get(j-1) > list.get(j)){
                    int temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("Sorted: " + Thread.currentThread().getId());
        return this.list;
    }
}
