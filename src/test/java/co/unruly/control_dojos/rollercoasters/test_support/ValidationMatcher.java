package co.unruly.control_dojos.rollercoasters.test_support;

import co.unruly.control.result.Result;
import co.unruly.control.validation.FailedValidation;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public abstract class ValidationMatcher<T, E> extends TypeSafeDiagnosingMatcher<Result<T, FailedValidation<T, E>>> {

    @Override
    protected boolean matchesSafely(Result<T, FailedValidation<T, E>> result, Description description) {
        result.either(
                success -> describeSuccess(description),
                failure -> describeFailure(description, failure.errors.stream())
        );

        return verifyResult(result);
    }

    protected abstract boolean verifyResult(Result<T, FailedValidation<T, E>> result);

    protected Description describeFailure(Description description, Stream<E> errors) {
        return description.appendText(String.format("A failure containing errors: [%s]",
                errors.map(Object::toString).collect(joining(", "))));
    }

    protected Description describeSuccess(Description description) {
        return description.appendText("A success");
    }
}
