package com.example.firstkotlinapp

/*
    1. Lamda
    람다식은 우리가 마치 value처럼 다룰 수 있는 익명함수이다.
    1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(a : Int) 여기서 람다를 이용하면 a : Int 파라미터대신
    fun을 넣어줄 수 있다.
    2) return 값으로 사용할 수가 있다.

    람다의 기본 정의
    var lamdaName : Type = {argumentList -> codeBody{
 */

fun main(){
    println(square(12))
    println(nameAge("kim", 12))
    val a = "kim said"
    val b = "Park said"

    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("ariana", 27))

    println(calculateGrade(4943))

    val lamda = {number : Double ->
        number == 4.4234
    }

    println(invokeLamda(lamda))
    println(invokeLamda({ it > 3.22 }))
    // 위와 같은 식이다.
    // 이것이 람다식의 특징이다. 만약 fun의 마지막 파라미터가 람다식일때는 이런식으로 표현이 가능하다.
    // 소괄호는 생략하고 중괄호를 써주면 된다.
    // 현재는 첫번째 파라미터이자 마지막 파라미터이다.
    invokeLamda { it > 3.2433 }

    // 3. 익명 내부 함수
}

//val square : (Int) -> (Int) = {number -> number * number}
val square : (Int) -> (Int) = {number -> number * number}
// 람다에서는 마지막에 있는 코드줄이 return값이다.
val nameAge = {name : String, age : Int ->
    "my name is ${name} I'm ${age}"
}

/*
    2. 확장함수
    class를 확장한다? -> 말그대로 있는 class를 이 클래스가 좋아서 몇개만 추가하고 싶다는 생각이 들때
    확장함수를 사용한다.
 */

val pizzaIsGreat : String.() -> String = {
    this + "Piizza is the best!"
}

fun extendString(name : String, age : Int) : String {
    // 여기서 this는 시작함수를 call하는 오브젝트를 가르키고, it은 하나만 들어가는 파라미터일 경우 it으로 생략가능!
    val introduceMyself : String.(Int) -> String = {"I am ${this} and ${it} years old"}
    return name.introduceMyself(age)
}

// 람다의 Return
// 람다는 마지막 표현식, 마지막 한줄이 return을 의미한다.

val calculateGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfact"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법
// invokeLamda라는 함수는 Boolean을 return하는데 그런데 어떤 람다식을 이용? 파라미터로 넣는 람다식을 사용하는데
// 그 람다의 5.2354를 넣어서 return이 되는 Boolean값을 invokeLamda의 return값으로 하겠다 라는 것이다.
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.2354)
}