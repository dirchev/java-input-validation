package eyeclinic.Helpers;

import java.util.ArrayList;

/**
 *
 * @author dirchev
 */

public class ValidatedInput {
    private Boolean valid = true;
    private ArrayList<String> validationMessages = new ArrayList<>();
    private String string;
    private String label;

    public ValidatedInput (String string, String label) {
        this.string = string;
        this.label = label;
    }

    private void checkCase (Boolean validationCase, String errorMessage) {
        if (!validationCase) {
            this.valid = false;
            this.validationMessages.add(errorMessage.replace("*label*", "'" + label + "'"));
        }
    }

    /**
     * Checks if the string has at least 1 character
     * @return ValidatedInput instance with updated properties
     */
    public ValidatedInput required () {
        this.checkCase(string.length() != 0, "*label* is required.");
        return this;
    }

    /**
     * Checks if the string contains only upper or lower case letters or numbers
     * @return ValidatedInput instance with updated properties
     */
    public ValidatedInput alphanum () {
        this.checkCase(string.matches("^[a-zA-Z0-9]*$"), "*label* must include only letters and numbers.");
        return this;
    }

    /**
     * Checks if the string contains only upper or lower case letters
     * @return ValidatedInput instance with updated properties
     */
    public ValidatedInput alpha () {
        this.checkCase(string.matches("^[a-zA-Z]*$"), "*label* must include only letters.");
        return this;
    }

    /**
     * Checks if the string contains only numbers
     * @return ValidatedInput instance with updated properties
     */
    public ValidatedInput integer () {
        this.checkCase(string.matches("^[0-9]*$"), "*label* must be an integer.");
        return this;
    }

    /**
     * Checks if the string length is more than given length
     * @param length length to be used in the validation
     * @return ValidatedInput instance with updated properties
     */
    public ValidatedInput min_length (Integer length) {
        this.checkCase(string.length() > length, "*label* must have more than " + length + " characters.");
        return this;
    }

    /**
     * Checks if the string length is less than the given length
     * @param length length to be used in the validation
     * @return ValidatedInput instance with updated properties
     */
    public ValidatedInput max_length (Integer length) {
        this.checkCase(string.length() < length, "*label* must have less than " + length + " characters.");
        return this;
    }

    /**
     * Checks if the string is a valid email (beta)
     * @return ValidatedInput instance with updated properties
     */
    public ValidatedInput email () {
        String emailRegex = "^[A-Z0-9._%+-]++@[A-Z0-9.-]++\\.[A-Z]{2,}+$";
        this.checkCase(string.matches(emailRegex), "*label* must be valid email.");
        return this;
    }

    /**
     * Tells if the string meets the validations or not
     * @return true if all validations have passed successfully and false otherwise
     */
    public Boolean isValid() {
        return valid;
    }

    /**
     * Gives all validation error messages
     * @return ArrayList of validation error messages
     */
    public ArrayList<String> getValidationMessages() {
        return validationMessages;
    }
}
