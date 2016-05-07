package huffman.tree

import org.testng.Assert.*
import org.testng.annotations.Test


class TreeBuilderKtTest {
    @Test
    fun shouldBuildFullHuffmanTree() {
        // given
        val nodeList = listOf(
                Node(weight = 0.5, isLeaf = true),
                Node(weight = 0.4, isLeaf = true),
                Node(weight = 0.1, isLeaf = true)
        )

        // when
        val huffmanTree = buildTree(nodeList)

        // then
        assertEquals(huffmanTree.size, 5)
        assertEquals(huffmanTree.last().weight, 1.0)
    }

    @Test
    fun shouldThrowExceptionIfInputArrayIsNotCorrect() {
        // given
        val nodeList = listOf(
                Node(weight = 0.4, isLeaf = true),
                Node(weight = 0.4, isLeaf = true),
                Node(weight = 0.1, isLeaf = true)
        )

        // expect
        assertThrows {
            buildTree(nodeList)
        }
    }
}