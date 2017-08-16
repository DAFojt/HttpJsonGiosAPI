package http.json.GiosAPI;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

public class HttpJsonGios {

	public static void main(String[] args) throws IOException, JSONException, InterruptedException {

		//Przyk�adowe wywo�anie pomiar�w dla danej stacji pomiarowej:
		
		
		
		
		//Pobranie ArrayListy obiekt�w klas Station wszystkich stacji pomiarowych
		ArrayList<Station> allStations = GetByFindAll.getArrayListByFindAll();
		
		//Wybranie jednej z pobranych stacji pomiarowych od id = 1
		Station station = allStations.get(1);
		
		//Pobranie wszystkich dost�pnych sensor�w dla danej stacji pomiarowej
		station.getAllSensorsByHttp();
		
		//Pobranie danych pomiarowych dla wybranego sensora wybranej stacji pomiarowej
		station.getSensor(2).getDataByHttp();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				//Wy�wietlenie wszystkich stacji pomiarowych w formie tabeli
				new FrameStations(allStations);
				
				//Wy�wietlenie wszystkich dost�pnych sensor�w dla danej stacji pomiarowej
				new FrameSensors(station.getSensors());
				
				//Wy�wietlenie wszystkich dost�pnych pomiar�w dla wybranego sensora wybranej stacji pomiarowej
				new FrameData(station.getSensor(2).getData());	
			}
		});
	}
}