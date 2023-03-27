import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ApskatitFailu extends JFrame{
    public ApskatitFailu() {
        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        JPanel panel = new JPanel();
        int platums = 700;
        int garums = 500;
        panel.setLayout(null);
        scroll.setBounds(50, 50, 400, 550);
        panel.add(scroll);
        try {
              FileReader fr = new FileReader("maksajums.txt");
              BufferedReader reader = new BufferedReader(fr);

              String line, str = "";
              while ((line = reader.readLine()) != null) {	
              str += line + "\n";
              }
              area.setText(str);
              reader.close();
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Kïuda");
            }

        add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(garums, platums);
        setLocation(1920 / 2 - garums / 2, 1080 / 2 - platums / 2);
        setVisible(true);
    }
}