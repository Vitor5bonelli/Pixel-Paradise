package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Notification {
    private final List<String> messages = new ArrayList<>();

    public boolean hasMessages() {
        return !messages.isEmpty();
    }

    public void addMessage(String message) {
        Objects.requireNonNull(message);

        messages.add(message);
    }

    public String getMessagesAsString() {
        if (!hasMessages())
            return "";

        StringBuilder messagesAsStringBuilder = new StringBuilder();

        messages.forEach(message -> messagesAsStringBuilder.append(message).append(";"));

        return messagesAsStringBuilder.toString();
    }
}
