package http.json.nbp;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

public class HttpJsonGios {

	public static void main(String[] args) throws IOException, JSONException, InterruptedException {


		ArrayList<String[]> data = getById.getArrayListById(14);

	
		ArrayList<Station> data2 = getByFindAll.getArrayListByFindAll();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FrameById(data);
				new FrameByFindAll(data2);
			}
		});
	}
}