
package DemoGameLavelTwo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class MapGenerator1 {
    
     public int map[][];//generates a 2D array to form the infrastructure of the bricks
     public int brickwidth;//Indicate the width of the brick
     public int brickheight;//Indiate the height of the brick
     
      public MapGenerator1(int row,int col)
      {
          /*
    	   * generates a 2D array for creating the outline of the bricks,sets values for each element of the array.
    	   */
          map=new int[row][col];
          for (int i = 0; i < map.length; i++) {
              for (int j = 0; j < map[0].length; j++) {
                  map[i][j]=1;//sets the initial value of each brick to 1
                  
                  
              }
              
          }
          
         brickwidth=940/col;
         brickheight=160/row;
      }
         public void draw(Graphics2D g)
         {
                /**
        	  * @param g, object of Graphics 2D class
        	  * sets outline of the brick as well as the determines the coloring
        	  */
             for (int i = 0; i < map.length; i++) {
                 for (int j = 0; j <map[0].length; j++) {
                    
                     if(map[i][j]>0){
                         g.setColor(Color.BLUE);
                         g.fillRect(j*brickwidth+80, i*brickheight+70, brickwidth, brickheight);
                    
                        g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth+80, i*brickheight+70, brickwidth, brickheight);
                     
                     
                     }
                 }
 
             }
         }
         public void setBrickValue(int value , int row , int col)
         {
                 /**
        	  *@param value,row,col 
        	  * sets a specific value for a given element of the 2D array;
        	  */
             map[row][col]=value;
         }
         
      }
    

