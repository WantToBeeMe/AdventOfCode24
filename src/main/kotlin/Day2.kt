import kotlin.math.absoluteValue

object Day2 {

    // Before you read this code, I just want to mention that i set an extra challenge that I would not use any variables

    fun solution1(): Int{
        return getLines("/day2/input.txt").map { line ->
            line.split(" ").map { it.toInt() }
        }.map{numbers ->
            numbers.zip(numbers.drop(1)).map {it.first - it.second}
        }.map { zipped ->
            zipped.zip(zipped.drop(1)).map{ pair ->
                (pair.first * pair.second) > 0
            }.count{ !it } == 0
                    &&
           zipped.map { it.absoluteValue in 1..3 }.count{ !it } == 0
        }.count{ it }
    }

    fun solution2(): Int{
        return getLines("/day2/input.txt").map { line ->
            line.split(" ").map { it.toInt() }
        }.map { singleList ->
            singleList.mapIndexed { index, item ->
                singleList.subList(0, index) + singleList.subList(index+1,singleList.size)
            }
        }.map{groups ->
            groups.map{numbers ->
                numbers.zip(numbers.drop(1)).map {it.first - it.second}
            }.map { zipped ->
                zipped.zip(zipped.drop(1)).map{ pair ->
                    (pair.first * pair.second) > 0
                }.count{ !it } == 0
                        &&
                zipped.map { it.absoluteValue in 1..3 }.count{ !it } == 0
            }.count{ it } > 0
        }.count{ it }
    }
}