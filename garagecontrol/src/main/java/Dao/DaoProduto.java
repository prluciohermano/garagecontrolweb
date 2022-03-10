package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConnectionFactory;
import model.Produto;

/**
 *
 * @author Pr Lúcio Hermano
 */
public class DaoProduto {
    
    private Connection con = null;   
    
        //-----------SALVAR PRODUTO-------------||
    
    public void Salvar(Produto produto) {
        
        String sql = ("INSERT INTO PRODUTO (PRO_NOME, PRO_PLA, PRO_ANF, PRO_ANM, PRO_COR, PRO_CPK, PRO_CPM,"
                + "PRO_TAR, PRO_COM, PRO_VCI, PRO_VCL, PRO_VCD, PRO_ACE, PRO_TIP, PRO_VAL, PRO_IMG, PRO_CAT_NOME) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
 
        PreparedStatement stm = null;
             
        try {
            stm = con.prepareStatement(sql);
                    
            stm.setString(1, produto.getPRO_NOME());
            stm.setString(2, produto.getPRO_PLA());
            stm.setString(3, produto.getPRO_ANF());
            stm.setString(4, produto.getPRO_ANM());
            stm.setString(5, produto.getPRO_COR());
            stm.setString(6, produto.getPRO_CPK());
            stm.setString(7, produto.getPRO_CPM());
            stm.setString(8, produto.getPRO_TAR());
            stm.setString(9, produto.getPRO_COM());
            stm.setString(10, produto.getPRO_VCI());
            stm.setString(11, produto.getPRO_VCL());
            stm.setString(12, produto.getPRO_VCD());
            stm.setString(13, produto.getPRO_ACE());
            stm.setString(14, produto.getPRO_TIP());
            stm.setDouble(15, produto.getPRO_VAL());
            stm.setString(16, produto.getPRO_IMG());
            stm.setString(17, produto.getPRO_CAT_NOME());

            int alterado = stm.executeUpdate();
         
            if (alterado > 0){
                System.out.println("PRODUTO ALTERADO COM SUCESSO!");
            }
        } catch (Exception erro) {
        	System.out.println("Erro Inserir um Produto: " + erro);
         }       
    }
     
        //-----------BUSCA TODOS PRODUTOS-------------||
        
    public ArrayList<Produto> BuscarProduto(){
    	
        // Esse aqui preenche a tabela com os produtos
    	 
         con = ConnectionFactory.getConnection();
         ResultSet rs = null;
         PreparedStatement stm = null;
         ArrayList<Produto> produtos = new ArrayList<>();
         
         String busca = "SELECT * FROM PRODUTO ORDER BY PRO_NOME";
        
        try {
        	stm = con.prepareStatement(busca);
        	rs = stm.executeQuery();
         
            while(rs.next()){
                int PRO_COD = rs.getInt(1);
                String PRO_NOME = rs.getString(2);
                String PRO_PLA = rs.getString(3);
                String PRO_ANF = rs.getString(4);
                String PRO_ANM = rs.getString(5);
                String PRO_COR = rs.getString(6);
                String PRO_CPK = rs.getString(7);
                String PRO_CPM = rs.getString(8);
                String PRO_TAR = rs.getString(9);
                String PRO_COM = rs.getString(10);
                String PRO_VCI = rs.getString(11);
                String PRO_VCL = rs.getString(12);
                String PRO_VCD = rs.getString(13);
                String PRO_ACE = rs.getString(14);
                String PRO_TIP = rs.getString(15);               
                Double PRO_VAL = rs.getDouble(16);
                String PRO_IMG = rs.getString(17);
                String PRO_CAT_NOME = rs.getString(18);
                             
                produtos.add(new Produto(PRO_COD, PRO_NOME, PRO_PLA, PRO_ANF, PRO_ANM, PRO_COR, PRO_CPK,
                		PRO_CPM, PRO_TAR, PRO_COM, PRO_VCI, PRO_VCL, PRO_VCD, PRO_ACE, PRO_TIP, PRO_VAL,
                		PRO_IMG, PRO_CAT_NOME));
            }  
            
            return produtos;
            
        } catch (Exception erro) {
        	System.out.println("Erro Buscando todos os Produto: " + erro);
        }
        return null;
    }
    
         //-----------ATUALIZA PRODUTO-------------||
        
        public void Atualizar(Produto produto){
            
           // System.out.println("Entrou do Dao.AtualizarProduto()");
         
        String sql = ("UPDATE PRODUTO SET PRO_NOME=?, PRO_PLA=?, PRO_ANF=?, PRO_ANM=?, PRO_COR=?, PRO_CPK=?, PRO_CPM=?,"
                + "PRO_TAR=?, PRO_COM=?, PRO_VCI=?, PRO_VCL=?, PRO_VCD=?, PRO_ACE=?, PRO_TIP=?, PRO_VAL=?, PRO_IMG=?, PRO_CAT_COD = ? WHERE PRO_COD = ? ORDER BY PRO_NOME");
                
        try {
                    
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, produto.getPRO_NOME());
        stm.setString(2, produto.getPRO_PLA());
        stm.setString(3, produto.getPRO_ANF());
        stm.setString(4, produto.getPRO_ANM());
        stm.setString(5, produto.getPRO_COR());
        stm.setString(6, produto.getPRO_CPK());
        stm.setString(7, produto.getPRO_CPM());
        stm.setString(8, produto.getPRO_TAR());
        stm.setString(9, produto.getPRO_COM());
        stm.setString(10, produto.getPRO_VCI());
        stm.setString(11, produto.getPRO_VCL());
        stm.setString(12, produto.getPRO_VCD());
        stm.setString(13, produto.getPRO_ACE());
        stm.setString(14, produto.getPRO_TIP());
        stm.setDouble(15, produto.getPRO_VAL());
        stm.setString(16, produto.getPRO_IMG());
        stm.setString(17, produto.getPRO_CAT_NOME());
        
        stm.setInt(18, produto.getPRO_COD());
        
        int alterado = stm.executeUpdate();
         
            if (alterado > 0){
               // System.out.println("PRODUTO ALTERADO COM SUCESSO!");
            } else{
            	System.out.println("Produto NÃO Atualizado ZÉ!");
            }

         } catch (Exception erro) {
        	 System.out.println("Erro Atualizando um Produto: " + erro);
        }       
    }
             
        //------------DELETE PRODUTO-------------||
        
        public void Excluir(int prod){
         
        try {
                    
        PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE PRO_COD = ?");
        
        stm.setInt(1, prod);
        System.out.println("PRODUTO excluido COM SUCESSO!");
        int alterado = stm.executeUpdate();
         
            if (alterado > 0){
            	System.out.println("Produto deletado com sucesso!");
            }
        
         } catch (Exception erro) {
        	 System.out.println("Erro excluindo Produto: " + erro);
      }       
    }
        
//-----------------------BUSCA POR NOME -------------------------||
        
    public List<Produto> BuscarNome(String nome){
        
        ResultSet rs;
        PreparedStatement stm;
        List<Produto> produtos = new ArrayList<Produto>();
        
        try {
            stm = con.prepareStatement("SELECT P.PRO_COD, P.PRO_NOME, P.PRO_PLA, P.PRO_ANF, P.PRO_ANM, P.PRO_COR, P.PRO_CPK, P.PRO_CPM,"
                + "P.PRO_TAR, P.PRO_COM, P.PRO_VCI, P.PRO_VCL, P.PRO_VCD, P.PRO_ACE, P.PRO_TIP, P.PRO_VAL, P.PRO_IMG, C.CAT_NOME"
                    + " FROM PRODUTO P INNER JOIN CATEGORIA C ON PRO_CAT_COD = CAT_COD"
                    + " WHERE PRO_NOME LIKE '%" + nome + "%' ORDER BY PRO_NOME");
            rs = stm.executeQuery();
            
          while(rs.next()){
                Produto produto = new Produto();
                produto.setPRO_COD(rs.getInt("PRO_COD"));
                produto.setPRO_NOME(rs.getString("PRO_NOME"));
                produto.setPRO_PLA(rs.getString("P.PRO_PLA"));
                produto.setPRO_ANF(rs.getString("P.PRO_ANF"));
                produto.setPRO_ANM(rs.getString("P.PRO_ANM"));
                produto.setPRO_COR(rs.getString("P.PRO_COR"));
                produto.setPRO_CPK(rs.getString("P.PRO_CPK"));
                produto.setPRO_CPM(rs.getString("P.PRO_CPM"));
                produto.setPRO_TAR(rs.getString("P.PRO_TAR"));
                produto.setPRO_COM(rs.getString("P.PRO_COM"));
                produto.setPRO_VCI(rs.getString("P.PRO_VCI"));
                produto.setPRO_VCL(rs.getString("P.PRO_VCL"));
                produto.setPRO_VCD(rs.getString("P.PRO_VCD"));
                produto.setPRO_ACE(rs.getString("P.PRO_ACE"));
                produto.setPRO_TIP(rs.getString("P.PRO_TIP"));               
                produto.setPRO_VAL(rs.getDouble("P.PRO_VAL"));
                produto.setPRO_IMG(rs.getString("P.PRO_IMG"));
                produto.setPRO_CAT_NOME(rs.getString("CAT_NOME"));
                
                produtos.add(produto);
            }      
        } catch (Exception erro) {
        	System.out.println("Erro Buscando Produto por nome: " + erro);
    }
        return produtos;
}
    
    public List<Produto> BuscarCodigo(int codProd){
        
        ResultSet rs;
        PreparedStatement stm;
        List<Produto> produtos = new ArrayList<Produto>();
        
        try {
            stm = con.prepareStatement("SELECT P.PRO_COD, P.PRO_NOME, P.PRO_PLA, P.PRO_ANF, P.PRO_ANM, P.PRO_COR, P.PRO_CPK, P.PRO_CPM,"
                + "P.PRO_TAR, P.PRO_COM, P.PRO_VCI, P.PRO_VCL, P.PRO_VCD, P.PRO_ACE, P.PRO_TIP, P.PRO_VAL, P.PRO_IMG, C.CAT_NOME"
                    + " FROM PRODUTO P INNER JOIN CATEGORIA C ON PRO_CAT_COD = CAT_COD"
                    + " WHERE PRO_COD = " + codProd);
            rs = stm.executeQuery();
            
          while(rs.next()){
                Produto produto = new Produto();
                produto.setPRO_COD(rs.getInt("PRO_COD"));
                produto.setPRO_NOME(rs.getString("PRO_NOME"));
                produto.setPRO_PLA(rs.getString("P.PRO_PLA"));
                produto.setPRO_ANF(rs.getString("P.PRO_ANF"));
                produto.setPRO_ANM(rs.getString("P.PRO_ANM"));
                produto.setPRO_COR(rs.getString("P.PRO_COR"));
                produto.setPRO_CPK(rs.getString("P.PRO_CPK"));
                produto.setPRO_CPM(rs.getString("P.PRO_CPM"));
                produto.setPRO_TAR(rs.getString("P.PRO_TAR"));
                produto.setPRO_COM(rs.getString("P.PRO_COM"));
                produto.setPRO_VCI(rs.getString("P.PRO_VCI"));
                produto.setPRO_VCL(rs.getString("P.PRO_VCL"));
                produto.setPRO_VCD(rs.getString("P.PRO_VCD"));
                produto.setPRO_ACE(rs.getString("P.PRO_ACE"));
                produto.setPRO_TIP(rs.getString("P.PRO_TIP"));               
                produto.setPRO_VAL(rs.getDouble("P.PRO_VAL"));
                produto.setPRO_IMG(rs.getString("P.PRO_IMG"));
                produto.setPRO_CAT_NOME(rs.getString("P.CAT_NOME"));
                produtos.add(produto);
                
            }      
        } catch (Exception erro) {
        	System.out.println("Erro Buscando Produto por nome: " + erro);
    }
        return produtos;
}

}
