package com.example.kotlinpractice

import org.junit.jupiter.api.Test

class ClassPractice {


    open class Human constructor( val name : String = "Anonymous") {

//        val name = name

        // 실행 순서 = 1. init , 2 constructor
        constructor(name : String , age : Int) : this(name) {
            println("my name is $name and $age years old")
        }

        init {
            println("New Human has been born!!")
        }

        fun eatingCake() {
            println("This is so Yummmmmmmyy~")
        }

        open fun singASong() {
            println("lalal~")
        }
    }

    class Korean : Human() { // 상속을 받으려면 부모클래스에 open 접근제한자 설정 -> open class Human()~~~

        override fun singASong() { // 메소드도 open 설정을 해야 오버라이딩 가능
            super.singASong()
            println("랄라라")
            println("my name is : $name")
        }
    }

    @Test
    fun main() {
        val human = Human("SeounSool")

        val staranger = Human()

        human.eatingCake()

        val yetii = Human("Yeti", 230)

        println("this is human's name is ${human.name}")
        println("this is human's name is ${staranger.name}")

        var korean = Korean()

        korean.singASong()
    }


}
