package Alura;

import javax.swing.*;

public class menuconversor {

    public static void main(String[] args) {
        String[] opciones = { "Conversor de Moneda", "Conversor de Temperatura", "Salir" };

        int opcionSeleccionada;
        do {
            opcionSeleccionada = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcionSeleccionada) {
                case 0:
                    mostrarMenuConversorMoneda();
                    break;
                case 1:
                    convertirTemperatura();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.", "Adiós",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Introduce una opción válida.", "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        } while (opcionSeleccionada != 2);
    }

    public static void mostrarMenuConversorMoneda() {
        String[] optionsToChoose = {
                "Peso a Dólar", "Peso a Euro", "Peso a Libra", "Peso a Yen", "Peso a Won",
                "Won a Peso", "Yen a Peso", "Libra a Peso", "Euro a Peso", "Dólar a Peso", "Volver"
        };

        int opcionSeleccionada;
        do {
            opcionSeleccionada = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Conversor de Moneda",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    optionsToChoose,
                    optionsToChoose[0]);

            switch (opcionSeleccionada) {
                case 0:
                    convertirMoneda("Peso a Dólar", 0.051);
                    break;
                case 1:
                    convertirMoneda("Peso a Euro", 0.043);
                    break;
                case 2:
                    convertirMoneda("Peso a Libra", 0.038);
                    break;
                case 3:
                    convertirMoneda("Peso a Yen", 5.62);
                    break;
                case 4:
                    convertirMoneda("Peso a Won", 58.21);
                    break;
                case 5:
                    convertirMoneda("Won a Peso", 0.0172);
                    break;
                case 6:
                    convertirMoneda("Yen a Peso", 0.178);
                    break;
                case 7:
                    convertirMoneda("Libra a Peso", 26.37);
                    break;
                case 8:
                    convertirMoneda("Euro a Peso", 23.13);
                    break;
                case 9:
                    convertirMoneda("Dólar a Peso", 19.58);
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal.", "Volver",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Introduce una opción válida.", "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        } while (opcionSeleccionada != 10);
    }

    public static void convertirMoneda(String conversion, double tipoCambio) {
        double cantidad = pedirNumero("Introduce la cantidad de dinero en pesos a convertir a " + conversion + ":");
        double resultado = cantidad * tipoCambio;
        JOptionPane.showMessageDialog(null, cantidad + " Pesos son " + resultado + " " + conversion + ".", "Resultado",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void convertirTemperatura() {
        double temperaturaCelsius = pedirNumero("Introduce la temperatura en grados Celsius:");
        double temperaturaFahrenheit = temperaturaCelsius * 9 / 5 + 32;
        JOptionPane.showMessageDialog(null, temperaturaCelsius + " °C son " + temperaturaFahrenheit + " °F.",
                "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    public static double pedirNumero(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje, "Entrada de datos", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                // Si el usuario cancela, salimos del programa
                System.exit(0);
            }
            if (esNumeroValido(input)) {
                return Double.parseDouble(input);
            } else {
                JOptionPane.showMessageDialog(null, "Error: Debes ingresar un valor numérico válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static boolean esNumeroValido(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
