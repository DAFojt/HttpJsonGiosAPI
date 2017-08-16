package http.json.tests;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONException;

import http.json.classes.Station;
import http.json.frames.FrameData;
import http.json.frames.FrameSensors;
import http.json.frames.FrameStations;
import http.json.giosAPI.Getter;

public class API_Test_MAIN {

	public static void main(String[] args) throws IOException, JSONException, InterruptedException {
		//Przyk³adowe wywo³anie pomiarów dla danej stacji pomiarowej:
		
		int station_Id = 1;
		int sensor_Id = -1;
		
		//Pobranie ArrayListy obiektów klas Station wszystkich stacji pomiarowych
		ArrayList<Station> allStations = Getter.getStationsArrayListByFindAll();
		Collections.sort(allStations);
		
		
		//Wybranie jednej z pobranych stacji pomiarowych o id z listy = 4
		//Station station = allStations.get(station_Id);
		
		//Pobranie wszystkich dostêpnych sensorów dla danej stacji pomiarowej
		//station.getAllSensorsByHttp();
		
		//Pobranie danych pomiarowych dla wybranego sensora wybranej stacji pomiarowej
		//station.getSensor(sensor_Id).getDataByHttp();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				//Wyœwietlenie wszystkich stacji pomiarowych w formie tabeli
				new FrameStations(allStations);
				
				//Wyœwietlenie wszystkich dostêpnych sensorów dla danej stacji pomiarowej
				//new FrameSensors(station.getSensors());
				
				//Wyœwietlenie wszystkich dostêpnych pomiarów dla wybranego sensora wybranej stacji pomiarowej
				//new FrameData(station.getSensor(sensor_Id).getData());
			}
		});
	}
}