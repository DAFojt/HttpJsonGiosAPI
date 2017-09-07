package http.json.frames;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import org.json.JSONException;

import http.json.classes.Sensor;
import http.json.classes.Station;
import http.json.giosAPI.Getter;

public class FrameSensors extends JFrame {

	JTable jData;

	public FrameSensors(ArrayList<Sensor> data2) {
		super("Dostępne sensory pomiarowe:");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(600, 180);

		setLayout(new GridLayout());
		String[] columnNames = { "ID", "IDStacji", "Nazwa parametru", "Parametr", "kod", "IDParametru" };

		if (data2.size() > 1) {
			Object[][] oData = new Object[data2.size()][6];
			for (int i = 0; i < data2.size(); i++) {
				oData[i][0] = data2.get(i).getId();
				oData[i][1] = data2.get(i).getStationId();
				oData[i][2] = data2.get(i).getParamName();
				oData[i][3] = data2.get(i).getParamFormula();
				oData[i][4] = data2.get(i).getParamName();
				oData[i][5] = data2.get(i).getIdParam();
			}

			jData = new JTable(oData, columnNames);

			add(new JScrollPane(jData, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		} else
			add(new JTextArea("Brak danych! Sprawdz LOGi"));

		jData.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = jData.rowAtPoint(evt.getPoint());
				int col = jData.columnAtPoint(evt.getPoint());

				if (row >= 0 && col >= 0) {

					try {
						data2.get(row).getDataByHttp();
						new FrameData(data2.get(row).getData());
					} catch (IOException | JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
	}
}
