package http.json.GiosAPI;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

public class HttpJsonGios {

	public static void main(String[] args) throws IOException, JSONException, InterruptedException {

		//Przykładowe wywołanie pomiarów dla danej stacji pomiarowej:
		
		
		
		
		//Pobranie ArrayListy obiektów klas Station wszystkich stacji pomiarowych
		ArrayList<Station> allStations = GetByFindAll.getArrayListByFindAll();
		
		//Wybranie jednej z pobranych stacji pomiarowych od id = 1
		Station station = allStations.get(1);
		
		//Pobranie wszystkich dostępnych sensorów dla danej stacji pomiarowej
		station.getAllSensorsByHttp();
		
		//Pobranie danych pomiarowych dla wybranego sensora wybranej stacji pomiarowej
		station.getSensor(2).getDataByHttp();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				//Wyświetlenie wszystkich stacji pomiarowych w formie tabeli
				new FrameStations(allStations);
				
				//Wyświetlenie wszystkich dostępnych sensorów dla danej stacji pomiarowej
				new FrameSensors(station.getSensors());
				
				//Wyświetlenie wszystkich dostępnych pomiarów dla wybranego sensora wybranej stacji pomiarowej
				new FrameData(station.getSensor(2).getData());	
			}
		});
	}
}