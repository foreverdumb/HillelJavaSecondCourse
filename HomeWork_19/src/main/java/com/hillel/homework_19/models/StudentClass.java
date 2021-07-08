package com.hillel.homework_19.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class StudentClass {
    private int id;
    private String fullName;
    private int groupId;
    private int admYear;
    private boolean isDeleted;

    public StudentClass(String fullName, int groupId, int admYear) {
        this.fullName = fullName;
        this.groupId = groupId;
        this.admYear = admYear;
    }
}
