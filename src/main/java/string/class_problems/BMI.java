package string.class_problems;

public class BMI {

    static String getStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {

        double[] height = {
                1.75, 1.60, 1.80, 1.65, 1.72
        };

        double[] weight = {
                70, 90, 80, 60, 85
        };

        System.out.printf("%-10s %-10s %-10s %-10s %-15s%n",
                "Person", "Height", "Weight", "BMI", "Status");

        for (int i = 0; i < height.length; i++) {

            double bmi = weight[i] /
                    (height[i] * height[i]);

            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15s%n",
                    i + 1,
                    height[i],
                    weight[i],
                    bmi,
                    getStatus(bmi));
        }
    }
}