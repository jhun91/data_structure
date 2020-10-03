package algo

fun main() {
    var arr = longArrayOf(22,33,44,55,11,2,3,4,5,7,9,999,333,22,7723,345712341234)

    bubbleSort(arr)
    println(arr.contentToString())
}

/**
 * 버블정렬
 */
fun bubbleSort(data: LongArray) {
    for (index in data.indices) {
        var swap = false
        for (index2 in 0 until data.size - index) { //data.size - index - 1 과 같다. until이 size-1까지 인덱싱 진행함
            if (index2 + 1 == data.size) break // 마지막-1 인덱스에서 비교하면 index2+1이 ArrayIndexOutOfBoundsException 발생하므로 break 처리
            if (data[index2] > data[index2 + 1]) {
                val temp = data[index2] //데이터 옮길 임시 변수
                data[index2] = data[index2 + 1]
                data[index2 + 1] = temp
                swap = true
            }
        }

        //1번도 변경되지 않았다면 전체 for문 break
        if (swap == false) break
    }
}