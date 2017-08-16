package Classes;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import http.json.GiosAPI.Getter;

public class Sensor {
	
	int id;
	int stationId;
	String paramName;
	String paramFormula;
	String paramCode;
	int idParam;
	ArrayList data;
	
	public Sensor(int id, int stationId, String paramName, String paramFormula, String paramCode, int idParam) {
		super();
		this.id = id;
		this.stationId = stationId;
		this.paramName = paramName;
		this.paramFormula = paramFormula;
		this.paramCode = paramCode;
		this.idParam = idParam;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamFormula() {
		return paramFormula;
	}
	public void setParamFormula(String paramFormula) {
		this.paramFormula = paramFormula;
	}
	public String getParamCode() {
		return paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	public int getIdParam() {
		return idParam;
	}
	public void setIdParam(int idParam) {
		this.idParam = idParam;
	}

	public ArrayList getData() {
		return data;
	}

	public void setData(ArrayList data) {
		this.data = data;
	}
	
	public void getDataByHttp() throws IOException, JSONException
	{
		data = Getter.getDataArrayListBySensorId(id);
	}	
}
