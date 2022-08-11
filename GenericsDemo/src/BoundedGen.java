public class BoundedGen <T extends Number>{
    T[] objs;
    BoundedGen(T[] objs){
        this.objs = objs;
    }

    public double getDoubleAvg(){
        double avg = 0.0;
        for(T obj: objs){
            avg+= obj.doubleValue();
        }
        return avg / objs.length;
    }

}
