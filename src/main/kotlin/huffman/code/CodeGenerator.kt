package huffman.code

import huffman.tree.Node
import huffman.tree.Tree

class CodeGenerator(val tree: Tree) {

    fun doIt(): List<Node> {
        generateCode(tree.nodes.find { it.isRoot() }!!)

        return tree.nodes.filter { it.isLeaf }
    }

    private fun generateCode(root: Node) {
        val leftChild = root.leftChild
        val rightChild = root.rightChild

        if (leftChild != null) {
            leftChild.createCode(root, "1")
            generateCode(leftChild)
        }

        if (rightChild != null) {
            rightChild.createCode(root, "0")
            generateCode(rightChild)
        }
    }
}