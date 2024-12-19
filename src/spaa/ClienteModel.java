package spaa;

public class ClienteModel {
private String nombre;
private String correo;
private int num_telefono;
private String fecha_cita;
private String hora;
private int num_invitados;
public ClienteModel(String nombre,String correo,int num_telefono,String fecha_cita,String hora,int num_invitados) {
	
	this.nombre= nombre;
	this.correo= correo;
	this.num_telefono= num_telefono;
	this.fecha_cita = fecha_cita;
	this.hora = hora;
	this.num_invitados= num_invitados;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public int getNum_telefono() {
	return num_telefono;
}
public void setNum_telefono(int num_telefono) {
	this.num_telefono = num_telefono;
}
public String getFecha_cita() {
	return fecha_cita;
}
public void setFecha_cita(String fecha_cita) {
	this.fecha_cita = fecha_cita;
}
public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}
public int getNum_invitados() {
	return num_invitados;
}
public void setNum_invitados(int num_invitados) {
	this.num_invitados = num_invitados;
}


}
