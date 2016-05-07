package huffman.alphabet

import huffman.tree.Node

data class Pair(val key: Char, val count: Int)

fun buildNodes(source: String): List<Node> {
    var characterSet = countWeightForEachChar(source)
    val firstElem = characterSet.first()

    characterSet -= firstElem

    val totalNumber: Double = characterSet.sumBy({ it.count }).toDouble()

    var nodes: List<Node> = characterSet.map {
        Node(weight = it.count.div(totalNumber), char = it.key, isLeaf = true)
    }.toList()

    return nodes + Node(weight = 1.0 - nodes.sumByDouble { it.weight }, char = firstElem.key, isLeaf = true)
}

private fun countWeightForEachChar(source: String): List<Pair> {
    return source.groupBy { it.toChar() }
            .map { Pair(it.key, it.value.size) }
            .toList()
}
