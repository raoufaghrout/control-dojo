package co.unruly.control_dojos.rollercoasters.test_support;

import co.unruly.control.Result.Result;
import co.unruly.control.Validation.FailedValidation;
import org.hamcrest.Description;

public class ValidationSuccessMatcher<T, E> extends ValidationMatcher<T, E> {
    @Override
    protected boolean verifyResult(Result<T, FailedValidation<T, E>> result) {
        return result.either(success -> true, failure -> false);
    }

    @Override
    public void describeTo(Description description) {
        describeSuccess(description);
    }
}
