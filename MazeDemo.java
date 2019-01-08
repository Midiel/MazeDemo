/*
 * Midiel Rodriguez
 * Course: COP-337
 * Assignemnt: 8
 * 
 * The purpose of this program is to test a maze for possible ways out.
 *
 * This programs creates a two dimension array of characters that represents 
 * the maze. The walls of the maze are represented by asterisks(*).
 * Then the programs creates an instance of a Maze class which will solve
 * the maze for a posible exit providing a starting point in the x and y
 * cordinates.
 * If the there is an exit, the Maze class return true if there is no exit 
 * it returns flase.
 * 
 * Disclaimer:
 * I hereby certify that this code is my work and my work alone and understand
 * the syllabus regarding plagiarized code.
 * Copyright 2018 Midiel
 */
package mazedemo;

/** 
 * This class is a test demo to test the Maze class. It provides a maze and
 * a starting point to the Maze class for test.
 *
 * @author Midiel Rodriguez
 * @version 1.0 March 31, 2018
 */
public class MazeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[][] m = {
         {'*', ' ', '*', '*', '*', '*', '*', '*', '*'}, 
         {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'}, 
         {'*', ' ', '*', '*', '*', '*', '*', ' ', '*'}, 
         {'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*'}, 
         {'*', ' ', '*', ' ', '*', '*', '*', ' ', '*'}, 
         {'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*'}, 
         {'*', '*', '*', ' ', '*', ' ', '*', '*', '*'}, 
         {'*', ' ', ' ', '*', ' ', ' ', '*', ' ', '*'}, 
         {'*', '*', '*', '*', '*', '*', '*', ' ', '*'}};
         
      Maze maze = new Maze(m);
      System.out.println(maze.escape(4, 3));
      System.out.println("Expected: true");
      System.out.println(maze.escape(5, 5));
      System.out.println("Expected: false");
    }   
}
