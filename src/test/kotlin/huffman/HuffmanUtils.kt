package huffman

import org.testng.Assert.*
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test
import java.io.File


class HuffmanUtils {
    val filePath = "/Users/kamilkucharski/workspace/huffman-ktl/tmp/compressed.huffman.bin"

    @AfterMethod
    fun cleaner() {
        File(filePath).delete()
        File(filePath + ".alphabet").delete()
        File(filePath + ".decompressed").delete()
    }

    @Test
    fun compressTest() {
        // when
        compress(filePath, "abcd")

        // then
        assertEquals(File(filePath).length(), 1)
    }


    @Test
    fun decompressTest() {
        // given
        val message = "My test message"
        compress(filePath, message)

        // when
        decompress(filePath)

        // then
        assertEquals(File(filePath + ".decompressed").readText(), message)
    }
}

