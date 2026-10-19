package es.deusto.deustobooking.obj;

import java.util.*;

public class Hotel {
    private String hotelName;
    private String hotelAddress;
    private String hotelCity;
    private String hotelState;
    private String hotelCountry;
    private List<Habitacion> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
    }

    public Hotel(String hotelName, String hotelAddress, String hotelCity, String hotelState, String hotelCountry) {
        this();
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelCity = hotelCity;
        this.hotelState = hotelState;
        this.hotelCountry = hotelCountry;
    }

    public List<Habitacion> getRooms() {
        return rooms;
    }

    public void setRooms(List<Habitacion> rooms) {
        this.rooms = rooms;
    }

    public String getHotelState() {
        return hotelState;
    }

    public void setHotelState(String hotelState) {
        this.hotelState = hotelState;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelAddress='" + hotelAddress + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelCity='" + hotelCity + '\'' +
                ", hotelState='" + hotelState + '\'' +
                ", hotelCountry='" + hotelCountry + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
