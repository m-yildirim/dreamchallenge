import kotlin.random.Random

class Game {

    enum class GameResult {
        WIN, LOSE, DRAW
    }

    enum class GameAction {
        ROCK, PAPER, SCISSOR
    }

    /**
     * This method randomly selects and returns one of three GameAction values.
     */
    fun randomActionSelector(): GameAction {
        return when(Random.nextInt(GameAction.values().size)) {
            0 -> GameAction.ROCK
            1 -> GameAction.PAPER
            2 -> GameAction.SCISSOR
            else -> throw Throwable("Unexpected random integer generated.")
        }
    }

    /**
     * Decides game result for first player.
     *
     * @param playerOneAction player one's action
     * @param playerTwoAction player two's action
     * @return [GameResult] for player one
     */
    fun decideGameResult(playerOneAction: GameAction, playerTwoAction: GameAction): GameResult {

        when(playerOneAction) {
            GameAction.SCISSOR -> {
                return when(playerTwoAction) {
                    GameAction.PAPER -> GameResult.WIN
                    GameAction.ROCK -> GameResult.LOSE
                    else -> GameResult.DRAW
                }
            }
            GameAction.ROCK -> {
                return when (playerTwoAction) {
                    GameAction.PAPER -> GameResult.LOSE
                    GameAction.SCISSOR -> GameResult.WIN
                    else -> GameResult.DRAW
                }
            }
            GameAction.PAPER -> {
                return when (playerTwoAction) {
                    GameAction.SCISSOR -> GameResult.LOSE
                    GameAction.ROCK -> GameResult.WIN
                    else -> GameResult.DRAW
                }
            }
        }
    }
}
