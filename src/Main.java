import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		System.out.println("Alustame pommitamisega!");
		System.out.println("Autor: Tanel");
		System.out.println("Aasta: 2016");

		int[][] lauaAlgseis = new int[9][9];
        int[][] lauaSeis = new int[9][9];

        // 0 - meri
		// 1 - laev
		// 2 - pihta saanud laev


		for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                lauaAlgseis[i][j] = (int) (Math.random() * 1.1);
            }
        }

        prindiLaud(lauaSeis);


		Scanner	sc = new Scanner(System.in);

        while(true) {
            System.out.println("Kuhu tahad pommitada? Formaat: x-y");
            String input = sc.nextLine();
            String[] xy = input.split("-");
            int x = Integer.parseInt(xy[0]) - 1;
            int y = Integer.parseInt(xy[1]) - 1;
            System.out.println(x);
            System.out.println(y);

            int tabamus = lauaAlgseis[y][x];
            if (tabamus == 1) {
                lauaSeis[y][x] = 2;
                lauaAlgseis[y][x] = 2;
                System.out.println("Pihtas!");
            } else if (tabamus == 0) {
                System.out.println("Mööda!");
                lauaSeis[y][x] = 3;

            } else if (tabamus == 2) {
                System.out.println("Siia sa juba lasid.");
            } else {
                System.out.println("Error: Kuidas sa üldse siia said?");
                break;
            }
            prindiLaud(lauaSeis);

            boolean labi = kasOnMangLabi(lauaAlgseis);
            if (labi == true){
                break;
            }

        }
        System.out.println("Mäng on läbi!");
    }

    private static boolean kasOnMangLabi(int[][] laud) {
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (laud[j][i] == 1){
                    return false;
                }

            }
        }
        return true;
    }

    public static void prindiLaud(int[][] prinditavLaud){
        for (int i = 0; i < 9; i++){
            System.out.println(Arrays.toString(prinditavLaud[i]));
        }
    }
}
