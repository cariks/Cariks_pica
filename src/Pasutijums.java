import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Pasutijums extends JFrame implements ActionListener{

	  JTextField vards = new JTextField(20);
	  JTextField numurs = new JTextField(20);
	  JTextField adrese = new JTextField(25);
	  JCheckBox pasVeids = new JCheckBox("Sa�emt us vietas");

	  JPanel ievadLodzini = new JPanel();
	  
	  JCheckBoxMenuItem pepperoni = new JCheckBoxMenuItem("Pepperoni");
	  JCheckBoxMenuItem studentu = new JCheckBoxMenuItem("Studentu");
	  JCheckBoxMenuItem salami = new JCheckBoxMenuItem("Salami");
	  JCheckBoxMenuItem hawaiian = new JCheckBoxMenuItem("Hawaiian");
	  
	  JCheckBoxMenuItem bekons = new JCheckBoxMenuItem("Bekons");
	  JCheckBoxMenuItem senes = new JCheckBoxMenuItem("S�nes");
	  JCheckBoxMenuItem extraSiers = new JCheckBoxMenuItem("Extra Siers");
	  JCheckBoxMenuItem bbq = new JCheckBoxMenuItem("BBQ M�rce");
	  
	  JCheckBoxMenuItem cm20 = new JCheckBoxMenuItem("20 santimetri");
	  JCheckBoxMenuItem cm30 = new JCheckBoxMenuItem("30 santimetri");
	  JCheckBoxMenuItem cm40 = new JCheckBoxMenuItem("40 santimetri");
	  
	  int kopejasumma = 0;
	  JLabel labelsumma = new JLabel("summa: "+kopejasumma);
	  
	public void veiktPasutijumu() {
		int garums = 750;
	    int platums = 400;
	    setLayout(null);
	    
	    ievadLodzini.setLayout(new GridLayout(6, 1));
	    ievadLodzini.add(new JLabel("V�rds")); // loga "nosaukums"
	    ievadLodzini.add(vards); // logs
	    ievadLodzini.add(new JLabel("T�lr.nr."));
	    ievadLodzini.add(numurs);
	    ievadLodzini.add(new JLabel("Adrese"));
	    ievadLodzini.add(adrese);

	    JPanel panel1 = new JPanel();
	    panel1.setLayout(new FlowLayout());
	    panel1.add(ievadLodzini);
	    panel1.add(pasVeids);
	    panel1.setBounds(10, 10, 300, 300);


	    add(panel1);
	    
	    
	    // ------------Picas izv�le
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
	    
	    
	    //-------------Picas toppings izv�le
	    JPanel pizzaToppings = new JPanel();
	    pizzaToppings.setLayout(new GridLayout(5, 1));
	    pizzaToppings.add(new JLabel("Picas toppings"));

	    pizzaToppings.add(bekons);
	    pizzaToppings.add(senes);
	    pizzaToppings.add(extraSiers);
	    pizzaToppings.add(bbq);
	    pizzaToppings.setBounds(420, 20, 100, 100);
	    add(pizzaToppings);
	    
	    
	 // ------------Picas izm�ra izv�le
	    JPanel pizzaIzmers = new JPanel();
	    pizzaIzmers.setLayout(new FlowLayout());
	    pizzaIzmers.add(new JLabel("Picas izm�rs"));
	    ButtonGroup gp_cm = new ButtonGroup();

	    gp_cm.add(cm20);
	    gp_cm.add(cm30);
	    gp_cm.add(cm40);

	    pizzaIzmers.add(cm20);
	    pizzaIzmers.add(cm30);
	    pizzaIzmers.add(cm40);
	    pizzaIzmers.setBounds(560, 17, 100, 200);
	    add(pizzaIzmers);
	    
	    
	 // ------------Iesp�ja pievienot, dzest un apmaks�t picu
	    JPanel pievienotButton = new JPanel();

	    pievienotButton.setLayout(new FlowLayout(FlowLayout.LEFT));
	    pievienotButton.add(addPizza);
	    pievienotButton.add(dzest);
	    pievienotButton.add(apmaksat);
	    pievienotButton.setBounds(580, 200, 120, 120);
	    add(pievienotButton);
	    
	    
	 // -------------Pievienots JTabel
	    String[] rindas_n = { "sa�emt uz vietas", "v�rds", "t.numurs", "adrese", "p.veids", "p.toppings", "p.izm�rs" };
	    String[][] kolonnas = {{}, {}, {}, {}, {}, {}, {}, {}, {} };
	    DefaultTableModel dtm = new DefaultTableModel(kolonnas, rindas_n);
	    table.setModel(dtm);
	    JScrollPane sp = new JScrollPane(table);
	    sp.setViewportView(table);
	    sp.setBounds(50, 180, 510, 160);
	    add(sp);

	    
	    //-------------Pasutijums loga iestat�jumi
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(garums, platums);
	    setLocation(1920 / 2 - garums / 2, 1080 / 2 - platums / 2);
	    
	    
	}
	
	JButton dzest = new JButton("Dz�st picu");
	JButton apmaksat = new JButton("Apmaks�t");
	JButton addPizza = new JButton("Pievienot picu");
	JTable table = new JTable();
	
	int i = 0;


	@Override
	public void actionPerformed(ActionEvent e) {

		//--------------Parbaud��ana
		if (e.getSource() == pasVeids) {
		      if (pasVeids.isSelected()) {
		        ievadLodzini.setVisible(false); // "uz�emt uz vietas" ir nospiests
		      } else {
		        ievadLodzini.setVisible(true); // "uz�emt uz vietas" nav nospiests
		      }
		    }
		
		//--------------Apmaks�t
		if(e.getSource( ) == apmaksat ){
		      
		      JOptionPane.showMessageDialog(null, "Picas ir apmaks�tas");
		    }
		
		//--------------Pievienot picu
		if (e.getSource() == addPizza) {
			
			
		boolean kluda = false;
		
		table.setValueAt(pasVeids.isSelected(), i, 0);
    	int summa = 0;
    	if(!pasVeids.isSelected()) {
    		summa+=3;
    		
    		//--------------V�rda parbaud��ana
    		if (vards.getText().length() > 0)
     		   table.setValueAt(vards.getText(), i, 1);
     		else {
     			JOptionPane.showMessageDialog(null, "Vards nav ierakstits!", "K��da", JOptionPane.ERROR_MESSAGE);
     			for (int j = 0; j < 7; j++) {
     				table.setValueAt(" ", i, j);
     				}
     			kluda = true;
     			}
    		
    		//--------------Numura parbaud��ana
    		if (numurs.getText().length() > 0 && !kluda)
    			table.setValueAt(numurs.getText(), i, 2);
    		else {
    			JOptionPane.showMessageDialog(null, "Numurs nav ierakstits!", "K��da", JOptionPane.ERROR_MESSAGE);
    			for (int j = 0; j < 7; j++) {
    				table.setValueAt(" ", i, j);
    				}
    			kluda = true;
    			}
    		
    		//--------------Adrese parbaud��ana
    		if (adrese.getText().length() > 0 && !kluda)
    			table.setValueAt(adrese.getText(), i, 3);
    		else {
    			JOptionPane.showMessageDialog(null, "Adrese nav ierakstita!", "K��da", JOptionPane.ERROR_MESSAGE);
    			for (int j = 0; j < 7; j++) {
    				table.setValueAt(" ", i, j);
    				}
    			kluda = true;
    			}
    		}
    	
    	//--------------Picas parbaud��ana
    	if (pepperoni.isSelected() && !kluda) {
    		table.setValueAt("Pepperoni", i, 4);
    		summa+=7;
    		
    	} else if (studentu.isSelected() && !kluda) {
    		table.setValueAt("Studentu", i, 4);
    		summa+=6;
    			
    	} else if (salami.isSelected()&& !kluda) {
    		table.setValueAt("Salami", i, 4);
    		summa+=7;
    		
    	} else if (hawaiian.isSelected()&& !kluda) {
    		table.setValueAt("Hawaiian", i, 4);
    		summa+=7;
    		
    	} else {
    		JOptionPane.showMessageDialog(null, "Pica nav izv�l�ta", "K��da", JOptionPane.ERROR_MESSAGE);
    		for (int j = 0; j < 7; j++) {
    			table.setValueAt(" ", i, j);
    		}
        kluda = true;
      }
    	
    	//--------------Toppinga parbaud��ana
    	String str = "";
        if (bekons.isSelected()&& !kluda) {
          str += "bekons, ";
          summa+=2;
        }
        if (extraSiers.isSelected()&& !kluda) {
          str += "extra siers, ";
          summa+=2;
        }
        if (senes.isSelected()&& !kluda) {
          str += "s�nes, ";
          summa+=2;
        }
        if (bbq.isSelected()&& !kluda) {
          str += "BBQ m�rce, ";
          summa+=1;
        }
        table.setValueAt(str, i, 5);
        
        //--------------Picas izm�ra parbaud��ana
        if (cm20.isSelected()&& !kluda) {
            table.setValueAt("20 cm", i, 6);
            summa+=0;
          } else if (cm30.isSelected()&& !kluda) {
            table.setValueAt("30 cm", i, 6);
            summa+=2;
          } else if (cm40.isSelected()&& !kluda) {
            table.setValueAt("40 cm", i, 6);
            summa+=4;
          } else {
            JOptionPane.showMessageDialog(null, "Izm�rs nav izv�l�ts", "K��da", JOptionPane.ERROR_MESSAGE);
            for (int j = 0; j < 7; j++) {
              table.setValueAt(" ", i, j);
            }
            kluda = true;
          }//esli vsjo pravilno to v kopejasumma dobavlajetsa summa i menjaetsa summas tekst
        
        
        //--------------Kop�j�s summas apre�in��ana un pievieno�ana
        if (!kluda) {
      	  i++;
      	  kopejasumma+=summa;
      	  labelsumma.setText("Summa: "+kopejasumma);
        }
      }
	
	//-----------------Rindas dz��ana
    if (e.getSource() == dzest) {
    	
    	
    }
  }
}


