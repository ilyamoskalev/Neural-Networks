import perceptrons.Sigmoidalnaya;

import java.util.Arrays;

public class Combinations {
    public static boolean combination(int[][] elements, int k) {
        int n = elements.length;

        if (k > n) {
            System.out.println("Invalid input, K > N");
            return false;
        }
        int combination[] = new int[k];
        int r = 0;
        int index = 0;

        while (r >= 0) {
            if (index <= (n + (r - k))) {
                combination[r] = index;
                if (r == k - 1) {
                    System.out.println(Arrays.toString(combination));
                    int[][] vector = new int[combination.length][5];
                    for(int i = 0; i < combination.length; ++i){
                        vector[i] = elements[combination[i]];
                    }
                    Sigmoidalnaya perceptron = new Sigmoidalnaya();
                    if(perceptron.study(vector)){
                        return true;
                    }
                    index++;
                } else {
                    index = combination[r] + 1;
                    r++;
                }
            } else {
                r--;
                if (r > 0)
                    index = combination[r] + 1;
                else
                    index = combination[0] + 1;
            }
        }
        return false;
    }
}
