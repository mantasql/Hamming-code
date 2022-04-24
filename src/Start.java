import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean program = true;
        while(program) {

            System.out.println("Choose your option:\n1. Encode\n2. Decode\n3. Exit");
            int option = in.nextInt();

            switch (option) {
                case 1 -> Encode(in);
                case 2 -> Decode(in);
                default -> program = false;
            }
        }
    }

    private static void Encode(Scanner in) {
        System.out.println("Input what to encode:");
        String input = in.next();
        int d1 = input.charAt(0)-48;
        int d2 = input.charAt(1)-48;
        int d3 = input.charAt(2)-48;
        int d4 = input.charAt(3)-48;
        int p1,p2,p3;

        p1 = (d1+d2+d3)%2==0 ? 0:1;
        p2 = (d2+d3+d4)%2==0 ? 0:1;
        p3 = (d1+d3+d4)%2==0 ? 0:1;

        String output = String.valueOf(d1) + d2 + d3 + d4 + p1 + p2 + p3;

        System.out.println("Output: " +output + "\n");
    }

    private static void Decode(Scanner in) {
        System.out.println("Input what to decode:");
        String input = in.next();
        int d1 = input.charAt(0)-48;
        int d2 = input.charAt(1)-48;
        int d3 = input.charAt(2)-48;
        int d4 = input.charAt(3)-48;
        int p1 = input.charAt(4)-48;
        int p2 = input.charAt(5)-48;
        int p3 = input.charAt(6)-48;

        boolean pp1 = (d1 + d2 + d3) % 2 == 0;
        boolean pp2 = (d2 + d3 + d4) % 2 == 0;
        boolean pp3 = (d1 + d3 + d4) % 2 == 0;

        boolean p1Flag = false;
        boolean p2Flag = false;
        boolean p3Flag = false;

        if(!pp1 && p1 == 0 || pp1 && p1 == 1) {
            p1Flag = true;
        }
        if (!pp2 && p2 == 0 || pp2 && p2 == 1) {
            p2Flag = true;
        }
        if (!pp3 && p3 == 0 || pp2 && p2 == 1) {
            p3Flag = true;
        }

        if(p1Flag && p2Flag && p3Flag) {
            if(d3 == 0) d3 = 1;
            else d3 = 0;
        } else if(p1Flag && p2Flag) {
            if(d2 == 0) d2 = 1;
            else d2 = 0;
        } else if(p2Flag && p3Flag) {
            if(d4 == 0) d4 = 1;
            else d4 = 0;
        } else if(p1Flag && p3Flag) {
            if(d1 == 0) d1 = 1;
            else d1 = 0;
        }

        String t = String.valueOf(d1) + d2 + d3 + d4 + p1 + p2 + p3;
        String s = String.valueOf(d1) + d2 + d3 + d4;
        System.out.println("t = "+ t);
        System.out.println("s = "+ s + "\n");
    }
}
