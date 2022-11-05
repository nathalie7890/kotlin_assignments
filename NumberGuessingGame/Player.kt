package Assignments.NumberGuessingGame

open class Player(private var name: String = "", private var points: Int = 0) {

    fun setName() {
        print("Hello player, kindly enter your name: ")
        name = readln()
    }

    fun getName(): String {
        return name
    }

    fun getPoints(): Int {
        return points
    }

    fun addPoints(point: Int) {
        points += point
    }

    fun showPoints() {
        println("$name: $points")
    }

    fun guess(a: Int, b: Int): Int {
        print("Guess the number ($a to $b):")
        if(a ==b ) println("It's an obvious choice isn't it?")

        if (name == "Computer") {
            return (a..b).random()
        } else {
            return try {
                val num = readln().toInt()
                if (num < a || num > b) {
                    print("Out of range\n")
                    guess(a, b)
                } else {
                    num
                }

            } catch (e: Exception) {
                print("Invalid input.")
                guess(a, b)
            }
        }
    }

}