/**
 * The Class WeightedQuickUnionUF.
 *
 * @author Manas Talukdar
 */
public class WeightedQuickUnion {

    /** The id. */
    private int[] id;

    /** The sz. */
    private int[] sz;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final int[] getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value the new id
     */
    public final void setId(final int[] value) {
        id = value;
    }

    /**
     * Instantiates a new quick union uf.
     *
     * @param n the n
     */
    public WeightedQuickUnion(final int n) {
        id = new int[n];
        sz = new int[n + 1];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
            }
        }

    /**
     * Root.
     *
     * @param i the i
     * @return the integer
     */
    private int root(final int i) {
        int j = i;
        while (j != id[j]) {
                j = id[j];
                }
        return j;
        }

    /**
     * Connected.
     *
     * @param p the p
     * @param q the q
     * @return true, if successful
     */
    public final boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }

    /**
     * Union.
     *
     * @param p the p
     * @param q the q
     */
    public final void union(final int p, final int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
            }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
            } else {
            id[j] = i;
            sz[i] += sz[j];
            }
        }
}
