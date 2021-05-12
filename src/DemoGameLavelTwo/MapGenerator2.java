
package DemoGameLavelTwo;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class MapGenerator2 {
     public int map[][];//generates a 2D array to form the infrastructure of the bricks
     public int brickwidth;//Indicate the width of the brick
     public int brickheight;//Indiate the height of the brick
     
     public MapGenerator2(int row , int col)
      {
          /*
    	   * generates a 2D array for creating the outline of the bricks,sets values for each element of the array.
    	   */
       
          map=new int[row][col];
          
          for (int i = 0; i < row; i++)
           {

           for (int j = 0; j< col; j++)
            {


           if(i<5)
            {
                if(j>=i && j<col-i-1)
                    map[i][j]=2;//sets the initial value of each brick to 2
                else
                    map[i][j]=0;
            }

            if(i>=5)
            {

                if(j>=i ||j<col-i-1)
                    map[i][j]=0;

                else
                    map[i][j]=2;//sets the initial value of each brick to 1
            }
          
          }
         
           }
         brickwidth=1190/col;
         brickheight=300/row;
      
             
      }     

         public void draw(Graphics2D g)
         {
                 /**
        	  * @param g, object of Graphics 2D class
        	  * sets outline of the brick as well as the determines the coloring
        	  */
             for (int i = 0; i < map.length; i++) {
                 for (int j = 0; j <map[0].length; j++) {
                    
                     if(map[i][j]==2)
                     {
                         
                         
                         g.setColor(Color.BLUE);
                         g.fillRect(j*brickwidth+10, i*brickheight+50, brickwidth, brickheight);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth+10, i*brickheight+50, brickwidth, brickheight);
                     
                     
                     }
                        else  if(map[i][j]==1)
                        {
                         
                         
                         g.setColor(new Color(0, 219, 73));
                         g.fillRect(j*brickwidth+10, i*brickheight+50, brickwidth, brickheight);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth+10, i*brickheight+50, brickwidth, brickheight);
                     
                     
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
    

