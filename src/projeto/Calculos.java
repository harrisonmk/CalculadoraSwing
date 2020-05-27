package projeto;

import estruturas.ListaCharacter;
import estruturas.ListaDouble;

public class Calculos {

    public static void main(String args[]) {
        Calculos c = new Calculos();
        System.out.println(">>>>" + c.calculadora("5/5"));
    }

    public String calculadora(String expressao) {
        String resultado;
        ListaDouble listaNumeros;
        //List<Character> listaOperadores;
        ListaCharacter listaOperadores;

        listaNumeros = (ListaDouble) obterNumeros(expressao);
        listaOperadores = obterOperadores(expressao);

        resultado = calcularValor(listaNumeros, listaOperadores);

        return resultado;

    }

    private String calcularValor(ListaDouble listaNumeros, ListaCharacter listaOperadores) {
        String resultado;
        double total = 0.0;
        int j = 0;
        for (int i = 0; i < listaNumeros.tamanhoLista() - 1; i++) {

            if (total == 0.0) {
                double numero1 = listaNumeros.obter(i);
                double numero2 = listaNumeros.obter(i + 1);
                char operador = listaOperadores.obter(i);
                total = executarOperacao(numero1, operador, numero2);
            } else if (total > 0.0) {

                double numero2 = listaNumeros.obter(i);
                char operador = listaOperadores.obter(j);
                total = executarOperacao(total, operador, numero2);
                j++;
            }

        }

        resultado = "" + total;
        return resultado;
    }

    private double executarOperacao(double numero1, char operador, double numero2) {
        double resultado = 0.0;

        switch (operador) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '/':
                resultado = numero1 / numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            default:
                break;
        }
        return resultado;
    }

    private ListaDouble obterNumeros(String expressao) {

        ListaDouble listaNumeros = new ListaDouble();

        String numeroEmString = "";
        for (int i = 0; i < expressao.length(); i++) {

            if (isOperador(expressao.charAt(i))) {
                Double numero = Double.valueOf(numeroEmString);
                listaNumeros.adicionar(numero);
                numeroEmString = "";
            } else {
                numeroEmString = numeroEmString.concat("" + expressao.charAt(i));
            }
        }
        if (!numeroEmString.isEmpty()) {
            Double numero = Double.valueOf(numeroEmString);
            listaNumeros.adicionar(numero);

        }
        return listaNumeros;
    }

    private ListaCharacter obterOperadores(String expressao) {

        ListaCharacter listaOperadores = new ListaCharacter();

        for (int i = 0; i < expressao.length(); i++) {

            if (isOperador(expressao.charAt(i))) {
                listaOperadores.adicionar(expressao.charAt(i));
            }
        }

        return listaOperadores;
    }

    private boolean isOperador(char caracter) {
        boolean isOperador = false;
        if (caracter == '-' || caracter == '+' || caracter == '/' || caracter == '*') {
            isOperador = true;
        }
        return isOperador;
    }

}
