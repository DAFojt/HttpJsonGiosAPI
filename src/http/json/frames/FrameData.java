package http.json.frames;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class FrameData extends JFrame {
	public FrameData(ArrayList<String[]> data) {
		super("Pomiary:");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(300, 300);

		setLayout(new GridLayout());
		if ((data != null) && (!data.isEmpty())) {
			String[] columnNames = { "Data", data.get(data.size() - 1)[1] };

			Object[][] oData = new Object[data.size()][2];
			for (int i = 0; i < data.size() - 1; i++) {
				oData[i][0] = data.get(i)[0];
				oData[i][1] = data.get(i)[1];
			}

			
				JTable jData = new JTable(oData, columnNames);
				// jData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				add(new JScrollPane(jData, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		}
		else
			add(new JTextArea("Brak danych! Sprawdz LOGi"));
	}
}