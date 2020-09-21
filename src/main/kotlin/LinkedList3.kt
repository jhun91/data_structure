fun main() {

    val doubleLinkedList = NodeMgmt03(0)

    for (i in 1 until 10) {
        doubleLinkedList.insert(i)
    }

    //doubleLinkedList.desc()

    val node3 = doubleLinkedList.searchFromHead(3)
    //println(node3?.data)

    val node33 = doubleLinkedList.searchFromTail(3)
    //println(node33?.data)

    doubleLinkedList.insertBefore(1.5, 2)
    doubleLinkedList.insertAfter(3.5, 3)

    doubleLinkedList.desc()
}

class Node03(
    val data: Any?,
    var prev: Node03? = null,
    var next: Node03? = null
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

            val new = Node03(data) //새로운 노드 데이터
            node?.next = new
            new.prev = node

            tail = new

        }
    }

    fun desc() {
        var node = head
        while (node != null) {
            println(node.data)
            node = node.next
        }
    }

    fun searchFromHead(data: Any): Node03? {
        if (head == null) {
            return null
        }

        var node = head
        while (node != null) {
            if (node.data == data) {
                return node
            } else {
                node = node.next
            }
        }
        return null
    }

    fun searchFromTail(data: Any): Node03? {
        if (head == null) {
            return null
        }

        var node = tail
        while (node != null) {
            if (node.data == data) {
                return node
            } else {
                node = node.prev
            }
        }
        return null
    }

    fun insertBefore(data: Any, beforeData: Any): Boolean {
        if (head == null) {
            head = Node03(data)
            return true
        } else {
            var node = tail
            while (node?.data != beforeData) {
                node = node?.prev

                if (node == null) {
                    return false
                }
            }

            val new = Node03(data)
            val beforeNew = node.prev //원래 노드의 앞 노드
            beforeNew?.next = new
            new.prev = beforeNew
            new.next = node
            node.prev = new
            return true
        }
    }

    fun insertAfter(data: Any, afterData: Any): Boolean {
        if (head == null) {
            head = Node03(data)
            return true
        } else {
            var node = head
            while (node?.data != afterData) {
                node = node?.next
                if(node == null) {
                    return false
                }
            }

            val new = Node03(data)
            val afterNew = node.next //원래 노드의 뒤 노드
            afterNew?.prev = new
            new.prev = node
            new.next = afterNew
            node.next = new
            return true
        }
    }
}