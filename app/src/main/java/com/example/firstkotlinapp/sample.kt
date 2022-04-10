package com.example.firstkotlinapp

fun main(){
    checkNum(1)
    forAndWhile()
    nullcheck()
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
    arrayList[0] = 20

    //arrayList = arrayListOf() // but 새로운 객체를 생성해서 할당하는 경우 오류발생!
}

// 6. For / While
fun forAndWhile(){
    val student = arrayListOf("kim", "Lee", "jung", "Park")

    for(name in student){ // in이라는 연산자를 이용해서 반복조건문을 사용한다.
        println("${name}")
    }

    var sum : Int = 0
    for( i in 1..10){
        sum += i
    }
    println(sum)
/*
    for( i in 1..10 step 2){ // 2칸씩 가라 -> 1,3,5,7,9
        sum += i
    }

    for( i in 10 downTo 1){ // 10부터 차례대로 10,9,8,7,6,...,1
        sum += i
    }

    for( i in 1 until 100){ // 1..100과 다른점은 100이 포함되지 않는다. 1~99
        sum += i
    }
*/
    var index = 0
    while(index < 10){
        println("current index : ${index}")
        index ++ // 0~9까지 출력이 된다.
    }

    for((index,name) in student.withIndex()){ // index와 name을 함께 사용할 수 있다.
        println("${index+1}번째 학생 : ${name}")
    }
}

// 7. Nullable / NonNull
fun nullcheck(){
    /*
     NPE : NULL pointer Exception
     java에서는 compail시점에서 잡을 수 없고 runtime에서만 잡히기 때문에 play를 해봐야지만
     알 수 있다.
     BUT! Kotlin에서는 ?를 사용해서 compail시점에서 다 잡아줄 수 있다!
    */
    var name = "kim" // 기본적으로 NonNull타입
    var nullName : String? = null // ?를 붙혀주게되면 Nullable타입이 된다.

    var nameInUpperCase = name.toUpperCase() // name같은 경우
    var nullNameInUpperCase = nullName?.toUpperCase()

    // ?:(엘비스 연산자)

    // 디폴트 값을 주고싶을때
    val lastName : String? = null
    val fullName = name + " " + (lastName?: "No lastName") // lastName이 Null일 경우
    // 만약 lastName이 있는지? Null이 아닌지? null이 아니라면 lastName을 출력
    // lastName이 없으면 No lastName을 출력을 한다
    println(fullName)

}
// !! - compailer한테 이것은 Null이 아니라고 말하는 것
fun ignoreNulls(str : String?){
    // 인자로 str을 받는데 이것이 null타입일수도 있다.
    // !!을 사용해서 str에는 절대 null이 들어올 리가 없다, 하는 경우 !!를 사용하게되면
    // compailer한테 이것은 절대 null일리가 없으니까 그냥 null이 아니라고 생각하라고 알려준다.
    val mNotNull : String = str!!
    val upper = mNotNull.toUpperCase()
    // But!! 이것을 사용하는 것을 지양해야 하는 이유는 정말 확실하지 않는 이상 만약 Null이 들어가게되면
    // Null Pointer Exception을 일으키기 때문에 확실하게 null이 아니지 않는 이상 사용하는것을 지양해야 한다.

    // email이 null이 아니면 let을 실행해라!
    val email : String? = "asdfv@naver.com"
    // let함수 - 자신의 Receiver객체를 람다식 내부로 옮겨서 실행하는 구문이다.
    email?.let{ // 여기서는 email을 람다식 내부로 옮겨준다.
        println("my email is ${email}")
    }
}