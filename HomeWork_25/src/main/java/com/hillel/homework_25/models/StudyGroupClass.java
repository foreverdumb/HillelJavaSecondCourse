package com.hillel.homework_25.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "studyGroup")
@Setter
@Getter
@Accessors(chain = true)
@ToString
public class StudyGroupClass {
    @Id
    @GeneratedValue
    @Column(name = "ID_SG")
    private int id;

    @Column(name = "groupName")
    private String groupName;
}
