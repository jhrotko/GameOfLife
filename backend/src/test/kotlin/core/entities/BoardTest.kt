package core.entities

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BoardTest {
    @Test
    fun `initializes a board only with dead cells`() {
        val board = Board(500, 500)

        assertEquals(500 * 500, board.getDeadCells().size)
    }

    @Test
    fun `computes the state of the cells in each iteration`() {
        val board = Board(2, 2)
        board.insertAlive(0, 0)
        board.insertAlive(0, 1)
        board.insertAlive(1, 0)
        board.insertAlive(1, 1)

        board.iteration()

        val aliveCells = board.getAliveCells()
        assertEquals(4, aliveCells.size)
    }
}