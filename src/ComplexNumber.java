public class ComplexNumber {
    int a, b;

    ComplexNumber(int a0, int b0) {
        a = a0;
        b = b0;
    }

    ComplexNumber(String number) {
        String sep = (number.contains("+") || number.contains("-")) ? "\\+" : "";

        if (!sep.isEmpty()) {
            sep = number.contains("+") ? "\\+" : "-";

            String[] parts = number.split(sep);

            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));

            if (sep.equals("-")) b *= -1;
        } else {
            a = Integer.parseInt(number);
            b = 0;
        }
    }

    ComplexNumber sum(ComplexNumber num1, ComplexNumber num2) {
        return new ComplexNumber(num1.a + num2.a, num1.b + num2.b);
    }

    ComplexNumber multiplication(ComplexNumber num1, ComplexNumber num2) {
        return new ComplexNumber(num1.a * num2.a - num1.b * num2.b, num1.a * num2.b + num1.b * num2.a);
    }
}
