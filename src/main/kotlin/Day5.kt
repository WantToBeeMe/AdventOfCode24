import java.util.Vector
import kotlin.math.absoluteValue

object Day5 {

    fun solution1(): Int{
        val input = getLines("/day5/input.txt")
        // Rules is a list of pairs ()
        val rules = input.subList(0, input.indexOf("")).map { st -> st.split("|").map { it.toInt() } }
        // Prints is the list of numbers that need to be sorted
        val prints = input.drop(input.indexOf("")+1).map {st -> st.split(",").map { it.toInt() } }

        var returnValue = 0
        for (print in prints) {
            if (isPrintCorrect(rules, print))
                returnValue += print[print.size/2]
        }

        return returnValue
    }

    private fun isPrintCorrect(rules: List<List<Int>>, print: List<Int>) : Boolean {
        print.forEachIndexed { index, item ->
            rules.filter { rule -> rule[0] == item }.forEach { rule ->
                val secondIndex = print.indexOf(rule[1])
                if (index > secondIndex && secondIndex != -1)
                    return false
            }
        }
        return true
    }

    // Solution 2 works IN THEORY. But I am using bogosort, so it takes way to long lol
    // I have to rewrite reOrder one day
    fun solution2(): Int{
        val input = getLines("/day5/input.txt")
        // Rules is a list of pairs ()
        val rules = input.subList(0, input.indexOf("")).map { st -> st.split("|").map { it.toInt() } }
        // Prints is the list of numbers that need to be sorted
        val prints = input.drop(input.indexOf("")+1).map {st -> st.split(",").map { it.toInt() } }

        var returnValue = 0
        for (print in prints) {
            if (isPrintCorrect(rules, print)) continue
            val currentPrint = reOrder(rules, print)
            returnValue += currentPrint[currentPrint.size/2]
        }

        return returnValue
    }

    private fun reOrder(rules: List<List<Int>>, print: List<Int>) : List<Int>{
        var currentPrint = print
        while(!isPrintCorrect(rules,currentPrint) ){
            currentPrint = currentPrint.shuffled()
        }
        return currentPrint
    }
}
