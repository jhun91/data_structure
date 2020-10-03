package data

fun main() {

    println(sumAll(100))
}

//1부터 n까지의 합 구하기
fun sumAll(n: Int): Int {
    /**
     * 같은 방법이지만 for문은 O(n)     아래는 O(1)
     */
//    var total: Int = 0
//
//    for (num in 1 until n+1) {
//        total += num
//    }
//    return total

    return n * (n + 1) / 2
}