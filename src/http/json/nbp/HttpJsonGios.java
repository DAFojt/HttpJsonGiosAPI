package http.json.nbp;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpJsonGios {
    
    public static void main(String[] args) throws IOException, JSONException, InterruptedException {
    	
    	getById getter = new getById();
    	ArrayList<String[]> data = getter.getArrayListById(92);
    	
    	getByFindAll getter2 = new getByFindAll();
    	ArrayList<Station> data2 = getter2.getArrayListByFindAll();
        
    	Thread.sleep(40000);
    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new FrameById(data);
                //new FrameByFindAll(data2);
            }       
        });
    }
}