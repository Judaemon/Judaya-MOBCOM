package com.example.judayafgemobcom1

fun main() {
    var total = getFirstNum() //Gets first number

    do {
        print("Enter operator: ")
        val operator = readLine().toString()

        if (operator == "=") break //stops the do while loop (Very big brain xD)

        if (checkOperator(operator)){  //Catch if invalid operator
            val nextNum =  getNextNum()
            total = calculate(operator, total, nextNum)//Gets the 3 parameter that is needed to calculate
        }else{
            println("Invalid Operator!")
        }
    }while (operator != "=")

    println("Result of computation is $total")
}

fun checkOperator(operator: String): Boolean{
    when(operator){
        "+" -> return true
        "-" -> return true
        "*" -> return true
        "/" -> return true
    }
    return false
}

fun calculate(operator: String, num1: Double, nextNum: Double): Double {
    when(operator){
        "+" -> return num1 + nextNum
        "-" -> return num1 - nextNum
        "*" -> return num1 * nextNum
        "/" -> return num1 / nextNum
    }
    return 0.0
}

fun getFirstNum(): Double {
    print("Enter first number: ")
    return try {
        readLine()!!.toDouble()
    }catch (e: Exception){
        println("Wrong input returning 0!")
        0.0
    }
}

fun getNextNum(): Double {
    print("Next number: ") //Next number here
    return try {
        readLine()!!.toDouble()
    }catch (e: Exception){
        println("Wrong input returning 0!")
        0.0
    }
}








