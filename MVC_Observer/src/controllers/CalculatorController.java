package controllers;

import java.util.List;

import logic.Calculator;

public class CalculatorController {
	private Calculator model;
	
	public CalculatorController(Calculator calculator) {
		this.model = calculator;
	}
	
	public int handleSum(String n1, String n2) {
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		
		int resultado = this.model.sumar(num1, num2);
		
		return resultado; 
	}

	public List<String> getHistory() {
		return this.model.getHistory();
	}
}
