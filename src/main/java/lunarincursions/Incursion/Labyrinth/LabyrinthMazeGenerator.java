package lunarincursions.Incursion.Labyrinth;

import java.util.*;

public class LabyrinthMazeGenerator {

    private final int width;
    private final int height;
    private final int[][] maze;
    private final int[] DX = {1, -1, 0, 0};
    private final int[] DY = {0, 0, 1, -1};

    public LabyrinthMazeGenerator(int width, int height, boolean startAtCenter, int roomSize) {
        this.width = width;
        this.height = height;
        this.maze = new int[height][width];
        generateMaze(startAtCenter, roomSize);
    }

    private void generateMaze(boolean startAtCenter, int roomSize) {
        // Initialize the grid with walls (1) everywhere
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = 1;
            }
        }

        // Determine starting position
        int startX, startY;
        if (startAtCenter) {
            startX = (width % 2 == 1) ? width / 2 : (width / 2) - 1;
            startY = (height % 2 == 1) ? height / 2 : (height / 2) - 1;
        } else {
            startX = 1;
            startY = 1;
        }

        // Create starting room if roomSize > 1
        if (roomSize > 1) {
            createRoom(startX, startY, roomSize);
        } else {
            maze[startY][startX] = 0; // Start carving path from this point
        }

        // Use a queue to implement breadth-first search (BFS)
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { startX, startY });

        while (!queue.isEmpty()) {
            int[] cell = queue.removeFirst();
            List<int[]> neighbors = getUnvisitedNeighbors(cell[0], cell[1]);

            if (!neighbors.isEmpty()) {
                queue.addFirst(cell); // Backtrack to current cell if neighbors exist

                int[] next = neighbors.get(new Random().nextInt(neighbors.size()));
                // Remove the wall between current cell and chosen neighbor
                maze[next[1]][next[0]] = 0;
                maze[(cell[1] + next[1]) / 2][(cell[0] + next[0]) / 2] = 0;
                queue.addFirst(next); // Add the chosen neighbor to the queue
            }
        }
    }

    private void createRoom(int centerX, int centerY, int roomSize) {
        int halfSize = roomSize / 2;

        for (int y = centerY - halfSize; y <= centerY + halfSize; y++) {
            for (int x = centerX - halfSize; x <= centerX + halfSize; x++) {
                if (isInBounds(x, y)) {
                    maze[y][x] = 0; // Clear the room
                }
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
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(maze[i][j] == 0 ? "  " : "█");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LabyrinthMazeGenerator maze = new LabyrinthMazeGenerator(20, 20, true, 5); // 20x20 maze with a center-started room of size 5x5
        maze.printMaze();
    }
}