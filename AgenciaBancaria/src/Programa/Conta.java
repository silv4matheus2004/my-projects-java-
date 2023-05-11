package Programa;

import utilitarios.Utils;

public class Conta {
	
	private static int contadorDeContas = 1;
	
	private int numeroConta;
	private Cliente cliente;
	private double saldo = 0.0;
	
	public Conta(Cliente cliente) {
		this.numeroConta = contadorDeContas;
		this.cliente = cliente;
		contadorDeContas++;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "\nNúmero da conta: " + this.getNumeroConta() +
				"\nNome: " + this.cliente.getNome() +
				"\nCPF: " + this.cliente.getCPF() +
				"\nEmail: " + this.cliente.getEmail() +
				"\nSaldo: " + Utils.doubletoString(this.getSaldo()) +
				"\n";
	}
	
	public void depositar(double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o depósito!");
		}
	}
	
	public void sacar(double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}
	
	public void transferir(Conta contaParaDeposito, double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor);
			System.out.println("Transferência realizada com sucesso!");
		} else {
			System.out.println("Não foi possível realizar a transferência!");
		}
	}
}




























	

