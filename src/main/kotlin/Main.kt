import java.util.*

fun main() {

    println("Please put in the number of games you would like to have played (0-10000000):")

    val input = Scanner(System.`in`)
    val numberOfGames: Int = try {
        input.nextInt()
    } catch (e: Exception) {
        println("Incompatible input. Please try again with a number.")
        0
    }

    Execution(Game()).executeGame(numberOfGames)
}