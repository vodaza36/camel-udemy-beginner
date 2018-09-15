package at.hochbichler.camel.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.Link;

import java.util.Objects;

@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
public class EmployeeCSVWithAddress {
    @DataField(pos = 1)
    private String id;
    @DataField(pos = 2)
    private String firstName;
    @DataField(pos = 3)
    private String lastName;
    @Link
    private AddressCSV addressCSV;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeCSVWithAddress that = (EmployeeCSVWithAddress) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(addressCSV, that.addressCSV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, addressCSV);
    }

    @Override
    public String toString() {
        return "EmployeeCSVWithAddress{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressCSV=" + addressCSV +
                '}';
    }

    public AddressCSV getAddressCSV() {
        return addressCSV;
    }

    public void setAddressCSV(AddressCSV addressCSV) {
        this.addressCSV = addressCSV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
