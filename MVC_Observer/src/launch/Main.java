package launch;

import javax.swing.SwingUtilities;

import controllers.CalculatorController;
import logic.Calculator;
import views.CalculatorView;

public class Main {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Crear el modelo
            Calculator model = new Calculator();
            
            // 2. Crear el controlador
            CalculatorController controller = new CalculatorController(model);
            
            // 3. Crear la vista, inyectando el controlador
            CalculatorView view = new CalculatorView(controller);
            
            // 4. Registrar la vista como observer en el modelo
            model.addObserver(view);
            
            // 5. Mostrar la ventana
            view.setVisible(true);
        });
    }
}
