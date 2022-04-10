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

open class Human(val name : String = "Anonymous"){ // constructor을 생략해주어도 무방하다.

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

    open fun signASong(){
        println("lalal")
    }
}
fun main(){
    val korean = Korean()
    korean.signASong()
}

// 상속!!!!
/*
    java에서는 extends를 사용했다.
    Kotlin에서는 extends대신에 : 를 사용한다.
    Kotlin의 클래스는 기본적으로 fireClass? 이다.
    그래서 아무리 같은 file내에 있더라도 접근하지 못한다.
    class앞에 open을 해주어야 한다.
 */
class Korean : Human(){ // 상속은 java와 같이 하나만 가능하다.
    // java라면 가능했지만 override가 되지않는 이유는 아까 open해줬던 이유와 같다.
    // 마찬가지로 signASong에 open을 해준다.
    override fun signASong(){
        super.signASong()
        println("라라라!")
        // 이때 name을 사용할 수 있는 이유는 Human을 상속을 할때 Human은 constructor에서 name을 받아온다.
        // 그런데 디폴트 값을 정해줌으로써 생성자의 parameter가 없는 것까지 만들어줬다.
        // 그래서 현재 Anonymous를 name으로 받아온것이다.
        println("my name is ${name}")

    }
}