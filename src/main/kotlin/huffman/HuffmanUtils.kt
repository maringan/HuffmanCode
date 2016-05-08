package huffman

import huffman.alphabet.buildNodes
import huffman.code.CodeGenerator
import huffman.tree.Tree
import java.io.File
import java.util.*


fun compress(filePath: String, message: String) {
    val codes = CodeGenerator(Tree(buildNodes(message))).doIt().map { it.char to it.code }.toMap()

    File(filePath).writeBytes(
            prepareByteBody(codes, message).toByteArray()
    )

    File(filePath + ".alphabet").bufferedWriter().use { out ->
        codes.forEach {
            out.write("${it.key} - ${it.value.joinToString(separator = "")}")
            out.newLine()
        }
    }
}

fun decompress() {

}

private fun prepareByteBody(codes: Map<Char?, List<String>>, message: String): BitSet {
    val bitOutput = BitSet()
    var counter = 0

    message.forEach { letter ->
        codes[letter.toChar()]!!.forEach {
            bitOutput.set(counter, it == "1")
            counter++
        }
    }

    return bitOutput;
}


