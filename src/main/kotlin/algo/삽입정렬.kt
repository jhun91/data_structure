package algo

fun main() {
    val arr = longArrayOf(34134, 33, 44, 55, 999, 2, 3, 723, 5, 9, 11, 333, 4, 3457, 22)

    insertionSort(arr)
    println(arr.contentToString())
}

fun insertionSort(data: LongArray) {
    for (index in data.indices) {
        for (index2 in index downTo 0) {  //index 부터 0까지 1씩 감소하면서 반복한다. (0..index 처럼 index를 포함해서 감소한다)
            if (index2 - 1 < 0) break    //index2 - 1이 -1을 가리키면 OutOfBoundsException 발생하므로 제어
            if (data[index2] < data[index2 - 1]) {  //현재 데이터가 앞의 데이터보다 작으면
                val temp = data[index2]
                data[index2] = data[index2 - 1]
                data[index2 - 1] = temp
            } else {
                break
            }
        }
    }
}