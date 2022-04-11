package com.example.firstkotlinapp

/*
    Object
    class와 object와 다른점은 바로 싱글톤 패턴이다.
    현재 CarFactory라는 객체는 모든 앱을 실행할 때 딱 한번 만들어지것이다.
 */

// Singleton Pattern
object CarFactory{
    val cars = mutableListOf<Car>()

    fun makeCar(horsePower: Int) : Car {
        var car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main(){
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.toString())
}