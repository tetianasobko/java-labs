package model;

import java.time.LocalDate;
import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    private String patronymic;

    private LocalDate dateOfBirth;
    private String passportId;

    private List<BankAccount> accounts;

}
