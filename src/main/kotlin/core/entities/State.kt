package core.entities

interface State {
    fun iteration(aliveNeighbors: Int)
}

class Alive(private val cell: Cell): State {
    override fun iteration(aliveNeighbors: Int) {
        when(aliveNeighbors) {
            0,1,4,5,6,7,8 -> cell.state = Dead(cell)
        }
    }
}

class Dead(private val cell: Cell): State {
    override fun iteration(aliveNeighbors: Int) {
        when(aliveNeighbors) {
            3 -> cell.state = Alive(cell)
        }
    }
}