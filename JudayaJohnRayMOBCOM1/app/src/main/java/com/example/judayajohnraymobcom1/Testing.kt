package com.example.judayajohnraymobcom1

fun main() {
    var getNewOrder: Boolean

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

        displayMenu()
        totalCost += getBeverage(beverages)
        totalCost += getDessert(desserts)

        println("Total: $totalCost")

        val change = calculateChangeTest(totalCost)

        print("Another order? ")
        getNewOrder = readLine().toString().uppercase() == "Y"
    }while (getNewOrder)

    print("       Bye!")
}

fun displayMenuTest() {
    println("MENU:")
    println("       [J] Juice 12.50                      [1] Cake 35.00")
    println("       [H] Hot Choco 18.50                  [2] Pudding 12.50")
    println("       [C] Coffee 10.00                     [3] Flan 10.00")
    println("       [S] Soda 25.50                       [4] Salad 20.50")
}

// Returns Change to main because it might be useful later on
fun calculateChangeTest(totalCost: Double): Double {
    print("Enter cash tendered: ")

//    ternary operation for null inputs
    val cash: Double = (readLine()?.toDoubleOrNull() ?: 0.0)

    val change = (cash - totalCost)

    if (cash < totalCost){
//        multiplying to -1 to convert to positive number
        println("       You lack " + change * -1)
        return change
    }

    println("       Change is $change")
    return change
}

fun getDessert(desserts: Array<Array<String>>): Double {
    print("Enter Dessert: ")
    val input = readLine()

    desserts.forEachIndexed  { _, element ->
        if (element[0] == input){
            println("This " + element[1] + ", will cost you " + element[2])
            return element[2].toDouble()
        }
    }

    println("       Invalid input: Nothing will be served")
    return 0.0
}

fun getBeverage(beverages: Array<Array<String>>): Double {
    print("Enter Beverage: ")
    val input = readLine()

    beverages.forEachIndexed  { _, element ->
        if (element[0] == input){
            print("This ${element[1]}, will cost you ${element[2]}")
            return element[2].toDouble()

        }
    }
    println("You will be given a glass of water, which costs 1.00")
    return 1.0
}