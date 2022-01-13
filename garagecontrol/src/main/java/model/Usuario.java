package model;

public class Usuario {
	
    private int USU_COD;
    private String USU_USUARIO;
    private String USU_LOG;
    private String USU_SEN;
    private String USU_PER;

 public Usuario(){}
 
    public Usuario(int uSU_COD, String uSU_USUARIO, String uSU_LOG, String uSU_SEN, String uSU_PER) {
	super();
	USU_COD = uSU_COD;
	USU_USUARIO = uSU_USUARIO;
	USU_LOG = uSU_LOG;
	USU_SEN = uSU_SEN;
	USU_PER = uSU_PER;
}

	public int getUSU_COD() {
        return USU_COD;
    }

    public void setUSU_COD(int USU_COD) {
        this.USU_COD = USU_COD;
    }

    public String getUSU_LOG() {
        return USU_LOG;
    }

    public void setUSU_LOG(String USU_LOG) {
        this.USU_LOG = USU_LOG;
    }

    public String getUSU_SEN() {
        return USU_SEN;
    }

    public void setUSU_SEN(String USU_SEN) {
        this.USU_SEN = USU_SEN;
    }

    public String getUSU_USUARIO() {
        return USU_USUARIO;
    }

    public void setUSU_USUARIO(String USU_USUARIO) {
        this.USU_USUARIO = USU_USUARIO;
    }

    public String getUSU_PER() {
        return USU_PER;
    }

    public void setUSU_PER(String USU_PER) {
        this.USU_PER = USU_PER;
    }
    
}
