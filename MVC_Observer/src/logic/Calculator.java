package logic;

import java.util.ArrayList;
import java.util.List;

import views.Observer;

public class Calculator {
    private List<String> history;
    private List<Observer> observers;
    
    public Calculator() {
        history = new ArrayList<>();
        observers = new ArrayList<Observer>();
    }
    
    // Agrega un observer a la lista
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer agregado");
    }
    
    // Notifica a todos los observers
    private void notifyObservers() {
    	System.out.println("len observer list: " + observers.size());
        for (Observer observer : observers) {
            observer.notificar();
            System.out.println("observer notificado");
        }
    }
    
    // Método que realiza la suma y actualiza el historial
    public int sumar(int a, int b) {
        int resultado = a + b;
        history.add(a + " + " + b + " = " + resultado);
        notifyObservers();
        return resultado;
    }
    
    // Devuelve el historial de operaciones
    public List<String> getHistory() {
        return history;
    }
}
