package http.json.nbp;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

public class HttpJsonGios {
    
    public static void main(String[] args) throws IOException, JSONException, InterruptedException {
    	
    	getById getter = new getById();
    	ArrayList<String[]> data = getter.getArrayListById(92);
    	
    	getByFindAll getter2 = new getByFindAll();
    	ArrayList<Station> data2 = getter2.getArrayListByFindAll();
        

    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new FrameById(data);
                new FrameByFindAll(data2);
            }       
        });
    }
}