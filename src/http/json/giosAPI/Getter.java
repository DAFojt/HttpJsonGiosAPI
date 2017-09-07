package http.json.giosAPI;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import http.json.classes.Sensor;
import http.json.classes.Station;

public class Getter {

	public static ArrayList<Station> getStationsArrayListByFindAll() throws IOException, JSONException {
		JsonReader jsonReader = new JsonReader();

		ArrayList<Station> data = new ArrayList<Station>();
		String API_URL = "http://api.gios.gov.pl/pjp-api/rest/station/findAll";
		JSONArray json = JsonReader.readJsonArrayFromUrl(API_URL);

		for (int i = 0; i < json.length(); i++) {
			JSONObject json2 = json.getJSONObject(i);
			JSONObject json3 = null;
			JSONObject json4 = null;

			try {
				try {
					json3 = json2.getJSONObject("city");
					try {
						json4 = json3.getJSONObject("commune");
					} catch (JSONException e) {
						System.out.println("B£¥D PRZY TWORZENIU OBIEKTU STACJI NR: " + i + " przy tworzeniu gminy");
						continue;
					}
				} catch (JSONException e) {
					System.out.println("B£¥D PRZY TWORZENIU OBIEKTU STACJI NR: " + i + " przy tworzeniu miasta");
					continue;
				}

				Station station = new Station(!json2.isNull("id") ? json2.getInt("id") : -1,
						!json2.isNull("stationName") ? json2.getString("stationName") : "NULL",
						!json2.isNull("gegrLat") ? json2.getDouble("gegrLat") : -1.0,
						!json2.isNull("gegrLon") ? json2.getDouble("gegrLon") : -1.0,
						!json3.isNull("id") ? json3.getInt("id") : -1,
						!json3.isNull("name") ? json3.getString("name") : "NULL",
						!json4.isNull("communeName") ? json4.getString("communeName") : "NULL",
						!json4.isNull("districtName") ? json4.getString("districtName") : "NULL",
						!json4.isNull("provinceName") ? json4.getString("provinceName") : "NULL",
						!json2.isNull("adressStreet") ? json2.getString("addressStreet") : "NULL");

				data.add(station);

				System.out
						.println("Stworzono obiekt stacji o id: " + station.getId() + ": " + station.getStationName());

			} catch (JSONException e) {
				System.out.println("B£¥D OGÓLNY PRZY TWORZENIU OBIEKTU STACJI NR: " + i);
				continue;
			}
		}

		return data;
	}

	public static ArrayList<Sensor> getSensorsArrayListByStationId(int id) throws IOException, JSONException {
		JsonReader jsonReader = new JsonReader();

		ArrayList<Sensor> data = new ArrayList<Sensor>();
		String API_URL = "http://api.gios.gov.pl/pjp-api/rest/station/sensors/" + id;
		JSONArray json = JsonReader.readJsonArrayFromUrl(API_URL);

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

	public static ArrayList<String[]> getDataArrayListBySensorId(int id) throws IOException, JSONException {
		JsonReader jsonReader = new JsonReader();

		ArrayList<String[]> data = new ArrayList<String[]>();
		String API_URL = "http://api.gios.gov.pl/pjp-api/rest/data/getData/" + id;
		JSONObject json = JsonReader.readJsonFromUrl(API_URL);

		JSONArray jsons = new JSONArray();
		String s[] = new String[json.length() + 1];

		String key = json.getString("key");
		JSONArray j1 = json.getJSONArray("values");

		if (json.getJSONArray("values").length() > 0) {

			for (int i = 0; i < j1.length(); i++) {

				String date;
				double value;
				JSONObject j2 = j1.getJSONObject(i);
				date = j2.getString("date");
				try {
					value = j2.getDouble("value");
				} catch (JSONException e) {
					value = -1;
				}

				if (value != -1) {
					System.out.println(
							"Dane dla sensora o id: " + id + " data: " + date + ", wartoœæ zanieczyszczeñ: " + value);
				} else {
					System.out.println("Dane dla sensora o id: " + id + " data: " + date
							+ ", brak danych pomiarowych dla danej godziny");
				}

				String sData[] = new String[2];
				sData[0] = date;
				sData[1] = "" + value;
				data.add(sData);
			}
		} else {
			System.out.println("Brak danych pomiarowych dla podanego punktu pomiarowego!");
			String error[] = { "NULL", "NULL" };
			data.add(error);
		}

		if (!data.isEmpty()) {
			String sData[] = new String[2];
			sData[0] = "KEY";
			sData[1] = key;
			data.add(sData);
		}

		return data;
	}
}
