package perceptrons;

import java.util.Arrays;

public class Sigmoidalnaya {
    private double[] weights;
    private static final double norma = 0.3;

    public boolean study(int[][] function) {
        weights = new double[]{0, 0, 0, 0, 0};
        int epoch = 0;      //номер эпохи
        int sum_error;      //суммарная ошибка
        System.out.println("--------------Начало обучения персептрона с сигмоидальной функцией активации--------------");
        System.out.println();
        do {        //начало обучения
            sum_error = 0;
            StringBuilder result = new StringBuilder();     //вывод нейронной сети
            ++epoch;
            for (int[] vector : function) {     //начало эпохи обучения
                double net = 0;
                for (int i = 0; i < vector.length - 1; ++i) {       //вычисление net
                    net += weights[i] * vector[i];
                }
                net += weights[weights.length - 1];
                double f_net = sigma_function(net);
                double delta = vector[vector.length - 1] - y_out(f_net);
                result.append(y_out(f_net));
                if (Math.abs(delta) > 0) {      //корректировка весовых коэффициентов
                    ++sum_error;        //никрементация суммарной ошибки
                    for (int i = 0; i < weights.length - 1; ++i) {
                        weights[i] += norma * vector[i] * delta + f_net * (1 - f_net);
                    }
                    weights[weights.length - 1] += norma * delta;
                }
            }
            System.out.println(String.valueOf(epoch) + " " + Arrays.toString(weights) + " " + result.toString() + " " + String.valueOf(sum_error));
        } while (sum_error > 0 && epoch < 1000);
        System.out.println();
        System.out.println("------------------------------------Обучение закончено------------------------------------");
        return test();
    }

    private double sigma_function(double net) {
        return (1 / (1 + Math.exp(-net)));
    }

    private int y_out(double f_net) {
        return f_net < 0.5 ? 0 : 1;
    }


    private boolean test (){
        StringBuilder result = new StringBuilder();
        for (int[] vector : Constants.boolean_function) {
            double net = 0;
            for (int i = 0; i < vector.length - 1; ++i) {
                net += weights[i] * vector[i];
            }
            net += weights[weights.length - 1];
            double f_net = sigma_function(net);
            int value = y_out(f_net);
            result.append(value);
            if( value != vector[vector.length - 1]){
                System.out.println(result);
                return false;
            }
        }
        System.out.println(result);
        return true;
    }

}
