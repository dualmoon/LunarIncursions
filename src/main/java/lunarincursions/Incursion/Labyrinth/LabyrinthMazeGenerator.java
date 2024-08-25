package lunarincursions.Incursion.Labyrinth;

import java.util.*;

public class LabyrinthMazeGenerator {

    private final int width;
    private final int height;
    private final int[][] maze;
    private final int[] DX = {1, -1, 0, 0};
    private final int[] DY = {0, 0, 1, -1};

    public LabyrinthMazeGenerator(int width, int height, boolean startAtCenter) {
        this.width = width;
        this.height = height;
        this.maze = new int[height][width];
        generateMaze(startAtCenter);
    }

    private void generateMaze(boolean startAtCenter) {
        // Initialize the grid with walls (1) everywhere
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                maze[x][y] = 1;
            }
        }

        // Determine starting position
        int startX, startY;
        if (startAtCenter) {
            startX = width / 2;
            startY = height / 2;
        } else {
            startX = 1;
            startY = 1;
        }
        maze[startY][startX] = 0; // Start carving path from this point

        // Use a stack to implement breadth-first recursive backtracking
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] { startX, startY });

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            List<int[]> neighbors = getUnvisitedNeighbors(cell[0], cell[1]);

            if (!neighbors.isEmpty()) {
                stack.push(cell); // Backtrack to current cell if neighbors exist

                int[] next = neighbors.get(new Random().nextInt(neighbors.size()));
                // Remove the wall between current cell and chosen neighbor
                maze[next[1]][next[0]] = 0;
                maze[(cell[1] + next[1]) / 2][(cell[0] + next[0]) / 2] = 0;
                stack.push(next); // Add the chosen neighbor to the stack
            }
        }
    }

    private List<int[]> getUnvisitedNeighbors(int x, int y) {
        List<int[]> neighbors = new ArrayList<>();

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i] * 2;
            int ny = y + DY[i] * 2;
            if (isInBounds(nx, ny) && maze[ny][nx] == 1) {
                neighbors.add(new int[] { nx, ny });
            }
        }

        return neighbors;
    }

    private boolean isInBounds(int x, int y) {
        return x > 0 && x < width - 1 && y > 0 && y < height - 1;
    }

    public void printMaze() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                System.out.print(maze[x][y] == 0 ? "🟫" : "✖️");
            }
            System.out.println();
        }
    }

    public int getTile(int x, int y) {
        return maze[x][y];
    }

    // this is for testing 🥴
    public static void main(String[] args) {
        LabyrinthMazeGenerator maze = new LabyrinthMazeGenerator(20, 20, true); // 20x20 maze starting at center
        maze.printMaze();
    }
}