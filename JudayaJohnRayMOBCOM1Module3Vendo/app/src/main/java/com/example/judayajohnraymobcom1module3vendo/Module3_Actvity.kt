package com.example.judayajohnraymobcom1module3vendo

fun main() {
    var getNewOrder: Boolean

//  Di nagamit kase while pala gagamitin
    val beverages = arrayOf(
        arrayOf("J","Juice", "12.50"),
        arrayOf("H","Hot Choco", "18.50"),
        arrayOf("C","Coffee", "10.00"),
        arrayOf("S","Soda", "25.5")
    )
    val desserts = arrayOf(
        arrayOf("1", "Cake", "35.00"),
        arrayOf("2", "Pudding", "12.50"),
        arrayOf("3", "Flan", "10.00"),
        arrayOf("4", "Salad", "20.50")
    )

    do {
        var totalCost = 0.0
        var change = 0.0

        displayMenu()
        totalCost += getBeverageUsingWhile()
        totalCost += getDessertUsingWhile()

        println("Total: $totalCost")

        change = calculateChange(totalCost)
        println("       Change is $change")

        print("Another order? ")
        getNewOrder = readLine() == "Y"
    }while (getNewOrder)

    print("       Bye!")

}

fun displayMenu() {
    println("MENU:")
    println("       [J] Juice 12.50                      [1] Cake 35.00")
    println("       [H] Hot Choco 18.50                  [2] Pudding 12.50")
    println("       [C] Coffee 10.00                     [3] Flan 10.00")
    println("       [S] Soda 25.5                        [4] Salad 20.50")
}

fun getBeverageUsingWhile(): Double {
    print("Enter Beverage: ")

    when (readLine()) {
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
            return 10.50
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

fun calculateChange(totalCost: Double): Double {
    print("Enter cash tendered: ")
    val readLine = readLine()
    val input = readLine ?.toDouble() ?: 0.0

    val change = input - totalCost

    if (input < totalCost){
        println("       You lack $change")
        return change
    }

    return change
}

// Di ko na basa instructions while pala gagamitin
// using 2d array mas better if like marami yung choices kase its looping
// Im not deleting this code for future reference lang po
fun getDessert(desserts: Array<Array<String>>): Double {
    print("Enter Dessert: ")
    val input = readLine();

    desserts.forEachIndexed  { _, element ->
        if (element[0] == input){
            println("This " + element[1] + ", will cost you " + element[2])
            return element[2].toDouble()
        }
    }

    println("You will be given a glass of water, which costs 1.00")
    return 1.0
}

fun getBeverage(beverages: Array<Array<String>>): Double {
    print("Enter Beverage: ")
    val input = readLine();

    beverages.forEachIndexed  { _, element ->
        if (element[0] == input){
            print("This ${element[1]}, will cost you ${element[2]}")
            return element[2].toDouble()

        }
    }
    println("You will be given a glass of water, which costs 1.00")
    return 1.0
}