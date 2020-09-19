fun main() {
    val linkedList1 = NodeMgmt(0)

    for (i in 1 until 10) {
        linkedList1.add(i)
    }

    linkedList1.desc()
}

//노드 객체 생성
class Node02(
    val data: Any,
    var next: Node02? = null
)


class NodeMgmt(
    val data: Any,
    var head: Node02? = Node02(data)
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
}