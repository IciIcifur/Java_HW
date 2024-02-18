public class ComplexNumber {
    int a, b;

    // in-code number initialization
    ComplexNumber(int a0, int b0) {
        a = a0;
        b = b0;
    }

    // console number initialization
    ComplexNumber(String number) {
        try {
            int aSign = 1;
            int bSign = 1;

            if (number.indexOf("+") == 0 || number.indexOf("-") == 0) {
                if (number.indexOf("-") == 0) aSign = -1;
                number = number.substring(1);
            }
            if (number.indexOf("-") > 0) bSign = -1;

            String sep = (number.contains("+") ? "\\+" : (number.contains("-") ? "-" : ""));

            if (!sep.isEmpty()) {
                String[] parts = number.split(sep);

                a = Integer.parseInt(parts[0]);
                b = parts[1].length() > 1 ? Integer.parseInt(parts[1].substring(0, parts[1].length() - 1)) : 1;
            } else {
                a = Integer.parseInt(number);
                b = 0;
            }
            a *= aSign;
            b *= bSign;
        } catch (RuntimeException e) {
            throw new RuntimeException("Incorrect input format. Try to specify real part.");
        }

    }

    static ComplexNumber sum(ComplexNumber num1, ComplexNumber num2) {
        return new ComplexNumber(num1.a + num2.a, num1.b + num2.b);
    }

    static ComplexNumber multiplication(ComplexNumber num1, ComplexNumber num2) {
        return new ComplexNumber(num1.a * num2.a - num1.b * num2.b, num1.a * num2.b + num1.b * num2.a);
    }
}