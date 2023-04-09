package leet_code

/**
 * Given an m x n 2D binary grid which
 * represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed
 * by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"]
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * */
fun main() {
    println(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0'),
            )
        )
    )
}
fun numIslands(grid: Array<CharArray>): Int {
    var counter = 0
    for (y in grid.indices) {
        for (x in grid[y].indices) {
            if (grid.isIsland(x, y)) {
                counter++
                destroyIsland(grid, x, y)
            }
        }
    }

    return counter
}

private fun destroyIsland(arr: Array<CharArray>, x: Int, y: Int) {
    arr[y][x] = '0'

    if (arr.isIsland(x + 1, y)) destroyIsland(arr, x + 1, y)
    if (arr.isIsland(x - 1, y)) destroyIsland(arr, x - 1, y)
    if (arr.isIsland(x, y + 1)) destroyIsland(arr, x, y + 1)
    if (arr.isIsland(x, y - 1)) destroyIsland(arr, x, y - 1)
}


private fun Array<CharArray>.isIsland(x: Int, y: Int): Boolean {
    val column = this.getOrNull(y) ?: return false
    val valueInRow = column.getOrNull(x) ?: return false
    return valueInRow == '1'
}

