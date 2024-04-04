package com.example.quickcash.util;

/**
 * The IDataValidator interface represents a validator in the Chain of Responsibility pattern.
 * Validators in the chain determine whether a given input meets certain criteria.
 * Each validator has the ability to either validate the input itself or delegate the validation
 * to the next validator in the chain.
 */
public interface IDataValidator {

    /**
     * Sets the next validator in the chain.
     *
     * @param nextVal the next validator to be set in the chain
     */
    void setNextValidator(IDataValidator nextVal);

    /**
     * Validates the given input string according to the implemented criteria.
     *
     * @param s the input string to be validated
     * @return {@code true} if the input meets the validation criteria, {@code false} otherwise
     */
    boolean validate(String s);

}
