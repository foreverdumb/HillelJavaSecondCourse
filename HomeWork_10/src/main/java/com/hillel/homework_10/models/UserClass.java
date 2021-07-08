package com.hillel.homework_10.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserClass {
    String name;
    AddressClass address;

    public UserClass() {
        this.address = new AddressClass();
    }
}
