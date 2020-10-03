package data

import java.util.*

fun main() {
    //재귀호출 함수 실습
    //data.recursive(4)

    val stack: Stack<Any> = Stack()
    stack.push(1)
    stack.push(3)
    stack.push(7)
    stack.push(9)

    println("스택의 첫번째 데이터 : ${stack.firstElement()}")
    println("스택의 마지막 데이터 : ${stack.lastElement()}")

    println("데이터 꺼냄 : ${stack.pop()}")
    println("스택의 마지막 데이터 : ${stack.lastElement()}")

    val stackList = ArrayList<Int>()

    push(stackList, 1)
    push(stackList, 7)
    push(stackList, 11)
    push(stackList, 9)

    pop(stackList)
    println(stackList)

    pop(stackList)
    println(stackList)

    pop(stackList)
    println(stackList)

    pop(stackList)

    pop(stackList)
}

fun recursive(data: Int) {
    if(data < 0) {
        println("ended")
    } else {
        println(data)
        recursive(data - 1)
        println("returned $data")
    }
}

fun push(stackList: ArrayList<Int>, data: Int) {
    stackList.add(data)
}

fun pop(stackList: ArrayList<Int>) {
    if(stackList.size <= 0) {
        println("Stack is Empty!!!")
        return
    } else {
        stackList.remove(stackList[stackList.size-1])
    }
}