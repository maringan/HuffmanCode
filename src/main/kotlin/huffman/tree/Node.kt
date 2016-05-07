package huffman.tree

import java.util.*

data class Node(val weight: Double,
                val leftChild: Node? = null,
                val rightChild: Node? = null,
                var parent: Node? = null,
                val char: Char? = null,
                var code: List<String> = listOf(),
                val isLeaf: Boolean = false) {

    fun isRoot(): Boolean {
        return leftChild != null
                && rightChild != null
                && parent == null
    }

    fun createCode(node: Node, value: String) {
        this.code += node.code
        this.code += value
    }
}