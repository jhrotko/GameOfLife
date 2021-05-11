import adapter.BoardHandler
import adapter.SomeHandler
import core.entities.Board
import io.javalin.Javalin


fun main() {
    val board = Board(500,500)
    val someHandler = SomeHandler()
    val boardHandler = BoardHandler(board)

    val app = Javalin.create().start(8080)
    app.get("/", someHandler)
    app.get("/board", boardHandler)
}
