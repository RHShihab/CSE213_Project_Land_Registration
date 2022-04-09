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
    
    @Override
    public String toString(){
        return "Street: " + street + ", Area: " + area + ", District: " + district
                + "Division: " +division;
    }
}
