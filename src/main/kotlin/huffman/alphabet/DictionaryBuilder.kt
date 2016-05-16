package huffman.alphabet

import huffman.alphabet.model.Dictionary
import java.io.File


fun buildDictionaryFromFile(filePath: String, batchSize: Int): Dictionary {
    val dict = Dictionary()

    File(filePath).forEachBlock(batchSize, { batch, position -> dict.add(batch) })

    return dict
}