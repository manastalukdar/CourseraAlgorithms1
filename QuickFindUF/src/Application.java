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
        QuickFindUF qf = new QuickFindUF(arrayLength);
        String input = "5-1 1-6 0-9 6-9 3-7 4-3";
        String[] pairs = input.split(" ");
        for(String pair: pairs){
            //pair.replace("-", ",");
            int p = Integer.parseInt(pair.split("-")[0]);
            int q = Integer.parseInt(pair.split("-")[1]);
            qf.union(p, q);
        }
        System.out.println(Arrays.toString(qf.id).replace(',', ' '));
    }

}
