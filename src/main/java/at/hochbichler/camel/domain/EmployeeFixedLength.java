package at.hochbichler.camel.domain;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import java.time.LocalDate;
import java.util.Objects;

@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeFixedLength {
    @DataField(pos = 1, length = 3)
    private String id;
    @DataField(pos = 2, length = 10, trim = true, align = "L")
    private String firstname;
    @DataField(pos = 3, length = 20)
    private String lastname;
    @DataField(pos = 4, length = 9, pattern = "ddMMMyyyy")
    private LocalDate joinDate;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EmployeeFixedLength{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeFixedLength that = (EmployeeFixedLength) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(joinDate, that.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, joinDate);
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
