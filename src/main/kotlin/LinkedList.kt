var head: Node = Node(1)    // 헤드 노드 생성

fun main() {

    //헤드 노드 이후로 데이터를 연결한다.
    for (index in 2 until 10) {
        add(index)
    }

    var node = head
    while (node.next != null) {
        println(node.data)
        node = node.next!!
    }
    println(node.data)
}

//헤드 노드부터 시작해서 데이터와 주소정보를 세팅한다.
fun add(data: Any) {
    var node = head
    while (node.next != null) {
        node = node.next!!
    }
    node.next = Node(data)
}

//노드 클래스 생성
class Node(
    val data: Any,
    var next: Node? = null  //다음 노드의 주소값이 들어가야 한다.
)