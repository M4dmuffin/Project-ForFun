/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author HP Pavillion
 */
public class Helper extends Item {

    private int counter = 0;
    private final static int MAX_VALUE = 1000;
   
    int best_solution = MAX_VALUE;
    private int aantalKol_Rij;
    private Veld[][] maze;
    public Veld[][] output_maze;

    public Helper() {
        ImageIcon img = new ImageIcon("src/Pics/helper.png");
        itemImage = img.getImage();
        output_maze = null;

    }

    private void cloneMaze() {
        aantalKol_Rij = maze.length;
        output_maze = new Veld[aantalKol_Rij][aantalKol_Rij];
        for (int x = 0; x < aantalKol_Rij; x++) {
            for (int y = 0; y < aantalKol_Rij; y++) {
                output_maze[x][y] = maze[x][y];
            }
        }
    }

    // Get the start location (x,y) and try to solve the maze
    public void solve(int x, int y) {
        cloneMaze();
        best_solution = MAX_VALUE;

        if (step(x, y, 0) != MAX_VALUE) {

            output_maze[x][y].setIsBezocht(true);
        }
    }

    // Backtracking method
    private int step(int x, int y, int count) {

        counter++;


        /**
         * Accept case - we found the exit *
         */
        if (maze[x][y].getVriend() != null) {
            best_solution = count;
            this.cloneMaze();
            return count;
        }

        /**
         * Reject case - we are hit a wall or our path *
         */
        if (maze[x][y].getMuur() != null || maze[x][y].isIsBezocht() == true) {
            return MAX_VALUE;
        }
        /**
         * Reject case - we already have a better solution! *
         */
        if (count == best_solution) {
            return MAX_VALUE;
        }

        /**
         * Backtracking Step *
         */
        // Mark this location as part of out path
        maze[x][y].setIsBezocht(true);
        int result = MAX_VALUE;

        int new_result = MAX_VALUE;

        // Try to go Right
        new_result = step(x, y + 1, count + 1);
        if (new_result < result) {
            result = new_result;
        }

        // Try to go Up
        new_result = step(x - 1, y, count + 1);
        if (new_result < result) {
            result = new_result;
        }

        // Try to go Left
        new_result = step(x, y - 1, count + 1);
        if (new_result < result) {
            result = new_result;
        }

        // Try to go Down
        new_result = step(x + 1, y, count + 1);
        if (new_result < result) {
            result = new_result;
        }

        // Unmark this location
        maze[x][y].setIsBezocht(false);

        if (result < MAX_VALUE) {
            return result;
        }

        /**
         * Deadend - this location can't be part of the solution *
         */
        // Go back
        return MAX_VALUE;
    }

    @Override
    public void paint(Graphics g) {
        if (output_maze == null) {
            return;
        }


        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 21; y++) {

                if (output_maze[x][y].isIsBezocht() == true) {
                } else {
                    g.setColor(Color.BLUE);
                    g.drawRect(output_maze.length * 40, output_maze.length * 40, 20, 20);
                }

            }

        }
        return;
    }

    public void setMaze(Veld[][] maze) {
        this.maze = maze;
    }

 
    
    
}
