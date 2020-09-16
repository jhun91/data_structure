import java.util.*

fun main() {
    val dataQueue: Queue<Any>

    //초기화시에는 링크드리스트로 한다.
    dataQueue = LinkedList()

    dataQueue.add("1")
    dataQueue.add("3")
    dataQueue.add("8")

    println(dataQueue.element())    //큐의 Head의 데이터를 확인만 한다. 꺼내지 않으므로 상태변화X
    println(dataQueue.size) //큐의 Size


}