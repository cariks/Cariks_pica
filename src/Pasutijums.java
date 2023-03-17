import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
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
	  
	  JCheckBoxMenuItem bekons = new JCheckBoxMenuItem("Bekons");
	  JCheckBoxMenuItem senes = new JCheckBoxMenuItem("Sçnes");
	  JCheckBoxMenuItem extraSiers = new JCheckBoxMenuItem("Extra Siers");
	  JCheckBoxMenuItem bbq = new JCheckBoxMenuItem("BBQ Mçrce");
	  
	  JCheckBoxMenuItem cm20 = new JCheckBoxMenuItem("20 santimetri");
	  JCheckBoxMenuItem cm30 = new JCheckBoxMenuItem("30 santimetri");
	  JCheckBoxMenuItem cm40 = new JCheckBoxMenuItem("40 santimetri");

	  
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
	    
	    ButtonGroup gp_type = new ButtonGroup(); // picas veidi grupa
	    gp_type.add(pepperoni);
	    gp_type.add(studentu);
	    gp_type.add(salami);
	    gp_type.add(hawaiian);
	    
	    pizzaTypes.add(pepperoni); // pievienojam checkbox pie jpanel
	    pizzaTypes.add(studentu);
	    pizzaTypes.add(salami);
	    pizzaTypes.add(hawaiian);
	    pizzaTypes.setBounds(310, 20, 100, 100);
	    add(pizzaTypes); // pievienojam jpanel
	    
	    //-------------Picas toppings izvçle
	    JPanel pizzaToppings = new JPanel();
	    pizzaToppings.setLayout(new GridLayout(5, 1));
	    pizzaToppings.add(new JLabel("Picas toppings"));

	    pizzaToppings.add(bekons);
	    pizzaToppings.add(senes);
	    pizzaToppings.add(extraSiers);
	    pizzaToppings.add(bbq);
	    pizzaToppings.setBounds(420, 20, 100, 100);
	    add(pizzaToppings);
	    
	 // ------------Picas izmçra izvçle
	    JPanel pizzaIzmers = new JPanel();
	    pizzaIzmers.setLayout(new FlowLayout());
	    pizzaIzmers.add(new JLabel("Picas izmçrs"));
	    ButtonGroup gp_cm = new ButtonGroup();

	    gp_cm.add(cm20);
	    gp_cm.add(cm30);
	    gp_cm.add(cm40);

	    pizzaIzmers.add(cm20);
	    pizzaIzmers.add(cm30);
	    pizzaIzmers.add(cm40);
	    pizzaIzmers.setBounds(560, 17, 100, 200);
	    add(pizzaIzmers);

	    
	    //-------------Pasutijums loga iestatîjumi
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(garums, platums);
	    setLocation(1920 / 2 - garums / 2, 1080 / 2 - platums / 2);
	    
	    
	}

}
