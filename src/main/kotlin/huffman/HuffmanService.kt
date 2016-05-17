package huffman

import huffman.code.CodeGenerator
import huffman.dictionary.Dictionary
import huffman.dictionary.DictionaryFactory
import huffman.file.util.fileReader
import huffman.tree.makeBinaryTreeFromDictionary
import huffman.tree.model.Node
import org.apache.commons.lang3.SerializationUtils
import java.io.File
import java.util.*

class HuffmanService(val filePath: String, val batchSize: Int) {
    private val leafs: MutableMap<BitSet, BitSet> = mutableMapOf()
    private val writeBuffer: Int = 5000

    fun compress() {
        val dict: Dictionary = DictionaryFactory.fromFile(filePath, batchSize)
        val root: Node = CodeGenerator(makeBinaryTreeFromDictionary(dict)).doIt()

        setLeafs(root)

        File(filePath + ".dict.bin").writeBytes(SerializationUtils.serialize(root))

        // todo fix write to file
        var tmpBitSet = BitSet()
        val file = File(filePath + ".compress")
        fileReader(filePath, batchSize) { byteBlock ->
            addBitSets(tmpBitSet, leafs[BitSet.valueOf(byteBlock)]!!)
            if (tmpBitSet.length() % (8 * writeBuffer) == 0) {
                file.appendBytes(tmpBitSet.toByteArray())
                tmpBitSet = BitSet()
            }
        }

        file.appendBytes(tmpBitSet.toByteArray())
    }

    private fun setLeafs(root: Node) {
        if (root.isLeaf) {
            leafs.put(root.char!!, root.code)
        } else {
            setLeafs(root.leftChild!!)
            setLeafs(root.rightChild!!)
        }
    }

    private fun addBitSets(thiz: BitSet, other: BitSet): BitSet {
        val otherLastIndex = other.length() - 1
        val thizLastIndex = thiz.length()

        for (i in 0..otherLastIndex) {
            thiz.set(thizLastIndex, other.get(i))
        }

        return thiz
    }
}