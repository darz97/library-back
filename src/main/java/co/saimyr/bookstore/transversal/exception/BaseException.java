package co.saimyr.bookstore.transversal.exception;


import co.saimyr.bookstore.transversal.exception.enumeration.ComponentEnum;
import co.saimyr.bookstore.transversal.exception.enumeration.TypeExceptionEnum;
import co.saimyr.bookstore.transversal.utilities.ObjectUtil;
import co.saimyr.bookstore.transversal.utilities.StringUtil;


public class BaseException extends RuntimeException {


	private static final long serialVersionUID = 5386023037822435124L;
	private TypeExceptionEnum type;
	private String userText;
	private ComponentEnum component;
	private Exception rootException;

	protected BaseException(TypeExceptionEnum type, String userText, ComponentEnum component, Exception rootException) {
		super();
		setType(type);
		setUserText(userText);
		setComponent(component);
		setRootException(rootException);
	}

	public TypeExceptionEnum getType() {
		return type;
	}

	public String getUserText() {
		return userText;
	}


	public ComponentEnum getComponent() {
		return component;
	}

	public Exception getRootException() {
		return rootException;
	}

	private void setType(TypeExceptionEnum type) {
		this.type = ObjectUtil.getDefaultValue(type, TypeExceptionEnum.getDefault());
	}

	private void setUserText(String userText) {
		this.userText = StringUtil.applyTrim(userText);
	}


	private void setComponent(ComponentEnum component) {
		this.component = ObjectUtil.getDefaultValue(component, ComponentEnum.getDefault());
	}

	private void setRootException(Exception rootException) {
		this.rootException = ObjectUtil.getDefaultValue(rootException, new Exception());
	}
}