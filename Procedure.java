/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Procedure class that stores medical procedure information
 * Due: 02/23/2026
 * Platform/compiler: macOS / Java JDK 17
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Print your Name here: Derrick Patterson
*/

public class Procedure {
    // Attributes
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharges;
    
    /**
     * No-arg constructor
     * Initializes all attributes to default values
     */
    public Procedure() {
        this.procedureName = "";
        this.procedureDate = "";
        this.practitionerName = "";
        this.procedureCharges = 0.0;
    }
    
    /**
     * Parametrized constructor for procedure name and date
     * @param procedureName name of the procedure
     * @param procedureDate date of the procedure
     */
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = "";
        this.procedureCharges = 0.0;
    }
    
    /**
     * Parametrized constructor for all attributes
     * @param procedureName name of the procedure
     * @param procedureDate date of the procedure
     * @param practitionerName name of the practitioner
     * @param procedureCharges charges for the procedure
     */
    public Procedure(String procedureName, String procedureDate, 
                     String practitionerName, double procedureCharges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.procedureCharges = procedureCharges;
    }
    
    // Accessor methods (Getters)
    public String getProcedureName() {
        return procedureName;
    }
    
    public String getProcedureDate() {
        return procedureDate;
    }
    
    public String getPractitionerName() {
        return practitionerName;
    }
    
    public double getProcedureCharges() {
        return procedureCharges;
    }
    
    // Mutator methods (Setters)
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }
    
    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }
    
    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }
    
    public void setProcedureCharges(double procedureCharges) {
        this.procedureCharges = procedureCharges;
    }
    
    /**
     * Returns string representation of procedure information
     * @return formatted procedure information
     */
    public String toString() {
        String output = "\t\tProcedure: " + procedureName + "\n";
        output += "\t\tProcedure Date: " + procedureDate + "\n";
        output += "\t\tPractitioner: " + practitionerName + "\n";
        output += String.format("\t\tCharge: $%.2f", procedureCharges);
        return output;
    }
}
