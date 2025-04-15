/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;

/**
 *
 * @author 08175
 */
import javax.swing.JOptionPane;

public class Calculator  {

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            String num1Str = JOptionPane.showInputDialog("Digite o primeiro número:");
            String num2Str = JOptionPane.showInputDialog("Digite o segundo número:");

            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);

            String[] opcoes = { "Soma (+)", "Subtração (-)", "Multiplicação (*)", "Divisão (/)" };
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha a operação:",
                "Calculadora Java",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            double resultado = 0;
            boolean operacaoValida = true;

            switch (escolha) {
                case 0:
                    resultado = somar(num1, num2);
                    break;
                case 1:
                    resultado = subtrair(num1, num2);
                    break;
                case 2:
                    resultado = multiplicar(num1, num2);
                    break;
                case 3:
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(null, "Erro: divisão por zero!");
                        operacaoValida = false;
                    } else {
                        resultado = dividir(num1, num2);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Operação cancelada.");
                    operacaoValida = false;
                    break;
            }

            if (operacaoValida) {
                JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
            }

            int continuarOpcao = JOptionPane.showConfirmDialog(null, "Deseja realizar outra operação?", "Continuar", JOptionPane.YES_NO_OPTION);
            continuar = (continuarOpcao == JOptionPane.YES_OPTION);
        }

        JOptionPane.showMessageDialog(null, "Obrigado por usar a calculadora!");
    }

    public static double somar(double a, double b) {
        return a + b;
    }

    public static double subtrair(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }
}