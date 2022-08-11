public class Gen<T> {
    T obj;

    Gen(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public String getType() {
        return obj.getClass().getName();
    }

/*
    this method will result an error if the invoking object and the passed object aren't of the same type
    thats why it is replaced with ? wildcards
    public boolean sameObj(Gen<T> obj) {
        return this.obj.equals(obj);
    }
*/

    //Wildcards
    public boolean sameObj(Gen<?> obj) {
        return this.obj.equals(obj);
    }

    //Generic method
    public <T extends Comparable<T>, V extends T> boolean isIn(T num, V[] arr){
        if (num != null && arr !=null)
            for (V element: arr) {
                if (num == element || num.equals(element))
                    return true;
            }
        return false;
    }

}
