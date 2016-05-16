package huffman

import huffman.alphabet.buildDictionaryFromFile
import huffman.code.CodeGenerator
import huffman.tree.Node
import huffman.tree.Tree
import huffman.tree.buildTree
import org.apache.commons.lang3.SerializationUtils
import java.io.File
import java.util.*


val SUFFIX = ".alphabet.bin"

fun compress(filePath: String, byteBatchSize: Int) {
    val dict: huffman.alphabet.model.Dictionary = buildDictionaryFromFile(filePath, byteBatchSize)
    val tree = Tree(buildTree(dict.get()))
    val codes = CodeGenerator(tree).doIt().map { it.char to it.code }.toMap()

    File(filePath).forEachBlock(byteBatchSize, { byteBody, i -> createSome(byteBody, codes) })
}

private fun createSome(byteBody: ByteArray, codes: Map<BitSet?, List<String>>) {
    val x = codes[BitSet.valueOf(byteBody)]

//    File("").writeBytes(x)
}


//fun compress(filePath: String, message: String) {
//    val tree = Tree(buildNodes(message))
//    val codes = CodeGenerator(tree).doIt().map { it.char to it.code }.toMap()
//
//    File(filePath).writeBytes(
//            prepareByteBody(codes, message).toByteArray()
//    )
//
//    File(filePath + ".alphabet").bufferedWriter().use { out ->
//        codes.forEach {
//            out.write("${it.key} - ${it.value.joinToString(separator = "")}")
//            out.newLine()
//        }
//    }
//
//    File(filePath + SUFFIX).writeBytes(SerializationUtils.serialize(tree))
//}

fun decompress(filePath: String) {
    val tree = SerializationUtils.deserialize<Tree>(File(filePath + SUFFIX).readBytes())
    val root = tree.nodes.find { it.parent == null }

    val message = BitSet.valueOf(File(filePath).readBytes())

    var node: Node = root!!

    File(filePath + ".decompressed").printWriter().use { out ->
        for (i in 0..(message.length() - 1)) {
            if (message.get(i)) {
                node = node.leftChild!!
            } else {
                node = node.rightChild!!
            }

            if (node.isLeaf) {
                print(node.char)
                out.print(node.char)
                node = root
            }
        }
    }

}

private fun prepareByteBody(codes: Map<BitSet, List<String>>, message: String): BitSet {
    val bitOutput = BitSet()
    var counter = 0

    message.forEach { letter ->
        codes[letter]!!.forEach {
            bitOutput.set(counter, it == "1")
            counter++
        }
    }

    return bitOutput;
}


