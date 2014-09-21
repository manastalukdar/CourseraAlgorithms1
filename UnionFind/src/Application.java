import java.util.Arrays;

/**
 * The Class Application.
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
        QuickFind qf = new QuickFind(arrayLength);
        QuickUnion qu = new QuickUnion(arrayLength);
        WeightedQuickUnion wqu = new WeightedQuickUnion(arrayLength);
        String inputQf = "5-1 1-6 0-9 6-9 3-7 4-3";
        String[] pairsQf = inputQf.split(" ");
        for (String pair: pairsQf) {
            //pair.replace("-", ",");
            int p = Integer.parseInt(pair.split("-")[0]);
            int q = Integer.parseInt(pair.split("-")[1]);
            qf.union(p, q);
        }
        //CHECKSTYLE:OFF
        System.out.println("QuickFind: " + Arrays.toString(qf.getId()).replace(',', ' '));
        //CHECKSTYLE:ON

        String inputQu = "0-1 6-2 3-7 9-3 4-8 2-4 3-0 8-9 7-5";
        String[] pairsQu = inputQu.split(" ");
        for (String pair: pairsQu) {
            //pair.replace("-", ",");
            int p = Integer.parseInt(pair.split("-")[0]);
            int q = Integer.parseInt(pair.split("-")[1]);
            qu.union(p, q);
            wqu.union(p, q);
        }
        //CHECKSTYLE:OFF
        System.out.println("QuickUnion: " + Arrays.toString(qu.getId()).replace(',', ' '));
        System.out.println("WeightedQuickUnion: " + Arrays.toString(wqu.getId()).replace(',', ' '));
        //CHECKSTYLE:ON
    }

}
