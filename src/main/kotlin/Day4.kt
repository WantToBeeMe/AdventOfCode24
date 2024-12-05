import java.util.Vector
import kotlin.math.absoluteValue

object Day4 {

    fun solution1(): Int{
        val map = getLines("/day4/input.txt")
        val searchKey = "XMAS"
        return listOf(
            findKeys(map, searchKey, Pair(1,0)),
            findKeys(map, searchKey, Pair(1,1)),
            findKeys(map, searchKey, Pair(0,1)),

            findKeys(map, searchKey, Pair(-1,0)),
            findKeys(map, searchKey, Pair(-1,-1)),
            findKeys(map, searchKey, Pair(0,-1)),

            findKeys(map, searchKey, Pair(1,-1)),
            findKeys(map, searchKey, Pair(-1,1)),
        ).sum()
    }

    private fun findKeys(map: List<String>, key: String, direction: Pair<Int, Int>) : Int{
        var count = 0

        map.forEachIndexed{ rowIndex, row ->
            row.forEachIndexed charLoop@{ charIndex, char ->
                if(!key.startsWith(char)) return@charLoop
                var nextPos = Pair(rowIndex,charIndex)
                var charComp ="$char"
                while(key.startsWith(charComp) && key != charComp){
                    nextPos = Pair(nextPos.first + direction.first , nextPos.second + direction.second)
                    charComp += map.getOrNull(nextPos.first)?.getOrNull(nextPos.second) ?: '.'
                }
                if(key== charComp) count++
            }
        }

        return count
    }


    fun solution2(): Int{
        val map = getLines("/day4/input.txt")
        var count = 0

        map.forEachIndexed{ rowIndex, row ->
            row.forEachIndexed charLoop@{ charIndex, char ->
                if(char != 'A') return@charLoop

                val corners = listOf(
                    map.getOrNull(rowIndex-1)?.getOrNull(charIndex-1) ?: return@charLoop, // Top    Left
                    map.getOrNull(rowIndex+1)?.getOrNull(charIndex-1) ?: return@charLoop, // Top    Right
                    map.getOrNull(rowIndex+1)?.getOrNull(charIndex+1) ?: return@charLoop, // Bottom Right
                    map.getOrNull(rowIndex-1)?.getOrNull(charIndex+1) ?: return@charLoop  // Bottom Left
                )

                if (corners[0] == corners[2] || corners[1] == corners[3]) return@charLoop
                if (corners.all { it == 'M' || it == 'S' }) count++
            }
        }
        return count
    }

}