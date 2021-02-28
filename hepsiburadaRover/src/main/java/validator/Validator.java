package validator;

import exceptions.InvalidDirectionException;

public class Validator {

    public static <E extends Enum<E>> void enumControl(Class<E> e, String id) {
        try {
            Enum.valueOf(e, id);
        } catch (IllegalArgumentException exception) {
            throw new InvalidDirectionException();
        }

    }
}
