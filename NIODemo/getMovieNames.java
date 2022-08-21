import java.io.File;

public class getMoviesNames{
    public static void main(String[] args){
        File dir = new File("/Movies");
        for(String movieName: dir.list()){
            System.out.println(movieName);
        }
    }
}