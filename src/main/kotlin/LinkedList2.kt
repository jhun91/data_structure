fun main() {
    //val linkedList1 = NodeMgmt(0)

    //for (i in 1 until 10) {
     //   linkedList1.add(i)
    //}
    //linkedList1.desc()

    val linkedList2 = NodeMgmt02(0)
//    linkedList2.desc()
//
//    println(linkedList2.head)
//
//    linkedList2.delete(0)   //해당 객체를 삭제
//    println(linkedList2.head)

    for (data in 1 until 10) {
        linkedList2.add(data)
    }

    //linkedList2.desc()
    linkedList2.delete(4)
    linkedList2.desc()

    linkedList2.delete(9)
    linkedList2.desc()
}

//노드 객체 생성
class Node02(
    val data: Any,
    var next: Node02? = null
)


class NodeMgmt02(
    private val data: Any,
    private var head: Node02? = Node02(data)
) {

    fun add(data: Any) {
        if (head == null) {
            head = Node02(data)
        } else {
            var node = head
            while (node?.next != null) {
                node = node.next
            }
            node?.next = Node02(data)
        }
    }

    fun desc() {
        var node = head

        while (node != null) {
            println(node.data)
            node = node.next
        }
    }

    fun delete(data: Any) {
        if (head == null) { //헤드가 아예 없을 경우
            println("해당 값을 가진 노드가 없습니다.")
            return
        }

        if (head!!.data == data) {
            head = head!!.next  //헤드에 헤드의 다음 데이터를 연결시켜준다 (코틀린은 객체를 삭제할 필요가 없다 - JVM이 가비지컬렉팅 하기 때문)
        } else {
            var node = head
            while (node?.next != null) {
                if (node.next!!.data == data) {
                    node.next = node.next!!.next  //노드의 주소값을 삭제할 노드의 다음 주소값으로 변경한다.
                } else {
                    node = node.next
                }
            }
        }
    }
}