package http.json.nbp;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class getByDataId {
	  public static ArrayList<String[]> getArrayListById(int id) throws IOException, JSONException
	  {
		  	readJsonFromURL jsonReader = new readJsonFromURL();
		  	
		  	ArrayList<String[]> data = new ArrayList<String[]>();
		  	String API_URL = "http://api.gios.gov.pl/pjp-api/rest/data/getData/" + id;
	        JSONObject json = readJsonFromURL.readJsonFromUrl(API_URL);
	        
	        JSONArray jsons = new JSONArray();
	        String s[] = new String[json.length()+1];
	        
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

					if (value != -1)
					{
						System.out.println("Dane dla sensora o id: "+ id + " data: " + date + ", wartoœæ zanieczyszczeñ: " + value);
					}
					else
					{
						System.out.println("Dane dla sensora o id: "+ id + " data: " + date + ", Brak danych pomiarowych dla danej godziny");
					}
					
					String sData[] = new String[2];
					sData[0] = date; 
					sData[1] = "" + value;
					data.add(sData);
				}
			} else {
				System.out.println("Brak danych pomiarowych dla podanego punktu pomiarowego!");
			}
			
			String sData[] = new String[2];
			sData[0] = "KEY"; 
			sData[1] = key;
			data.add(sData);
			
			return data;
	  }
}
