package co.saimyr.bookstore.transversal.exception.enumeration;

public enum TypeExceptionEnum {

	BUSINESS("Business", "It is an exception type thrown from a business flow, due to a specific business rule violation."), APPLICATION("Application", "It is an exception type thrown from anywhere in the application.");

	private String name;
	private String description;

	private TypeExceptionEnum(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public static TypeExceptionEnum getDefault() {
		return APPLICATION;
	}
}
