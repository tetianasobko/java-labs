package org.example.services;

import model.CurrencyType;
import model.IndividualBankAccount;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtSerializer<T> implements Serializer<T> {
    @Override
    public void serialize(T entity, String filename) throws IOException {
        String data = entity.toString();
        Files.write(Paths.get(filename), data.getBytes());
    }

    @Override
    public T deserialize(String filename, Class<T> entityType) throws IOException {
        File file = new File(filename);

        String data = new String(Files.readAllBytes(file.toPath()));

        Pattern pattern = Pattern.compile("IndividualBankAccount\\{accountType='(.*?)', accountNumber='(.*?)'" +
                ", currencyType=(.*?), balance=(.*?)\\}");
        Matcher matcher = pattern.matcher(data);

        if (matcher.matches()) {
            String accountType = matcher.group(1);
            String accountNumber = matcher.group(2);
            CurrencyType currencyType = CurrencyType.valueOf(matcher.group(3));
            double balance = Double.parseDouble(matcher.group(4));

            return (T) new IndividualBankAccount(accountType, accountNumber, currencyType, balance);
        }
        return null;
    }
}
