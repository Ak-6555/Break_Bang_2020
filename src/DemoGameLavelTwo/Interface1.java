package DemoGameLavelTwo;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Interface1 extends JFrame implements ActionListener {

    private Container c;//declares variable c under Container class
    private ImageIcon iconplay,iconhelp,iconexit,iconhscore,iconbackground,icon;//declares variables under ImageIcon class
    private JLabel imglabel; //declares variables under JLabel class
    private JButton btnplay,btnhelp,btnexit,btnhs;//declares variables under JButton class    
    
    Interface1()
    {  
      /**
        *This constructor carries out the operations done inside init method
        */
        init();
    }
     public void init()
     { 
         /**
    	  * returns null type output
    	  * used to set the the specifications of the frame,creates object for calling the instant variables,buttons are added in accordance with the requisite to run                        the game
    	  **/
         this.setBounds(150, 5, 1100, 700);
         this.setVisible(true);
         this.setResizable(false);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setTitle("Break Bang");
         
         icon =new ImageIcon("src/icon.jpg");
         this.setIconImage(icon.getImage());
         
         c=this.getContentPane();
         c.setLayout(null);
         
           
          
         
          btnplay =new JButton ();
          iconplay=new ImageIcon("src/play6.jpg");
          btnplay.setBounds(470,350,iconplay.getIconWidth(), iconplay.getIconHeight());
          btnplay.setIcon(iconplay);
          c.add(btnplay);
          
          
          btnexit=new JButton ();
          iconexit=new ImageIcon("src/Exit.jpg");
          btnexit.setBounds(470,350+2* iconplay.getIconHeight(),iconplay.getIconWidth(), iconplay.getIconHeight());
          btnexit.setIcon(iconexit);
          c.add(btnexit);
        
        
          
          btnhelp =new JButton ();
          iconhelp=new ImageIcon("src/help.jpg");
          btnhelp.setBounds(470,350+ iconplay.getIconHeight(),iconplay.getIconWidth(), iconplay.getIconHeight());
          btnhelp.setIcon(iconhelp);
          c.add(btnhelp);
          
          
          
          btnhs =new JButton ();
          iconhscore=new ImageIcon("src/hs.jpg");
          btnhs.setBounds(470,350+ 3*iconplay.getIconHeight(),iconplay.getIconWidth(), iconplay.getIconHeight());
          btnhs.setIcon(iconhscore);
           c.add(btnhs);
           
         
         
          
          
          iconbackground=new ImageIcon("src/BACK1.jpg");
          imglabel = new JLabel(iconbackground);
          imglabel.setBounds(0, 0,iconbackground.getIconWidth(),iconbackground.getIconHeight());
          c.add(imglabel);
         
         
          
          btnplay.addActionListener(this);
          btnhelp.addActionListener(this);
          btnexit.addActionListener(this);
          btnhs.addActionListener(this);
          
          
         
         
     }
    public static void main(String[] args) {
        /**
    	 * creates an object of Interface1 class
    	 */
        
        Interface1 menu=new Interface1();
      
      playMusic("Music\\\\Intro.wav");
        
        
        
        
    }
     //introSound
     public static void playMusic(String filepath)
      {
         /**
          * plays Intro music when the game begins 
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
         JOptionPane.showMessageDialog(null, "Sound Error");
     }
      
      
    }

     
    @Override
    public void actionPerformed(ActionEvent e) {
        
        /**
    	 * @param e,e is a variable declared under the class of ActionListener
    	 * specifies the conditions as to when the game will resume,play or show setting
    	 */
         
        if(btnplay==e.getSource())
        {
            

             dispose();
          
           
            Main1 letsplay =new Main1();
            letsplay.setVisible(true);
            


           
        }
        else if(btnexit==e.getSource())
        {
            ImageIcon exiticon= new ImageIcon("src/exiticon.jpg");
            JOptionPane.showMessageDialog(null, "Exit the Game","Exit",1,exiticon);
            this.dispose();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
        }
        if(btnhelp==e.getSource())
        {   
             ImageIcon helpicon = new ImageIcon("src/hicon.jpg");
            JOptionPane.showMessageDialog(null, "We appreciate your interest in playing this game."
                    + "\nHere are detailed instructions to maneuver you:\n There are three levels of the game,"
                    + "\nthat will be unlocked only if you win the previous levels.\nThe first level is accessible to all by default."
                    + "\n\nRules of the game:\n\nUse your cursor or keys to move the paddle to and fro in accordance with "
                    + "\nthe motion of the ball so that the ball can land on the paddle after hitting the bricks."
                    + "\nIf the ball gets misplaced instead of landing,"
                    + "\nthe game gets over and final score is put on the display."
                    + "\nIf you manage to break all the bricks successfully,\n"
                    + " you get to play in the next level.Enjoy! ","Help",1,helpicon);
        }
        
        if(btnhs==e.getSource())
        {
            ImageIcon hsicon = new ImageIcon("src/hsicon.jpg");
            JOptionPane.showMessageDialog(null, "High Score : "+60755,"High Score",1,hsicon);
        }
        
        
        
        
    }
    
}
