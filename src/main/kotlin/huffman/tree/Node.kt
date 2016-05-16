package huffman.tree

import java.io.Serializable
import java.util.*

data class Node(val weight: Double,
                val leftChild: Node? = null,
                val rightChild: Node? = null,
                var parent: Node? = null,
                val char: BitSet? = null,
                var code: List<String> = listOf(),
                val isLeaf: Boolean = false) : Serializable {

    fun isRoot(): Boolean {
        return leftChild != null
                && rightChild != null
                && parent == null
    }

    fun createCode(node: Node, value: String): Node {
        this.code += node.code
        this.code += value

        return this
    }
}