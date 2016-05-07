package huffman.alphabet

import huffman.tree.Node
import org.testng.Assert.*
import org.testng.annotations.Test

class AlphabetBuilderTest {

    @Test
    fun shouldCreateNodeList() {
        // given
        val message = "aabbcc"

        // when
        val nodes = buildNodes(message)

        // then
        assert(nodes is List<Node>)
        assertEquals(nodes.size, 3)
    }

    @Test
    fun weightAllOfNodesShouldBeEqOne() {
        // given
        val message = "aabbccxxzzwwppkamil"

        // when
        val nodes = buildNodes(message)

        // then
        assertEquals(nodes.sumByDouble { it.weight }, 1.0)
    }

    @Test
    fun allOfNodesShouldBeLeafWithEmptyParent() {
        // given
        val message = "aabbccxxzzwwppkamil"

        // when
        val nodes = buildNodes(message)

        // then
        assert(nodes.all { it.isLeaf })
        assert(nodes.all { it.parent == null })
    }
}