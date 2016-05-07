package huffman

import huffman.alphabet.buildNodes
import huffman.code.CodeGenerator
import huffman.tree.Tree

class HuffmanService(val message: String = "") {
    private val codes = CodeGenerator(Tree(buildNodes(message))).doIt()

    init {
        codes.forEach {
            println("${it.char} - ${it.code.joinToString(separator = "")}")
        }
    }

    fun compress() {

    }

    fun decompress() {

    }
}

