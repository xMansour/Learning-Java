import java.util.Arrays;

public class Main {
    enum Car {
        Fiat(30000), Mercedes(1500000), BMW(1000000), Jeep(900000);
        private int price;

        Car(int price) {
            this.price = price;
        }
        public int getPrice(){
            return price;
        }
        public void setPrice(int price){
            this.price = price;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Car.values()));
        for (Car car : Car.values()) {
            System.out.println(car);
        }
        System.out.println(Car.valueOf("BMW"));
        System.out.println(Car.BMW.compareTo(Car.Mercedes));
        System.out.println(Car.Fiat.equals(Car.Jeep));
    }
}
