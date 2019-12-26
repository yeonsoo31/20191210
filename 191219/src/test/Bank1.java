package test;

import java.util.*;

public class Bank1 {
	
	private String name, account;
	private int number, balance;
	
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	Bank1(int number, String name, String account, int balance){
		this.number = number;
		this.name = name;
		this.account = account;
		this.balance = balance;
	}
	

	
	void deposit(int deposit){
		balance = balance+deposit;
		System.out.println("입금 완료.");
	}

	void withdraw(int withdraw) {
		
		if(balance<withdraw) {
			System.out.println("잔액 부족으로 출금불가.");
		} else {
			balance = balance-withdraw;
			System.out.println("출금 완료.");
		}
	}
	
	
	@Override
	public String toString() {
		return "Bank1 [고객번호=" + number + ", 이름=" + name + ", 계좌번호=" + account + ", 잔액=" + balance + "]";
	}
	
	
	
	
	
	
	
	
	
}
