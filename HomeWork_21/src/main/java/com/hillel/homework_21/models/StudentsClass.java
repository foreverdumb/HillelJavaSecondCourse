package com.hillel.homework_25.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Table(name = "Students")
@Setter
@Getter
@Accessors(chain = true)
@ToString
public class StudentsClass {
    @Id
    @GeneratedValue
    @Column(name = "ID_ST")
    private int id;

    @Column(name = "studentFullName")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "groupID")
    private StudyGroupClass group;

    @Column(name = "studentYearOfAdmission")
    private int admYear;

}
