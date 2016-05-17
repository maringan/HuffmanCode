package huffman.code

import huffman.tree.model.Node


class CodeGenerator(val root: Node) {

    fun doIt(): Node {
        generateCode(root)
        return root
    }

    private fun generateCode(root: Node) {
        val leftChild = root.leftChild
        val rightChild = root.rightChild

        if (leftChild == null
                && rightChild == null
                && root.parent == null) {
            root.createCode(root, true)
        }

        if (leftChild != null) {
            leftChild.createCode(root, true)
            generateCode(leftChild)
        }

        if (rightChild != null) {
            rightChild.createCode(root, false)
            generateCode(rightChild)
        }
    }
}