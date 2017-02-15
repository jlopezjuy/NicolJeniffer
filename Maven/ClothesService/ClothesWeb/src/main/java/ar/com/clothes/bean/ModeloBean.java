package ar.com.clothes.bean;


public class ModeloBean extends BaseBean {
	// private static final Logger LOG = Logger.getLogger(ModeloBean.class);
	// private int idModelos;
	// private Cliente clientes;
	// private byte[] imagen;
	// private String nombreModelo;
	// private String observacion;
	// private String colorVestido;
	// private Modelos modeloSelect;
	// private List<Modelos> listaModelos;
	// private String imagenTemp;
	// private StreamedContent imageLoad;
	//
	// public ModeloBean() {
	// super();
	// }
	//
	// /**
	// * Metodo para guardar un nuevo Modelo
	// * @return
	// * @author JLopez
	// * @since 31/10/2015
	// * @version 1.0
	// */
	// public String gurdarModelo() {
	// try {
	//
	// getServicioModelo().guardarModelo(getModeloNuevo());
	// limpiarFormulario();
	// } catch (ExcepcionServicio e) {
	// LOG.error(e);
	// return null;
	//
	// }
	// return "listaModeloView";
	// }
	//
	// public Boolean validateInsert(){
	// Boolean validate = Boolean.TRUE;
	//
	// return validate;
	// }
	//
	// /**
	// * Metodo para obtenr un nuevo modelo
	// *
	// * @return Modelos
	// * @author JLopez
	// * @since 31/10/2015
	// * @version 1.0
	// */
	// private Modelos getModeloNuevo(){
	// Modelos modelo = new Modelos();
	// modelo.setClientes(clientes);
	// modelo.setNombreModelo(nombreModelo);
	// modelo.setObservacion(observacion);
	// modelo.setImagen(imagen);
	// modelo.setColorVestido(colorVestido);
	// return modelo;
	// }
	//
	// /**
	// * Metodo par cancelar el alta de un modelo
	// *
	// * @return
	// * @author JLopez
	// * @since 31/10/2015
	// * @version 1.0
	// */
	// public String cancelarModelo(){
	// limpiarFormulario();
	// return "listaModeloView";
	// }
	//
	// /**
	// * Metodo para limpiar el formulario
	// * @author JLopez
	// * @since 31/10/2015
	// * @version 1.0
	// */
	// private void limpiarFormulario(){
	// imagen = null;
	// nombreModelo = null;
	// observacion = null;
	// colorVestido = null;
	// imagenTemp = null;
	// }
	//
	//
	// public void handleFileUpload(FileUploadEvent event) {
	// FacesMessage message = new FacesMessage("Succesful",
	// event.getFile().getFileName() + " is uploaded.");
	// FacesContext.getCurrentInstance().addMessage(null, message);
	// LOG.debug("econtro el siguiente archivo: "+event.getFile().getFileName());
	//
	// try {
	// UploadedFile upFile = event.getFile();
	//
	// InputStream input = event.getFile().getInputstream();
	// LOG.debug("VALOR DE LA IMAGEN EN uploadedFile: "+upFile.getFileName() +
	// " valor: "+ upFile.getContentType());
	// byte[] buffer = new byte[8192];
	// int bytesRead;
	// ByteArrayOutputStream output = new ByteArrayOutputStream();
	// while ((bytesRead = input.read(buffer)) != -1)
	// {
	// output.write(buffer, 0, bytesRead);
	// }
	// imagen = output.toByteArray();
	// imagenTemp = new sun.misc.BASE64Encoder().encode(output.toByteArray());
	// LOG.debug("CONVERTIDO EN BASE 64: "+ imagenTemp);
	// LOG.debug("Cadena de la imagen: "+output.toByteArray());
	// RequestContext.getCurrentInstance().update("form");
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * Metodo para mostrar imagen seleccionada en el datatable
	// * @return
	// * @author JLopez
	// * @since 19/11/2015
	// * @versio 1.0
	// */
	// public String getLoadImage(){
	// if(null != this.getImagen()){
	// imageLoad = new DefaultStreamedContent(new
	// ByteArrayInputStream(this.getImagen()));
	// RequestContext.getCurrentInstance().update("form");
	//
	// this.refreshCurrentPage();
	// }
	// return null;
	// }
	//
	//
	// public StreamedContent getImage() throws IOException {
	// FacesContext context = FacesContext.getCurrentInstance();
	//
	// if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	// // So, we're rendering the HTML. Return a stub StreamedContent so that it
	// will generate right URL.
	// return new DefaultStreamedContent();
	// }
	// else {
	// // So, browser is requesting the image. Return a real StreamedContent with
	// the image bytes.
	// String studentId =
	// context.getExternalContext().getRequestParameterMap().get("idModelos");
	// Modelos student =
	// getServicioModelo().findById(Integer.valueOf(studentId).intValue());
	// return new DefaultStreamedContent(new
	// ByteArrayInputStream(student.getImagen()));
	// }
	// }
	//
	// /**
	// * Metodo para refrescar el current Page
	// * @author JLopez
	// * @since 19/11/2015
	// * @version 1.0
	// */
	// public void refreshCurrentPage(){
	// FacesContext context = FacesContext.getCurrentInstance();
	// String viewId = context.getViewRoot().getViewId();
	// ViewHandler handler = context.getApplication().getViewHandler();
	// UIViewRoot root = handler.createView(context, viewId);
	// root.setViewId(viewId);
	// context.setViewRoot(root);
	// }
	//
	//
	// public int getIdModelos() {
	// return this.idModelos;
	// }
	//
	// public void setIdModelos(int idModelos) {
	// this.idModelos = idModelos;
	// }
	//
	// public Clientes getClientes() {
	// return this.clientes;
	// }
	//
	// public void setClientes(Clientes clientes) {
	// this.clientes = clientes;
	// }
	//
	// public byte[] getImagen() {
	// return this.imagen;
	// }
	//
	// public void setImagen(byte[] imagen) {
	// this.imagen = imagen;
	// }
	//
	// public String getNombreModelo() {
	// return this.nombreModelo;
	// }
	//
	// public void setNombreModelo(String nombreModelo) {
	// this.nombreModelo = nombreModelo;
	// }
	//
	// public String getObservacion() {
	// return this.observacion;
	// }
	//
	// public void setObservacion(String observacion) {
	// this.observacion = observacion;
	// }
	//
	// public String getColorVestido() {
	// return this.colorVestido;
	// }
	//
	// public void setColorVestido(String colorVestido) {
	// this.colorVestido = colorVestido;
	// }
	//
	// public Modelos getModeloSelect() {
	// return modeloSelect;
	// }
	//
	// public void setModeloSelect(Modelos modeloSelect) {
	// this.modeloSelect = modeloSelect;
	// }
	//
	// public List<Modelos> getListaModelos() {
	// try {
	// listaModelos = getServicioModelo().listAll(clientes);
	// LOG.debug("cantidad de datos: " + listaModelos.size());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return listaModelos;
	// }
	//
	// public void setListaModelos(List<Modelos> listaModelos) {
	// this.listaModelos = listaModelos;
	// }
	//
	// public String getImagenTemp() {
	// return imagenTemp;
	// }
	//
	// public void setImagenTemp(String imagenTemp) {
	// this.imagenTemp = imagenTemp;
	// }
	//
	// public StreamedContent getImageLoad() {
	// return imageLoad;
	// }
	//
	// public void setImageLoad(StreamedContent imageLoad) {
	// this.imageLoad = imageLoad;
	// }
	//

}
