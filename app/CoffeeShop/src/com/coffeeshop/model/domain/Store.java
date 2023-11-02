package com.coffeeshop.model.domain;

public class Store {

    private int locationID;
    private String name;
    private int streetNo;
    private String streetName;
    private String city;
    private int zip;
    private String phone;

    /**
     * Default Constructor
     */
    public Store() {
        this.locationID = -1;
        this.name = null;
        this.streetName = null;
        this.streetNo = -1;
        this.city = null;
        this.zip = -1;
        this.phone = null;
    }

    /**
     * Copy Constructor
     * @param locationID int value to copy
     * @param name String value to copy
     * @param streetNo int value to copy
     * @param streetName String value to copy
     * @param city String value to copy
     * @param zip int value to copy
     * @param phone String value to copy
     */
    public Store(int locationID, String name, int streetNo, String streetName, String city, int zip, String phone) {
        this.locationID = locationID;
        this.name = name;
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
    }

    /**
     * Getter for location ID
     * @return locationID
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * Setter for locationID
     * @param locationID value to set
     */
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    /**
     * Getter for name
     * @return value to set
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for street number
     * @return streetNo
     */
    public int getStreetNo() {
        return streetNo;
    }

    /**
     * Setter for street number
     * @param streetNo value to set
     */
    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    /**
     * Getter for street name
     * @return streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Setter for street name
     * @param streetName value to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Getter for city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for city
     * @param city value to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for zip
     * @return zip
     */
    public int getZip() {
        return zip;
    }

    /**
     * Setter for zip
     * @param zip value to set
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Getter for phone
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter for phone
     * @param phone value to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Validate checks that all fields are not null or blank and integers are not negative. Also checks that phone
     * is in format XXX-XXX-XXXX
     * @return true on pass, otherwise false
     */
    public boolean validate() {
        if (this.locationID < 0 || this.name == null || this.streetNo < 0 || this.streetName == null || this.city == null
            || this.zip < 0 || this.phone == null)
            return false;

        if (this.name.isBlank() || this.name.isBlank() || this.streetName.isBlank() || this.city.isBlank() || this.phone.isBlank())
            return false;

        if (String.valueOf(zip).length() != 5)
            return false;

        // try to convert string to int and catch exception for letters
        try {
            // split the string
            String[] phoneSplit = this.phone.split("-");
            // check for valid lengths
            if (phoneSplit[0].length() != 3 || phoneSplit[1].length() != 3 ||
                    phoneSplit[2].length() != 4) {
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store store)) return false;

        if (locationID != store.locationID) return false;
        if (streetNo != store.streetNo) return false;
        if (zip != store.zip) return false;
        if (!name.equals(store.name)) return false;
        if (!streetName.equals(store.streetName)) return false;
        if (!city.equals(store.city)) return false;
        return phone.equals(store.phone);
    }

    @Override
    public int hashCode() {
        int result = locationID;
        result = 31 * result + name.hashCode();
        result = 31 * result + streetNo;
        result = 31 * result + streetName.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + zip;
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", name='" + name + '\'' +
                ", streetNo=" + streetNo +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", phone='" + phone + '\'' +
                '}';
    }
}
