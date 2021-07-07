package hillel.java.homework_4;

import java.util.Scanner;

public class PrintingStudentsInfoMainClass {
    public static void main(String[] args) {
        int option;

        SettingStudentsInfoClass[] pupilArr = new SettingStudentsInfoClass[9];

        SettingStudentsInfoClass pupil_0 = new SettingStudentsInfoClass(12, 0, 1111,
                4, "Britva", "Oleg", "Fedorovych", "Popova, 13",
                "ICS", "AM-191");
        pupil_0.setYearOfBirth(1800);

        SettingStudentsInfoClass pupil_1 = new SettingStudentsInfoClass(24, 0, 1111,
                4, "Petrova", "Anastasia", "Gennadievna", "Kamanina, 5",
                "ICS", "AМ-191");
        pupil_1.setYearOfBirth(1800);

        SettingStudentsInfoClass pupil_2 = new SettingStudentsInfoClass(5, 0, 1111,
                3, "Korchinskiy", "Vasiliy", "Vasil'ev", "Kanatnaya, 17",
                "IBRT", "AК-191");
        pupil_2.setYearOfBirth(1800);

        SettingStudentsInfoClass pupil_3 = new SettingStudentsInfoClass(43, 0, 1111,
                1, "Lomonosova", "Victoria", "Andreevna", "Hovorova, 13",
                "IEE", "AЕ-161");
        pupil_3.setYearOfBirth(1800);

        SettingStudentsInfoClass pupil_4 = new SettingStudentsInfoClass(123, 0, 1111,
                5, "Tolstoy", "John", "Markovich", "Akademicheskaya, 44",
                "RTF", "AС-152");
        pupil_4.setYearOfBirth(1999);

        SettingStudentsInfoClass pupil_5 = new SettingStudentsInfoClass(65, 0, 1111,
                3, "Dostoevskaya", "Olha", "Pavlovna", "Lanzeronovskaya, 8",
                "ICS", "AM-191");
        pupil_5.setYearOfBirth(1800);

        SettingStudentsInfoClass pupil_6 = new SettingStudentsInfoClass(32, 0, 1111,
                2, "Korolev", "Vladislav", "Aleksandrovich", "Popova, 13",
                "KISM", "AM-172");
        pupil_6.setYearOfBirth(1989);

        SettingStudentsInfoClass pupil_7 = new SettingStudentsInfoClass(21, 0, 1111,
                6, "Sobchak", "Ksenia", "Denisovna", "Pushkinskaya, 13",
                "IOT", "AM-152");
        pupil_7.setYearOfBirth(2000);

        SettingStudentsInfoClass director = new SettingStudentsInfoClass();
        director.setAddress("Kanatnaya, 8");
        director.setFacultyName("DECANAT");
        director.setYearOfBirth(1940);
        director.setFirstName("Petr");
        director.setId(1317);
        director.setGroupName("Head-Teacher");
        director.setPatronymic("Metallinovych");
        director.setLastName("Tishin");
        director.setPhoneNumber(10000000);
        director.setYearOfStudy(1970);

        pupilArr[0] = pupil_0;
        pupilArr[1] = pupil_1;
        pupilArr[2] = pupil_2;
        pupilArr[3] = pupil_3;
        pupilArr[4] = pupil_4;
        pupilArr[5] = pupil_5;
        pupilArr[6] = pupil_6;
        pupilArr[7] = pupil_7;
        pupilArr[8] = director;

        do {
            System.out.println(""" 
                    Please, choose an option: \s
                    1 - Print whole info about ALL students:  \s
                    2 - Print info about the students with the same faculty: \s
                    3 - Print info about students with the same faculty years of study: \s
                    4 - Print info about the students with the same age: \s
                    5 - Exit""");
            option = setOption();
            switch (option) {
                case 1 -> {
                    System.out.println("Info about every student:");
                    for (SettingStudentsInfoClass allStudentsInfo :
                            pupilArr) {
                        System.out.println(allStudentsInfo);
                    }
                }
                case 2 -> {
                    System.out.println("----------------------------------------------------------------------------" +
                            "---------------------------------------------------------------------------------------" +
                            "------------------------------------------------------------------");
                    System.out.println("Info about the students with the same faculty:");
                    for (SettingStudentsInfoClass var :
                            pupilArr) {
                        var.printSameFaculty();
                    }
                }
                case 3 -> {
                    System.out.println("----------------------------------------------------------------------------" +
                            "---------------------------------------------------------------------------------------" +
                            "------------------------------------------------------------------");
                    System.out.println("Info about students with the same faculty years of study:");
                    for (SettingStudentsInfoClass var :
                            pupilArr) {
                        var.printSameFacultyAndGroup("ICS", 4);
                    }
                }
                case 4 -> {
                    System.out.println("----------------------------------------------------------------------------" +
                            "---------------------------------------------------------------------------------------" +
                            "------------------------------------------------------------------");
                    System.out.println("Info about the students that were born after set year: ");
                    for (SettingStudentsInfoClass var :
                            pupilArr) {
                        var.printSameAge(1899);
                    }
                }
                case 5 -> System.out.println("Bye!");
            }
        } while (option != 5);
    }

    static int setOption() {

        int option;
        Scanner sc = new Scanner(System.in);
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Attention! Integer required!");
                sc.next();
            }
            option = sc.nextInt();
        } while (option <= 0);
        return option;
    }
}
