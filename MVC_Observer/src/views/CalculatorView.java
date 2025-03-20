package views;

import javax.swing.*;

import controllers.CalculatorController;
import logic.Calculator;

import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorView extends JFrame implements Observer {
    private JTextField txtNumber1;
    private JTextField txtNumber2;
    private JButton btnSumar;
    private JLabel lblResult;
    private JList<String> listHistory;
    private DefaultListModel<String> listModel;
    
    // Referencia al modelo para poder consultar el historial en notificar()
    
    private CalculatorController controller;
    
    public CalculatorView(CalculatorController controller) {
        this.controller = controller;
        
        setTitle("Calculadora con Historial (MVC + Observer)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JLabel lbl1 = new JLabel("Número 1:");
        lbl1.setBounds(20, 20, 80, 25);
        getContentPane().add(lbl1);
        
        txtNumber1 = new JTextField();
        txtNumber1.setBounds(100, 20, 100, 25);
        getContentPane().add(txtNumber1);
        
        JLabel lbl2 = new JLabel("Número 2:");
        lbl2.setBounds(20, 60, 80, 25);
        getContentPane().add(lbl2);
        
        txtNumber2 = new JTextField();
        txtNumber2.setBounds(100, 60, 100, 25);
        getContentPane().add(txtNumber2);
        
        btnSumar = new JButton("Sumar");
        btnSumar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (controller != null) {
                    try {
                        int resultado = controller.handleSum(txtNumber1.getText(), txtNumber2.getText());
                        lblResult.setText("Resultado: " + resultado);
                    } catch (NumberFormatException ex) {
                        lblResult.setText("Error: ingrese números válidos");
                    }
                }
        	}
        });
        btnSumar.setBounds(220, 40, 100, 25);
        getContentPane().add(btnSumar);
        
        lblResult = new JLabel("Resultado:");
        lblResult.setBounds(20, 100, 300, 25);
        getContentPane().add(lblResult);
        
        // Lista de historial
        listModel = new DefaultListModel<>();
        listHistory = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listHistory);
        scrollPane.setBounds(20, 140, 440, 200);
        getContentPane().add(scrollPane);
    }
    
    // Método del Observer: se invoca cuando el modelo notifica un cambio.
    @Override
    public void notificar() {
        List<String> history = controller.getHistory();
        System.out.println("history: " + history);
        listModel.clear();
        for (String entry : history) {
        	System.out.println("entry: "+ entry);
            listModel.addElement(entry);
        }
    }
    
    // Getters que usará el controlador
    public JTextField getTxtNumber1() {
        return txtNumber1;
    }
    
    public JTextField getTxtNumber2() {
        return txtNumber2;
    }
    
    public JButton getBtnSumar() {
        return btnSumar;
    }
    
    // Permite actualizar la etiqueta del resultado
    public void setLblResult(String text) {
        lblResult.setText(text);
    }
}
