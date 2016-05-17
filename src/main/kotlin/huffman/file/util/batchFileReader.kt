package huffman.file.util

import java.io.File


fun fileReader(filePath: String,
               batchSize: Int,
               action: (ByteArray) -> Unit) {
    if (batchSize > 512) {
        File(filePath).forEachBlock(batchSize, { batch, position -> action(batch) })
    } else {
        var counter = 0
        var bytes: ByteArray = ByteArray(batchSize)
        for (byte in File(filePath).readBytes()) {
            if (batchSize <= counter) {
                action(bytes)
                counter = 0
                bytes = ByteArray(batchSize)
            } else {
                bytes[counter] = byte
                counter++
            }
        }
        action(bytes)
    }
}