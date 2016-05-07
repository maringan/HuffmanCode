package huffman.tree

class Tree(val alphabet: List<Node>) {
    val nodes = buildTree(alphabet)
}