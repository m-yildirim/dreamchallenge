import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.random.Random

internal class ExecutionTest {

    private var execution = Execution(Game())

    @BeforeEach
    fun reinitializeExecution() {
    execution = Execution(Game())}

    @Test
    fun `test that right amount of games will be played when only one game is to be played`() {

        execution.executeGame(1)
        assertEquals(1, execution.draws + execution.rockPlayingPlayerWins + execution.randomlyPlayingPlayerWins)

    }

    @Test
    fun `test that right amount of games will be played when number of games to be played is zero`() {

        execution.executeGame(0)
        assertEquals(0, execution.draws + execution.rockPlayingPlayerWins + execution.randomlyPlayingPlayerWins)

    }

    @Test
    fun `test that an exception is thrown when a negative number is given as number of games to be played`() {

        assertThrows(Exception::class.java) {
            execution.executeGame(-5)
        }

    }

    @Test
    fun `test that an exception is thrown when too big a number is given as number of games to be played`() {

        assertThrows(Exception::class.java) {
            execution.executeGame(999999999)
        }

    }

    @Test
    fun `test that total amount of wins, loses and draws for a player is equal to total numbers of played games`() {

        val randomNumberOfGames = Random.nextInt(150)
        execution.executeGame(randomNumberOfGames)
        assertEquals(randomNumberOfGames, execution.draws + execution.rockPlayingPlayerWins + execution.randomlyPlayingPlayerWins)

    }
}