package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.northcoders.demospringbootapp.DAO.CityDao;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private long id;
    private String name;
    private double latitude;
    private double longitude;
    private String country;

    public City(CityDao dao) {
        if (dao != null) {
            this.id = dao.id();
            this.name = dao.name();
            this.latitude = dao.latitude();
            this.longitude = dao.longitude();
            this.country = dao.country();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
