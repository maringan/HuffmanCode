package huffman.code

import huffman.alphabet.buildNodes
import huffman.tree.Tree
import org.testng.annotations.Test
import org.testng.Assert.*

class CodeGeneratorTest {

    @Test
    fun shouldGenerateHuffmanCode() {
        // given
        val tree = Tree(buildNodes("abc"))

        // when
        val code = CodeGenerator(tree).doIt()

        // then
        assertEquals(code.size, 3)
        assert(code.any({ it.code.size == 1 }))
    }
}