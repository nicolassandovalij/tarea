import java.util.Scanner;

public class IMC {
    public static void main(String[] args) {
        ejecutarPrograma();
    }

    public static void ejecutarPrograma() {
        Scanner scanner = new Scanner(System.in);
        double[] pesos = new double[3];
        double[] alturas = new double[3];
        String[] nombres = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese el nombre del niño #" + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
            pesos[i] = ingresarDato("Ingrese el peso del niño #" + (i + 1) + " (en kg): ");
            alturas[i] = ingresarDato("Ingrese la altura del niño #" + (i + 1) + " (en cm): ");
        }

        calcularIMCDeNinos(nombres, pesos, alturas);
    }

    public static void calcularIMCDeNinos(String[] nombres, double[] pesos, double[] alturas) {
        System.out.println("\nResultados:");

        double sumaPeso = 0;
        double sumaAltura = 0;

        for (int i = 0; i < 3; i++) {
            double imc = calcularImc(pesos[i], alturas[i]);
            String estadoImc = mostrarEstadoImc(imc);

            System.out.println("\nNiño #" + (i + 1) + ":");
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Peso: " + pesos[i] + " kg");
            System.out.println("Altura: " + alturas[i] + " cm");
            System.out.println("IMC: " + imc);
            System.out.println("Estado IMC: " + estadoImc);

            sumaPeso += pesos[i];
            sumaAltura += alturas[i];
        }

        double promedioPeso = sumaPeso / 3;
        double promedioAltura = sumaAltura / 3;

        System.out.println("\nPromedio de Peso: " + promedioPeso + " kg");
        System.out.println("Promedio de Altura: " + promedioAltura + " cm");
    }

    public static double calcularImc(double weight, double height) {
        return weight / Math.pow((height / 100), 2);
    }

    public static String mostrarEstadoImc(double result) {
        if (result <= 18.5) {
            return "Bajo peso";
        } else if (result <= 24.9) {
            return "Normal";
        } else if (result <= 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }

    public static double ingresarDato(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        double valor = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextDouble();

                if (valor > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Valor no válido. Debe ser mayor que 0.");
                }
            } catch (Exception e) {
                System.out.println("Error: Solo se permiten valores numéricos.");
                scanner.next();
            }
        }

        return valor;
    }
}