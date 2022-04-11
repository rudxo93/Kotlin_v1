package com.example.firstkotlinapp

/*
    Companion Object
     - Companion Object가 하는 것은 java의 static대신에 사용되는 것으로 정적인 메소드나 정적인 변수를
     선언할때 Companion Object를 사용한다.
*/

class Book private constructor (val id : Int, val name : String){

    // companion object가 하는 일은 private property나 method를 읽어올 수 있게끔 하는것이다.
    // 즉 java의 static역할을 한다.
    //companion object는 property도 써줄 수 있고 이름, 상속이 가능하다.

    companion object BookFactory : IdProvider {

        override fun getId(): Int {
            return 444
        }

        val myBook = "new Book"

        fun create() = Book(getId(), myBook)
    }

}

interface IdProvider{
    fun getId() : Int
}

fun main(){
    val book = Book.create() // 사이에 있는 Companion은 생략 가능하다.

    val bookId = Book.BookFactory.getId()

    println("${book.id} ${book.name}")
}