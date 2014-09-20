/**
 * The Class QuickFindUF.
 *
 * @author Manas Talukdar
 */
public class QuickFindUF {
    /** The id. */
    public final int[] id;

    /**
     * Instantiates a new quick find uf.
     *
     * @param n
     *            the n
     */
    public QuickFindUF(final int n) {
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
