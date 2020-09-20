fun main() {

}

class Node03(
    val data: Any,
    val prev: Node03? = null,
    val next: Node03? = null
)

class NodeMgmt03(
    private val data: Any,
    private var head: Node03? = Node03(data),
    private var tail: Node03? = head
) {

    fun insert(data: Any) {
        if (head == null) {
            head = Node03(data)
            tail = head
        } else {
            var node = head

            while (node?.next != null) {
                node = node.next //노드의 끝 찾기
            }


        }
    }

}