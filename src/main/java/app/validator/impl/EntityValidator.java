package app.validator.impl;

import app.domain.Entity;
import app.exception.InputFieldsEmptyException;
import app.exception.RequestBodyNullException;
import app.validator.Validator;

public class EntityValidator extends Validator {
	
	private Entity entity;

	public EntityValidator(Entity entity, Validator next) {
		super(next);
		this.entity = entity;
	}

	@Override
	public void specificValidation() {
		if(entity == null) {
			throw new RequestBodyNullException("Error: Entidad nula. No se pudo construir el recurso. ");
		}
		
		if(!entity.isValid()) {
			throw new InputFieldsEmptyException("Error: Campos vacíos requeridos. ");
		}
	}
}
