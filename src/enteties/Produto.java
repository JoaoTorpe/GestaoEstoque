package enteties;

public class Produto {

	private String nome;
	private Double preco;
	private int quantidade;
	private int id;
	
	public Produto() {
		
	}
	
	public Produto(String nome, Double preco, int quantidade, int id) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public  Double precoTotal(Double preco , int quantidade) {
		
		return preco * quantidade;
		
		
	}
	
	
	
}
