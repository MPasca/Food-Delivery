package Bussiness.Validators;

import Model.Client;

public class ClientValidator implements Validator<Client>{

    private static ClientValidator singleInstance = new ClientValidator();

    public static ClientValidator getValidator() {
        return singleInstance;
    }

    @Override
    public void validate(Client client) {
        TelephoneValidator.getValidator().validate(client.getTelephoneNumber());

    }
}
