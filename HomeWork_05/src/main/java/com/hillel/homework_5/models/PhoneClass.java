package com.hillel.homework_5.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhoneClass {
    private String firstName;
    private String lastName;
    private String patronymicName;
    private String address;
    private long creditCardNumber;
    private int debit;
    private int credit;
    private int timeOfLongDistanceCalls;
    private int timeOfCityDistanceCalls;
    private int internetTraffic;
    private int id;
}
