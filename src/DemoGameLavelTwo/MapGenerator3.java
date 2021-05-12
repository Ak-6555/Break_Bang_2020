
package DemoGameLavelTwo;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class MapGenerator3 {
    
     public int map[][];//generates a 2D array to form the infrastructure of the bricks
     public int brickwidth;//Indicate the width of the brick
     public int brickheight;//Indiate the height of the brick
     
     public MapGenerator3(int row , int col)
      {
          /*
    	   * generates a 2D array for creating the outline of the bricks,sets values for each element of the array.
    	   */
       
          map=new int[row][col];
          
          for (int i = 0; i < row; i++) 
          {
              
              for (int j = 0; j< col; j++) 
              {
                map[1][2]=3;  map[1][7]=3;
                map[2][3]=3;  map[2][6]=3;
                map[3][4]=3;  map[3][5]=3;
                map[9][2]=3;  map[9][7]=3;
                map[8][3]=3;  map[8][6]=3;
                map[7][4]=3;  map[7][5]=3;
               
                  
                 
           
            if(i<5)
            {
                if(j>=i && j<col-i)
                    map[i][j]=0;
                else
                    map[i][j]=3;
            }

            if(i>=5 && i<=9)
            {

                if(j>=i ||j<col-i)
                    map[i][j]=3;

                else
                    map[i][j]=0;
            }
                  
              }
              
          }
         
          
         brickwidth=1090/col;
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
                    
                     
                     
                         if(map[i][j]==3)
                        {
                         
                         
                         g.setColor(Color.BLUE);
                         g.fillRect(j*brickwidth, i*brickheight+20, brickwidth, brickheight);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth, i*brickheight+20, brickwidth, brickheight);
                     
                     
                        }
                         if(map[i][j]==2)
                       {
                         
                         
                         g.setColor(new Color(2, 225, 250));
                        //level4  g.setColor(new Color(118, 58, 161));
                         g.fillRect(j*brickwidth, i*brickheight+20, brickwidth, brickheight);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth, i*brickheight+20, brickwidth, brickheight);
                         }
                        if(map[i][j]==1)
                        {
                         
                         
                         g.setColor(new Color (0, 219, 73));
                         g.fillRect(j*brickwidth, i*brickheight+20, brickwidth, brickheight);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth, i*brickheight+20, brickwidth, brickheight);
                     
                     
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
    

