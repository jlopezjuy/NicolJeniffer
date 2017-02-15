package ar.com.clothes.bean;

import org.apache.log4j.Logger;

public class MensajeBean extends BaseBean {
	private final static Logger LOG = Logger.getLogger(MensajeBean.class);

	public MensajeBean() {
		super();
		LOG.debug("");
	}

	public String volver() {
		return "";// getMensajeDto().getRetorno();
	}

	public String siguiente() {
		return "";// getMensajeDto().getSiguiente();
	}

}
