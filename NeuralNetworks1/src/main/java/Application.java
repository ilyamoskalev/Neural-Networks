import perceptrons.Constants;
import perceptrons.Porogovaya;
import perceptrons.Sigmoidalnaya;

public class Application {
    public static void main(String[] args) {
        Porogovaya perceptron1 = new Porogovaya();
        perceptron1.study(Constants.boolean_function);
        System.out.println();
        Sigmoidalnaya perceptron2 = new Sigmoidalnaya();
        perceptron2.study(Constants.boolean_function);
        for (int i = 1; i < Constants.boolean_function.length; ++i) {
            if(Combinations.combination(Constants.boolean_function, i)){
                return;
            }
        }
    }
}
