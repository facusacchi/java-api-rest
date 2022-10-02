package app.validator.impl;

import app.exception.StringPathVariableException;
import app.validator.Validator;

public class StringPathVariableValidator extends Validator {

	private String value; 
	
	public StringPathVariableValidator(String value, Validator next) {
		super(next);
		this.value = value;
	}

	@Override
	protected void specificValidation() {
		if(value == null || value.isEmpty()) {
			throw new StringPathVariableException("Error: Variable en el path, String nulo o vacío. ");
		}
	}
}
