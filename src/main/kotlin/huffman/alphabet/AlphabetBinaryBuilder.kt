package huffman.alphabet

import huffman.tree.Node
import java.io.File
import java.util.*

fun buildAlphabetFromFile(filePath: String, batchSize: Int): List<Node> {

    File(filePath).forEachBlock(batchSize, { batch, position -> Dictionary.add(batch) })
}

object Dictionary {
    private val dict: HashMap<BitSet, Double> = hashMapOf()
    private var counter: Int = 0


    fun add(batch: ByteArray) {
        counter += 1

        val key = BitSet.valueOf(batch)

        when (dict[key]) {
            null -> dict[key] = 0.0
            else -> dict[key] = dict[key]!! + 1.0
        }
    }

    fun get(): List<Node> {
        return dict.map { Node(weight = it.value.div(counter)) }
    }

}
