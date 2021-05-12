
package DemoGameLavelTwo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class MapGenerator4 {
      
      public int map1[][];//generates a 2D array to form the infrastructure of the bricks
      public int map2[][];//generates a 2D array to form the infrastructure of the bricks
      public int brickwidth;//Indicate the width of the brick
      public int brickheight;//Indiate the height of the brick
      
      public MapGenerator4(int row,int col)
      {
          /**
    	   * generates a 2D array for creating the outline of the bricks,sets values for each element of the array.
    	   */
          map1=new int[row][col];
          map2=new int[row][col];
          for (int i = 0; i < map1.length; i++) {
              for (int j = 0; j < map1[0].length; j++) {
                  map1[i][j]=1;
                  map2[i][j]=1;
                  
                  
              }
              
          }
          
         brickwidth=1040/col;
         brickheight=70/row;
      }
         public void draw(Graphics2D g)
         {
             
                 /**
        	  * @param g, object of Graphics 2D class
        	  * sets outline of the brick as well as the determines the coloring
        	  */
             for (int i = 0; i < map1.length; i++) {
                 for (int j = 0; j <map1[0].length; j++) {
                         
                     //upper brick
                     if(map1[i][j]>0)
                     {
                         g.setColor(Color.BLUE);
                         g.fillRect(j*brickwidth+30, i*brickheight+30, brickwidth, brickheight);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth+30, i*brickheight+30, brickwidth, brickheight);
                     }
                     
                       //lower brick
                       if(map2[i][j]>0)  
                       {  
                         g.setColor(Color.GREEN);
                         g.fillRect(j*brickwidth+30, i*brickheight+580, brickwidth, brickheight);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth+30, i*brickheight+580, brickwidth, brickheight);
                     
                     
                         }
                 }
 
             }
         }
         public void setBrickValueMap1(int value , int row , int col)
         {
                 /**
        	  *@param value,row,col 
        	  * sets a specific value for a given element of the 2D array;
        	  */ 
             map1[row][col]=value;
         }
         public void setBrickValueMap2(int value , int row , int col)
         {
                 /**
        	  *@param value,row,col 
        	  * sets a specific value for a given element of the 2D array;
        	  */
             map2[row][col]=value;
         }
         
      }
    

