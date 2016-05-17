package huffman.code

import huffman.dictionary.DictionaryFactory
import huffman.tree.makeBinaryTreeFromDictionary
import org.testng.Assert.*
import org.testng.annotations.Test

class CodeGeneratorTest {
    val filePath = "/Users/kamilkucharski/workspace/huffman-ktl/src/test/resources/lalka"

    @Test
    fun shouldGenerateCorrectCode() {
        // given
        val batchSize = 1
        val dict = DictionaryFactory.fromFile(filePath, batchSize)
        val root = makeBinaryTreeFromDictionary(dict)

        // when
        val calculatedRoot = CodeGenerator(root).doIt()

        // then
        assertTrue(calculatedRoot.isRoot())
        assertEquals(root.code.length(), 0)
        assertEquals(root.leftChild!!.code.length(), 1)
    }
}