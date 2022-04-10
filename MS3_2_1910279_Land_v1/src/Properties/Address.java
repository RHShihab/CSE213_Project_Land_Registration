package Properties;

import java.io.Serializable;

public class Address implements Serializable{
    String street, area, district, division;
    
    Address(String street, String area, String district, String division){
        this.street = street;
        this.area = area;
        this.district = district;
        this.division = division;
    }

    public String getStreet() {
        return street;
    }

    public String getArea() {
        return area;
    }

    public String getDistrict() {
        return district;
    }

    public String getDivision() {
        return division;
    }
    
    @Override
    public String toString(){
        return "Street: " + street + ", Area: " + area + ", District: " + district
                + ", Division: " +division;
    }
}
