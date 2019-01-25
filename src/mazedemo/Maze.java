/*
 * Midiel Rodriguez
 * Course: COP-337
 * Assignemnt: 8
 * 
 * This class will find a way out of a provided maze.
 *
 * It accepts a maze as argument and find a way out of the provided starting
 * point. If there is a way out, it return true and prints the way out pattern
 * If there is no way out it just returns false.
 *
 */
package mazedemo;

/**
 *
 * @author Midiel Rodriguez
 * @version 1.2 April 1, 2018
 */
public class Maze {
    private final char[][] MAZE;            // Original maze
    private char[][] tempMaze;              // Temporary maze
    private boolean[][] visited;            // To mark the visited cells
    private final int RIGHT_WALL;           // Position of right wall
    private final int BOTTOM_WALL;          // Position of bottom wall
    
    /**
     * Constructor to initialize the maze. It accepts a two dimensional
     * array of characters that represents the maze.
     * 
     * @param m an array of characters that represents the maze
     */
    public Maze(char[][] m) {
        // Clone the maze
        MAZE = m.clone();
        tempMaze = new char[m.length][m[0].length];
        visited = new boolean[tempMaze.length][tempMaze[0].length];
        RIGHT_WALL = m.length - 1;
        BOTTOM_WALL = m[0].length - 1;
    }
    
    /**
     * To escape the maze.
     * It accepts an x and y coordinate. It calls the move() function
     * to find a way out. Is there is a way out, it returns true or false
     * otherwise.
     * 
     * @param x the row position
     * @param y the column position
     * @return true there is a way out, false otherwise
     */
    public boolean escape(int x, int y) {
        for(int i = 0; i < MAZE.length; i++) {
            for(int j = 0; j < MAZE[0].length; j++) {
                tempMaze[i][j] = MAZE[i][j];        // Initialize the temp maze
                visited[i][j] = false;              // Resets the visited cells
            }
        }
        
        // Validate that the starting point is not out of bounds.
        if(x > RIGHT_WALL || x < 0 || y > BOTTOM_WALL || y < 0 ) {
            System.out.println("Invalid starting point, out of bounds.");
            System.out.println("Starting point must be inside the maze.");
            return false;
        }
        
        // Validate that the starting point is an empty cell.
        if(tempMaze[x][y] == '*') {
            System.out.println("Invalid starting point. Starting point must " +
                                "be an empty cell.");
            return false;
        }
        
        // Prints the way out and returns true if there is a way out the maze.
        if(move(x, y)) {
            print();                            // Prints the way out pattern
            return true;
        }
        return false;
    }
    
    /**
     * To move towards an exit.
     * It accepts an x and y coordinate. It returns true if it can move, or
     * false otherwise.
     * 
     * @param x the row position 
     * @param y the column position
     * @return true if it can move, false otherwise
     */
    public boolean move(int x, int y) {
        boolean moveUp;         // Temporary variable to move up
        boolean moveDown;       // Temporary variable to move down
        boolean moveLeft;       // Temporary variable to move left
        boolean moveRight;      // Temporary variable to move right

        // return false if it is wall or previourly visited
        if(tempMaze[x][y] == '*' || visited[x][y]) {
            return false;
        }
        
        // mark visited cells
        visited[x][y] = true;
        if(x > 0 && x < RIGHT_WALL && y > 0 && y < BOTTOM_WALL) {
            tempMaze[x][y] = '$';
        }
                
        // base case 1. Top exit
        if(x == 0 && tempMaze[x][y] == ' ') {
            tempMaze[x][y] = '^';
            return true;
        }
        
        // base case 2. Left exit
        if(y == 0 && tempMaze[x][y] == ' ') {
            tempMaze[x][y] = '<';
            return true;
        }
        
        // base case 3. Bottom exit
        if(x == BOTTOM_WALL && tempMaze[x][y] == ' ') {
            tempMaze[x][y] = 'v';
            return true;
        }
        
        // base case 4. Right exit
        if(y == RIGHT_WALL && tempMaze[x][y] == ' ') {
            tempMaze[x][y] = '>';
            return true;
        }
        
        // move up recursively 
        moveUp = move((x-1), y);
        if(moveUp) {
            return true;
        }
       
        // move down recursively 
        moveDown = move((x+1), y);
        if(moveDown) {
            return true;
        }
            
        // move left recursively 
        moveLeft = move(x, (y-1));
        if (moveLeft){
            return true;
        }
        
        // move right recursively
        moveRight = move(x, (y+1));
        if (moveRight) {
            return true;
        }
        
        // reset visited cells
        visited[x][y] = false;
        tempMaze[x][y] = ' ';
        
        // return false if no exit is found
        return false;
    }
    
    /**
     * Print the exit pattern.
     */
    public void print() {
        for(char[] x : tempMaze) {
            System.out.println();
            for(char y : x) {
                System.out.print(y + " ");
            }
        }
        System.out.println();
    }     
}

