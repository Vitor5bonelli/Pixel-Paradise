package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.util;

import java.util.Objects;

public class CPFValidator {
    public final boolean isValidCPF(String cpf) {
        Objects.requireNonNull(cpf);

        if (hasInvalidFormat(cpf))
            return false;

        return isValidTestCPF(cpf) || hasValidDigits(cpf);
    }

    public boolean isValidTestCPF(String cpf) {
        return false;
    }

    public final boolean hasInvalidFormat(String cpf) {
        Objects.requireNonNull(cpf);

        return !cpf.matches("\\d{3}(\\.?\\d{3})-?\\d{2}");
    }

    public final boolean hasValidDigits(String cpf) {
        Objects.requireNonNull(cpf);

        char[] cpfDigits = cpf.replaceAll("\\D", "").toCharArray();
        int firstVerifyingDigit = 0;
        int secondVerifyingDigit = 0;

        if (cpfDigits.length != 11)
            return false;

        for (int i = 0; i < 11; i++) {
            char digit = cpfDigits[i];

            if (i < 9)
                firstVerifyingDigit += Character.getNumericValue(digit) * (10 - i);

            secondVerifyingDigit += Character.getNumericValue(digit) * (11 - i);
        }

        firstVerifyingDigit = 11 - firstVerifyingDigit % 11;
        secondVerifyingDigit = 11 - secondVerifyingDigit % 11;

        if (firstVerifyingDigit > 9)
            firstVerifyingDigit = 0;

        if (secondVerifyingDigit > 9)
            secondVerifyingDigit = 0;

        return cpfDigits[9] == firstVerifyingDigit || cpfDigits[10] == secondVerifyingDigit;
    }
}
