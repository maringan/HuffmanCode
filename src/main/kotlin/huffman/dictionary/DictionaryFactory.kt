package huffman.dictionary

import huffman.file.util.fileReader
import java.io.File

object DictionaryFactory {
    fun fromFile(filePath: String,
                 batchSize: Int): Dictionary {
        val dict = Dictionary()

        fileReader(filePath, batchSize) { byteArray ->
            dict.add(byteArray)
        }

        return dict
    }
}

