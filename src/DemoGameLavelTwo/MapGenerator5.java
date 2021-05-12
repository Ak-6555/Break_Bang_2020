
package DemoGameLavelTwo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class MapGenerator5 {
    
    
    public int map1[][], map2[][];//generates a 2D array to form the infrastructure of the bricks
    public int map3[][], map4[][];//generates a 2D array to form the infrastructure of the bricks
    
    public int brickwidth;//Indicate the width of the upper and lower brick
    public int brickheight;//Indiate the height of the upper and lower brick
    public int brickWidthLeftBrick;//Indicate the width of the left and right brick
    public int brickHeightLeftBrick;//Indicate the height of the upper and lower brick
    
    
      public MapGenerator5()
      {
          /**
    	   * generates a 2D array for creating the outline of the bricks,sets values for each element of the array.
    	   */
          
          int row=2,col=12;
          map1=new int[row][col];
          map2=new int[row][col];
          map3=new int[5][2];
          map4=new int[5][2];
          for (int i = 0; i < map1.length; i++) 
          {
              for (int j = 0; j < map1[0].length; j++) 
              {
                  map1[i][j]=1;
                  map2[i][j]=1;
                
                  
                  
              }
              
          }
          for (int i = 0; i < map3.length; i++)
          {
              for (int j = 0; j < map3[0].length; j++) 
              {
                 
                  map3[i][j]=1;
                  map4[i][j]=1;
                  
             
              }
              
          }
          
         brickwidth=1040/col;
         brickheight=70/row;
         
         brickWidthLeftBrick=86/row;
         brickHeightLeftBrick=481/((col-2)/2);
         
         
         
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
                         g.setColor(Color.BLUE);
                         g.fillRect(j*brickwidth+30, i*brickheight+580, brickwidth, brickheight);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth+30, i*brickheight+580, brickwidth, brickheight);
                     
                     
                         }
                       
                     
                 }
 
             }
             for (int i = 0; i < map3.length; i++) {
                 for (int j = 0; j <map3[0].length; j++) {
                         
                       //left side
                        if(map3[i][j]>0)  
                        {  
                         g.setColor(new Color(106, 0, 117));
                         g.fillRect(j*brickWidthLeftBrick+30, i*brickHeightLeftBrick+100, brickWidthLeftBrick, brickHeightLeftBrick);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickWidthLeftBrick+30, i*brickHeightLeftBrick+100, brickWidthLeftBrick, brickHeightLeftBrick);
                     
                     
                          }
                     
                        //rightside
                        if(map4[i][j]>0)  
                        {  
                         g.setColor(new Color(106, 0, 117));
                         g.fillRect(j*brickWidthLeftBrick+976, i*brickHeightLeftBrick+100, brickWidthLeftBrick, brickHeightLeftBrick);
                         g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickWidthLeftBrick+976, i*brickHeightLeftBrick+100, brickWidthLeftBrick, brickHeightLeftBrick);
                     
                     
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
         public void setBrickValueMap3(int value , int row , int col)
         { 
                 /**
        	  *@param value,row,col 
        	  * sets a specific value for a given element of the 2D array;
        	  */
             map3[row][col]=value;
         }
         public void setBrickValueMap4(int value , int row , int col)
         { 
                 /**
        	  *@param value,row,col 
        	  * sets a specific value for a given element of the 2D array;
        	  */
             map4[row][col]=value;
         }
         
      }
    

