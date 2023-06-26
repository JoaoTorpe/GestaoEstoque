package AcessoDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Program.*;
import enteties.Produto;
public class Ad {

	public void adicionarProduto(Produto p) {
				try {
			PreparedStatement st = Main.conn.prepareStatement("insert into Produto (id_produto,nome_produto,quant_produto,preco) values (?,?,?,?)");
			st.setInt(1, p.getId());
			st.setString(2,p.getNome());
			st.setInt(3, p.getQuantidade());
			st.setDouble(4, p.getPreco());
			st.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void listarEstoque() {
		Produto p = new Produto();
		Double valorTotal = 0.0;
			try {
				PreparedStatement st = Main.conn.prepareStatement("select * from Produto");
				
				ResultSet rs = st.executeQuery();
				System.out.println(" ");
				while(rs.next()) {
					System.out.println("Id: "+rs.getInt("id_produto")+"| "+rs.getString("nome_produto") +"| Quantidade: "+rs.getInt("quant_produto")+"| Preco: R$"+rs.getDouble("preco"));
					 valorTotal += p.precoTotal(rs.getDouble("preco") , rs.getInt("quant_produto") ) ; 
					 
					
				}
				 System.out.println("\nValor total no estoque: R$"+valorTotal);
				System.out.println(" ");
				
			} catch (SQLException e) {
					e.printStackTrace();
			}
		
	}
	
	public void remover(int id) {
		
		try {
			PreparedStatement st = Main.conn.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
			st.setInt(1, id);
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void  alterar(int id,String novoNome, int novaQuant,Double novoValor) {
		
		try {
			PreparedStatement st = Main.conn.prepareStatement("update produto set nome_produto = ? , quant_produto = ?,preco = ? where id_produto = ?");
			st.setString(1, novoNome);
			st.setInt(2, novaQuant);
			st.setDouble(3, novoValor);
			st.setInt(4, id);
			
			st.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Produto alterado com sucesso!");
		
		
	}
	
	
	
	
	
	
	
}
