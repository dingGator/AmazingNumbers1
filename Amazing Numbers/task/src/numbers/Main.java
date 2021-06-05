package numbers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       //int input = 0;
       // input = 567;
        Scanner scanner = new Scanner(System.in);
        long natNum = 0;
        int secNum = 0;
        int numCount = 0;

        System.out.println("Welcome to Amazing Numbers!");

            System.out.println("Supported requests: ");
            System.out.println("- enter a natural number to know its properties;\n" +
                    "- enter two natural numbers to obtain the properties of the list:\n" +
                    "  * the first parameter represents a starting number;\n" +
                    "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                    "- separate the parameters with one space;");
            System.out.println("- enter 0 to exit.");
            // process request
        do {
            System.out.println("Enter a request: ");

            while (scanner.hasNext()) {
                if (scanner.hasNextLong()) {
                    if (numCount == 0) {
                        natNum = scanner.nextLong();
                        if (natNum == 0) {
                             break;
                        }else if (natNum < 0){
                            //error msg
                                System.out.println("The first parameter should be a natural number or zero.");
                                System.out.println("Supported requests: ");
                                System.out.println("- enter a natural number to know its properties;\n" +
                                        "- enter two natural numbers to obtain the properties of the list:\n" +
                                        "  * the first parameter represents a starting number;\n" +
                                        "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                                        "- separate the parameters with one space;");
                                System.out.println("- enter 0 to exit.");
                        } else {

                            numCount++;
                        }
                    } else if (numCount == 1) {
                        secNum = scanner.nextInt();
                        numCount++;



                    }
                } //scanner.close();

            }
            //scanner.close();

            if (numCount == 1) {
                firstNum(natNum, secNum);
            } else if (numCount == 2) {
                twoNum(natNum, secNum);
            }

        } while (natNum != 0);
        System.out.println("Goodbye!");
    }

    public static void firstNum(long natNum, int secNum) {
        boolean evenBool = false;
        boolean oddBool = false;
        boolean divBool = false;
        boolean endBool = false;
        boolean buzzBool = false;
        boolean duckBool = false;
        boolean natBool = false;
        boolean palBool = false;
        boolean gapBool = false;
        String intToStr;
        //natural number evaluation

        if (natNum > 0) {
            natBool = true;
            //odd / even number evaluation
            if (natNum % 2 == 0) {
                evenBool = true;
            } else {
                oddBool = true;
            }
            // buzz number evaluation
            if (natNum % 7 == 0) {
                divBool = true;
            }
            if (natNum % 10 == 7) {
                endBool = true;
            }

            if ((divBool == false) &&
                    (endBool == false)) {
                buzzBool = false;
            } else if ((divBool == true) &&
                    (endBool == false)) {
                buzzBool = true;
            } else if ((divBool == false) &&
                    (endBool == true)) {
                buzzBool = true;
            } else if ((divBool == true) &&
                    (endBool == true)) {
                buzzBool = true;
            }
            //duck number evaluation
            intToStr = Long.toString(natNum);
            if (intToStr.contains("0")) {
                duckBool = true;
            }
            //Palindromic number evaluation
            long remNum = 0;
            long sumNum = 0;
            long tempNum = 0;
            long workNum = natNum;
            tempNum = workNum;
            while (workNum > 0) {
                remNum = workNum % 10;
                sumNum = (sumNum * 10) + remNum;
                workNum = workNum / 10;
            }
            if (tempNum == sumNum) {
                palBool = true;
            }
            natNum = tempNum;
            // gapful numbers
            long lastDi = 0;
            long firstDi = 0;
            long concatNum = 0;
            long gapWNum = natNum;
            lastDi = gapWNum % 10;
            if (gapWNum > 99) {
                while (gapWNum != 0) {
                    firstDi = gapWNum % 10;
                    gapWNum /= 10;
                }
                concatNum = firstDi * 10 + lastDi;
                if (gapWNum % concatNum == 0) {
                    gapBool = true;
                }

            }
        }
        if (secNum == 0) {
            printOne(natNum, natBool,
                    evenBool, oddBool,
                    buzzBool, duckBool,
                    palBool, gapBool);
        } else {
            printTwo(natNum, secNum,
                    natBool, evenBool,
                    oddBool, buzzBool,
                    duckBool, palBool, gapBool);
        }

        // reset boolean
        evenBool = false;
        oddBool = false;
        divBool = false;
        endBool = false;
        buzzBool = false;
        duckBool = false;
        natBool = false;
        palBool = false;
        gapBool = false;


        System.out.println("Goodbye!");
    }

    public static void twoNum(long natNum,
                              int secNum) {
        long nextNum = 0;
        //generate list of number starting with natNum
        for (int i = 0; i < secNum; i++) {
            nextNum = natNum + 1;
            firstNum(nextNum, secNum);

        }


    }

    public static void printTwo(long natNum, int secNum,
                                boolean natBool,
                                boolean evenBool,
                                boolean oddBool,
                                boolean buzzBool,
                                boolean duckBool,
                                boolean palBool,
                                boolean gapBool) {
        if (natBool == false) {
            System.out.println("The first parameter should " +
                    "be a natural number or zero.");

        } else {
            System.out.print(natNum + " is ");
            if (buzzBool == true) {
                System.out.print("buzz, ");
            }
            if (duckBool == true) {
                System.out.print("duck, ");
            }
            if (palBool == true) {
                System.out.print("palindromic, ");
            }
            if (gapBool == true) {
                System.out.print("gapful, ");
            }
            if (evenBool == true) {
                System.out.print("even, ");
            }
            if (oddBool == true) {
                System.out.print("odd, ");
            }


        }

    }

    public static void printOne(long natNum,
                                boolean natBool,
                                boolean evenNum,
                                boolean oddNum,
                                boolean buzzNum,
                                boolean duckNum,
                                boolean palNum,
                                boolean gapNum) {
        if (natBool == false) {
            System.out.println("The first parameter should " +
                    "be a natural number or zero.");

        } else {
            System.out.println("Properties of " + natNum);

            System.out.println("        buzz: " + buzzNum);
            System.out.println("        duck: " + duckNum);
            System.out.println(" palindromic: " + palNum);
            System.out.println("      gapful: " + gapNum);
            System.out.println("        even: " + evenNum);
            System.out.println("         odd: " + oddNum);
        }
    }

}
