package Assignments.NumberGuessingGame


class NumberGame(private val player1: Player, private val player2: Player) {
    private var hiddenNumber: Int = 0
    private var flag = true
    private val repeat = 6
    private var low = 0
    private var high = 10

    fun resetLowHigh() {
        low = 0
        high = 10
    }

    private fun generateHiddenNumber(low: Int, high: Int) {
        hiddenNumber = (low..high).random()
    }

    private fun takeTurn(player: Player): Boolean {
        print("${player.getName()}, your turn. \n")
        val guessedNumber = player.guess(low, high)

        if(player.getName() == "Computer") {
            println(guessedNumber)
        }
        if (guessedNumber == hiddenNumber) {
            print("YOUR GUESS IS CORRECT!\n\n")
            return true
        } else if (guessedNumber < hiddenNumber) {
            print("The hidden number is greater than your guess\n\n")
            low = guessedNumber + 1
        } else {
            print("The hidden number is smaller than your guess\n\n")
            high = guessedNumber - 1
        }
        return false
    }


    fun play() {
        val low = 0
        val high = 10
        generateHiddenNumber(low, high)

        for (i in 0 until repeat) {
            val status = if (flag) {
                takeTurn(player1)
            } else {
                takeTurn(player2)
            }

            if (status) {
                if (i == 0) {
                    if (flag) {
                        player1.addPoints(5)
                        break
                    } else {
                        player2.addPoints(5)
                        break
                    }
                } else if (i == 1) {
                    if (flag) {
                        player1.addPoints(3)
                        break
                    } else {
                        player2.addPoints(3)
                        break
                    }
                } else {
                    if (flag) {
                        player1.addPoints(2)
                        break
                    } else {
                        player2.addPoints(2)
                        break
                    }
                }

            }

            if (i == repeat - 1) {
                println("\nAnswer: $hiddenNumber")
            }
            flag = !flag
        }
    }
}