package com.example.quickcash.util;

/**
 * The NotNullValidator class represents a validator that checks whether the input string is not null.
 * It implements the IDataValidator interface and is part of the Chain of Responsibility pattern.
 * If the input string is not null, the validation is delegated to the next validator in the chain.
 */
public class NotNullValidator implements IDataValidator {
    private IDataValidator nextValidator = null;

    /**
     * Sets the next validator in the chain.
     *
     * @param nextValidator the next validator to be set in the chain
     */
    @Override
    public void setNextValidator(IDataValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    /**
     * Validates the given input string to ensure it is not null.
     * If the input string is not null, the validation is delegated to the next validator in the chain.
     *
     * @param s the input string to be validated
     * @return {@code true} if the input string is not null and passes validation by subsequent validators,
     *         {@code false} otherwise
     */
    @Override
    public boolean validate(String s) {
        return s != null && (nextValidator == null || nextValidator.validate(s));
    }
}
