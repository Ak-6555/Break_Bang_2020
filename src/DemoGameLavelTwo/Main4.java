
package DemoGameLavelTwo;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main4 extends JFrame {
    
    private  Gameplay4 gameplay;//declares variable under Gameplay class
    private ImageIcon icon;//declare variable under ImageIcon class
    
    Main4()
    {
        /**
         *this constructor carries out the operations done inside the initComponent method 
         */
        initcomponent();
    }
    
    public void initcomponent()
    {
               /**
		 * specifies the construction of a frame,as well as setting the background details.
		 *  returns null type output
 	         * used to set the the specifications of the frame,creates object for calling the instant variables,buttons are added in accordance with the requisite to run the game
		 */
           this.setBounds(10, 10,1100, 700);
           this. setResizable(false);
           this.setLocation(150, 5);
           this. setVisible(true);
           this.setTitle("Break Bang");
           
         gameplay = new Gameplay4();   
       
        
        this.getContentPane().setBackground(Color.BLACK);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(gameplay);
        
        icon = new ImageIcon("src/icon.jpg");
               this.setIconImage(icon.getImage());   
               
    }
        
    
    
    public static void main(String[] args) {
        
        /**
    	 * creates an object of Main4 class
    	 */
        Main4 obj=new Main4();
        
         
        
               
    } 
    
}
