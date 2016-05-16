package huffman.alphabet.model

import huffman.tree.Node
import java.util.*

class Dictionary {
    private val dict: HashMap<BitSet, Double> = hashMapOf()
    private var counter: Int = 0

    fun add(batch: ByteArray) {
        counter++

        val key = BitSet.valueOf(batch)

        dict[key] = dict[key]?.inc() ?: 0.0
    }

    fun get(): List<Node> {
        return dict.map { Node(weight = it.value.div(counter)) }.toList()
    }
}