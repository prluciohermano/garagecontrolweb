package model;

public class Usuario {
	
    private int USU_COD;
    private String USU_USUARIO;
    private String USU_LOG;
    private String USU_SENHA;
    private String USU_PER;

 public Usuario(){}
 
 
 
	public Usuario(int uSU_COD, String uSU_USUARIO, String uSU_LOG, String uSU_SENHA, String uSU_PER) {
	super();
	USU_COD = uSU_COD;
	USU_USUARIO = uSU_USUARIO;
	USU_LOG = uSU_LOG;
	USU_SENHA = uSU_SENHA;
	USU_PER = uSU_PER;
}



	public Usuario(String uSU_USUARIO, String uSU_LOG, String uSU_SENHA, String uSU_PER) {
	super();
	USU_USUARIO = uSU_USUARIO;
	USU_LOG = uSU_LOG;
	USU_SENHA = uSU_SENHA;
	USU_PER = uSU_PER;
}

	public int getUSU_COD() {
		return USU_COD;
	}

	public void setUSU_COD(int uSU_COD) {
		USU_COD = uSU_COD;
	}

	public String getUSU_USUARIO() {
		return USU_USUARIO;
	}

	public void setUSU_USUARIO(String uSU_USUARIO) {
		USU_USUARIO = uSU_USUARIO;
	}

	public String getUSU_LOG() {
		return USU_LOG;
	}

	public void setUSU_LOG(String uSU_LOG) {
		USU_LOG = uSU_LOG;
	}

	public String getUSU_SENHA() {
		return USU_SENHA;
	}

	public void setUSU_SENHA(String uSU_SENHA) {
		USU_SENHA = uSU_SENHA;
	}

	public String getUSU_PER() {
		return USU_PER;
	}

	public void setUSU_PER(String uSU_PER) {
		USU_PER = uSU_PER;
	}



	
}
