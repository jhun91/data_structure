fun main() {

    val head = Node(1)
    NodeMgmt(head)
}

class Node(
    var value: Long,
    var left: Node? = null,
    var right: Node? = null
)

class NodeMgmt(
    var _head: Node
) {
    var head: Node? = null
    lateinit var currentNode: Node

    init {
        head = _head
    }

    fun insert(value: Long?) {
        currentNode = head!!

        while (true) {

        }
    }
}