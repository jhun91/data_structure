package data

import java.util.*

fun main() {
    
    //가장 일반적인 큐
    val dataQueue: Queue<Any>

    //초기화시에는 링크드리스트로 한다.
    dataQueue = LinkedList()

    dataQueue.add("1")
    dataQueue.add("3")
    dataQueue.add("8")

    println("현재 큐의 Head 값 : ${dataQueue.element()}")    //큐의 Head의 데이터를 확인만 한다. 꺼내지 않으므로 상태변화X
    println("큐의 사이즈 : ${dataQueue.size}") //큐의 Size

    //우선순위 큐
    val priorityQueue: PriorityQueue<TestClass> = PriorityQueue()

    val testClass1 = TestClass("test1", 1)
    val testClass2 = TestClass("test2", 2)
    val testClass3 = TestClass("test3", 3)

    priorityQueue.offer(testClass1)
    priorityQueue.offer(testClass3)
    priorityQueue.offer(testClass2)

    println("우선순위 큐의 가장 높은 우선순위 : ${priorityQueue.element().name}")
}

/**
 * 우선순위 큐를 사용할땐 Comparable 인터페이스를 상속받아 compareTo를 구현해야 한다.
 */
class TestClass(
    val name: String,
    private val priority: Int
) : Comparable<TestClass> {

    /*
        1 과 -1 이면 내림차순,  -1과 1이면 오름차순
     */
    override fun compareTo(other: TestClass): Int {
        return if(this.priority <= other.priority) {
            1
        } else {
            -1
        }
    }

}