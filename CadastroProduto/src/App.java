// import java.beans.Statement;
// import java.sql.Connection;
// import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class App {

    static List<produtos> armazena = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        // String url = "jdbc:mysql://localhost:3306/";
        // String user = "root";
        // String senha = "0910";
        // String nomeBancoDados = "Produtos";

        // try {
        //     Connection connection = DriverManager.getConnection(url , user , senha);
        //     Statement statement = connection.createStatement();
        //     String sqlCriaBanco = "CREATE DATABASE IF NOT EXISTS " + nomeBancoDados + "DEFAULT CHARACTER SET 'utf8mb4' DEFAULT COLLATE utf8mb4_general_ci" ;
        //     statement.executeUpdate(sqlCriaBanco);
        //     System.out.println("Banco de dados criado com sucesso");
        //     statement.close();
        //     connection.close();
        // }
        // catch (SQLException e){
        //     e.printStackTrace();
        // }
        // List <String> nomes = new ArrayList<>();
        // List <Integer> quantidades = new ArrayList<>();
        // List <Double> valores = new ArrayList<>();
        // List <String> tipos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String titular = titulo("Cadrastro de produto", 50) ;
            String linha = "=".repeat(50);
            System.out.println( titular);
            System.out.println("[1]Novo Produto");
            System.out.println("[2]Ver produto cadastrado");
            System.out.println("[3]Sair");
            System.out.println(linha);

            System.out.print("Sua opção: ");
            int valorOpcao = scanner.nextInt();
            if (valorOpcao == 1){
 
                System.out.print("Nome do produto: ");
                String nomeProduto = scanner.next();
                // nomes.add(nomeProduto);

                System.out.print("Quantidade: ");
                Integer quantidades = scanner.nextInt();
                // quantidades.add(quantidade);

                System.out.print("Valor:R$ ");
                Double valor = scanner.nextDouble();
                // valores.add(valor);

                System.out.print("Tipo: ");
                String tipos = scanner.next();
                // tipos.add(tipo);
                produtos novoProduto = new produtos();
                novoProduto.produto = nomeProduto;
                novoProduto.quantidade = quantidades;
                novoProduto.saldo = valor;
                novoProduto.tipo = tipos;

                armazena.add(novoProduto);   
            }else if ( valorOpcao == 2){
                if (armazena.isEmpty()){
                    System.out.println("Ainda não possue produtos cadastrados!");
                }else{
                    String mostraProduto = titulo("Produtos", 50);
                    System.out.println(mostraProduto);
                    for ( produtos produto : armazena){
                        System.out.println("nome " + produto.produto);
                        System.out.println("Quantidade " +produto.quantidade);
                        System.out.println("Valor " + produto.saldo);
                        System.out.println("tipo " + produto.tipo);
                        System.out.println();
                    }
                    System.out.println(linha);
                }
            }else if ( valorOpcao == 3){
                break;

            }else{
                System.out.println("Por favor imforme uma opção valida");
            }

        }
    }
    public static String titulo (String mensagem , int numero ) {
        String linha = "=".repeat(numero);
        return linha + "\n" + mensagem  + "\n" + linha ;
    }
}


