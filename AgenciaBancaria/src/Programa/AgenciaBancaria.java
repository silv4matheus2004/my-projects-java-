package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner teclado = new Scanner( System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	 
	
	public static void operacoes() {

		System.out.println("------------------------------------------------");
		System.out.println("---- bem vindos a sua �gencia banc�ria ---- ");
		System.out.println("------------------------------------------------");
		System.out.println("************** selecione a opera��o ************");
		System.out.println("------------------------------------------------");
		System.out.println("[    op��o 1 - criar conta    ]");
		System.out.println("[    op��o 2 - depositar      ]");
		System.out.println("[    op��o 3 - sacar          ]");
		System.out.println("[    op��o 4 - transferir     ]");
		System.out.println("[    op��o 5 - listar contas  ]");
		System.out.println("[    op��o 6 - sair           ]");
	
		int operacao =  teclado.nextInt();
		
		
		
		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println(" obrigado por usar o nossa �gencia, tmj aliado ");
			System.exit(0);
			
			default:
				System.out.println(" op��o inv�lida !!!");
				break;		
		}
	}



public static void criarConta() {
	
	System.out.println("\nNome: ");
	String nome = teclado.next();
	
	System.out.println("\nCpf: ");
	String Cpf = teclado.next();
	
	System.out.println("\nEmail: ");
	String email = teclado.next();
	
	
	
	Cliente cliente = new Cliente(nome, Cpf, email);
	
	
	Conta conta = new Conta (cliente);
	
	contasBancarias.add(conta);
	System.out.println("  sua conta foi criada com sucesso !!! ");
	
	
	operacoes();

   }


private static Conta encontrarConta(int numeroConta) {
	Conta conta = null;
	if(contasBancarias.size() > 0) {
		for(Conta c:contasBancarias) {
		if(c.getNumeroConta() == numeroConta);{
		conta = c;
			}
		}		
		
	}
	return conta;
}	
	
	public static void depositar() {
		System.out.println(" n�mero da conta:  ");
		int numeroConta = teclado.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		
	if(conta != null) {
		System.out.println(" qual valor deseja depositar ? ");
		double valorDeposito = teclado.nextDouble();
		conta.depositar(valorDeposito);
		System.out.println(" sua graninha foi depositada com sucesso !!!");
	}else {
		System.out.println(" conta n�o encontrada !");
	}
	operacoes();
}

public static void sacar() {
	System.out.println(" n�mero da conta:  ");
	int numeroConta = teclado.nextInt();
	
	Conta conta = encontrarConta(numeroConta);
	
	if(conta != null) {
		System.out.println(" qual valor deseja sacar ? ");
		double valorSaque = teclado.nextDouble();
		conta.sacar(valorSaque);
		//System.out.println(" valor sacado com sucesso ");
	}else {
		System.out.println(" conta n�o encontrada !");
	}
	operacoes();
}

	public static void transferir() {
		System.out.println("n�mero da conta do remetente: ");
		int numeroContaRemetente = teclado.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println(" n�mero da conta do destinat�rio: ");
			int numeroContaDestinatario = teclado.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println(" Valor da transf�rencia : ");
				Double valor = teclado.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}else {
				System.out.println("  a conta para  dep�sito n�o foi  encontrada");
			}
		}else {
			System.out.println(" a conta para trasnferencia n�o foi encontrada ");
		}
		operacoes();
	}

		public static void listarContas() {
		if(contasBancarias.size()>0) {
		for(Conta conta: contasBancarias) {
		System.out.println(conta);
		}
		}else {
		System.out.println(" n�o h� contas cadastradas");
		
	}
		operacoes();
}




}
