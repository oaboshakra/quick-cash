package com.example.quickcash.util;

/**
 * The PhoneNumberValidator class represents a validator that checks whether the given phone number
 * matches any of the valid phone numbers defined in the application constants.
 * It implements the IDataValidator interface and is part of the Chain of Responsibility pattern.
 */
public class PhoneNumberValidator implements IDataValidator {

    /**
     * Validates the given phone number against the valid phone numbers defined in the application.
     *
     * @param phoneNumber the phone number to be validated
     * @return {@code true} if the phone number matches any of the valid phone numbers,
     *         {@code false} otherwise
     */
    @Override
    public boolean validate(String phoneNumber) {
        for (String validPhoneNumber : AppConstants.VALID_PHONE_NUM) {
            if (validPhoneNumber.equalsIgnoreCase(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is not implemented in this class as it is the last validator in the chain.
     * Therefore, there is no need to set the next validator.
     *
     * @param nextVal the next validator in the chain (unused)
     */
    @Override
    public void setNextValidator(IDataValidator nextVal) {
        // No implementation needed as this is the last validator in the chain
    }
}
