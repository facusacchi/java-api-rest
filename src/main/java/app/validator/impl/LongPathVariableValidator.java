package app.validator.impl;

import app.exception.LongPathVariableException;
import app.validator.Validator;

public class LongPathVariableValidator extends Validator {
	
	private Long value;

	public LongPathVariableValidator(Long value, Validator next) {
		super(next);
		this.value = value;
	}

	@Override
	protected void specificValidation() {
		if(value == null || value.equals(0L)) {
			throw new LongPathVariableException("Error: Variable en el path, Long nulo o cero. ");
		}
	}

}
