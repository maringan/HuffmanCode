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
    }

    @Test
    fun compressTest() {
        // when
        compress(filePath, File("/Users/kamilkucharski/workspace/huffman-ktl/build/distributions/huffman-1.0-SNAPSHOT/bin/pan-tadeusz.txt").readText())

        // then
        assertEquals(File(filePath).length(), 1)
    }
}

