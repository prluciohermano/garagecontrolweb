package model;

public class Clientes {

	private int PES_COD;
	private String PES_NOME;
	private String PES_RG;
	private String PES_CPF;
	private String PES_DTNASCIMENTO;
	private String PES_CEP;
	private String PES_TEL;
	private String PES_RUA;
	private String PES_NUM;
	private String PES_BAI;
	private String PES_CID;
	private String PES_UF;
	private String PES_COMP;
	private String PES_DTCADASTRO;
	private String PES_STATUS;

	public Clientes() {
		super();
	}

	public Clientes(int pES_COD, String pES_NOME, String pES_RG, String pES_CPF, String pES_DTNASCIMENTO,
			String pES_CEP, String pES_TEL, String pES_RUA, String pES_NUM, String pES_BAI,
			String pES_CID, String pES_UF, String pES_COMP, String pES_DTCADASTRO, String pES_STATUS) {
		super();
		PES_COD = pES_COD;
		PES_NOME = pES_NOME;
		PES_RG = pES_RG;
		PES_CPF = pES_CPF;
		PES_DTNASCIMENTO = pES_DTNASCIMENTO;
		PES_CEP = pES_CEP;
		PES_TEL = pES_TEL;
		PES_RUA = pES_RUA;
		PES_NUM = pES_NUM;
		PES_BAI = pES_BAI;
		PES_CID = pES_CID;
		PES_UF = pES_UF;
		PES_COMP = pES_COMP;
		PES_DTCADASTRO = pES_DTCADASTRO;
		PES_STATUS = pES_STATUS;
	}

	public int getPES_COD() {
		return PES_COD;
	}

	public void setPES_COD(int pES_COD) {
		PES_COD = pES_COD;
	}

	public String getPES_NOME() {
		return PES_NOME;
	}

	public void setPES_NOME(String pES_NOME) {
		PES_NOME = pES_NOME;
	}

	public String getPES_RG() {
		return PES_RG;
	}

	public void setPES_RG(String pES_RG) {
		PES_RG = pES_RG;
	}

	public String getPES_CPF() {
		return PES_CPF;
	}

	public void setPES_CPF(String pES_CPF) {
		PES_CPF = pES_CPF;
	}

	public String getPES_DTNASCIMENTO() {
		return PES_DTNASCIMENTO;
	}

	public void setPES_DTNASCIMENTO(String pES_DTNASCIMENTO) {
		PES_DTNASCIMENTO = pES_DTNASCIMENTO;
	}

	public String getPES_CEP() {
		return PES_CEP;
	}

	public void setPES_CEP(String pES_CEP) {
		PES_CEP = pES_CEP;
	}

	public String getPES_TEL() {
		return PES_TEL;
	}

	public void setPES_TEL(String pES_TEL) {
		PES_TEL = pES_TEL;
	}

	public String getPES_RUA() {
		return PES_RUA;
	}

	public void setPES_RUA(String pES_RUA) {
		PES_RUA = pES_RUA;
	}

	public String getPES_NUM() {
		return PES_NUM;
	}

	public void setPES_NUM(String pES_NUM) {
		PES_NUM = pES_NUM;
	}

	public String getPES_BAI() {
		return PES_BAI;
	}

	public void setPES_BAI(String pES_BAI) {
		PES_BAI = pES_BAI;
	}

	public String getPES_CID() {
		return PES_CID;
	}

	public void setPES_CID(String pES_CID) {
		PES_CID = pES_CID;
	}

	public String getPES_UF() {
		return PES_UF;
	}

	public void setPES_UF(String pES_UF) {
		PES_UF = pES_UF;
	}
	
	public String getPES_COMP() {
		return PES_COMP;
	}

	public void setPES_COMP(String pES_COMP) {
		PES_COMP = pES_COMP;
	}

	public String getPES_DTCADASTRO() {
		return PES_DTCADASTRO;
	}

	public void setPES_DTCADASTRO(String pES_DTCADASTRO) {
		PES_DTCADASTRO = pES_DTCADASTRO;
	}

	public String getPES_STATUS() {
		return PES_STATUS;
	}

	public void setPES_STATUS(String pES_STATUS) {
		PES_STATUS = pES_STATUS;
	}

	@Override
	public String toString() {
		return "JavaBeans [PES_NOME=" + PES_NOME + "]";
	}	
	
	
	
}
