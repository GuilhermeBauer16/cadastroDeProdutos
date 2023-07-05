
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class App {

    static List<produtos> armazena = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        produtos novoProduto = new produtos();
        double valorItem = 0.0;
        int quantidadeItem = 0 ;
        double totalCompra = 0;
        double valorOpcao = 0;
        double quantidades = 0;
        double valor = 0;

        while (true) {
            String titular = titulo("Cadrastro de produto", 50) ;
            String linha = "=".repeat(50);
            System.out.println( titular);
            System.out.println("[1]Novo Produto");
            System.out.println("[2]Ver produto cadastrado");
            System.out.println("[3]Sair");
            System.out.println(linha);
            valorOpcao = verificaNumero("Sua opção: ",valorOpcao);
            limpaTerminal();
            if (valorOpcao == 1){
                String mostraProduto = titulo("Novo produto",50);
                System.out.println(mostraProduto);
                System.out.print("Nome do produto: ");
                String nomeProduto = scanner.next();
                quantidades = verificaNumero("Digite a quantidade: ", quantidades);
                valor = verificaNumero("valor R$ ", valor);

                System.out.print("Tipo: ");
                String tipos = scanner.next();

                novoProduto.produto = nomeProduto;
                novoProduto.quantidade = quantidades;
                novoProduto.saldo = valor;
                novoProduto.tipo = tipos;
                
                armazena.add(novoProduto); 
                    totalCompra += valor;
                    quantidadeItem += quantidades;
                limpaTerminal();
            }else if ( valorOpcao == 2){
                if (armazena.isEmpty()){
                    System.out.println("Ainda não possue produtos cadastrados!");
                }else{
                    String mostraProduto = titulo("Produtos", 50);
                    System.out.println(mostraProduto);
                    for ( produtos produto : armazena){
                        System.out.println("nome: " + produto.produto);
                        System.out.println("Quantidade: " +produto.quantidade);
                        System.out.println("Valor: " + produto.saldo);
                        System.out.println("tipo: " + produto.tipo);
                        System.out.println("total: " + valorItem);
                        System.out.println();
                    }

                    System.out.println("Você comprou o total de " + quantidadeItem + "itens");
                    System.out.println("O total a pagar é de R$" + totalCompra);

                    }
                    System.out.println(linha);
                }
            else if ( valorOpcao == 3){
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

    public static double verificaNumero(String mensagen , double numero){
        boolean digitaNumero = false;
        Scanner scanner = new Scanner(System.in);
        while (!digitaNumero){
            System.out.print(mensagen);
            if (scanner.hasNextInt()){
                numero = scanner.nextInt();
                digitaNumero = true;
            }else{
                System.out.println("Você não digitou um numero");
                scanner.nextLine();
                }}
         
            
        return numero;
    }
    public static void limpaTerminal(){
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;
            
            if (os.contains("win")){
                processBuilder = new ProcessBuilder("cmd"," /c ","cls");

            }else{
                processBuilder = new ProcessBuilder("clear");
            }

            Process process = processBuilder.inheritIO().start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    }



