public class StringCalculator {

    public int add(String numbers) {
        if (numbers.length() < 2) {
            if (numbers.isEmpty()) {
                return 0;
            } else {
                return  Integer.parseInt(numbers);
            }
        } else {
            String delimiter = ",";
            if (numbers.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }

            String[] numList = numbers.split(delimiter + "|\n");

            return addition(numList);
        }
    }

    private int addition(String[] numbers) {
        StringBuilder negativeString = new StringBuilder();
        int sumation = 0;
        for (String num : numbers) {
            if (Integer.parseInt(num) < 0) {
                if (negativeString.toString().equals(""))
                    negativeString = new StringBuilder(num);
                else
                    negativeString.append(",").append(num);
            }
            if (Integer.parseInt(num) < 1000)
                sumation += Integer.parseInt(num);
        }

        if (!negativeString.toString().equals("")) {
            throw new IllegalArgumentException("Negative numbers are not allowed " + negativeString);
        }

        return sumation;
    }
}
