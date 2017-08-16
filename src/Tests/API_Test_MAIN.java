package Tests;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONException;

import Classes.Station;
import http.json.Frames.FrameData;
import http.json.Frames.FrameSensors;
import http.json.Frames.FrameStations;
import http.json.GiosAPI.Getter;

public class API_Test_MAIN {

	public static void main(String[] args) throws IOException, JSONException, InterruptedException {
		//Przyk³adowe wywo³anie pomiarów dla danej stacji pomiarowej:
		
		//Pobranie ArrayListy obiektów klas Station wszystkich stacji pomiarowych
		ArrayList<Station> allStations = Getter.getStationsArrayListByFindAll();
		Collections.sort(allStations);
		
		
		//Wybranie jednej z pobranych stacji pomiarowych o id z listy = 4
		Station station = allStations.get(4);
		
		//Pobranie wszystkich dostêpnych sensorów dla danej stacji pomiarowej
		station.getAllSensorsByHttp();
		
		//Pobranie danych pomiarowych dla wybranego sensora wybranej stacji pomiarowej
		station.getSensor(2).getDataByHttp();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				//Wyœwietlenie wszystkich stacji pomiarowych w formie tabeli
				new FrameStations(allStations);
				
				//Wyœwietlenie wszystkich dostêpnych sensorów dla danej stacji pomiarowej
				new FrameSensors(station.getSensors());
				
				//Wyœwietlenie wszystkich dostêpnych pomiarów dla wybranego sensora wybranej stacji pomiarowej
				new FrameData(station.getSensor(2).getData());	
			}
		});
	}
}