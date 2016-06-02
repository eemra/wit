package com.whereistango.web.temp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("emailValidator")
public class TestMailValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public TestMailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	private boolean valid(final String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();

	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		TestSubscribeForm user = (TestSubscribeForm) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty.userForm.email");

		if (!valid(user.getMail())) {
			errors.rejectValue("mail", "Pattern.userForm.email");
		}
	}
}