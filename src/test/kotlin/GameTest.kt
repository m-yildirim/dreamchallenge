import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GameTest {

    private val game = Game()

    private val paperAction = Game.GameAction.PAPER
    private val rockAction = Game.GameAction.ROCK
    private val scissorAction = Game.GameAction.SCISSOR

    private val winResult = Game.GameResult.WIN
    private val loseResult = Game.GameResult.LOSE
    private val drawResult = Game.GameResult.DRAW

    @Test
    fun `test that decideWinner method implements the rules correctly`() {
        assertEquals(game.decideGameResult(paperAction, rockAction), winResult)
        assertEquals(game.decideGameResult(rockAction, rockAction), drawResult)
        assertEquals(game.decideGameResult(scissorAction, rockAction), loseResult)

        assertEquals(game.decideGameResult(paperAction, paperAction), drawResult)
        assertEquals(game.decideGameResult(rockAction, paperAction), loseResult)
        assertEquals(game.decideGameResult(scissorAction, paperAction), winResult)

        assertEquals(game.decideGameResult(paperAction, scissorAction), loseResult)
        assertEquals(game.decideGameResult(rockAction, scissorAction), winResult)
        assertEquals(game.decideGameResult(scissorAction, scissorAction), drawResult)
    }
}
