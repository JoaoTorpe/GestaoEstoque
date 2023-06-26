package Program;
import java.sql.Connection;
import java.util.Scanner;

import DataBase.Db;
import enteties.Produto;
import AcessoDados.*;
public class Main {
	static Scanner sc = new Scanner(System.in);
	public static Connection conn = Db.createConnection();
	public static void main(String[] args) {
		Ad Ad = new Ad();
		int op  = menu();
		while(op != 5) {
		switch (op) {
		case 1: System.out.println("-------------Adicionar dados do produto----------");
			
			System.out.print("\nID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("\nNome: ");
			String nome = sc.nextLine() ;
			
			System.out.print("\nPreco: ");
			
			Double preco = sc.nextDouble();
			
			System.out.println("\nQuantidade: ");
			int quant = sc.nextInt();
			
			Produto p = new Produto(nome, preco, quant, id);
			
			
			System.out.println("Produto adicionado: ");
			Ad.adicionarProduto(p);
			op = menu();
			break;
			
			case 2 :
			
				System.out.println("Qual o ID do produto a ser alterado ?");
					
				int idAlter = sc.nextInt();	
				System.out.println("Insira o novo nome do produto: ");
				sc.nextLine();
				String novoNome = sc.nextLine();
				System.out.println("Insira a nova quantidade do produto: ");
				int novaQuant = sc.nextInt();
				System.out.println("Insira o novo valor do produto");
				Double novoValor= sc.nextDouble();
				Ad.alterar(idAlter, novoNome, novaQuant, novoValor);
				op = menu();
				break;
				
			case 3:
				System.out.println("Insira o Id do produto a ser removido: ");
				int Id = sc.nextInt();
				Ad.remover(Id);
				System.out.println("Removido");
				op = menu();
				break;
				
			case 4:
				Ad.listarEstoque();
				op = menu();
				break;
				
			case 5:
				
				
				
				break;
				
				default:
					System.out.println("Escolha invalida!");
					op = menu();
					break;
			
			
		}
		}
		
		

	}
	
	public static int menu() {
		
		System.out.print("1-Adicionar produto\n2-Editar produto\n3-Remover produto\n4-Listar estoque\n5-Sair\n--->>>");
		int op = sc.nextInt();
		if(op == 5) {
			System.out.println("programa encerrado!");
			Db.closeConnection(conn);
		}
		return op;
		
		
	}
	
	
}
