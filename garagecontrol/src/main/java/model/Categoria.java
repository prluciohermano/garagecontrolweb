package model;

public class Categoria {
	
	private int CAT_COD;
    private String CAT_NOME;
    
    public Categoria(){}
      
    public Categoria(int CAT_COD, String CAT_NOME) {
        this.CAT_COD = CAT_COD;
        this.CAT_NOME = CAT_NOME;
    }
    
    public int getCAT_COD() {
        return CAT_COD;
    }

    public void setCAT_COD(int CAT_COD) {
        this.CAT_COD = CAT_COD;
    }

    public String getCAT_NOME() {
        return CAT_NOME;
    }

    public void setCAT_NOME(String CAT_NOME) {
        this.CAT_NOME = CAT_NOME;
    }

	@Override
	public String toString() {
		return "Categoria [CAT_COD=" + CAT_COD + ", CAT_NOME=" + CAT_NOME + "]";
	}
    
}
