package com.example.firstkotlinapp

fun main(){

    // 3. String Template
    // ${}를 사용해서 변수 출력
    val name = "kim"
    var lastname = "hong"
    println("my name is ${name + lastname} I'm 25")

    println("is this true? ${1==0}")  // false

    println("this is 2\$a") // 만약 $표시를 사용하고 싶다면 $앞에 \를 붙혀주면 문자가 된다.

    // 한 줄 주석
    /* 여러줄 주석 입니다.*/

//    Ctrl + / 선택한 여러줄 동시 주석
//    println("my name is ${name + lastname} I'm 25")
//    println("my name is ${name + lastname} I'm 25")
//    println("my name is ${name + lastname} I'm 25")

}

// 1. 함수
// 리턴형식이 없다면 상략해도 무관하다!

fun helloWorld() : Unit{ // Unit = void 리턴형식이 없을때 사용
    println("Hello World!")
}

// 리턴타입이 있는 경우
// java와 다른점은 변수 이름을 먼저 써주고 타입을 뒤에 써준다.
// 리턴이 존재한다면 생략하면 안된다.

fun add(a : Int, b : Int) : Int {
    return a + b
}

// 2. val VS var
// val = value / var = variable

fun h1(){
    val a: Int = 10 // 변하지 않는 값, 상수
    var b : Int = 9 // 변할 수 있는 값

    var e : String // var는 바로 할당해주지 않을 때는 타입을 선언해주어야 한다.

    b = 100

    val c = 100 // Int라고 적지 않아도 100이 들어가면 Int인줄 알기 때문에 타입을 써주지 않아도 상관없다.
                // 단, val인지 var인지는 구분해서 써줘야 한다.
    var d = 100

    var name = "kim"
}