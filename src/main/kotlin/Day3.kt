import kotlin.math.absoluteValue

object Day3 {

    fun solution1(): Int{
        val bigString = getLines("/day3/input.txt").joinToString()
        return applyMultipliers(bigString)
    }

    fun solution2(): Int{
        val bigString = getLines("/day3/input.txt").joinToString()
        val filterString = bigString.split("do()").joinToString { it.split("don't()")[0] }
        return applyMultipliers(filterString)
    }

    private fun applyMultipliers(bigString : String) : Int{
        val splits = bigString.split("mul(")

        val multiplyList = splits.mapNotNull something@{
            val numbers = it.split(')')[0].split(',')

            if(numbers.size != 2) return@something null
            val realNumbers = numbers.mapNotNull { num -> num.toIntOrNull() }
            if(realNumbers.size != 2) return@something null
            realNumbers[0] * realNumbers[1]
        }

        return multiplyList.sum()
    }
}