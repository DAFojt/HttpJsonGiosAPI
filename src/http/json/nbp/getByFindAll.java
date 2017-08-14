package http.json.nbp;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class getByFindAll {
	  public ArrayList<Station> getArrayListByFindAll() throws IOException, JSONException
	  {
		  	readJsonFromURL jsonReader = new readJsonFromURL();
		  	
		  	ArrayList<Station> data = new ArrayList<Station>();
		  	String API_URL = "http://api.gios.gov.pl/pjp-api/rest/station/findAll";
	        JSONArray json = jsonReader.readJsonArrayFromUrl(API_URL);
	        
	        System.out.println(json.toString());
	        
		for (int i = 0; i < json.length(); i++) {
			JSONObject json2 = json.getJSONObject(i);
			//System.out.println(json2.toString());

			try {
				JSONObject json3 = json2.getJSONObject("city");
				JSONObject json4 = json3.getJSONObject("commune");

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
				
				System.out.println("Stworzono stacjê o id: " + (!json3.isNull("id") ? json3.getInt("id") : -1) + ": " + (!json2.isNull("stationName") ? json2.getString("stationName") : "Brak"));
				
			} catch (JSONException e) {
					System.out.println("B£¥D PRZY TWORZENIU OBIEKTU STACJI NR: " + i);
			} finally {
				
			}

		}
		
			return data;
	  }
}
