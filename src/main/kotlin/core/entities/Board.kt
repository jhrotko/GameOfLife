package core.entities


class Board(val width: Int, val height: Int) {
    var cells: Array<Array<Cell>> = Array(width) { x -> Array(height) { y -> Cell(x, y) } }

    fun getDeadCells(): List<Cell> {
        return cells.map { column -> column.filter { it.isDead() } }.flatten()
    }

    fun getAliveCells(): List<Cell> {
        return cells.map { column -> column.filter { it.isAlive() } }.flatten()
    }

    fun insertAlive(x: Int, y: Int) {
        cells[x][y] = Cell(x,y).alive()
    }

    fun iteration() {
        cells.forEach {
            it.forEach { cell ->
                cell.playIteration(this)
            }
        }
    }

    fun isAliveCell(x: Int, y: Int): Boolean {
        return cells[x][y].isAlive()
    }

    //    init {
//        if (aliveCells!! > 0) {
//            var alive = 0
//            val alivePositions = emptyMap<Pair<Int, Int>, Boolean>().toMutableMap()
//            while (alive < aliveCells!!) {
//                var position = generateAlivePosition()
//                while (alivePositions[position] == true) {
//                    position = generateAlivePosition()
//                }
//                alivePositions[position] = true
//                alive++
//            }
//            println(alivePositions)
//
//            alivePositions.keys.forEach { cells[it.first][it.second] = Cell(it.first, it.second) }
//        }
//    }

//    private fun generateAlivePosition(): Pair<Int, Int> {
//        val x = (0 until width).random()
//        val y = (0 until height).random()
//
//        return Pair(x, y)
//    }
}