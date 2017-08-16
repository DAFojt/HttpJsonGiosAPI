package http.json.GiosAPI;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetBySensorId {

	public static ArrayList<Sensor> getArrayListById(int id) throws IOException, JSONException {
		ReadJsonFromURL jsonReader = new ReadJsonFromURL();

		ArrayList<Sensor> data = new ArrayList<Sensor>();
		String API_URL = "http://api.gios.gov.pl/pjp-api/rest/station/sensors/" + id;
		JSONArray json = ReadJsonFromURL.readJsonArrayFromUrl(API_URL);

		//System.out.println(json.toString());

		for (int i = 0; i < json.length(); i++) {
			try {
				JSONObject json2 = json.getJSONObject(i);
				JSONObject json3 = null;

				try {
					json3 = json2.getJSONObject("param");
				} catch (JSONException e) {
					System.out.println("B£¥D PRZY TWORZENIU SENSORA NR: " + i + " przy tworzeniu parametrów");
					continue;
				}

				Sensor sensor = new Sensor(!json2.isNull("id") ? json2.getInt("id") : -1,
						!json2.isNull("stationId") ? json2.getInt("stationId") : -1,
						!json3.isNull("paramName") ? json3.getString("paramName") : "NULL",
						!json3.isNull("paramFormula") ? json3.getString("paramFormula") : "NULL",
						!json3.isNull("paramCode") ? json3.getString("paramCode") : "NULL",
						!json3.isNull("idParam") ? json3.getInt("idParam") : -1);
				
						data.add(sensor);
						
				System.out.println(
						"Stworzono sensor o id: " + sensor.getId() + " dla stacji o id: " + sensor.getStationId());
			} catch (JSONException e) {
				System.out.println("B£¥D PRZY TWORZENIU OBIEKTU SENSORA NR: " + i);
			}
		}
		return data;
	}
}
