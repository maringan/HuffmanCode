package huffman.tree

import huffman.dictionary.Dictionary
import huffman.tree.model.Node

fun makeBinaryTreeFromDictionary(dict: Dictionary): Node {
    var sortedNodeCollection = dict.get().sortedBy { it.weight }

    while (sortedNodeCollection.filter { it.parent == null }.size != 1) {

        val min1 = sortedNodeCollection.filter(withoutParent())[0]
        val min2 = sortedNodeCollection.filter(withoutParent())[1]

        val newNode = Node(
                leftChild = min1,
                rightChild = min2,
                weight = min1.weight + min2.weight)

        sortedNodeCollection += newNode

        min1.parent = newNode
        min2.parent = newNode

        sortedNodeCollection = sortedNodeCollection.sortedBy { it.weight }
    }

    println(sortedNodeCollection.size)
    println(sortedNodeCollection.filter { it.isLeaf }.size)
    return sortedNodeCollection.filter { it.isRoot() }.first()
}

private fun withoutParent(): (Node) -> Boolean = { it.parent == null }