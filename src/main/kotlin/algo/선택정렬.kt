package algo

fun main() {
    val arr = longArrayOf(34134, 33, 44, 55, 999, 2, 3, 723, 5, 9, 11, 333, 4, 3457, 22)

    selectionSort(arr)
    println(arr.contentToString())
}

fun selectionSort(data: LongArray) {
    for (stand in data.indices) {   //기준점을 선택
        var lowest = stand      //최소값을 먼저 기준점으로 잡아두고
        for (index in stand+1 until data.size) {
            if (data[lowest] > data[index]) {   //먼저 잡은 기준점의 값이 비교할 값 보다 크면 최소값 인덱스 수정
                lowest = index
            }
        }
        val temp = data[lowest]
        data[lowest] = data[stand]
        data[stand] = temp

        //println(lowest)
    }
}