package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CPF {
    private static final Map<String, CPF> instances = new HashMap<>();
    private final String code;

    private CPF(String code) {
        this.code = code;
    }

    public static CPF of(String cpf) {
        return createWithCustomValidator(cpf, new CPFValidator());
    }

    public static CPF createWithCustomValidator(String cpf, CPFValidator validator) {
        Objects.requireNonNull(cpf);
        Objects.requireNonNull(validator);

        if (!validator.isValidCPF(cpf))
            throw new IllegalArgumentException("The CPF has not a valid format or valid digits!");

        cpf = formatCPF(cpf);

        if (!instances.containsKey(cpf))
            instances.put(cpf, new CPF(cpf));

        return instances.get(cpf);
    }

    public static String formatCPF(String cpf) {
        char[] formattedCPF = new char[14];
        formattedCPF[3] = '.';
        formattedCPF[7] = '.';
        formattedCPF[11] = '-';

        int i = 0;

        for (char digit : cpf.toCharArray()) {
            if (!Character.isDigit(digit))
                continue;

            formattedCPF[i++] = digit;

            if (i + 1 % 4 == 0)
                i++;
        }

        return String.valueOf(formattedCPF);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return code.equals(cpf.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return code;
    }
}
