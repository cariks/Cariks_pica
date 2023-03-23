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
	  JCheckBox pasVeids = new JCheckBox("Sa�emt us vietas");

	  JPanel ievadLodzini = new JPanel();
	  
	  JCheckBoxMenuItem pepperoni = new JCheckBoxMenuItem("Pepperoni - 7eur");
	  JCheckBoxMenuItem studentu = new JCheckBoxMenuItem("Studentu - 6eur");
	  JCheckBoxMenuItem salami = new JCheckBoxMenuItem("Salami - 7eur");
	  JCheckBoxMenuItem hawaiian = new JCheckBoxMenuItem("Hawaiian - 7eur");
	  
	  JCheckBoxMenuItem bekons = new JCheckBoxMenuItem("Bekons +2eur");
	  JCheckBoxMenuItem senes = new JCheckBoxMenuItem("S�nes +2eur");
	  JCheckBoxMenuItem extraSiers = new JCheckBoxMenuItem("Extra Siers +2eur");
	  JCheckBoxMenuItem bbq = new JCheckBoxMenuItem("BBQ M�rce +1eur");
	  
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
	    ievadLodzini.add(new JLabel("(Pieg�de +3 euro)"));
	    ievadLodzini.add(new JLabel("V�rds"));
	    ievadLodzini.add(vards);
	    ievadLodzini.add(new JLabel("T�lr.nr."));
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
	    
	    
	    // ------------Picas izv�le
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
	    
	    
	    //-------------Picas toppings izv�le
	    JPanel pizzaToppings = new JPanel();
	    pizzaToppings.setLayout(new GridLayout(5, 1));
	    pizzaToppings.add(new JLabel("Picas toppings"));

	    pizzaToppings.add(bekons);
	    pizzaToppings.add(senes);
	    pizzaToppings.add(extraSiers);
	    pizzaToppings.add(bbq);
	    pizzaToppings.setBounds(470, 20, 130, 100);
	    add(pizzaToppings);
	    
	    
	 // ------------Picas izm�ra izv�le
	    JPanel pizzaIzmers = new JPanel();
	    pizzaIzmers.setLayout(new FlowLayout(FlowLayout.LEFT));
	    pizzaIzmers.add(new JLabel("Picas izm�rs"));
	    ButtonGroup gp_cm = new ButtonGroup();

	    gp_cm.add(cm20);
	    gp_cm.add(cm30);
	    gp_cm.add(cm40);

	    pizzaIzmers.add(cm20);
	    pizzaIzmers.add(cm30);
	    pizzaIzmers.add(cm40);
	    pizzaIzmers.setBounds(600, 17, 150, 200);
	    add(pizzaIzmers);
	    
	    
	 // ------------Iesp�ja pievienot, dzest un apmaks�t picu
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
	    String[] rindas_n = { "sa�emt uz vietas", "v�rds", "t.numurs", "adrese", "p.veids", "p.toppings", "p.izm�rs" };
	    kolonnas = new String[rowCount][rindas_n.length];
	    dtm = new DefaultTableModel(kolonnas, rindas_n);
	    table.setModel(dtm);
	    JScrollPane sp = new JScrollPane(table);
	    sp.setViewportView(table);
	    sp.setBounds(50, 190, 510, 160);
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
		    	  wr.println("V�rds: "+((String)table.getValueAt(k,1))
		    			  +"\nNumurs: "+(String)table.getValueAt(k,2)
		    			  +"\nAdrese: "+(String)table.getValueAt(k,3)
		                  +"\nPicas: "+(String)table.getValueAt(k,4)
		                  +"\nToppings: "+(String)table.getValueAt(k,5)
		                  +"\nIzm�rs: "+(String)table.getValueAt(k,6)+""
		                  +"\n"+labelsumma.getText()+"�\n"
		                  +"--------------------------------\n");			
		    	  }
		      wr.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "K�uda", "K��da", JOptionPane.ERROR_MESSAGE);
		}
	}
	
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
			this.dispose();
			
			PizzaOrderingSystem obj = new PizzaOrderingSystem();
			obj.newFrame();
			writeFile();
			new ApskatitFailu();
			JOptionPane.showMessageDialog(null, "Picas ir apmaks�tas");
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
    		
    		//--------------V�rda p�rbaud��ana
    		if (vards.getText().length() > 0)
     		   table.setValueAt(vards.getText(), i, 1);
     		else {
     			JOptionPane.showMessageDialog(null, "Vards nav ierakstits!", "K��da", JOptionPane.ERROR_MESSAGE);
     			for (int j = 0; j < 7; j++) {
     				table.setValueAt(" ", i, j);
     				}
     			kluda = true;
     			}
    		
    		//--------------Numura p�rbaud��ana
    		if (numurs.getText().length() > 0 && !kluda)
    			table.setValueAt(numurs.getText(), i, 2);
    		else {
    			JOptionPane.showMessageDialog(null, "Numurs nav ierakstits!", "K��da", JOptionPane.ERROR_MESSAGE);
    			for (int j = 0; j < 7; j++) {
    				table.setValueAt(" ", i, j);
    				}
    			kluda = true;
    			}
    		
    		//--------------Adrese p�rbaud��ana
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
    	
    	//--------------Picas p�rbaud��ana
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
    	
    	//--------------Toppinga p�rbaud��ana
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
        
        //--------------Picas izm�ra p�rbaud��ana
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
          }
        
        
        //--------------Kop�j�s summas apre�in��ana un pievieno�ana
        if (!kluda) {
      	  i++;
      	  kopejasumma+=summa;
      	  labelsumma.setText("Summa: "+kopejasumma);
        }
      }
	
	//-----------------Rindas dz��ana
		if (e.getSource() == dzest) {
			try{
				int rowIndex = Integer.parseInt(JOptionPane.showInputDialog("Ievadi rindas k�rtas numuru, kuru j�nodz��:"));
		    	rowIndex--;
		    	dtm.removeRow(rowIndex);
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "K�uda", "K��da", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	//------------------JTable jaunu rindu pievieno�ana
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
