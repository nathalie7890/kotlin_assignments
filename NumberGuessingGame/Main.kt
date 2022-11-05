package Assignments.NumberGuessingGame

fun main(args: Array<String>) {
    println("Number Guessing Game\n")
    while (true) {
        if(gameStart()) continue
        else break
    }
}

fun gameStart(): Boolean {
    val player1 = Player()
    player1.setName()
    val player2 = Player("Computer")
    val rounds = 5
    val game = NumberGame(player1, player2)

    println("This game is between ${player1.getName()} and ${player2.getName()}.\n")

    for (i in 1..rounds) {
        println("Round $i:\n")
        game.play()
        println("Round $i ends.\n")

        println("Points of players:")
        player1.showPoints()
        player2.showPoints()
        println("\n")

        game.resetLowHigh()

        val losingPlayer = if(player1.getPoints() < player2.getPoints())  player1.getName() else player2.getName()

        if(i == rounds -1) {
            println("Final round! $losingPlayer, this is your last chance!")
        }
        if (i == rounds) {
            println("GAME OVER")
            if (player1.getPoints() > player2.getPoints()) {
                println("${player1.getName()} won!\nWow, you actually beat the computer.\n")
            } else println("${player2.getName()} won! AI's gonna take over the world.")

            println("Would you like play again?\nType 'yes' or 'y' for yes, anything else to quit.")
            return when (readln().lowercase()) {
                "yes" -> true
                "y" -> true
                else -> false
            }
        }
    }

    return true
}