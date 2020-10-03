package data

fun main() {

    val head = Node(1)

    val BST = NodeMgmt(head)
    BST.insert(2)
    BST.insert(3)
    BST.insert(0)
    BST.insert(4)
    BST.insert(8)

    println(BST.search(-1))

}

class Node(
    var value: Long,
    var left: Node? = null,
    var right: Node? = null
)

class NodeMgmt(
    var head: Node
) {

    fun insert(value: Long) {
        var currentNode = head

        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left != null) {
                    currentNode = currentNode.left!!
                } else {
                    currentNode.left = Node(value)
                    break
                }
            } else {
                if (currentNode.right != null) {
                    currentNode = currentNode.right!!
                } else {
                    currentNode.right = Node(value)
                    break
                }
            }
        }
    }

    fun search(value: Long): Boolean {
        var currentNode: Node? = head

        while (currentNode != null) {
            if (currentNode.value == value) {
                return true
            } else if (value < currentNode.value) {
                currentNode = currentNode.left
            } else {
                currentNode = currentNode.right
            }
        }
        return false
    }

    fun delete(value: Long): Boolean {
        var searched = false  //값을 찾았는지 확인하는 변수
        var currentNode: Node? = head
        var parent: Node? = head
        var changeNode: Node?
        var changeNodeParent: Node?

        //삭제할 노드 탐색
        while (currentNode != null) {
            if (currentNode.value == value) {
                searched = true
                break
            } else if (value < currentNode.value) { //값이 작으면
                parent = currentNode
                currentNode = currentNode.left
            } else {
                parent = currentNode
                currentNode = currentNode.right
            }
        }

        //탐색 결과 없을 경우 중지
        if (!searched) {
            return false
        }


        // case 1 삭제할 노드가 Leaf data.Node 일 경우
        if (currentNode?.left == null && currentNode?.right == null) { //왼쪽, 오른쪽 모두 없음
            if (value < parent?.value!!) {  //parent node와 비교해서 현재 값이 작으면 parent의 left를 null처리
                parent.left = null
            } else {                        //현재값이 parent보다 크면 right를 null 처리
                parent.right = null
            }
        }
        // case 2 삭제할 노드가 1개의 child node를 가지고 있을 경우
        else if (currentNode.left != null && currentNode.right == null) { //왼쪽에 1개의 node를 가지고 있을 때
            if (value < parent?.value!!) {      //parent와 비교해서 지우려는 노드의 값이 작을때. parent의 left에 현재 노드의 left를 연결한다.
                parent.left = currentNode.left
            } else {                            //지우려는 노드의 값이 크면 parent의 right에 현재 노드의 right를 연결한다.
                parent.right = currentNode.right
            }
        } else if (currentNode.left == null && currentNode.right != null) { //오른쪽에 1개의 node를 가지고 있을 때
            if (value < parent?.value!!) {      //parent와 비교해서 지우려는 노드의 값이 작을때. parent의 left에 현재 노드의 left를 연결한다.
                parent.left = currentNode.left
            } else {                            //지우려는 노드의 값이 크면 parent의 right에 현재 노드의 right를 연결한다.
                parent.right = currentNode.right
            }
        }
        // case 3 삭제할 노드가 2개의 child node를 가지고 있을 경우
        else if (currentNode.left != null && currentNode.right != null) {
            if (value < parent?.value!!) {
                changeNode = currentNode.right
                changeNodeParent = currentNode.right

                while (changeNode?.left != null) {
                    changeNodeParent = changeNode
                    changeNode = changeNode.left
                }

                if (changeNode?.right != null) {
                    changeNodeParent?.left = changeNode.right
                } else {
                    changeNodeParent?.left = null
                }

                parent.left = changeNode
                changeNode?.right = currentNode.right
                changeNode?.left = currentNode.left
            } else {
                changeNode = currentNode.right
                changeNodeParent = currentNode.right

                while (changeNode?.left != null) {
                    changeNodeParent = changeNode
                    changeNode = changeNode.left
                }

                if (changeNode?.right != null) {
                    changeNodeParent?.left = changeNode.right
                } else {
                    changeNodeParent?.left = null
                }

                parent.left = changeNode
                changeNode?.right = currentNode.right
                changeNode?.left = currentNode.left
            }
        }


        return true
    }
}
