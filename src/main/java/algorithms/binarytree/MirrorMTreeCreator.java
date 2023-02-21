package algorithms.binarytree;

import model.TreeNode;

import java.util.LinkedList;

/**
 * <a href="https://www.techiedelight.com/mirror-of-m-ary-tree/">link</a>
 * <p>
 * <b>Create a mirror of an m–ary tree</b>
 * <p>
 * Given an m–ary tree, write an efficient algorithm to convert the tree into its mirror.
 * An m-ary tree (aka k–ary tree) is a tree in which each node has no more than m children.
 * Each node of an m–ary tree has an array for storing pointers to each of its children.
 * The binary tree and the ternary tree are special cases of the m–ary tree where m = 2 and m = 3.
 */
public class MirrorMTreeCreator {

    void flipTree(TreeNode node) {
        if (node == null) return;

        var revertedChildren = new LinkedList<TreeNode>();
        for (TreeNode kid : node.getChildren()) {
            flipTree(kid);
            revertedChildren.push(kid);
        }

        node.setChildren(revertedChildren);
    }
}
