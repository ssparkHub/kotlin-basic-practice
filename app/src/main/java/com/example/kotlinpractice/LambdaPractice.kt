package com.example.kotlinpractice

import org.junit.jupiter.api.Test

class LambdaPractice {

    // 1. Lambda
    // 람다의 기본 정의
    //  1) 메소드의 파라미터로 넘겨줄 수 있다.
    //  2) return 값으로 사용 할 수 있다.

    //  val lambdaName : Type = {argumentList -> codeBody}


    val square : (Int) -> (Int) = {number -> number * number}
    // or
    val square2 = {number : Int -> number * number}

    val nameAge = {name : String, age : Int ->
        "my name is $name I'm $age"
    }

    @Test
    fun main() {
        println(square(12))
        println(square2(12))
        println(nameAge("sspark", 33))

        val a = "park said"
        val b = "joyce said"

        println(a.pizzaIsGreat())
        println(b.pizzaIsGreat())

        println(extendString("ariana", 27))

        println(calculateGrade(902))
        println(calculateGrade(2))
        println(calculateGrade(50))
        println(calculateGrade(90))


        val lambda = {number : Double ->
            number == 4.3212
        }

        println(invokeLambda(lambda))
        println(invokeLambda { it > 3.3 })

    }


    // 확장 함수

    val pizzaIsGreat : String.() -> String = {
        this + "Pizza is the Best!"
    }

    fun extendString(name : String, age : Int) : String {
        val introduceMySelf : String.(Int) -> String = {"I am $this and $it years old"}
        return name.introduceMySelf(age)
    }

    // 람다의 Return

    val calculateGrade : (Int) -> String = {
        when(it) {
            in 0..40 -> "fail"
            in 41..70 -> "pass"
            in 71..100 -> "perfect"
            else -> "Error"
        }
    }
    
    // 람다의 여러가지 표현 방식

    fun invokeLambda (lambda : (Double) -> Boolean) : Boolean {
        return lambda(5.2343)
    }


}