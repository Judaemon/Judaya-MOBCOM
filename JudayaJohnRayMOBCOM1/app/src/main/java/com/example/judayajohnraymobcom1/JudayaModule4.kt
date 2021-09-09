package com.example.judayajohnraymobcom1

fun main(){
    println(foo1(4,5.0))             //valid
    println("What is Ana\'s age:") //valid
    println("${foo2("Ana",5)} years old next year. ")          //valid
    val a = 5          //valid
    val b = 8          //valid
    val c = 2          //valid
    println("The sum of $a, $b and $c is ${foo3(a, b, c)}.")
    foo4(201912,201805, 5 , "Ana","Fe") //edit parameters
    foo4(201912, d = "Ana", b = 201805,e = "Fe") //You are not allowed to change order of parameters
}

fun foo1(x: Int, y: Double) = x + y

fun foo2(s: String, a: Int): Int {
    println("$s\'s age is currently $a years old and")
    return a+1
}

fun foo3(x: Int, y: Int, z: Int): Int = x+y+z //valid

fun foo4(a: Int,                            //valid
         b: Int,                            //valid
         c: Int = 0,                        //valid
         d: String,                         //valid
         e: String,                         //valid
         f: String = "Dummy Account"){     //valid
    println("=========================================") //valid
    println("ID\t\t\tStudent")  //valid
    println("$a\t\t$d")         //valid
    println("$b\t\t$e")         //valid
    println("$c\t\t\t$f")       //valid
}