package huffman.tree

fun buildTree(nodeList: List<Node>): List<Node> {
    if (!valid(nodeList))
        throw Exception("Bad input date")

    var sortedNodeCollection = nodeList.sortedBy { it.weight }

    while (sortedNodeCollection.filter { it.parent == null }.size != 1 ) {

        var min1 = sortedNodeCollection.filter(withoutParent())[0]
        var min2 = sortedNodeCollection.filter(withoutParent())[1]

        var newNode = Node(
                leftChild = min1,
                rightChild = min2,
                weight = min1.weight + min2.weight)

        sortedNodeCollection += newNode

        min1.parent = newNode
        min2.parent = newNode

        sortedNodeCollection = sortedNodeCollection.sortedBy { it.weight }
    }

    return sortedNodeCollection
}

private fun withoutParent(): (Node) -> Boolean = { it.parent == null }

private fun valid(nodeList: List<Node>): Boolean {
    return nodeList.sumByDouble { it.weight } == 1.0
}