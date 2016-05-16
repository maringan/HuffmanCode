package huffman.code

import huffman.tree.Node
import huffman.tree.Tree


class CodeGenerator(val tree: Tree) {

    fun doIt(): List<Node> {
        val root = tree.nodes.find { it.isRoot() } ?: tree.nodes.first()

        generateCode(root)

        return tree.nodes.filter { it.isLeaf }
    }

    private fun generateCode(root: Node) {
        val leftChild = root.leftChild
        val rightChild = root.rightChild

        if (leftChild == null
                && rightChild == null
                && root.parent == null) {
            root.createCode(root, "1")
        }

        leftChild?.createCode(root, "1")?.let { it -> generateCode(it) }
        rightChild?.createCode(root, "0")?.let { it -> generateCode(it) }
    }
}