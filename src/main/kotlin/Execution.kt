class Execution(private val game: Game) {

    var randomlyPlayingPlayerWins = 0
    var rockPlayingPlayerWins = 0
    var draws = 0

    /**
     * Executes the game logic with player one playing a random action and player two always going for rock.
     */
    fun executeGame(numberOfGames: Int) {

        if (numberOfGames < 0) {
            throw Exception("A negative number for number of games cannot be accepted.")
        }

        if (numberOfGames > 10000000) {
            throw Exception(
                "Hard-coded upper limit for number of games to be played is 10000000 (10 millions). " +
                        "Please use a smaller number for this parameter."
            )
        }

        repeat(numberOfGames) {
            when (game.decideGameResult(game.randomActionSelector(), Game.GameAction.ROCK)) {
                Game.GameResult.WIN -> randomlyPlayingPlayerWins++
                Game.GameResult.LOSE -> rockPlayingPlayerWins++
                Game.GameResult.DRAW -> draws++
            }
        }

        println("A total of $numberOfGames game(s) were played.")
        println("Random playing player won $randomlyPlayingPlayerWins times.")
        println("Player who always plays rock won $rockPlayingPlayerWins times.")
        println("$draws times the result was a draw.")
    }
}