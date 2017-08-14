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

public class getById {
	  public ArrayList<String[]> getArrayListById(int id) throws IOException, JSONException
	  {
		  	readJsonFromURL jsonReader = new readJsonFromURL();
		  	
		  	ArrayList<String[]> data = new ArrayList<String[]>();
		  	String API_URL = "http://api.gios.gov.pl/pjp-api/rest/data/getData/" + id;
	        JSONObject json = jsonReader.readJsonFromUrl(API_URL);
	        System.out.println(json.toString());
	        System.out.println(json.get("values"));
	        System.out.println(json.getJSONArray("values").length());
	        
	        JSONArray jsons = new JSONArray();
	        String s[] = new String[63];
	        
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

					if (value != -1)
					{
						System.out.println("Data: " + date + ", wartoœæ zanieczyszczeñ: " + value);
					}
					else
					{
						System.out.println("Data: " + date + ", Brak danych pomiarowych dla danej godziny");
					}
					
					String sData[] = new String[2];
					sData[0] = date; sData[1] = "" + value;
					data.add(sData);
				}
			} else {
				System.out.println("SYSTEM ERROR: Brak danych pomiarowych z API");
			}
			
			return data;
	  }
}
