package hillel.java.homework_4;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SettingStudentsInfoClass {
    private int id;
    private int yearOfBirth;
    private int phoneNumber;
    private int yearOfStudy;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String facultyName;
    private String groupName;


    public void printSameFaculty() {
        if (this.getFacultyName().equals("ICS")) {

            System.out.println(getId() + " " + getLastName() + " " + getFirstName() + " " + getPatronymic() + " "
                    + getYearOfBirth() + " " + getAddress() + " " + getPhoneNumber() + " " + getFacultyName()
                    + " " + getYearOfStudy() + " " + getGroupName());
        }
    }

    public void printSameFacultyAndGroup(String facultyName, int yearOfStudy) {

        if (getFacultyName().equals(facultyName) && getYearOfStudy() == yearOfStudy) {
            System.out.println(getId() + " " + getLastName() + " " + getFirstName() + " " + getPatronymic() + " "
                    + getYearOfStudy() + " " + getAddress() + " " + getPhoneNumber() + " " + getFacultyName()
                    + " " + getYearOfStudy() + " " + getGroupName());
        }
    }

    public void printSameAge(int age) {
        if (getYearOfBirth() > age) {
            System.out.println(getId() + " " + getLastName() + " " + getFirstName() + " " + getPatronymic() + " "
                    + getYearOfBirth() + " " + getAddress() + " " + getPhoneNumber() + " " + getFacultyName()
                    + " " + getYearOfStudy() + " " + getGroupName());
        }
    }
}
