package co.saimyr.bookstore.transversal.utilities;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	private static final String BLANK_SPACE = " ";
	private static final String BLANK_SPACES = " +";

	private StringUtil() {
	}

	public static String getDefaultValue(String value) {
		return StringUtils.defaultString(value);
	}

	public static String applyTrim(String value) {
		value = StringUtils.trimToEmpty(value);
		value = value.replaceAll(BLANK_SPACES, BLANK_SPACE).trim();
		return value;
	}

	public static boolean isEmpty(String valor) {
		return StringUtils.EMPTY.equals(applyTrim(valor));
	}



}
