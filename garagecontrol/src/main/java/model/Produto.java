package model;

public class Produto {
	
	private int PRO_COD;
    private String PRO_NOME;
    private String PRO_PLA;
    private String PRO_ANF;
    private String PRO_ANM;
    private String PRO_COR;
    private String PRO_CPK;
    private String PRO_CPM;
    private String PRO_TAR;
    private String PRO_COM;
    private String PRO_VCI;
    private String PRO_VCL;
    private String PRO_VCD;
    private String PRO_ACE;
    private String PRO_TIP;
    private double PRO_VAL;
    private String PRO_IMG;
    private String PRO_CAT_NOME;   
 
    public Produto() {}



	public Produto(int pRO_COD, String pRO_NOME, String pRO_PLA, String pRO_ANF, String pRO_ANM, String pRO_COR,
			String pRO_CPK, String pRO_CPM, String pRO_TAR, String pRO_COM, String pRO_VCI, String pRO_VCL,
			String pRO_VCD, String pRO_ACE, String pRO_TIP, double pRO_VAL, String pRO_IMG, String pRO_CAT_NOME) {
		super();
		PRO_COD = pRO_COD;
		PRO_NOME = pRO_NOME;
		PRO_PLA = pRO_PLA;
		PRO_ANF = pRO_ANF;
		PRO_ANM = pRO_ANM;
		PRO_COR = pRO_COR;
		PRO_CPK = pRO_CPK;
		PRO_CPM = pRO_CPM;
		PRO_TAR = pRO_TAR;
		PRO_COM = pRO_COM;
		PRO_VCI = pRO_VCI;
		PRO_VCL = pRO_VCL;
		PRO_VCD = pRO_VCD;
		PRO_ACE = pRO_ACE;
		PRO_TIP = pRO_TIP;
		PRO_VAL = pRO_VAL;
		PRO_IMG = pRO_IMG;
		PRO_CAT_NOME = pRO_CAT_NOME;
	}



	public int getPRO_COD() {
		return PRO_COD;
	}

	public void setPRO_COD(int pRO_COD) {
		PRO_COD = pRO_COD;
	}

	public String getPRO_NOME() {
		return PRO_NOME;
	}

	public void setPRO_NOME(String pRO_NOME) {
		PRO_NOME = pRO_NOME;
	}

	public String getPRO_PLA() {
		return PRO_PLA;
	}

	public void setPRO_PLA(String pRO_PLA) {
		PRO_PLA = pRO_PLA;
	}

	public String getPRO_ANF() {
		return PRO_ANF;
	}

	public void setPRO_ANF(String pRO_ANF) {
		PRO_ANF = pRO_ANF;
	}

	public String getPRO_ANM() {
		return PRO_ANM;
	}

	public void setPRO_ANM(String pRO_ANM) {
		PRO_ANM = pRO_ANM;
	}

	public String getPRO_COR() {
		return PRO_COR;
	}

	public void setPRO_COR(String pRO_COR) {
		PRO_COR = pRO_COR;
	}

	public String getPRO_CPK() {
		return PRO_CPK;
	}

	public void setPRO_CPK(String pRO_CPK) {
		PRO_CPK = pRO_CPK;
	}

	public String getPRO_CPM() {
		return PRO_CPM;
	}

	public void setPRO_CPM(String pRO_CPM) {
		PRO_CPM = pRO_CPM;
	}

	public String getPRO_TAR() {
		return PRO_TAR;
	}

	public void setPRO_TAR(String pRO_TAR) {
		PRO_TAR = pRO_TAR;
	}

	public String getPRO_COM() {
		return PRO_COM;
	}

	public void setPRO_COM(String pRO_COM) {
		PRO_COM = pRO_COM;
	}

	public String getPRO_VCI() {
		return PRO_VCI;
	}

	public void setPRO_VCI(String pRO_VCI) {
		PRO_VCI = pRO_VCI;
	}

	public String getPRO_VCL() {
		return PRO_VCL;
	}

	public void setPRO_VCL(String pRO_VCL) {
		PRO_VCL = pRO_VCL;
	}

	public String getPRO_VCD() {
		return PRO_VCD;
	}

	public void setPRO_VCD(String pRO_VCD) {
		PRO_VCD = pRO_VCD;
	}

	public String getPRO_ACE() {
		return PRO_ACE;
	}

	public void setPRO_ACE(String pRO_ACE) {
		PRO_ACE = pRO_ACE;
	}

	public String getPRO_TIP() {
		return PRO_TIP;
	}

	public void setPRO_TIP(String pRO_TIP) {
		PRO_TIP = pRO_TIP;
	}

	public double getPRO_VAL() {
		return PRO_VAL;
	}

	public void setPRO_VAL(double pRO_VAL) {
		PRO_VAL = pRO_VAL;
	}

	public String getPRO_IMG() {
		return PRO_IMG;
	}

	public void setPRO_IMG(String pRO_IMG) {
		PRO_IMG = pRO_IMG;
	}

	public String getPRO_CAT_NOME() {
		return PRO_CAT_NOME;
	}

	public void setPRO_CAT_NOME(String pRO_CAT_NOME) {
		PRO_CAT_NOME = pRO_CAT_NOME;
	}

	@Override
	public String toString() {
		return "Produto [PRO_COD=" + PRO_COD + ", PRO_NOME=" + PRO_NOME + ", PRO_PLA=" + PRO_PLA + ", PRO_ANF="
				+ PRO_ANF + ", PRO_ANM=" + PRO_ANM + ", PRO_COR=" + PRO_COR + ", PRO_CPK=" + PRO_CPK + ", PRO_CPM="
				+ PRO_CPM + ", PRO_TAR=" + PRO_TAR + ", PRO_COM=" + PRO_COM + ", PRO_VCI=" + PRO_VCI + ", PRO_VCL="
				+ PRO_VCL + ", PRO_VCD=" + PRO_VCD + ", PRO_ACE=" + PRO_ACE + ", PRO_TIP=" + PRO_TIP + ", PRO_VAL="
				+ PRO_VAL + ", PRO_IMG=" + PRO_IMG + ", PRO_CAT_NOME=" + PRO_CAT_NOME + "]";
	}
	
	

}
