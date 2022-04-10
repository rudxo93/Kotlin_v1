package com.example.firstkotlinapp

// java와 다른점
// 꼭 파일이름과 class이름이 일치하지 않아도 된다.
// 여러 class도 한 file안에 넣을 수 있다.

/*
class Human{
    val name = "kim"
    fun eatingbeef(){
        println("this is so big~~!!!")
    }
}
fun main(){
    val human = Human()
    human.eatingbeef()
    println("this human's name is ${human.name}")
}
 */
// 만약 name을 객체를 생성할때 꼭 정의해주고 싶으면 어떻게 하면될까?
// constructor 생성자를 이용한다.

class Human(val name : String = "Anonymous"){ // constructor을 생략해주어도 무방하다.

    init { // 주생성자의 일부, Human class가 생성됨과 동시에 같이 코드블럭이 돈다.
        println("New Human has been born!!")
    }
    // 주생성자 뿐만 아니라 부생성자도 여러개 만들어 줄 수 있다.
    /*
        java의 경우
        class Person{
            public person(String name){
            }

            public Person(String name, int age) {
                this(name);
            }
        }
     */
    // 위와 똑같이 Kotlin에서 구현하려면 constructor라는 부생성자를 이용해주면 된다.
    // : this 부생성자는 주생성자의 위임을 받아야 한다.
    // 만약 주생성자가 없으면 위임해 줄 필요가 없다.
    constructor(name : String, age : Int) : this(name) {
        println("my name is ${name}, ${age}years old!")
    }

    //디폴트 값을 주게되면 constructor가 val name : String = "Anonymous" 생성자 뿐만 아니라
    //이게 없는 빈 생성자까지 만든다.
    fun eatingbeef(){
        println("this is so big~~!!!")
    }
}
fun main(){
//    val human = Human("Park")
//    val stranger = Human() // 현재 디폴트값을 줬기 때문에 이렇게 해도 생성자가 생성된다.
//    human.eatingbeef()
    /*
        주의깊게 봐야할 것!
        mother객체를 생성했는데 위에서 init먼저 생성이된다.
        왜냐하면 init은 주생성자의 일부이다.
        constructor가 아무리 많이 있어도 init블록 먼저 실행이 되고 constructor블록이 실행이 된다.
     */
    val mother = Human("Park", 45)

//    println("this human's name is ${stranger.name}")
}
