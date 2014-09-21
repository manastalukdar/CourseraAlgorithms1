import java.util.Arrays;

/**
 * The Class Application.
 */
public class Application {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        final int arrayLength = 10;
        QuickUnionUF qu = new QuickUnionUF(arrayLength);
        WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(arrayLength);
        String input = "0-1 6-2 3-7 9-3 4-8 2-4 3-0 8-9 7-5";
        String[] pairs = input.split(" ");
        for(String pair: pairs){
            //pair.replace("-", ",");
            int p = Integer.parseInt(pair.split("-")[0]);
            int q = Integer.parseInt(pair.split("-")[1]);
            qu.union(p, q);
            wqu.union(p, q);
        }
        System.out.println("QuickUnionUF: " + Arrays.toString(qu.id).replace(',', ' '));
        System.out.println("WeightedQuickUnionUF: " + Arrays.toString(wqu.id).replace(',', ' '));
    }

}
