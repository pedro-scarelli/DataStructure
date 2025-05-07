package dataStructure.helpers;

import java.time.LocalDate;

public class Student {
    private int registerNumber;
    private String name;
    private LocalDate birthday;

    public Student(int registerNumber, String name, LocalDate birthday) {
        this.registerNumber = registerNumber;
        this.name = name;
        this.birthday = birthday;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }    
}
