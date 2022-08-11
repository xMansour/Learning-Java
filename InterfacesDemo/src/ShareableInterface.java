public interface ShareableInterface {
    int CONSTANT1 = 1; //variables are public, final, and static by default
    //int CONSTANT2; Error, variables must be initialized
    int CONSTANT3 = 3;

    int shareableMethod1();

    default void shareableMethod2() {
        System.out.println("Shareable Method 2 Default Implementation");
    }

    static int shareableMethod3() {
        System.out.println("Static interface methods should have a body");
        return 0;
    }

}
