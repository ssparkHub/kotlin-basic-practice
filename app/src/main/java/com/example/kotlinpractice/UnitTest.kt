package com.example.kotlinpractice

import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {

    // 1. 함수
    @Test
    fun main() {
        helloWorld()
        "add Func : " + println(add(4,5))

        // 3. String Template
        val name = "SeongSul"
        val lastName = "Park"
        println("my name is ${name +" "+ lastName} I'm 31")
        println("this is 2\$a")

        println("check number")
        checkNumb(1)

        forAndWhile()

        nullCheck()

        ignoreNulls("sspark")

    }

    private fun helloWorld() : Unit {
        println("Hello World")
    }

    fun add(a : Int, b : Int) : Int {
        return a + b
    }

    // 2. val VS var

    fun hi() {
        val a : Int = 10 //변할 수 없는 상수
        var b : Int = 9  //변할 수 있는

//        a = 100 //Val cannot be reassigned

        b = 100
        println(b)

        val c = 100
        var d = 100

        var name= "sspark"
        var changeName : String // 가변일시 타입 선언

        
    }


    //4. 조건식
    fun maxBy(a : Int , b : Int) : Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun maxBy2(a : Int, b : Int) = if(a>b) a else b


    // 자바 함수의 경우 리턴 값에 void 를 사용 가능 -> statement
    // 코틀린 함수의 경우 리턴 값이 없어도 무조건 Unit 을 반환 하기 때문에 expression 으로 정의됨
    fun checkNumb(score : Int) {
        when(score) { // statement 사용 시
            0 -> println("this is 0")
            1 -> println("this is 1")
            2,3 -> println("this is 2 or 3")
            else -> println("I don't know") // else 생략 가능
        }

        var b = when(score) { // expression 사용 시 == 값을 만들어 낼 경우를 의미
            1 -> 1
            2 -> 2
            else -> 3 // else 생략 불가능
        }

        println("b : ${b}")

        when(score) {
            in 90..100 -> println("You are Genius")
            in 10..80 -> println("not bad")
            else -> println("okay")
        }
    }
    
    // 5. Array And List
    // Array 기존 배열과 동일
    // List 1. List , 2. MutableList
    
    fun array() {
        val array = arrayOf(1,2,3)
        val list = listOf(1,2,3)
        
        var array2 = arrayOf(1,"d",3,4f) // anyType 설정 가능 -> <Any> 제네릭 자동 생성
        val list2 = listOf(1,"d",11L)

        array[0] = 3
        var result = list.get(0)

        val arrayList = arrayListOf<Int>()
        arrayList.add(10)
        arrayList.add(20)
        arrayList[0] = 20
    }

    // 6. for / while

    fun forAndWhile() {
        val students = arrayListOf("joyce", "james", "jenny", "john")

        for (name in students) {
            println("${name}")
        }

        var sum : Int = 0
        var sumDown : Int = 0
        var sumUntil : Int = 0
        for ( i in 1..10 step 2) {
            sum += i
        }
        println("sumStep : ${sum} ")

        for ( i in 10 downTo 1) {
            sumDown += i
        }
        println("sumDown : $sumDown")

        for ( i in 1 until 100) {
            sumUntil += i
        }
        println("sumUntil(1~99) : $sumUntil")

        var index = 0
        while (index < 10){
            println("current index : ${index}")
            index++
        }

        for((index, name) in students.withIndex()) {
            println("${index + 1}번째 학생 : ${name}")
        }
    }

    // 7. Nullable / NonNull

    fun nullCheck() {

        var name : String = "sspark"

        var nullName : String? = null

        var nameInUpperCase = name.uppercase()

        var nullNameInUpperCase = nullName?.uppercase()

        // ?:

        val lastName : String? = null

        val fullName = name + " " + (lastName?: "No Last Name")

        println(fullName)

    }

    fun ignoreNulls(str : String) {
        val mNotNull : String = str!!
        val upper = mNotNull.uppercase()

        val email : String? = "sspark@naver.com"
        email?.let {
            println("my email is $email")
        }
    }

}