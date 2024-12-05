import java.util.Dictionary
import kotlin.math.absoluteValue

object Day1 {

    fun solution1(): Int{
        val lefties = mutableListOf<Int>()
        val righties = mutableListOf<Int>()
        getLines("/day1/input.txt").forEach { line ->
            val split = line.split("   ")
            lefties.add(split[0].toInt())
            righties.add(split[1].toInt())
        }

        lefties.sort()
        righties.sort()
        val combs = lefties.zip(righties)

        return combs.sumOf { comb -> (comb.first - comb.second).absoluteValue }
    }


    fun solution2(): Int{
        val lefties = mutableListOf<Int>()
        val righties = mutableListOf<Int>()
        getLines("/day1/input.txt").forEach { line ->
            val split = line.split("   ")
            lefties.add(split[0].toInt())
            righties.add(split[1].toInt())
        }

        val toAmountMap : (List<Int>)-> MutableMap<Int, Int>  = { list ->
            val dict = mutableMapOf<Int,Int>()
            list.forEach { item ->
                if (!dict.containsKey(item))
                    dict[item] = 0
                dict[item] = dict[item]!! + 1;
            }
            dict
        }

        val leftiesMap = toAmountMap(lefties)
        val rightMap = toAmountMap(righties)

        var returnValue = 0;
        leftiesMap.forEach {key, value ->
            returnValue += key * value * (rightMap[key] ?: 0)
        }

        return returnValue
    }
}