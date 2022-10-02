package app.validator;

public abstract class Validator {
	protected Validator next;
	
	protected Validator(Validator next) {
		this.next = next;
	}
	
	protected void callNextValidator() {
		if(next != null) {
			next.validate();
		}
	}
	
	public void validate() {
		this.specificValidation();
		this.callNextValidator();
	}
	
	protected abstract void specificValidation();
}
