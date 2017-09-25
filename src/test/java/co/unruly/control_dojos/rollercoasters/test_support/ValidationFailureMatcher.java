package co.unruly.control_dojos.rollercoasters.test_support;

import co.unruly.control.result.Result;
import co.unruly.control.validation.FailedValidation;
import org.hamcrest.Description;

import java.util.List;

public class ValidationFailureMatcher<T, E> extends ValidationMatcher<T, E> {

    private final List<E> expectedErrors;

    public ValidationFailureMatcher(List<E> expectedErrors) {
        this.expectedErrors = expectedErrors;
    }

    @Override
    protected boolean verifyResult(Result<T, FailedValidation<T, E>> result) {
        return result.either(
                success -> false,
                failure -> failure.errors.equals(expectedErrors)
        );
    }

    @Override
    public void describeTo(Description description) {
        describeFailure(description, expectedErrors.stream());
    }
}
