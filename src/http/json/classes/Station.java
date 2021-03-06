package http.json.classes;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import http.json.giosAPI.Getter;

public class Station implements Comparable<Station>{

	private int id;
	private String stationName;
	private double gegrLat;
	private double gegrLon;

	private int cityId;
	private String cityName;
	private String communeName;
	private String districtName;
	private String provinceName;
	private String adressStreet;
	
	private ArrayList sensors = new ArrayList();

	public Station(int id, String stationName, double gegrLat, double gegrLon, int cityId, String cityName,
			String communeName, String districtName, String provinceName, String adressStreet) {
		super();
		this.id = id;
		this.stationName = stationName;
		this.gegrLat = gegrLat;
		this.gegrLon = gegrLon;
		this.cityId = cityId;
		this.cityName = cityName;
		this.communeName = communeName;
		this.districtName = districtName;
		this.provinceName = provinceName;
		this.adressStreet = adressStreet;
	}
	
	public void addSensors(Station sensor)
	{
		sensors.add(sensor);
	}
	
	public ArrayList getSensors() {
		return sensors;
	}
	
	public Sensor getSensor(int id)
	{
		if((id <= sensors.size()&& id >= 0))
			return (Sensor) sensors.get(id);
		else if(id > sensors.size())
			return (Sensor) sensors.get(sensors.size()-1);
		else return (Sensor) sensors.get(0);
	}

	public void setSensors(ArrayList sensors) {
		this.sensors = sensors;
	}
	
	public void getAllSensorsByHttp() throws IOException, JSONException
	{
		ArrayList<Sensor> data3 = Getter.getSensorsArrayListByStationId(id);
		sensors = data3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public double getGegrLat() {
		return gegrLat;
	}

	public void setGegrLat(double gegrLat) {
		this.gegrLat = gegrLat;
	}

	public double getGegrLon() {
		return gegrLon;
	}

	public void setGegrLon(double gegrLon) {
		this.gegrLon = gegrLon;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCommuneName() {
		return communeName;
	}

	public void setCommuneName(String communeName) {
		this.communeName = communeName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getAdressStreet() {
		return adressStreet;
	}

	public void setAdressStreet(String adressStreet) {
		this.adressStreet = adressStreet;
	}

	@Override
	public int compareTo(Station station) {
		return id - station.id;
	}
}
