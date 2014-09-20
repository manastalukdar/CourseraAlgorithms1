import java.util.Arrays;

/**
 * The Class application.
 */
final class Application {
    /**
     * Instantiates a new application.
     */
    private Application() {
        throw new AssertionError("Instantiating utility class...");
    }
        /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final int arrayLength = 10;
        final int number3 = 3;
        QuickFindUF qf = new QuickFindUF(arrayLength);
        qf.union(number3, 1);
        //CHECKSTYLE:OFF
        qf.union(1, 6);
        qf.union(2, 3);
        qf.union(7, 0);
        qf.union(6, 9);
        qf.union(5, 2);
        //CHECKSTYLE:ON
        System.out.println(Arrays.toString(qf.id));
    }

}
