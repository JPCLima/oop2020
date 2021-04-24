package wsb;

public class SuperNumber<T extends Number> {

    T obj;

    public SuperNumber(T obj){
        this.obj = obj;
    }

    public void printClassType(){
        System.out.println(this.getClass().getName());
    }

    public double toDouble(){
        return obj.doubleValue();
    }

    public int toInteger(){
        return  obj.intValue();
    }

    public boolean compareInteger(SuperNumber n){
        return toInteger() == n.toInteger();
    }

    public boolean compareDouble(SuperNumber n){
        return toDouble() == n.toDouble();
    }

    public boolean compareDoubleToInt(){
        return this.toDouble() == this.toInteger();
    }

}
