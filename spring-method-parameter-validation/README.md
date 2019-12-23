

Spring provides an easy way to validate method parameters using JSR 303 bean validation (https://beanvalidation.org/).
In this post we will see how to use this feature.

Setup

First we need to add support for method parameter validation by creating a MethodValidationPostProcessor bean:

@Configuration
public class MyConfiguration {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}

Validating method parameters

After registering the MethodValidationPostProcessor we can enable method parameter validation per bean by adding
the @Validated annotation. Now we can add Java Bean validation annotation to our method signatures to perform parameter validation.

@Service
@Validated
public class UserService {

    public User getUser(@NotBlank String uuid) {
        ...
    }
}

Here we added a @NotBlank annotation to make sure the passed uuid parameter is not null or an empty string.
Whenever an invalid uuid is passed a ContraintViolationException will be thrown.

Besides simple parameter validation we can also validate objects annotated with JSR 303 annotations.

For example:

public class User {

    @NotBlank
    private String name;

    // getter + setter
}

@Service
@Validated
public class UserService {

    public void createUser(@Valid User user) {
        ...
    }
}

By adding @Valid (not @Validated) we mark the user parameter for validation. The passed user object will then
be validated based on the validation constraints defined in the User class.
Here the name field should not be null or contain an empty string.

How does this work?

The MethodValidationPostProcessor bean we registered is a BeanPostProcessor that checks each bean if it is annotated with @Validated.
If thats the case it will add an AOP interceptor (MethodValidationInterceptor) to intercept method calls and performs validation.
The actual bean method is only called if the validation was successful.
Because this feature relies on AOP interceptors it works only on spring beans.

