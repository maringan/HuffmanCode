package huffman.dictionary

import huffman.tree.model.Node
import java.util.*

class Dictionary {
    private val dict: HashMap<BitSet, Double> = hashMapOf()
    private var counter: Int = 0

    fun add(batch: ByteArray) {
        counter++

        val key = BitSet.valueOf(batch)

        dict[key] = dict[key]?.inc() ?: 1.0
    }

    fun get(): List<Node> {
        return dict.map { Node(weight = it.value.div(counter), isLeaf = true, char = it.key) }.toList()
    }
}