package org.example.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Client {
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String passportId;
    private List<IndividualBankAccount> accounts;

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportId='" + passportId + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(patronymic, client.patronymic) && Objects.equals(dateOfBirth, client.dateOfBirth) && Objects.equals(passportId, client.passportId) && Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, dateOfBirth, passportId, accounts);
    }
}
