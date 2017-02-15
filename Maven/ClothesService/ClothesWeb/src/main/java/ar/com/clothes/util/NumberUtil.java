package ar.com.clothes.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class NumberUtil {
	public static boolean esNuloOMenorQueUno(Long numero) {
		return numero == null || numero < 1;
	}

	public static boolean esNuloOMenorQueUno(BigDecimal numero) {
		return numero == null || numero.compareTo(BigDecimal.ZERO) < 1;
	}

	public static List<Long> getListaLong(List<String> listaString) {
		List<Long> idsLong = new ArrayList<Long>();
		try {
			if (listaString != null) {
				for (String idCliente : listaString) {
					idsLong.add(new Long(idCliente));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idsLong;
	}

	public static boolean esNuloOMenorQueUno(Integer numero) {
		return numero == null || numero < 1;
	}

	public static boolean esMayorACero(BigDecimal numero) {
		return numero == null || numero.compareTo(BigDecimal.ZERO) > 0;
	}
}
