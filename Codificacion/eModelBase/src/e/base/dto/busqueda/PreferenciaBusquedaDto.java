package e.base.dto.busqueda;

public class PreferenciaBusquedaDto {
	private int resultadoMaximo;
	private int numeroDePagina;

	public PreferenciaBusquedaDto() {
		this.resultadoMaximo = 5;
		this.numeroDePagina = 0;
	}

	public PreferenciaBusquedaDto(int resultadoMaximo, int numeroDePagina) {
		this.resultadoMaximo = resultadoMaximo;
		this.numeroDePagina = numeroDePagina;
	}

	@Override
	public String toString() {
		return "resultadoMaximo: " + resultadoMaximo + ", numeroDePagina: " + numeroDePagina;
	}

	public int getResultadoMaximo() {
		return resultadoMaximo;
	}

	public void setResultadoMaximo(int resultadoMaximo) {
		this.resultadoMaximo = resultadoMaximo;
	}

	public int getNumeroDePagina() {
		return numeroDePagina;
	}

	public void setNumeroDePagina(int numeroDePagina) {
		this.numeroDePagina = numeroDePagina;
	}

}
