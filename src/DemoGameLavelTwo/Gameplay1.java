package DemoGameLavelTwo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;



public class Gameplay1 extends JPanel implements KeyListener, ActionListener {
        
    

    
        private boolean play = false;//declares a boolean variable
	private Timer timer;//declares a variable under Timer class
	private int delay = 8;//parameter to be used while using the timer variable
        
	private int playerX = 310;//position of the paddle along x-axis
	private int ballposX = 350;//position of the first ball along x-axis
	private int ballposY = 617;//position of the first ball along y-axis
	private int ballxdir = -1;//direction of the first ball along x-axis
	private int ballydir = -2;//direction of the first ball along y-axis
	private MapGenerator1  mapob;//generator the outlining of bricks
        
	//new
	
	private Font f, f2;//declares variable under font class
        
        
        private int totalbrick = 32;//number of total bricks
	//second ball
	private boolean isSecondBallAppear = false;//declares a boolean variable
	private int secondBallPosX = 1050;//position of the second ball along x-axis
	private int secondBallPosY = 500;//position of the second ball along y-axis
	private int secondBallDirX = -2;//direction of the first ball along x-axis
	private int secondBallDirY = -2;//direction of the first ball along y-axis
	private int secondBallStartBrick = 24;//total bricks that would be present during the arrival of the second ball

	//bounsbutton
        private int bonusAY=-100;//position of the bonusA brick along y-axis
        private int bonusBY=-100;//position of the bonusB brick along y-axis
        private int bonusCY=-100;//position of the bonusC brick along y-axis
        private int cnt1=0;//counter when bonusA brick hits paddle 
        private int cnt2=0;//counter when bonusB brick hits paddle 
        private int cnt3=0;//counter when bonusC brick hits paddle 
        
        //life
        private int lifeposY=-200;//position of heart sign along y-axis
        public static int life=0;//a variable declared to keep track of the score,which is initially 0
        
        //score
        public static int score = 0;//a variable declared to keep track of the score,which is initially 0
       
	
        //new 
        private static int playerSpeed = 20;//paddle's motion
	private static int playerWidth = 100;//paddle's width

	
	private String gameOverMessage = "Game Over!";//conveys the message that game is over
        
        
	public Gameplay1() 
        {
                /**
		 * adds keyListener to the object of JPanel class,add background music ,sets the values for traversalkeysenabled and the focus of the frame.Creates the object of timer class.
		 */
		 mapob = new MapGenerator1(4, 8);
           
                 playMusic("Music\\\\Game1.wav");
                
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
               
	}

	public void paint(Graphics g) {
               
               /**
		 * @param object of Graphics class,g
		 * set the background
                 * set score of the level
                 * set life button through heart sign
                 * set bonus point
		 * sets the fonts,width,height of the winning message and scores
		 * sets the boundary conditions for the game,on the basis of the 1st and 2nd balls positions.
		 * draws the map to construct bricks
		 * draws the second ball
		 * marks the borders 
		 * constructs the paddle
		 * draws the first ball
		 */
               
		// background
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 1092, 692);
                 

		// drawingmap
		 mapob.draw((Graphics2D) g);

	       //Level
		g.setColor(Color.white);
		f = new Font("Arial", Font.PLAIN, 14);
		g.setFont(f);
		g.drawString("Level : 1", 20, 30);
                
                //score
		g.setColor(Color.white);
		f = new Font("Arial", Font.PLAIN, 14);
		g.setFont(f);
                //new change score position 
		g.drawString("Score: " + score, 975, 30);
                
                
                if(ballposY>670 && life!=0)
                {
                    play=false;
                    isSecondBallAppear=false;
                   
                    g.setColor(Color.WHITE);
                    g.setFont(f);
                    g.drawString("Life : "+life, 500, 310);
                    g.setColor(Color.WHITE);
                    g.setFont(f);
                    g.drawString("Press ( Enter ) to Continue", 435, 340);
                }
                
		if (ballposY > 670&& life==0) {
			play = false;
                        isSecondBallAppear = false;
			ballxdir = 0;
			ballydir = 0;
			g.setColor(Color.white);
			f2 = new Font("Arial", Font.PLAIN, 26);
			g.setFont(f2);
			g.drawString(gameOverMessage, 460, 300);
                        
                        //restart option
                         g.setColor(Color.WHITE);
                         g.setFont(f);
                         g.drawString("Press ( Enter ) to Restart", 450, 340);
                         
		}
                
		if (isSecondBallAppear)
                {
                    
                       //score
			g.setColor(Color.BLUE);
			g.fillOval(secondBallPosX, secondBallPosY, 20, 20);
                       
                }
                if(secondBallPosY>670 && life!=0)
                {
                    play=false;
                    isSecondBallAppear = false;
                    g.setColor(Color.WHITE);
                    g.setFont(f);
                    g.drawString("Life : "+life, 500, 310);
                    g.setColor(Color.WHITE);
                    g.setFont(f);
                    g.drawString("Press ( Enter ) to Continue", 435, 340);
                }
			
                if (secondBallPosY > 670 &&life==0)
                {
                            
                       play = false;
                       isSecondBallAppear = false;
                       
                       secondBallDirX = 0;
			secondBallDirY = 0;
			g.setColor(Color.white);
			f2 = new Font("Arial", Font.PLAIN, 26);
			g.setFont(f2);                                
                            //New/change the position
			g.drawString(gameOverMessage , 460, 300);
                              
                           //restart option
                        g.setColor(Color.WHITE);
                        g.setFont(f);
                        g.drawString("Press ( Enter ) to Restart", 450, 340);
			}
                        
                 //Life
		g.setColor(Color.white);
		f = new Font("Arial", Font.PLAIN, 14);
		g.setFont(f);
		g.drawString("Life : "+life, 915, 30);       
		
                
                //bonusobject
                
                //A
                g.setColor(new Color(219, 9, 72));
                g.fill3DRect(100, bonusAY, 60, 30 ,true);
                g.setColor( Color.WHITE);
                f = new Font("Arial", Font.PLAIN, 18);
                g.setFont(f);
                g.drawString("500+", 110,bonusAY+20);
                
                //B
                g.setColor(new Color(0, 207, 204));
                g.fill3DRect(400,bonusBY, 70, 30,true);
                g.setColor( Color.WHITE);
                f = new Font("Arial", Font.PLAIN, 18);;
                g.setFont(f);
                g.drawString("1000+", 410,bonusBY+20);
                
                //C
                g.setColor(new Color(219, 9, 72));
                g.fill3DRect(900,bonusCY, 70, 30,true);
                g.setColor( Color.WHITE);
                f = new Font("Arial", Font.PLAIN, 18);
                g.setFont(f);
                g.drawString("2000+", 910,bonusCY+20);
                
                
                //life
                int[] px={601,655,628};
                int[] py={lifeposY,lifeposY,lifeposY+32};
                
                g.setColor(new Color(219, 9, 72));
                g.fillOval(600, lifeposY-21, 30, 30);
                
                g.setColor(new Color(219, 9, 72));
                g.fillOval(626, lifeposY-21, 30, 30);
                
                g.setColor(new Color(219, 9, 72));
                g.fillPolygon(px, py, px.length);
                
               

		// border
                g.setColor(new Color(9, 219, 58));
		g.fillRect(0, 0, 3, 692);
		g.fillRect(0, 0, 1092, 3);
		g.fillRect(1091, 0, 3, 692);

		// paddle
		g.setColor(new Color(9, 219, 58));
		g.fillRect(playerX, 638, playerWidth, 20);
		

		//ball
		g.setColor(new Color(9, 219, 58));
		g.fillOval(ballposX, ballposY, 20, 20);
		g.dispose();
	   }
           public static void playMusic(String filepath)
           {
               /**
                * sets the background 
                */
           InputStream music;
           try
           {
           music = new FileInputStream(new File(filepath));
           AudioStream audios =new AudioStream(music);
           AudioPlayer.player.start(audios);

           }
           catch(Exception e)
           {
           JOptionPane.showMessageDialog(null, "Error");
           }
      
      
          }
           
         
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) 
        {
                /**
		 * @param e,an object of keyListener class
		 * sets conditions as to when to  move right or left
		 * sets the pace of the paddle
                 * sets conditions of getting back to life
		 * sets conditions of restarting
		 */
            
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
			if (playerX >=1000)
				playerX = 1000;
			else
				moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
                {
			if (playerX < 10)
				playerX = 10;
			else
				moveLeft();

		}
                if(e.getKeyCode()==KeyEvent.VK_ENTER && life==1)
                {
                    if(!play)
                    {
                    play=true;
                    isSecondBallAppear=true;
                    life--;

                             
                   
                    ballposX = 350;
	            ballposY = 617;
                    ballxdir = -1;
                    ballydir = -2;
                    
                    secondBallPosX = 1050;
                    secondBallPosY = 500;
                    secondBallDirX = -2;
                    secondBallDirY = -2;
                    secondBallStartBrick = 24;
                        
                    }
                }
                //new Resatrt action
                if(e.getKeyCode()==KeyEvent.VK_ENTER && totalbrick!=0)
                  {
                      
                  if(!play)
                    {
                        
                    play = true;
                       
                       
                       
                    playerX = 310;
                    ballposX = 350;
	            ballposY = 617;
                    ballxdir = -1;
                    ballydir = -2;
                    
                    mapob=new MapGenerator1(4,8);
	            //new
                    totalbrick = 32;
	
                    score = 0;
                   
                    //bonusobject
                    bonusAY=-100;
                    bonusBY=-100;
                    bonusCY=-100;
                    cnt1=0;
                    cnt2=0;
                    cnt3=0;
                    
                    life=0;
                  
                    //life
                    lifeposY=-200;

	           //second ball
                   isSecondBallAppear = false;
                   secondBallPosX = 1050;
                   secondBallPosY = 500;
                   secondBallDirX = -2;
                   secondBallDirY = -2;
                   secondBallStartBrick = 24;

	           //player handle speed
	  
                   playerSpeed = 20;
                   playerWidth = 100;

	          
                       
                     repaint();

                          }


                        }

                
                
                

	 }
        
        
        
        

	  public void moveRight()
          {
                /*
		 * sets the game in motion and increments the position of the paddle along x axis
		 */
		play = true;
                
               
                    playerX = playerX + playerSpeed;
                    

	    }

	  public void moveLeft()
          {
              
               /*
		 * sets the game in motion and decrements the position of the paddle along x axis
		 */
		play = true;
               
		playerX = playerX - playerSpeed;
              
                  
	   }

	  @Override
	  public void keyReleased(KeyEvent e) {
 
	  }

	  @Override
	  public void actionPerformed(java.awt.event.ActionEvent e) {
               
               /**@parameter e is an object of actionListener class
		 * repaints the whole frame 
		 * changes the direction of the ball according to the condition
                 * sets sound when ball hits the brick
		 * sets the position of the bricks along X and Y axis
		 * creates new object of the rectangle class
		 * sets the conditions as to how the brickValue method will work if the ball intersects the brick for both the first and second ball
		 * increments the score
		 * decrements the total bricks
		 * 
		 */
		
                repaint();
		timer.start();
		if (play) {
			if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
				ballydir = (ballydir * -1);
                                    playMusic("Music\\\\hitt.wav");
                         
			}
			if (isSecondBallAppear) {
				if (new Rectangle(secondBallPosX, secondBallPosY, 20, 20)
						.intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
					secondBallDirY = (secondBallDirY * -1);
                                            playMusic("Music\\\\hitt.wav");

				}
			}

			// new
			A: for (int i = 0; i <  mapob.map.length; i++) {
				for (int j = 0; j <  mapob.map[0].length; j++) {
					if ( mapob.map[i][j] > 0) {
						int brickX = j *  mapob.brickwidth + 80;
						int brickY = i *  mapob.brickheight + 70;
						int brickwidth =  mapob.brickwidth;
						int brickheight =  mapob.brickheight;

						Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickheight);
						Rectangle ballrect = new Rectangle(ballposX, ballposY, 20, 20);

						Rectangle brickrect = rect;
						if (ballrect.intersects(brickrect)) {
							 mapob.setBrickValue(0, i, j);
							totalbrick--;
                                                      playMusic("Music\\\\hitperfect.wav");

							score = score + 10;
							if (totalbrick == secondBallStartBrick) {
								isSecondBallAppear = true;
								playerWidth = 170;
                                                                playerSpeed=30;
								
							}
                                                        if (totalbrick == 0) 
                                                              {
									play = false;
									
                                                                        
                                                                    
                                                                Interface2 level2= new Interface2();
                                                                level2.setVisible(true);     
								}
							

							if (ballposX + 19 <= brickrect.x || ballposX + 1 >= brickrect.x + brickrect.width) {
								ballxdir = -ballxdir;
							} else {
								ballydir = -ballydir;
							}
							break A;
						}

					}

				}

			}

			if (isSecondBallAppear) {
				B: for (int i = 0; i <  mapob.map.length; i++) {
					for (int j = 0; j <  mapob.map[0].length; j++) {
						if ( mapob.map[i][j] > 0) {
							int brickX = j *  mapob.brickwidth + 80;
							int brickY = i *  mapob.brickheight + 70;
							int brickwidth =  mapob.brickwidth;
							int brickheight =  mapob.brickheight;

							Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickheight);
							Rectangle ballrect = new Rectangle(secondBallPosX, secondBallPosY, 20, 20);

							Rectangle brickrect = rect;
							if (ballrect.intersects(brickrect)) {
								 mapob.setBrickValue(0, i, j);
								totalbrick--;
                                                                
						             playMusic("Music\\\\hitperfect.wav");
                                                             
								if (totalbrick == 0) {
									play = false;
									
                                                                        
                                                               
                                                                Interface2 level2= new Interface2();
                                                                level2.setVisible(true);     
								}

								score = score + 30;

								if (secondBallPosX + 19 <= brickrect.x
										|| secondBallPosX + 1 >= brickrect.x + brickrect.width) {
									secondBallDirX = -secondBallDirX;
								} else {
									secondBallDirY = -secondBallDirY;
								}
								break B;
							}

						}

					}

				}
			}
                              //FIRST BALL
                               ballposX = ballposX + ballxdir;
			       ballposY = ballposY + ballydir;
            
                                if (ballposX < 0) {
			 	ballxdir = (ballxdir * -1);


			        }
			        if (ballposY < 0) {
				ballydir = (ballydir * -1);

			        }
			        if (ballposX > 1070) {
				ballxdir = (ballxdir * -1);
			        }
                                //SECOND BALL
			        if (isSecondBallAppear) {
				secondBallPosX = secondBallPosX + secondBallDirX;
				secondBallPosY = secondBallPosY + secondBallDirY;
                                
				if (secondBallPosX < 0) {
					secondBallDirX = (secondBallDirX * -1);

				}
				if (secondBallPosY < 0) {
					secondBallDirY = (secondBallDirY * -1);

				}
				if (secondBallPosX > 1070) {
					secondBallDirX = (secondBallDirX * -1);
				}
			       }
                                //bonusbutton
                                if(totalbrick<=24)
                                { 
                                    bonusAY=bonusAY+1;
                                    if(cnt1==0)
                                    {
                                    if (new Rectangle(100, bonusAY, 60, 30 ).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
                                     score=score+500;
                                     cnt1++;
                                    }
                                }}
                                if(totalbrick<=8)
                                {
                                    bonusBY=bonusBY+1;
                                    if(cnt2==0)
                                    {
                                    if (new Rectangle(400, bonusBY, 70, 30 ).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
                                     score=score+1000;
                                     cnt2++;
                                    }
                                    }
                                }
                                if(totalbrick<=16)
                                {
                                    bonusCY=bonusCY+1;
                                    if(cnt3==0)
                                    {
                                    if (new Rectangle(900, bonusCY, 70, 30 ).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
                                     score=score+2000;
                                     cnt3++;
                                    }
                                    }
                                }
                                
                                //life button
                                
                                if(totalbrick<=12)
                                {
                                    lifeposY = lifeposY +  2;
                                    if (new Rectangle(601,lifeposY,55,32).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
				    
                                     life=1;
                                     
                                    }
                                }
                                
                                 
                                

		}

	}
}























/*
//3rd submission 

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
         private boolean play = false;
	private Timer timer;
	private int delay = 8;

	private int playerX = 310;
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballxdir = -1;
	private int ballydir = -2;
	private MapGenerator map;
	// new
	private int totalbrick = 21;
	private Font f, f2;
        
        
            private int score = 0;
	// second ball
	private boolean isSecondBallAppear = false;
	private int secondBallPosX = 240;
	private int secondBallPosY = 120;
	private int secondBallDirX = -2;
	private int secondBallDirY = -2;
	private int secondBallStartBrick = 14;

	// player handle speed
	
	private static int playerWidth = 100;

	// win
	private boolean isWin = false;
	private String winMessage = "You Win!";
	private String gameOverMessage = "Game Over!";

	public Gameplay() {
		map = new MapGenerator(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint(Graphics g) {
		// background
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 692, 592);

		if (isWin) {
			g.setColor(Color.white);
			f2 = new Font("Arial", Font.BOLD, 26);
			g.setFont(f2);
			g.drawString(winMessage, 250, 300);
			g.drawString("Your Score: " + score, 240, 350);
			return;
		}

		// drawingmap
		map.draw((Graphics2D) g);

		// new //score
		g.setColor(Color.white);
		f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.drawString("Your Score: " + score, 510, 30);

		if (ballposY > 570) {
			play = false;
			ballxdir = 0;
			ballydir = 0;
			g.setColor(Color.white);
			f2 = new Font("Arial", Font.BOLD, 26);
			g.setFont(f2);
			g.drawString("Game Over! ", 250, 300);
		}
		if (isSecondBallAppear) {
                    //secre
			if (secondBallPosY > 570) {
				secondBallDirX = 0;
				secondBallDirY = 0;
				play = false;
				g.setColor(Color.white);
				f2 = new Font("Arial", Font.BOLD, 26);
				g.setFont(f2);
				g.drawString("Game Over! ", 250, 300);
			}
                        //<score
			//g.setColor(new Color(5, 47, 255));
			g.setColor(Color.RED);
			g.fillOval(secondBallPosX, secondBallPosY, 20, 20);
		}

		// border
		g.setColor(Color.green);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);

		// paddle
		g.setColor(Color.green);
                //for second ball 
		g.fillRect(playerX, 538, playerWidth, 20);
		

		/// ball
		//g.setColor(new Color(5, 255, 68));
		g.setColor(Color.white);
		g.fillOval(ballposX, ballposY, 20, 20);
		g.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (playerX >= 600)
				playerX = 600;
			else
				moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (playerX < 10)
				playerX = 10;
			else
				moveLeft();

		}

	}

	public void moveRight() {
		play = true;
		playerX = playerX + 20;

	}

	public void moveLeft() {
		play = true;
		playerX = playerX - 20;

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		repaint();
		timer.start();
		if (play) {
			if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, playerWidth, 8))) {
				ballydir = (ballydir * -1);

			}
			if (isSecondBallAppear) {
				if (new Rectangle(secondBallPosX, secondBallPosY, 20, 20)
						.intersects(new Rectangle(playerX, 550, playerWidth, 8))) {
					secondBallDirY = (secondBallDirY * -1);

				}
			}

			// new
			A: for (int i = 0; i < map.map.length; i++) {
				for (int j = 0; j < map.map[0].length; j++) {
					if (map.map[i][j] > 0) {
						int brickX = j * map.brickwidth + 80;
						int brickY = i * map.brickheight + 50;
						int brickwidth = map.brickwidth;
						int brickheight = map.brickheight;

						Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickheight);
						Rectangle ballrect = new Rectangle(ballposX, ballposY, 20, 20);

						Rectangle brickrect = rect;
						if (ballrect.intersects(brickrect)) {
							map.setBrickValue(0, i, j);
							totalbrick--;
                                                        
							score = score + 10;
							if (totalbrick == 0) {
								play = false;
								isWin = true;
							}
							// second ball
							if (totalbrick == secondBallStartBrick) {
								isSecondBallAppear = true;
								playerWidth = 170;
								
							}
							

							if (ballposX + 19 <= brickrect.x || ballposX + 1 >= brickrect.x + brickrect.width) {
								ballxdir = -ballxdir;
							} else {
								ballydir = -ballydir;
							}
							break A;
						}

					}

				}

			}

			if (isSecondBallAppear) {
				B: for (int i = 0; i < map.map.length; i++) {
					for (int j = 0; j < map.map[0].length; j++) {
						if (map.map[i][j] > 0) {
							int brickX = j * map.brickwidth + 80;
							int brickY = i * map.brickheight + 50;
							int brickwidth = map.brickwidth;
							int brickheight = map.brickheight;

							Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickheight);
							Rectangle ballrect = new Rectangle(secondBallPosX, secondBallPosY, 20, 20);

							Rectangle brickrect = rect;
							if (ballrect.intersects(brickrect)) {
								map.setBrickValue(0, i, j);
								totalbrick--;
								System.out.println(totalbrick);
								if (totalbrick == 0) {
									play = false;
									isWin = true;
								}

								score = score + 30;

								if (secondBallPosX + 19 <= brickrect.x
										|| secondBallPosX + 1 >= brickrect.x + brickrect.width) {
									secondBallDirX = -secondBallDirX;
								} else {
									secondBallDirY = -secondBallDirY;
								}
								break B;
							}

						}

					}

				}
			}
                              //FIRST BALL
                               ballposX = ballposX + ballxdir;
			       ballposY = ballposY + ballydir;
            
                                if (ballposX < 0) {
			 	ballxdir = (ballxdir * -1);


			        }
			        if (ballposY < 0) {
				ballydir = (ballydir * -1);

			        }
			        if (ballposX > 670) {
				ballxdir = (ballxdir * -1);
			        }
                                //SCOND BALL
			        if (isSecondBallAppear) {
				secondBallPosX = secondBallPosX + secondBallDirX;
				secondBallPosY = secondBallPosY + secondBallDirY;
//	            System.out.println(ballposX + " " + ballposY + " " + ballxdir + " " + ballydir);
				if (secondBallPosX < 0) {
					secondBallDirX = (secondBallDirX * -1);

				}
				if (secondBallPosY < 0) {
					secondBallDirY = (secondBallDirY * -1);

				}
				if (secondBallPosX > 670) {
					secondBallDirX = (secondBallDirX * -1);
				}
			       }

		}

	}
}




/*











































/*
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements KeyListener,ActionListener {
 
    private boolean play=false;
    private Timer timer;
    private int delay =8;
    
    private int playerX=310;
    private int ballposX=120;
    private int ballposY=350;
    private int ballxdir=-1;
    private int ballydir=-2;
    private MapGenerator map;
    
    private int totalbrick=21;
    private int score =0;
    private Font f,f2;

    
    public Gameplay()
    {
        map=new MapGenerator(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g)
    {     
        //background
        g.setColor(Color.BLACK);
        g.fillRect(1,1, 692,592);
        
        //drawingmap
        map.draw((Graphics2D)g);
        
          //new//score 
        g.setColor(Color.white);
        f= new Font("Arial", Font.BOLD, 14); 
        g.setFont(f);
        g.drawString("Your Score: "+score,510,30);
        if(ballposY>570)
        {
           play = false;
           ballxdir=0;
           ballydir=0;
           g.setColor(Color.white);
           f2= new Font("Arial",Font.BOLD,26);
           g.setFont(f2);
           g.drawString("Game Over! ", 250, 300);
        }
        
       
        
        
           //border
        g.setColor(Color.green);
        g.fillRect(0,0,3, 592);
        g.fillRect(0,0,692, 3);
        g.fillRect(691,0,3, 592);
       
             //paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 538, 100, 25);
             
        
             ///ball
        g.setColor(Color.WHITE);
        g.fillOval(ballposX,ballposY,20,20);
        g.dispose();
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_RIGHT)
       { if(playerX>=600)
            playerX=600;
          else
           moveRight();
       }
       if(e.getKeyCode()==KeyEvent.VK_LEFT)
       {
          if(playerX<10)
              playerX=10;
          else
              moveLeft();
                     
       }
  
    }
       public void moveRight()
          {
       play=true;
       playerX=playerX+20;
    
         }
       public void moveLeft()
         {
       play=true;
       playerX=playerX-20;
    
         }
    
    
    
    
    @Override
    public void keyReleased(KeyEvent e) {
      
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        repaint();
        timer.start();
        if(play)
        {   
            if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8)))
            {
                ballydir = (ballydir * -1);
                
            }
           //new
           A:for (int i = 0; i < map.map.length; i++) { 
                for (int j = 0; j <map.map[0].length; j++) {
                    if(map.map[i][j]>0)
                    {
                     int brickX=j*map.brickwidth+80;
                     int brickY=i*map.brickheight+50;
                     int brickwidth=map.brickwidth;
                     int brickheight=map.brickheight;
                     
                        
                    Rectangle rect = new Rectangle(brickX,brickY,brickwidth,brickheight);
                    Rectangle ballrect = new Rectangle(ballposX,ballposY,20,20);
                    Rectangle brickrect =rect;
                    if(ballrect.intersects(brickrect))
                    {
                        map.setBrickValue(0, i, j);
                        totalbrick++;
                        score=score+10;
                        
                        if(ballposX+19<=brickrect.x||ballposX+1>=brickrect.x+brickrect.width)
                        {
                            ballxdir= -ballxdir;
                        }
                        else{
                            ballydir= -ballydir;
                          }
                        break A;
                      }
                     
                    }
                    
                }
                
            }
          ///new<
			ballposX = ballposX + ballxdir;
			ballposY = ballposY + ballydir;
            
            if(ballposX < 0)
            {
           
              ballxdir = (ballxdir * -1);
             
            }
            if(ballposY < 0)
            {

              ballydir = (ballydir * -1);
             
            }
            if(ballposX > 670)
            {
              ballxdir = (ballxdir * -1); 
            }
           
            
            
        }
        
        
    }
}
  */  
    