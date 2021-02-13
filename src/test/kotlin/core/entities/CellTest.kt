package core.entities

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CellTest {
    @Nested
    inner class CalculateNeighbors {
        @Test
        fun `returns the number of neighbors at the top left of the board`() {
            val cell = Cell(0, 0)
            val board = Board(4, 4)
            board.insertAlive(0, 0)
            board.insertAlive(0, 1)
            board.insertAlive(1, 0)
            board.insertAlive(1, 1)

            val numberOfNeighbors = cell.numberOfAliveNeighbors(board)

            assertEquals(3, numberOfNeighbors)
        }

        @Test
        fun `returns the number of neighbors at the top right of the board`() {
            val cell = Cell(3, 0)
            val board = Board(4, 4)
            board.insertAlive(2, 0)
            board.insertAlive(2, 1)
            board.insertAlive(3, 1)

            val numberOfNeighbors = cell.numberOfAliveNeighbors(board)

            assertEquals(3, numberOfNeighbors)
        }

        @Test
        fun `returns the number of neighbors at the bottom right of the board`() {
            val cell = Cell(0, 3)
            val board = Board(4, 4)
            board.insertAlive(0, 2)
            board.insertAlive(1, 2)
            board.insertAlive(1, 3)

            val numberOfNeighbors = cell.numberOfAliveNeighbors(board)

            assertEquals(3, numberOfNeighbors)
        }

        @Test
        fun `returns the number of neighbors at the bottom left of the board`() {
            val cell = Cell(3, 3)
            val board = Board(4, 4)
            board.insertAlive(3, 2)
            board.insertAlive(2, 3)
            board.insertAlive(2, 2)

            val numberOfNeighbors = cell.numberOfAliveNeighbors(board)

            assertEquals(3, numberOfNeighbors)
        }
    }

    @Nested
    inner class StateMachine {

        @Nested
        inner class AliveToDead {

            @Test
            fun `sets the state to DEAD when an ALIVE cell has 0 neighbors`() {
                val cell = Cell(1,1).alive()
                val board = Board(3,3)
                board.insertAlive(0,0)

                cell.playIteration(board)

                assertTrue(cell.isDead())
            }

            @Test
            fun `sets the state to DEAD when an ALIVE cell has 1 neighbors`() {
                val cell = Cell(1,1).alive()
                val board = Board(3,3)
                board.insertAlive(0,0)

                cell.playIteration(board)

                assertTrue(cell.isDead())
            }

            @Test
            fun `sets the state to DEAD when an ALIVE cell has 4 neighbors`() {
                val cell = Cell(1, 1).alive()
                val board = Board(3, 3)
                board.insertAlive(0,0)
                board.insertAlive(1,0)
                board.insertAlive(2,0)
                board.insertAlive(0,1)

                cell.playIteration(board)

                assertTrue(cell.isDead())
            }

            @Test
            fun `sets the state to DEAD when an ALIVE cell has 5 neighbors`() {
                val cell = Cell(1, 1).alive()
                val board = Board(3, 3)
                board.insertAlive(0,0)
                board.insertAlive(1,0)
                board.insertAlive(2,0)
                board.insertAlive(0,1)
                board.insertAlive(2,1)

                cell.playIteration(board)

                assertTrue(cell.isDead())
            }

            @Test
            fun `sets the state to DEAD when an ALIVE cell has 6 neighbors`() {
                val cell = Cell(1, 1).alive()
                val board = Board(3, 3)
                board.insertAlive(0,0)
                board.insertAlive(1,0)
                board.insertAlive(2,0)
                board.insertAlive(0,1)
                board.insertAlive(2,1)
                board.insertAlive(0,2)

                cell.playIteration(board)

                assertTrue(cell.isDead())
            }

            @Test
            fun `sets the state to DEAD when an ALIVE cell has 7 neighbors`() {
                val cell = Cell(1, 1).alive()
                val board = Board(3, 3)
                board.insertAlive(0,0)
                board.insertAlive(1,0)
                board.insertAlive(2,0)
                board.insertAlive(0,1)
                board.insertAlive(2,1)
                board.insertAlive(0,2)
                board.insertAlive(1,2)

                cell.playIteration(board)

                assertTrue(cell.isDead())
            }

            @Test
            fun `sets the state to DEAD when an ALIVE cell has 8 neighbors`() {
                val cell = Cell(1, 1).alive()
                val board = Board(3, 3)
                board.insertAlive(0,0)
                board.insertAlive(1,0)
                board.insertAlive(2,0)
                board.insertAlive(0,1)
                board.insertAlive(2,1)
                board.insertAlive(0,2)
                board.insertAlive(1,2)
                board.insertAlive(2,2)

                cell.playIteration(board)

                assertTrue(cell.isDead())
            }
        }

        @Nested
        inner class DeadToAlive {

            @Test
            fun `sets the state to ALIVE when a DEAD cell has 3 neighbors`() {
                val cell = Cell(1, 1)
                val board = Board(3, 3)
                board.insertAlive(0,0)
                board.insertAlive(1,0)
                board.insertAlive(2,0)

                cell.playIteration(board)

                assertTrue(cell.isAlive())
            }
        }
    }
}
