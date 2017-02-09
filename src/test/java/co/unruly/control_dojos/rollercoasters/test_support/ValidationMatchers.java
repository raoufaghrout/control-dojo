package co.unruly.control_dojos.rollercoasters.test_support;

import co.unruly.control.LinkList.LinkLists;
import co.unruly.control.Result.Result;
import co.unruly.control.Validation.FailedValidation;
import org.hamcrest.Matcher;

public class ValidationMatchers {

    public static <T, E> Matcher<Result<T, FailedValidation<T, E>>> failure(E... errors) {
        return new ValidationFailureMatcher<>(LinkLists.of(errors));
    }


    public static <T, E> Matcher<Result<T, FailedValidation<T, E>>> success() {
        return new ValidationSuccessMatcher<>();
    }
}
