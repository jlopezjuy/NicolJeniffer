package e.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateUtil {

	public static String getFechaString(Date fecha, String formato) {
		String fechaString = getFechaString(fecha, formato, null);
		if (fechaString == null) {
			fechaString = getFechaString(fecha, formato, new Locale("es"));
		}
		if (fechaString == null) {
			fechaString = getFechaString(fecha, formato, new Locale("en"));
		}
		return fechaString;
	}

	public static String getFechaString(Date fecha, String formato, Locale locale) {
		String fechaString = null;
		try {
			if (locale != null) {
				SimpleDateFormat sdf = new SimpleDateFormat(formato, locale);
				fechaString = sdf.format(fecha);
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				fechaString = sdf.format(fecha);
			}
		} catch (Exception e) {
			fechaString = null;
			e.printStackTrace();
		}
		return fechaString;
	}

	public static Integer getFechaInteger(Date fecha) {
		String dateString = getFechaString(fecha, "yyyyMMdd");
		Integer dateInteger = null;
		try {
			dateInteger = Integer.valueOf(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateInteger;
	}
}
