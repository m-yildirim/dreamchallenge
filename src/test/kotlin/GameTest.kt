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
    fun `test that decide result returns win when paper is played`() {
        assertEquals(game.decideWinner(paperAction), winResult)
    }

    @Test
    fun `test that decide result returns draw when rock is played`() {
        assertEquals(game.decideWinner(rockAction), drawResult)
    }

    @Test
    fun `test that decide result returns lose when scissor is played`() {
        assertEquals(game.decideWinner(scissorAction), loseResult)
    }

}