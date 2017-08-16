package http.json.nbp;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

public class HttpJsonGios {

	public static void main(String[] args) throws IOException, JSONException, InterruptedException {


		//ArrayList<String[]> data = getByDataId.getArrayListById(92);
		ArrayList<Station> allStations = getByFindAll.getArrayListByFindAll();
		

		//for(int i = 0 ; i < data2.size() ; i++)
		//{
				//data2.get(i).getAllSensorsByHttp();
		//}
		
		Station station = allStations.get(1);
		station.getAllSensorsByHttp();
		station.getSensor(2).getDataByHttp();
		
		
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FrameByFindAll(allStations);
				new FrameById(station.getSensor(2).getData());	
			}
		});
	}
}