package com.example.firstkotlinapp

fun main(){
    checkNum(1)
}

// 4. 조건식
fun maxBy(a : Int, b : Int) : Int {
    if( a > b ){
        return a
    } else {
        return b
    }
}
fun maxBy2( a : Int, b : Int) = if(a>b) a else b // Expression
// 코틀린에서는 삼항연산자가 없기 때문에 위와 같이 표현해준다.
// return (a>b) ? a : b

// 4 - 1. when
fun checkNum(score : Int) {
    when(score) {  // Statement
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 ro 3") // 복수로 사용해도 된다.
        //else -> println("I don't know") // 모든게 다 아닐경우 else로 빠진다. else를 사용안해도 무방하다.
    }

    var b = when(score){ // 이렇게 사용할 경우에는 else를 사용해야 한다. // Expression
        1 -> 1
        2 -> 2
        else -> 3
    }
    println("b : ${b}")

    when(score){
        in 90 .. 100 -> println("You are genius")
        in 10 .. 80 -> println("not bad")
        else -> println("okey")
    }
}
/*
 Expression VS Statement
 어떠한 식, 코드로 값을 만들면 -> Expression
 어떠한 행위로 값을 만드는 것이 아닌 실행을 하도록 만드는 문장은 -> Statement
 Kotlin의 모든 함수는 Expression이다.
 그리고 Statement라고 했던 함수들도 사실은 생략된 Unit를 return하고 있다.
 그렇기 때문에 모든 함수는 Kotlin에서는 Expression으로 사용된다.

 반대로 java경우 void라는 return값이 없는 함수가 존재한다.
 이러한 경우에는 Statement로 사용이 된다.

 Kotlin의 모든 함수는 Expression이며 아무 return값이 없더라도 Unit을 반환을 하고
 if문이 java에서 Statement로 밖에 사용할 수 없었다면은 Kotlin에서는 Expression으로도 사용할 수 있고
 Statement로도 사용할 수 있다.(when도 마찬가지이다.)
 Expression -> 어떠한 행위로 값을 반환한다.
 Statement -> ~해라! / 명령을 지시하는 문장같은 경우
 */