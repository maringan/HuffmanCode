package huffman

import java.io.File

fun main(args: Array<String>) {
    if (args[0] == "-c") {
        compress(args[1], File(args[2]).readText())
    } else {
        if (args[0] == "-d") {
            decompress(args[1])
        } else {
            println("You have two option: \n -c - for compression file \n -d - for decompression file")
        }
    }
}