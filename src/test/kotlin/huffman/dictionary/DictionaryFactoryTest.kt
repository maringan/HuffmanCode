package huffman.dictionary

import org.testng.Assert.*
import org.testng.annotations.Test

class DictionaryFactoryTest {
    val filePath = "/Users/kamilkucharski/workspace/huffman-ktl/src/test/resources/lalka"

    @Test
    fun shouldReturnDictionaryWithCorrectSize() {
        // given
        val batchSize = 1

        // when
        val dict = DictionaryFactory.fromFile(filePath, batchSize)

        // then
        assertTrue(dict.get().size <= Math.pow(2.0, batchSize.toDouble() * 8))
    }

    @Test
    fun eachElementOfDictionaryShouldHaveWeightMoreThanZero() {
        // given
        val batchSize = 2

        // when
        val dict = DictionaryFactory.fromFile(filePath, batchSize)

        // then
        assertTrue(dict.get().all { it.weight > 0.0 })
    }
}