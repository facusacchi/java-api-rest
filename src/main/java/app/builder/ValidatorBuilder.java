package app.builder;

import app.domain.Entity;
import app.validator.Validator;
import app.validator.impl.EntityValidator;
import app.validator.impl.LongPathVariableValidator;
import app.validator.impl.StringPathVariableValidator;

public class ValidatorBuilder {
	
	private Validator validator;
	
	public ValidatorBuilder withEntityValidator(Entity entity) {
		this.validator = new EntityValidator(entity, validator);
		return this;
	}
	
	public ValidatorBuilder withLongPathVariableValidator(Long value) {
		this.validator = new LongPathVariableValidator(value, validator);
		return this;
	}
	
	public ValidatorBuilder withStringPathVariableValidator(String value) {
		this.validator = new StringPathVariableValidator(value, validator);
		return this;
	}
	
	public Validator build() {
		return this.validator;
	}
}
