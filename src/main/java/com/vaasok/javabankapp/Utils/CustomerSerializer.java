package com.vaasok.javabankapp.Utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vaasok.javabankapp.Models.Account;
import com.vaasok.javabankapp.Models.Customer;

import java.io.IOException;

public class CustomerSerializer extends JsonSerializer<Customer> {
    @Override
    public void serialize(Customer customer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", customer.getId());
        jsonGenerator.writeStringField("name", customer.getName());
        jsonGenerator.writeStringField("email", customer.getEmail());
        jsonGenerator.writeNumberField("age", customer.getAge());

        // Выводим данные аккаунтов без ссылки на пользователя
        jsonGenerator.writeArrayFieldStart("accounts");
        for (Account account : customer.getAccounts()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", account.getId());
            jsonGenerator.writeStringField("number", account.getNumber());
            jsonGenerator.writeStringField("currency", account.getCurrency().toString());
            jsonGenerator.writeNumberField("balance", account.getBalance());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}
