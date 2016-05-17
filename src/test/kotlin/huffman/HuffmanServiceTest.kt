package huffman

import org.testng.Assert.*
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test
import java.io.File

class HuffmanServiceTest {
    val filePath = "/Users/kamilkucharski/workspace/huffman-ktl/src/test/resources/lalka"

    @Test
    fun compressTest() {
        //given
        val subject = HuffmanService(filePath, 2)

        //when
        subject.compress()

        //then
        assertEquals(1, 1)
    }
}