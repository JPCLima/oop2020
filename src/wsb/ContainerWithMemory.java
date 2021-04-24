package wsb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

public class ContainerWithMemory<E> extends Container<E> {

    private HashMap<String, ArrayList<E>> versions;

    public ContainerWithMemory() {
        versions = new HashMap<>();
        saveVersion();
    }

    private void saveVersion() {
        String id = Integer.toString(list.hashCode());
        System.out.println("Version: " + id);
        versions.put(id, list);
    }

    private void restoreVersion(String version){
        list = versions.get(version);
    }

    public void printVersion(String version){
        System.out.println("Version: " + version);

        for(E data: versions.get(version)){
            System.out.println(data);
        }
    }

    public void printHistory(){
        for (String key: versions.keySet()){
            printVersion(key);
        }
    }

}
