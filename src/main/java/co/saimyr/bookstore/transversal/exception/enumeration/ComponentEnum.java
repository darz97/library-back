package co.saimyr.bookstore.transversal.exception.enumeration;

public enum ComponentEnum {
	DATA, BUSINESS, API, DOMAIN, ENTITY, DTO, TRANSVERSAL, GENERAL;
	
	public static ComponentEnum getDefault() {
		return GENERAL;
	}
}
