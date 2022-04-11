package com.example.firstkotlinapp

/*
Data Class
말그대로 데이터를 담는 그릇이 되는 class이다.
pojo 클래스 - 어떤 모델이 되는 클래스, 딱히 그 안에서 메소드가 작동하는 것이 아니라 메소드가 있어서
특정 행동을 하는 클래스라기 보다는 비어있는, 틀 역할을 하는 클래스를 pojo클래스라고 한다.

여기에는 변수를 선언해줘서 각각은 class의 property처럼 사용을 해 줄수 있고, constructor뿐만 아니라
toString도 자동으로 compailer가 만들어주고 hashCode(), equals(), copy() 메소드를 dataClass를 이용하면
자동으로 만들어 준다.
codebody도 없이 pojo클래스가 만들어 지는 것이다.
 */
data class Ticket(val compamyName : String, val name : String, var date : String, val seatNumber : Int)

class TicketNormal(val compamyName : String, val name : String, var date : String, val seatNumber : Int)

fun main() {
    val ticketA = Ticket("koreanAir", "kim", "2022/03/14", 12)

    val ticketB = TicketNormal("koreanAir", "kim", "2022/03/14", 12)

    println(ticketA) // 객체의 내용이 보인다
    println(ticketB) // 메모리 주소값이 나온다.
}

/*
    **코틀린의 특징 중 하나!
        한 파일 안에서 여러개의 클래스를 만들 수 있다.
        연관된 dataClass는 하나의 파일에 다 모아서 만들 수 있다 -> 관리하기 편하다
 */