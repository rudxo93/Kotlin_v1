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

/*
 5. Array and List
    Array - 기본적으로 정해져있는 size가 있다. (메모리가 할당이 되어서 나옴)
            처음에 크기를 지정해주어야 한다.
    List - 1. List - 수정이 불가능하다.
           2. MutableList - 수정이 가능하다.
 */

fun array(){
    val array = arrayOf(1,2,3)// array초기화
    val list = listOf(1,2,3) // list 초기화

    val array2 = arrayOf(1,"d",3.4f)
    val list2 = listOf(1,"r",114F)
    // 기본적으로 array는 MutableList이다.
    // 즉 값을 변경하는 것이 가능하다.(size를 변경하지 않는다면)
    array[0] = 2
    /*
     list는 값을 변경하지 못하는 읽기전용이다.
     list[0] = 2 -> 리스트의 값을 변경하는 것은 불가능!
     list의 경우 array와 다르게 interface이다.
     list.get해서 가져올 수 있고 가져온 값을 result에 넣어줄 수 있지만
     직접적으로 바꾸는 것은 불가능하다.
     */
    var result = list.get(0)

    // MutableList의 가장 대표적인 것이 arrayList이다.
    // arrayList의 참조값(주소값)자체는 바뀌지 않기 때문에 val을 사용해도 된다.
    val arrayList = arrayListOf<Int>()
    arrayList.add(10) // arrayList에 10이 추가되었다.
    arrayList.add(20)

    //arrayList = arrayListOf() // but 새로운 객체를 생성해서 할당하는 경우 오류발생!

}