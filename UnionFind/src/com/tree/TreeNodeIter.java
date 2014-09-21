package com.tree;

import java.util.Iterator;

/**
 * The Class TreeNodeIter.
 * https://code.google.com/p/yet-another-tree-structure/
 * @param <T> the generic type
 */
public class TreeNodeIter<T> implements Iterator<TreeNode<T>> {

        /**
         * The Enum ProcessStages.
         */
        enum ProcessStages {
                
                /** The Process parent. */
                ProcessParent, 
 /** The Process child cur node. */
 ProcessChildCurNode, 
 /** The Process child sub node. */
 ProcessChildSubNode
        }

        /** The tree node. */
        private TreeNode<T> treeNode;

        /**
         * Instantiates a new tree node iter.
         *
         * @param treeNode the tree node
         */
        public TreeNodeIter(TreeNode<T> treeNode) {
                this.treeNode = treeNode;
                this.doNext = ProcessStages.ProcessParent;
                this.childrenCurNodeIter = treeNode.children.iterator();
        }

        /** The do next. */
        private ProcessStages doNext;
        
        /** The next. */
        private TreeNode<T> next;
        
        /** The children cur node iter. */
        private Iterator<TreeNode<T>> childrenCurNodeIter;
        
        /** The children sub node iter. */
        private Iterator<TreeNode<T>> childrenSubNodeIter;

        /* (non-Javadoc)
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {

                if (this.doNext == ProcessStages.ProcessParent) {
                        this.next = this.treeNode;
                        this.doNext = ProcessStages.ProcessChildCurNode;
                        return true;
                }

                if (this.doNext == ProcessStages.ProcessChildCurNode) {
                        if (childrenCurNodeIter.hasNext()) {
                                TreeNode<T> childDirect = childrenCurNodeIter.next();
                                childrenSubNodeIter = childDirect.iterator();
                                this.doNext = ProcessStages.ProcessChildSubNode;
                                return hasNext();
                        }

                        else {
                                this.doNext = null;
                                return false;
                        }
                }
                
                if (this.doNext == ProcessStages.ProcessChildSubNode) {
                        if (childrenSubNodeIter.hasNext()) {
                                this.next = childrenSubNodeIter.next();
                                return true;
                        }
                        else {
                                this.next = null;
                                this.doNext = ProcessStages.ProcessChildCurNode;
                                return hasNext();
                        }
                }

                return false;
        }

        /* (non-Javadoc)
         * @see java.util.Iterator#next()
         */
        @Override
        public TreeNode<T> next() {
                return this.next;
        }

        /* (non-Javadoc)
         * @see java.util.Iterator#remove()
         */
        @Override
        public void remove() {
                throw new UnsupportedOperationException();
        }

}
