package com.example.springbootproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {

    //name, email, phone, department_name, advisor_id (reference from Teacher)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String departmentName;

    private String Password;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Teacher advisor;


}
