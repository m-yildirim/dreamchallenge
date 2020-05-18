import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GameTest() {

    private val game = Game()

    private val paperAction = Game.GameAction.PAPER
    private val rockAction = Game.GameAction.ROCK
    private val scissorAction = Game.GameAction.SCISSOR

    private val winResult = Game.GameResult.WIN
    private val loseResult = Game.GameResult.LOSE
    private val drawResult = Game.GameResult.DRAW


    @Test
    fun `test that decideWinner method implements the rules correctly`() {
        assertEquals(game.decideWinner(paperAction, rockAction), winResult)
        assertEquals(game.decideWinner(rockAction, rockAction), drawResult)
        assertEquals(game.decideWinner(scissorAction, rockAction), loseResult)

        assertEquals(game.decideWinner(paperAction, paperAction), drawResult)
        assertEquals(game.decideWinner(rockAction, paperAction), loseResult)
        assertEquals(game.decideWinner(scissorAction, paperAction), winResult)

        assertEquals(game.decideWinner(paperAction, scissorAction), loseResult)
        assertEquals(game.decideWinner(rockAction, scissorAction), winResult)
        assertEquals(game.decideWinner(scissorAction, scissorAction), drawResult)
    }



}