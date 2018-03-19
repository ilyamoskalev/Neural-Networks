package perceptrons;

import java.util.Arrays;

public class Porogovaya {
    private static double[] weights = {0, 0, 0, 0, 0};
    private static final double norma = 0.3;

    public void study(int[][] function) {
        int epoch = 0;      //номер эпохи
        int sum_error;      //суммарная ошибка
        System.out.println("---------------Начало обучения персептрона с пороговой функцией активации---------------");
        System.out.println();
        do { //начало обучения
            sum_error = 0;
            StringBuilder result = new StringBuilder();     //вывод нейронной сети
            ++epoch;
            for (int[] vector : function) {     //начало эпохи обучения
                double net = 0;
                for (int i = 0; i < vector.length - 1; ++i) {//вычисление net
                    net += weights[i] * vector[i];
                }
                net += weights[weights.length - 1];
                double delta = vector[vector.length - 1] - porog_function(net);
                result.append(porog_function(net));
                if (Math.abs(delta) > 0) {      //корректировка весовых коэффициентов
                    ++sum_error;        //никрементация суммарной ошибки
                    for (int i = 0; i < weights.length - 1; ++i) {
                        weights[i] += norma * vector[i] * delta;
                    }
                    weights[weights.length - 1] += norma * delta;
                }
            }
            System.out.println(String.valueOf(epoch) + " " + Arrays.toString(weights) + " " + result.toString() + " " + String.valueOf(sum_error));
        } while (sum_error > 0);
        System.out.println();
        System.out.println("------------------------------------Обучение закончено------------------------------------");
    }

    private int porog_function(double net) {
        return net < 0 ? 0 : 1;
    }
}
