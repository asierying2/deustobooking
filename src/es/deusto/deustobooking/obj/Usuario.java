package es.deusto.deustobooking.obj;

public class Usuario {
    private String correo;
    private String username;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int numTel;
    private String contrasena;
    
    
    
	public Usuario(String correo, String username, String nombre, String apellido1, String apellido2, int numTel,
			String contrasena) {
		super();
		this.correo = correo;
		this.username = username;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.numTel = numTel;
		this.contrasena = contrasena;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", username=" + username + ", nombre=" + nombre + ", apellido1="
				+ apellido1 + ", apellido2=" + apellido2 + ", numTel=" + numTel + ", contrasena=" + contrasena + "]";
	}
    
    

}
