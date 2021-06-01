package Bussiness.Validators;

import javax.swing.*;
import java.util.regex.Pattern;

class TelephoneValidator{
    private static final String TELEPHONE_PATTERN = "(\\+4)?07[0-9]{8}";

    private static TelephoneValidator singleInstance = new TelephoneValidator();

    public static TelephoneValidator getValidator() {
        return singleInstance;
    }

    protected void validate(String telephone) {
        Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
        if(!pattern.matcher(telephone).matches()){
            JOptionPane.showMessageDialog(null, "Not a valid telephone number.", "Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Not a valid telephone number");
        }
    }
}
