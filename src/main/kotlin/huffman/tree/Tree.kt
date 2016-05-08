package huffman.tree

import java.io.Serializable

class Tree(val alphabet: List<Node>) : Serializable {
    val nodes = buildTree(alphabet)
}