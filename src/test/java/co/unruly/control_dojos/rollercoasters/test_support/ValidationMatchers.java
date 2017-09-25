package co.unruly.control_dojos.rollercoasters.test_support;

import co.unruly.control.result.Result;
import co.unruly.control.validation.FailedValidation;
import org.hamcrest.Matcher;

import static java.util.Arrays.asList;

public class ValidationMatchers {

    public static <T, E> Matcher<Result<T, FailedValidation<T, E>>> failure(E... errors) {
        return new ValidationFailureMatcher<>(asList((errors)));
    }


    public static <T, E> Matcher<Result<T, FailedValidation<T, E>>> success() {
        return new ValidationSuccessMatcher<>();
    }
}
