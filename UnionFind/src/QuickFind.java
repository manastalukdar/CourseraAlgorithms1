/**
 * The Class QuickFindUF.
 *
 * @author Manas Talukdar
 */
public class QuickFind {
    /** The id. */
    private int[] id;

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
     * Instantiates a new quick find uf.
     *
     * @param n
     *            the n
     */
    public QuickFind(final int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * Connected.
     *
     * @param p
     *            the p
     * @param q
     *            the q
     * @return true, if successful
     */
    public final boolean connected(final int p, final int q) {
        return id[p] == id[q];
    }

    /**
     * Union.
     *
     * @param p
     *            the p
     * @param q
     *            the q
     */
    public final void union(final int p, final int q) {
        final int pid = id[p];
        final int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
