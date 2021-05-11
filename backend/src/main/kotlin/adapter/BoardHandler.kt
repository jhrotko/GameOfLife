package adapter

import core.entities.Board
import io.javalin.http.Context
import io.javalin.http.Handler


class SomeHandler: Handler {
    override fun handle(ctx: Context) {
        ctx.result("Hello handler")
    }
}

class BoardHandler(private val board: Board): Handler {
    override fun handle(ctx: Context) {
        ctx.json(board)
    }
}