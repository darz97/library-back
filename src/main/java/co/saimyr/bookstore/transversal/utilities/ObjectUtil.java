package co.saimyr.bookstore.transversal.utilities;

import org.apache.commons.lang3.ObjectUtils;

public class ObjectUtil {

	private ObjectUtil() {
	}

	public static <T> boolean objectIsNull(T object) {
		return object == null;
	}

	public static <T> T getDefaultValue(T value, T defaultValue) {
		return ObjectUtils.defaultIfNull(value, defaultValue);
	}
}