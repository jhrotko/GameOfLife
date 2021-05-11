package core.entities

class Cell(private val x: Int, private val y: Int) {
    var state: State = Dead(this)

    fun alive(): Cell {
        state = Alive(this)
        return this
    }

    fun isDead(): Boolean {
        return state is Dead
    }

    fun isAlive(): Boolean {
        return state is Alive
    }

    fun numberOfAliveNeighbors(board: Board): Int {
        var aliveNeighbors = 0

        if(right() < board.width) {
            if(up() >= 0) {
                if (board.isAliveCell(right(), up()))
                    aliveNeighbors++
            }
            if(down() < board.height) {
                if (board.isAliveCell(right(), down()))
                    aliveNeighbors++
            }
            if (board.isAliveCell(right(), y))
                aliveNeighbors++
        }

        if(left() >= 0) {
            if(down() < board.height) {
                if (board.isAliveCell(left(), down()))
                    aliveNeighbors++
            }
            if(up() >= 0) {
                if (board.isAliveCell(left(), up()))
                    aliveNeighbors++
            }
            if (board.isAliveCell(left(), y))
                aliveNeighbors++
        }

        if(down() < board.height) {
            if (board.isAliveCell(x, down()))
                aliveNeighbors++
        }

        if(up() >= 0) {
            if (board.isAliveCell(x, up()))
                aliveNeighbors++
        }

        return aliveNeighbors
    }

    fun playIteration(board: Board) {
        val aliveNeighbors = numberOfAliveNeighbors(board)
        state.iteration(aliveNeighbors)
    }

    private fun left(): Int {
        return x-1
    }

    private fun right(): Int {
        return x+1
    }

    private fun up(): Int {
        return y-1
    }

    private fun down(): Int {
        return y+1
    }
}