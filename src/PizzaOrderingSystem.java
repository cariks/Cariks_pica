import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PizzaOrderingSystem  implements ActionListener{
	JFrame frame = new JFrame("Pizza Ordering System");
	JButton jaunaisPasutijums = new JButton("Jaunais pas�t�jums");
	JButton apskatitPasutijumus = new JButton("Apskat�t pas�t�jumus");
	JButton apturet = new JButton("Aptur�t programmu");

	
	public void newFrame() {
		ImageIcon pizza_image = new ImageIcon("pizza_image.png");
	    ImageIcon pizza_logo = new ImageIcon("pizza_logo.png");

	    int garums = 600;
	    int platums = 400;
	    
	    frame.setLayout(new FlowLayout());
	    frame.setResizable(false);
	    frame.setLocation(1920 / 2 - garums / 2, 1080 / 2 - platums / 2);
	    
	    frame.add(new JLabel(pizza_image)); // Att�ls
	    frame.add(jaunaisPasutijums); // Pasut�jums
	    jaunaisPasutijums.addActionListener(this);

	    frame.add(apskatitPasutijumus); // Apskat�t
	    apskatitPasutijumus.addActionListener(this);

	    frame.add(apturet); // Aptur�t
	    apturet.addActionListener(this);
	    
	    frame.setIconImage(pizza_logo.getImage());
	    frame.setSize(garums, platums);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	    
	    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
