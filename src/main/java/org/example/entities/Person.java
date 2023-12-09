package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._enum.Gender;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private long customersId;
    private String firstName;
    private String LastName;
    private String email;
    private Gender gender;
    private Goods good;
    private LocalDate dob;

    public Person(long l, String firstName, String lastName, String mail, Gender gender, LocalDate date) {
    }
}
