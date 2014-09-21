package com.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The Class TreeNode.
 * https://code.google.com/p/yet-another-tree-structure/
 * @param <T> the generic type
 */
public class TreeNode<T> implements Iterable<TreeNode<T>> {

        /** The data. */
        public T data;

        /** The parent. */
        public TreeNode<T> parent;

        /** The children. */
        public List<TreeNode<T>> children;

        /**
         * Checks if is root.
         *
         * @return true, if is root
         */
        public final boolean isRoot() {
                return parent == null;
        }

        /**
         * Checks if is leaf.
         *
         * @return true, if is leaf
         */
        public final boolean isLeaf() {
                return children.size() == 0;
        }

        /** The elements index. */
        private List<TreeNode<T>> elementsIndex;

        /**
         * Instantiates a new tree node.
         *
         * @param data the data
         */
        public TreeNode(final T data) {
                this.data = data;
                this.children = new LinkedList<TreeNode<T>>();
                this.elementsIndex = new LinkedList<TreeNode<T>>();
                this.elementsIndex.add(this);
        }

        /**
         * Adds the child.
         *
         * @param child the child
         * @return the tree node
         */
        public final TreeNode<T> addChild(final T child) {
                TreeNode<T> childNode = new TreeNode<T>(child);
                childNode.parent = this;
                this.children.add(childNode);
                this.registerChildForSearch(childNode);
                return childNode;
        }

        /**
         * Gets the level.
         *
         * @return the level
         */
        public final int getLevel() {
                if (this.isRoot()) {
                    return 0;
                } else {
                    return parent.getLevel() + 1;
                }
        }

        /**
         * Register child for search.
         *
         * @param node the node
         */
        private void registerChildForSearch(final TreeNode<T> node) {
                elementsIndex.add(node);
                if (parent != null) {
                    parent.registerChildForSearch(node);
                }
        }

        /**
         * Find tree node.
         *
         * @param cmp the cmp
         * @return the tree node
         */
        public final TreeNode<T> findTreeNode(final Comparable<T> cmp) {
                for (TreeNode<T> element : this.elementsIndex) {
                        T elData = element.data;
                        if (cmp.compareTo(elData) == 0) {
                            return element;
                        }
                }

                return null;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public final String toString() {
                return data != null ? data.toString() : "[data null]";
        }

        /* (non-Javadoc)
         * @see java.lang.Iterable#iterator()
         */
        @Override
        public final Iterator<TreeNode<T>> iterator() {
                TreeNodeIter<T> iter = new TreeNodeIter<T>(this);
                return iter;
        }

}