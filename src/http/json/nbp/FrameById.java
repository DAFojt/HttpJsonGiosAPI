package http.json.nbp;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class FrameById extends JFrame {

    public FrameById(ArrayList<String[]> data) {
        super("Pomiary:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 300);
        
        setLayout(new GridLayout());
        String[] columnNames = {"Data", "Pomiar"};
        
        Object[][] oData = new Object[data.size()][2];
        for(int i = 0 ; i < data.size() ; i ++)
        {
        	oData[i][0] = data.get(i)[0];
        	oData[i][1] = data.get(i)[1];
        }
        if(!data.isEmpty())
		add(new JTable(oData, columnNames));
        else
        add(new JTextArea("Brak danych! Sprawdz LOGi"));
    }
}