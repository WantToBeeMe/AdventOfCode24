import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val solution : Any
    val executionTime = measureTimeMillis {
        solution = Day6.solution1()
    }
    println("\u001B[33m your solution is: $solution")
    println("\u001B[33m and it took: $executionTime ms")
}

fun getLines(path: String) : List<String>{
    return object {}.javaClass.getResourceAsStream(path)
        ?.bufferedReader()?.lineSequence()!!.toList()
}