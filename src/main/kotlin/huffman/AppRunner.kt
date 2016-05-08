package huffman

import java.io.File

fun main(args: Array<String>) {
    compress(args[0], File(args[1]).readText())
}