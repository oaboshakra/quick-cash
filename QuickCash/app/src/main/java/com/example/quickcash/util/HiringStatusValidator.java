package com.example.quickcash.util;

/**
 * The HiringStatusValidator class represents a validator that checks whether the hiring status
 * is one of the valid hiring statuses defined in the application constants.
 * It implements the IDataValidator interface and is part of the Chain of Responsibility pattern.
 */
public class HiringStatusValidator implements IDataValidator {

    /**
     * Validates the given hiring status string against the valid hiring statuses defined in the application.
     *
     * @param hiringStatus the hiring status to be validated
     * @return {@code true} if the hiring status is one of the valid hiring statuses,
     *         {@code false} otherwise
     */
    @Override
    public boolean validate(String hiringStatus) {
        for (String validStatus : AppConstants.VALID_HIRING_STATUS) {
            if (validStatus.equalsIgnoreCase(hiringStatus)) {
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
