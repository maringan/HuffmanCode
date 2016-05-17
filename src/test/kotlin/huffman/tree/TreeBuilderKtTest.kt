package huffman.tree

import huffman.dictionary.DictionaryFactory
import org.testng.Assert.*
import org.testng.annotations.Test

class TreeBuilderKtTest {
    val filePath = "/Users/kamilkucharski/workspace/huffman-ktl/src/test/resources/lalka"

    @Test
    fun shouldReturnRoot() {
        // given
        val batchSize = 1
        val dict = DictionaryFactory.fromFile(filePath, batchSize)

        // when
        val root = makeBinaryTreeFromDictionary(dict)

        // then
        assertTrue(root.isRoot())
    }
}