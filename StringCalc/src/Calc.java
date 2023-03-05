import java.util.Scanner;



public class Calc {
    static Scanner scn = new Scanner(System.in);
    static String exp = scn.nextLine();
    static String[] data;
    static char operation;


    public static void main(String[] args) throws Exception {
        exp = exp.replace("\"", "");
        if (exp.contains("+")) {
            data = exp.split("\\+");
            operation = '+';
        } else if (exp.contains("-")) {
            data = exp.split("-");
            operation = '-';
        } else if (exp.contains("*")) {
            data = exp.split("\\*");
            operation = '*';
        }
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            operation = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            operation = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            operation = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            operation = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (operation == '*' || operation == '/') {
            if (data[1].contains("\""))
                throw new Exception("Строчку можно делить или умножать только на число");
        }

        if (operation == '+') {
            System.out.println(data[0] + data[1]);
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].replace("\"", "");
            }
        } else if (operation == '*') {
            if (operation == '+') {
                solution(data[0] + data[1]);
            } else if (operation == '*') {
                int multiplier = Integer.parseInt(data[1]);
                String result = "";
                for (int i = 0; i < multiplier; i++) {
                    System.out.print(data[0]);
                    result += data[0];
                }
                solution(result);
            } else if (operation == '-') {
                int index = data[0].indexOf(data[1]);
                if (index == -1) {
                    solution(data[0]);
                } else {
                    String result = data[0].substring(0, index);
                    result += data[0].substring(index + data[1].length());
                    solution(result);
                }
            } else {
                int newLen = data[0].length() / Integer.parseInt(data[1]);
                String result = data[0].substring(0, newLen);
                solution(result);
            }
            if (data[0].length() > 40) {
                String result = data[0] + "...";
                solution(result);
            }
        }


    }
    static void solution(String text){
        System.out.println("\""+text+"\"");
        }
}





