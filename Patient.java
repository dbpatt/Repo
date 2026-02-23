/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Patient class that stores patient information including name, address, phone, and emergency contact
 * Due: 02/23/2026
 * Platform/compiler: macOS / Java JDK 17
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Print your Name here: Derrick Patterson
*/

public class Patient {
    // Attributes
    private String firstName;
    private String middleName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emergencyContactName;
    private String emergencyContactPhone;
    
    /**
     * No-arg constructor
     * Initializes all attributes to empty strings
     */
    public Patient() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zipCode = "";
        this.phoneNumber = "";
        this.emergencyContactName = "";
        this.emergencyContactPhone = "";
    }
    
    /**
     * Parametrized constructor for name only
     * @param firstName patient's first name
     * @param middleName patient's middle name
     * @param lastName patient's last name
     */
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zipCode = "";
        this.phoneNumber = "";
        this.emergencyContactName = "";
        this.emergencyContactPhone = "";
    }
    
    /**
     * Parametrized constructor for all attributes
     * @param firstName patient's first name
     * @param middleName patient's middle name
     * @param lastName patient's last name
     * @param streetAddress patient's street address
     * @param city patient's city
     * @param state patient's state
     * @param zipCode patient's ZIP code
     * @param phoneNumber patient's phone number
     * @param emergencyContactName emergency contact's name
     * @param emergencyContactPhone emergency contact's phone number
     */
    public Patient(String firstName, String middleName, String lastName,
                   String streetAddress, String city, String state, String zipCode,
                   String phoneNumber, String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }
    
    // Accessor methods (Getters)
    public String getFirstName() {
        return firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getStreetAddress() {
        return streetAddress;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getEmergencyContactName() {
        return emergencyContactName;
    }
    
    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }
    
    // Mutator methods (Setters)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }
    
    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }
    
    /**
     * Builds full name by concatenating first, middle, and last name
     * @return full name as a string
     */
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
    
    /**
     * Builds address by concatenating street address, city, state, and ZIP
     * @return address as a string
     */
    public String buildAddress() {
        return streetAddress + " " + city + " " + state + " " + zipCode;
    }
    
    /**
     * Builds emergency contact by concatenating emergency contact name and phone
     * @return emergency contact information as a string
     */
    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactPhone;
    }
    
    /**
     * Returns string representation of patient information
     * @return formatted patient information
     */
    public String toString() {
        String output = "Patient info:\n";
        output += "  Name: " + buildFullName() + "\n";
        output += "  Address: " + buildAddress() + "\n";
        output += "  EmergencyContact: " + buildEmergencyContact();
        return output;
    }
}
