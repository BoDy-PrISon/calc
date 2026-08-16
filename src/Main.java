import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите:");
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println("Результат: " + calc(input));
        }
    }

    public static String calc(String input) {
        String[] parts = input.trim().split(" ");
        if (parts.length != 3) {
            throw new RuntimeException("Invalid format");
        }

        int a;
        int b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid numbers");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new RuntimeException("Numbers must be from 1 to 10 inclusive");
        }

        int result;
        switch (parts[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new RuntimeException("Unsupported operation");
        }

        return String.valueOf(result);
    }
}