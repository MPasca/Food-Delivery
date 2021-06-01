package Bussiness.Validators;

import java.io.Serializable;

public interface Validator<T> extends Serializable {
    void validate(T t);
}

