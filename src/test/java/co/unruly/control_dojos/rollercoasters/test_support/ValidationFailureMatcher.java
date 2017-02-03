package co.unruly.control_dojos.rollercoasters.test_support;

import co.unruly.control.LinkList.LinkList;
import co.unruly.control.LinkList.LinkLists;
import co.unruly.control.Result.Result;
import co.unruly.control.Validation.FailedValidation;
import org.hamcrest.Description;

public class ValidationFailureMatcher<T, E> extends ValidationMatcher<T, E> {

    private final LinkList<E> expectedErrors;

    public ValidationFailureMatcher(LinkList<E> expectedErrors) {
        this.expectedErrors = expectedErrors;
    }

    @Override
    protected boolean verifyResult(Result<T, FailedValidation<T, E>> result) {
        return result.either(
                success -> false,
                failure -> LinkLists.listsEqual(failure.errors, expectedErrors)
        );
    }

    @Override
    public void describeTo(Description description) {
        describeFailure(description, expectedErrors.stream());
    }
}
