package com.vaasok.javabankapp.Utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vaasok.javabankapp.Models.Account;

import java.io.IOException;

public class AccountSerializer extends JsonSerializer<Account> {
    @Override
    public void serialize(Account account, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", account.getId());
        jsonGenerator.writeStringField("number", account.getNumber());
        jsonGenerator.writeStringField("currency", account.getCurrency().toString());
        jsonGenerator.writeNumberField("balance", account.getBalance());

        // Выводим данные пользователя без ссылки на аккаунты
        jsonGenerator.writeObjectFieldStart("customer");
        jsonGenerator.writeNumberField("id", account.getCustomer().getId());
        jsonGenerator.writeStringField("name", account.getCustomer().getName());
        jsonGenerator.writeStringField("email", account.getCustomer().getEmail());
        jsonGenerator.writeNumberField("age", account.getCustomer().getAge());
        jsonGenerator.writeEndObject();

        jsonGenerator.writeEndObject();
    }
}

