package model;

import java.io.Serializable;
import java.util.Objects;

public class ModelTelefone implements Serializable 	{

	private static final long serialVersionUID = 1L;
	
	private Long tel_id;
	private String tel_num;
	
	private ModelUsuario user_pai_id;
	private ModelUsuario user_cad_id;
	
	
	
	public Long getTel_id() {
		return tel_id;
	}
	public void setTel_id(Long tel_id) {
		this.tel_id = tel_id;
	}
	public String getTel_num() {
		return tel_num;
	}
	public void setTel_num(String tel_num) {
		this.tel_num = tel_num;
	}
	public ModelUsuario getUser_pai_id() {
		return user_pai_id;
	}
	public void setUser_pai_id(ModelUsuario user_pai_id) {
		this.user_pai_id = user_pai_id;
	}
	public ModelUsuario getUser_cad_id() {
		return user_cad_id;
	}
	public void setUser_cad_id(ModelUsuario user_cad_id) {
		this.user_cad_id = user_cad_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(tel_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelTelefone other = (ModelTelefone) obj;
		return Objects.equals(tel_id, other.tel_id);
	}
	
	
}
