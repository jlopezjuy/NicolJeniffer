package ar.com.clothes.util;

public abstract class StringUtil {
	public static boolean esVacio(String texto) {
		return texto == null || texto.trim().isEmpty();

	}
}
