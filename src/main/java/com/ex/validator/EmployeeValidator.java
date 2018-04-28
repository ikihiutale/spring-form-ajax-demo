package com.ex.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ex.model.Employee;

public class EmployeeValidator implements Validator {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LOG.info("validate employee name {}", ((Employee)target).getName());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "employee.name.required");
	}
}
