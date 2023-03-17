import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pasutijums extends JFrame {

	  JTextField vards = new JTextField(20);
	  JTextField numurs = new JTextField(20);
	  JTextField adrese = new JTextField(25);
	  JCheckBox pasVeids = new JCheckBox("Saòemt us vietas");

	  JPanel ievadLodzini = new JPanel();
	  
	  JCheckBoxMenuItem pepperoni = new JCheckBoxMenuItem("Pepperoni");
	  JCheckBoxMenuItem studentu = new JCheckBoxMenuItem("Studentu");
	  JCheckBoxMenuItem salami = new JCheckBoxMenuItem("Salami");
	  JCheckBoxMenuItem hawaiian = new JCheckBoxMenuItem("Hawaiian");

	  
	public void veiktPasutijumu() {
		int garums = 750;
	    int platums = 400;
	    setLayout(null);
	    
	    ievadLodzini.setLayout(new GridLayout(6, 1));
	    ievadLodzini.add(new JLabel("Vârds")); // loga "nosaukums"
	    ievadLodzini.add(vards); // logs
	    ievadLodzini.add(new JLabel("Tâlr.nr."));
	    ievadLodzini.add(numurs);
	    ievadLodzini.add(new JLabel("Adrese"));
	    ievadLodzini.add(adrese);

	    JPanel panel1 = new JPanel();
	    panel1.setLayout(new FlowLayout());
	    panel1.add(ievadLodzini);
	    panel1.add(pasVeids);
	    panel1.setBounds(10, 10, 300, 300);


	    add(panel1);
	    
	    // ------------Picas izvçle

	    JPanel pizzaTypes = new JPanel();
	    pizzaTypes.setLayout(new GridLayout(5, 1));
	    pizzaTypes.add(new JLabel("Picas veids"));

	    
	    pizzaTypes.add(pepperoni); // pievienojam checkbox pie jpanel
	    pizzaTypes.add(studentu);
	    pizzaTypes.add(salami);
	    pizzaTypes.add(hawaiian);
	    pizzaTypes.setBounds(310, 20, 100, 100);
	    add(pizzaTypes); // pievienojam jpanel
	    
	    
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(garums, platums);
	    setLocation(1920 / 2 - garums / 2, 1080 / 2 - platums / 2);
	    
	    
	}

}
