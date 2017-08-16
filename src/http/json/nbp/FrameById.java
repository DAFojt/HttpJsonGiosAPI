package http.json.nbp;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class FrameById extends JFrame {

	public FrameById(ArrayList<String[]> data) {
		super("Pomiary:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 300);

		setLayout(new GridLayout());
		String[] columnNames = { "Data", data.get(data.size()-1)[1]};

		Object[][] oData = new Object[data.size()][2];
		for (int i = 0; i < data.size()-1; i++) {
			oData[i][0] = data.get(i)[0];
			oData[i][1] = data.get(i)[1];
		}
		
		
		
		if (!data.isEmpty()) {
			JTable jData = new JTable(oData, columnNames);
			//jData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			add(new JScrollPane(jData, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		} else
			add(new JTextArea("Brak danych! Sprawdz LOGi"));

		
		
	}
}