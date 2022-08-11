public class Gen2<T, V> {
    private T obj1;
    private V obj2;

    Gen2(T obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObj1() {
        return obj1;
    }

    public V getObj2() {
        return obj2;
    }

    public String getObj1Type() {
        return this.obj1.getClass().getName();
    }

    public String getObj2Type() {
        return this.obj2.getClass().getName();
    }

    public void setObj1(T obj) {
        this.obj1 = obj;
    }

    public void setObj2(V obj) {
        this.obj2 = obj;
    }


}
