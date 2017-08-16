package http.json.Frames;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import http.json.classes.Station;

public class FrameStations extends JFrame {

	public FrameStations(ArrayList<Station> data2) {
		super("Dostêpne stacje pomiarowe:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(784, 900);

		setLayout(new GridLayout());
		String[] columnNames = { "ID", "Nazwa", "Lat", "Lon", "m_ID", "Miasto", "Gmina", "Powiat", "Województwo",
				"Ulica" };

		Object[][] oData = new Object[data2.size()][data2.size()];
		for (int i = 0; i < data2.size(); i++) {
			oData[i][0] = data2.get(i).getId();
			oData[i][1] = data2.get(i).getStationName();
			oData[i][2] = data2.get(i).getGegrLat();
			oData[i][3] = data2.get(i).getGegrLon();
			oData[i][4] = data2.get(i).getCityId();
			oData[i][5] = data2.get(i).getCityName();
			oData[i][6] = data2.get(i).getCommuneName();
			oData[i][7] = data2.get(i).getDistrictName();
			oData[i][8] = data2.get(i).getProvinceName();
			oData[i][9] = data2.get(i).getAdressStreet();
		}

		if (!data2.isEmpty()) {
			JTable jData = new JTable(oData, columnNames);
			//jData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			add(new JScrollPane(jData, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		} else
			add(new JTextArea("Brak danych! Sprawdz LOGi"));

	}
}