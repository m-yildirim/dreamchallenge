import java.lang.Exception
import kotlin.random.Random

class Game {

    enum class GameResult {
        WIN, LOSE, DRAW
    }

    enum class GameAction {
        ROCK, PAPER, SCISSOR
    }


    fun randomActionSelector(): GameAction {

        return when(Random.nextDouble(3.0)) {
            in 0.0..1.0 -> GameAction.ROCK
            in 1.0..2.0 -> GameAction.PAPER
            in 2.0..3.0 -> GameAction.SCISSOR
            else -> throw Throwable("unexpected case of random double generation")
        }

    }

    fun decideWinner(randomAction: GameAction): GameResult {

        return when (randomAction) {
            GameAction.PAPER -> GameResult.WIN
            GameAction.ROCK -> GameResult.DRAW
            GameAction.SCISSOR -> GameResult.LOSE
        }
    }

}