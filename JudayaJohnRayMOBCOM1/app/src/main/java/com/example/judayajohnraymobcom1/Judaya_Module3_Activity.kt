package com.example.judayajohnraymobcom1

fun main() {
    var getNewOrder: Boolean

    do {
        var totalCost = 0.0

        displayMenu()
        totalCost += getBeverageUsingWhile()
        totalCost += getDessertUsingWhile()

        println("Total: $totalCost")

        calculateChange(totalCost)

        print("Another order? ")
        getNewOrder = readLine().toString().uppercase() == "Y"
    }while (getNewOrder)

    print("       Bye!")
}

fun displayMenu() {
    println("MENU:")
    println("       [J] Juice 12.50                      [1] Cake 35.00")
    println("       [H] Hot Choco 18.50                  [2] Pudding 12.50")
    println("       [C] Coffee 10.00                     [3] Flan 10.00")
    println("       [S] Soda 25.50                       [4] Salad 20.50")
}

fun getBeverageUsingWhile(): Double {
    print("Enter Beverage: ")

//    Gets input then turns it to uppercase
    when (readLine().toString().uppercase()) {
        "J" -> {
            println("       This Juice, will cost you 12.50")
            return 12.50
        }
        "H" -> {
            println("       This  Hot Choco, will cost you 18.50")
            return 18.50
        }
        "C" -> {
            println("       This Coffee, will cost you 10.00")
            return 10.00
        }
        "S" -> {
            println("       This Soda, will cost you 25.50")
            return 25.50
        }
        else -> {
            println("       You will be given a glass of water, which costs 1.00")
            return 1.0
        }
    }
}

fun getDessertUsingWhile(): Double {
    print("Enter Dessert: ")

//    try catch for catching character inputs
//    -1 for invalid input
    when (try { readLine()?.toInt() } catch (e: NumberFormatException) { -1 }) {
        1 -> {
            println("       This Cake, will cost you 35.00")
            return 35.00
        }
        2 -> {
            println("       This  Pudding, will cost you 12.50")
            return 12.50
        }
        3 -> {
            println("       This Flan, will cost you 10.00)")
            return 10.00
        }
        4 -> {
            println("       This Salad, will cost you 20.50")
            return 20.50
        }
        else -> {
            println("       Invalid input: Nothing will be served")
            return 0.0
        }
    }
}

// Returns Change to main because it might be useful
fun calculateChange(totalCost: Double): Double {
    print("Enter cash tendered: ")

//    ternary operation for null inputs
    val cash: Double = (readLine()?.toDoubleOrNull() ?: 0.0)

    val change = cash - totalCost

//    if expression
//    change * -1 is used to convert negative number to positive number
    println("       " + if (cash >= totalCost) "Change is $change" else "You lack " + change * -1 )
    return change
}
