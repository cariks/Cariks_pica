import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;

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

	  String[][] kolonnas;
	  DefaultTableModel dtm;
	  JTextField vards = new JTextField(20);
	  JTextField numurs = new JTextField(20);
	  JTextField adrese = new JTextField(25);
	  JCheckBox pasVeids = new JCheckBox("Saòemt us vietas");

	  JPanel ievadLodzini = new JPanel();
	  
	  JCheckBoxMenuItem pepperoni = new JCheckBoxMenuItem("Pepperoni - 7eur");
	  JCheckBoxMenuItem studentu = new JCheckBoxMenuItem("Studentu - 6eur");
	  JCheckBoxMenuItem salami = new JCheckBoxMenuItem("Salami - 7eur");
	  JCheckBoxMenuItem hawaiian = new JCheckBoxMenuItem("Hawaiian - 7eur");
	  
	  JCheckBoxMenuItem bekons = new JCheckBoxMenuItem("Bekons +2eur");
	  JCheckBoxMenuItem senes = new JCheckBoxMenuItem("Sçnes +2eur");
	  JCheckBoxMenuItem extraSiers = new JCheckBoxMenuItem("Extra Siers +2eur");
	  JCheckBoxMenuItem bbq = new JCheckBoxMenuItem("BBQ Mçrce +1eur");
	  
	  JCheckBoxMenuItem cm20 = new JCheckBoxMenuItem("20 santimetri");
	  JCheckBoxMenuItem cm30 = new JCheckBoxMenuItem("30 santimetri +2eur");
	  JCheckBoxMenuItem cm40 = new JCheckBoxMenuItem("40 santimetri +4eur");
	  
	  int kopejasumma = 0;
	  JLabel labelsumma = new JLabel("summa: "+kopejasumma);
	  
	public void veiktPasutijumu() {
		int garums = 800;
	    int platums = 400;
	    setLayout(null);
	    
	    ievadLodzini.setLayout(new GridLayout(7, 1));
	    ievadLodzini.add(new JLabel("(Piegâde +3 euro)"));
	    ievadLodzini.add(new JLabel("Vârds"));
	    ievadLodzini.add(vards);
	    ievadLodzini.add(new JLabel("Tâlr.nr."));
	    ievadLodzini.add(numurs);
	    ievadLodzini.add(new JLabel("Adrese"));
	    ievadLodzini.add(adrese);

	    JPanel panel1 = new JPanel();
	    panel1.setLayout(new FlowLayout());
	    panel1.add(ievadLodzini);
	    panel1.add(pasVeids);
	    panel1.setBounds(10, 10, 330, 300);
	    pasVeids.addActionListener(this);


	    add(panel1);
	    
	    
	    // ------------Picas izvçle
	    JPanel pizzaTypes = new JPanel();
	    pizzaTypes.setLayout(new GridLayout(5, 1));
	    pizzaTypes.add(new JLabel("Picas veids"));
	    
	    ButtonGroup gp_type = new ButtonGroup();
	    gp_type.add(pepperoni);
	    gp_type.add(studentu);
	    gp_type.add(salami);
	    gp_type.add(hawaiian);
	    
	    pizzaTypes.add(pepperoni);
	    pizzaTypes.add(studentu);
	    pizzaTypes.add(salami);
	    pizzaTypes.add(hawaiian);
	    pizzaTypes.setBounds(340, 20, 130, 100);
	    add(pizzaTypes);
	    
	    
	    //-------------Picas toppings izvçle
	    JPanel pizzaToppings = new JPanel();
	    pizzaToppings.setLayout(new GridLayout(5, 1));
	    pizzaToppings.add(new JLabel("Picas toppings"));

	    pizzaToppings.add(bekons);
	    pizzaToppings.add(senes);
	    pizzaToppings.add(extraSiers);
	    pizzaToppings.add(bbq);
	    pizzaToppings.setBounds(470, 20, 130, 100);
	    add(pizzaToppings);
	    
	    
	 // ------------Picas izmçra izvçle
	    JPanel pizzaIzmers = new JPanel();
	    pizzaIzmers.setLayout(new FlowLayout(FlowLayout.LEFT));
	    pizzaIzmers.add(new JLabel("Picas izmçrs"));
	    ButtonGroup gp_cm = new ButtonGroup();

	    gp_cm.add(cm20);
	    gp_cm.add(cm30);
	    gp_cm.add(cm40);

	    pizzaIzmers.add(cm20);
	    pizzaIzmers.add(cm30);
	    pizzaIzmers.add(cm40);
	    pizzaIzmers.setBounds(600, 17, 150, 200);
	    add(pizzaIzmers);
	    
	    
	 // ------------Iespçja pievienot, dzest un apmaksât picu
	    JPanel pievienotButton = new JPanel();

	    pievienotButton.setLayout(new FlowLayout(FlowLayout.LEFT));
	    pievienotButton.add(addPizza);
	    pievienotButton.add(dzest);
	    pievienotButton.add(apmaksat);
	    pievienotButton.add(labelsumma);
	    pievienotButton.setBounds(580, 200, 120, 120);
	    add(pievienotButton);
	    addPizza.addActionListener(this);
	    apmaksat.addActionListener(this);
	    dzest.addActionListener(this);
	    
	    
	 // -------------Pievienots JTabel
	    String[] rindas_n = { "saòemt uz vietas", "vârds", "t.numurs", "adrese", "p.veids", "p.toppings", "p.izmçrs" };
	    kolonnas = new String[rowCount][rindas_n.length];
	    dtm = new DefaultTableModel(kolonnas, rindas_n);
	    table.setModel(dtm);
	    JScrollPane sp = new JScrollPane(table);
	    sp.setViewportView(table);
	    sp.setBounds(50, 190, 510, 160);
	    add(sp);

	    
	    //-------------Pasutijums loga iestatîjumi
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(garums, platums);
	    setLocation(1920 / 2 - garums / 2, 1080 / 2 - platums / 2);
	}
	
	JButton dzest = new JButton("Dzçst picu");
	JButton apmaksat = new JButton("Apmaksât");
	JButton addPizza = new JButton("Pievienot picu");
	JTable table = new JTable();
	
	int i = 0;
	int rowCount = 3;

	public void writeFile(){
		try{
			FileWriter fw = new FileWriter("maksajums.txt", true);
			PrintWriter wr = new PrintWriter(fw);
			int j = 0;
			String str = null;
			do{
				if(table.getValueAt(j, 2)!=null){
					j++;
				}
			}while(table.getValueAt(j, 2)!=null);
		      for(int k = 0; k<j; k++){
		    	  wr.println("Vârds: "+((String)table.getValueAt(k,1))
		    			  +"\nNumurs: "+(String)table.getValueAt(k,2)
		    			  +"\nAdrese: "+(String)table.getValueAt(k,3)
		                  +"\nPicas: "+(String)table.getValueAt(k,4)
		                  +"\nToppings: "+(String)table.getValueAt(k,5)
		                  +"\nIzmçrs: "+(String)table.getValueAt(k,6)+""
		                  +"\n"+labelsumma.getText()+"€\n"
		                  +"--------------------------------\n");			
		    	  }
		      wr.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kïuda", "Kïûda", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		//--------------Parbaudîðana
		if (e.getSource() == pasVeids) {
		      if (pasVeids.isSelected()) {
		        ievadLodzini.setVisible(false); // "uzòemt uz vietas" ir nospiests
		      } else {
		        ievadLodzini.setVisible(true); // "uzòemt uz vietas" nav nospiests
		      }
		    }
		
		//--------------Apmaksât
		if(e.getSource( ) == apmaksat ){
			this.dispose();
			
			PizzaOrderingSystem obj = new PizzaOrderingSystem();
			obj.newFrame();
			writeFile();
			new ApskatitFailu();
			JOptionPane.showMessageDialog(null, "Picas ir apmaksâtas");
		}
		
		//--------------Pievienot picu
		if (e.getSource() == addPizza) {
			if(i>=3) {
	    		rowCount++;
	    		String[][] newRow = new String[rowCount][7];
	    		newRow = swapArray(newRow, kolonnas);
	    		dtm.addRow(newRow);
	    	}
		boolean kluda = false;
		
		table.setValueAt(pasVeids.isSelected(), i, 0);
    	int summa = 0;
    	if(!pasVeids.isSelected()) {
    		summa+=3;
    		
    		//--------------Vârda pârbaudîðana
    		if (vards.getText().length() > 0)
     		   table.setValueAt(vards.getText(), i, 1);
     		else {
     			JOptionPane.showMessageDialog(null, "Vards nav ierakstits!", "Kïûda", JOptionPane.ERROR_MESSAGE);
     			for (int j = 0; j < 7; j++) {
     				table.setValueAt(" ", i, j);
     				}
     			kluda = true;
     			}
    		
    		//--------------Numura pârbaudîðana
    		if (numurs.getText().length() > 0 && !kluda)
    			table.setValueAt(numurs.getText(), i, 2);
    		else {
    			JOptionPane.showMessageDialog(null, "Numurs nav ierakstits!", "Kïûda", JOptionPane.ERROR_MESSAGE);
    			for (int j = 0; j < 7; j++) {
    				table.setValueAt(" ", i, j);
    				}
    			kluda = true;
    			}
    		
    		//--------------Adrese pârbaudîðana
    		if (adrese.getText().length() > 0 && !kluda)
    			table.setValueAt(adrese.getText(), i, 3);
    		else {
    			JOptionPane.showMessageDialog(null, "Adrese nav ierakstita!", "Kïûda", JOptionPane.ERROR_MESSAGE);
    			for (int j = 0; j < 7; j++) {
    				table.setValueAt(" ", i, j);
    				}
    			kluda = true;
    			}
    		}
    	
    	//--------------Picas pârbaudîðana
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
    		JOptionPane.showMessageDialog(null, "Pica nav izvçlçta", "Kïûda", JOptionPane.ERROR_MESSAGE);
    		for (int j = 0; j < 7; j++) {
    			table.setValueAt(" ", i, j);
    		}
        kluda = true;
      }
    	
    	//--------------Toppinga pârbaudîðana
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
          str += "sçnes, ";
          summa+=2;
        }
        if (bbq.isSelected()&& !kluda) {
          str += "BBQ mçrce, ";
          summa+=1;
        }
        table.setValueAt(str, i, 5);
        
        //--------------Picas izmçra pârbaudîðana
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
            JOptionPane.showMessageDialog(null, "Izmçrs nav izvçlçts", "Kïûda", JOptionPane.ERROR_MESSAGE);
            for (int j = 0; j < 7; j++) {
              table.setValueAt(" ", i, j);
            }
            kluda = true;
          }
        
        
        //--------------Kopçjâs summas apreíinâðana un pievienoðana
        if (!kluda) {
      	  i++;
      	  kopejasumma+=summa;
      	  labelsumma.setText("Summa: "+kopejasumma);
        }
      }
	
	//-----------------Rindas dzçðana
		if (e.getSource() == dzest) {
			try{
				int rowIndex = Integer.parseInt(JOptionPane.showInputDialog("Ievadi rindas kârtas numuru, kuru jânodzçð:"));
		    	rowIndex--;
		    	dtm.removeRow(rowIndex);
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "Kïuda", "Kïûda", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	//------------------JTable jaunu rindu pievienoðana
	String[][] swapArray(String[][] a, String[][] b) {
		String[] temp = new String[a.length*a[0].length];
		 int counter = 0;
		 for(int i = 0; i<b.length; i++) {
			 for(int j=0; j<b[i].length; j++) {
				 temp[counter] = b[i][j];
				 counter++;
				 }
			 }
		 counter = 0;
		 for(int i = 0; i<a.length; i++) {
			 for(int j = 0; j<a[i].length; j++) {
				 if(counter+1<temp.length) {
					 a[i][j] = temp[counter];
					 counter++;				 
					 }
				 }
			 }
		 return a;
		 }
}
