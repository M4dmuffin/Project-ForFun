/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author HP Pavillion
 */
public class Helper extends Item {

    private int counter;
    private final static int MAX_VALUE = 1000;
    int best_solution = MAX_VALUE;
    private int aantalKol_Rij;
    private Veld[][] maze;
    public char[][] output_maze;
    public char[][] doolhof;

    public Helper() {
        ImageIcon img = new ImageIcon("src/Pics/helper.png");
        itemImage = img.getImage();
        output_maze = null;
        doolhof = new char[21][21];

    }

    public void terugOmzetten() {
        for (int y = 0; y < 21; y++) {
            for (int x = 0; x < 21; x++) {

                Veld huidig = maze[y][x];
                if (huidig.getMuur() != null) {
                    doolhof[y][x] = 'M';
                }

                if (huidig.getVriend() != null) {
                    doolhof[y][x] = 'V';
                }

                if (huidig.getGang() != null) {
                    doolhof[y][x] = 'G';
                }

            }

        }

    }
    
    

    private void cloneMaze() {
        output_maze = new char[21][21];
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 21; y++) {
                output_maze[x][y] = doolhof[x][y];
            }
        }
    }

    // Get the start location (x,y) and try to solve the maze
    public void solve(int x, int y) {

        for (int q = 0; q < maze.length; q++) 
        {
            for (int r = 0; r < maze.length; r++) 
            {
                if(maze[q][r].getVriend() != null)
                {
                    doolhof[q][r] = 'V';
                }
            }
        }
        terugOmzetten();
        best_solution = MAX_VALUE;

        if (step(x, y, 0) != MAX_VALUE) {
            output_maze[x][y] = 'S';
        }
    }
    

    // Backtracking method
    public int step(int x, int y, int count) {
        
        
        counter++;
        //System.out.println(this.toString());

        /**
         * Accept case - we found the exit *
         */
        if (doolhof[x][y] == 'V') {
            best_solution = count;
            this.cloneMaze();
            return count;
        }

        /**
         * Reject case - we are hit a wall or our path *
         */
        if (doolhof[x][y] == 'M' || doolhof[x][y] == '*') {
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
        doolhof[x][y] = '*';
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
        doolhof[x][y] = 'G';

        if (result < MAX_VALUE) {
            return result;
        }

        /**
         * Deadend - this location can't be part of the solution *
         */
        // Go back
        return MAX_VALUE;
    }

    public String toString() {
        String output = "";
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 21; y++) {
                output += doolhof[x][y] + " ";
            }
            output += "\n";
        }
        return output;
    }

    public String toStringSolution() {
        if (output_maze == null) {
            return "No Solution!";
        }
        String output = "";
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 21; y++) {
                output += output_maze[x][y] + " ";
            }
            output += "\n";
        }
        return output;
    }
    
    @Override
    public void paint(Graphics g)
    {
        ImageIcon img = new ImageIcon("src/Pics/helperPad.png");
        itemImage = img.getImage();
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 21; y++) {
                
                if(output_maze[x][y] == '*')
                {
                    super.paint(g);
                    g.drawImage(itemImage, y * 40, x * 40, null);

                }
            }
        }
        
        
        
    }

//	public static void main(String[] args) {
//		Maze_best m = new Maze_best();
//		// Locate the exit
//		m.maze[1][1] = 'X';
//		
//		// Start solving the maze from (8, 1)
//		m.solve(8, 1);
//		System.out.println(m.toStringSolution());
//		System.out.println("Total calls: " + m.counter);
//	}	
    public void setMaze(Veld[][] maze) {
        this.maze = maze;
    }
}
