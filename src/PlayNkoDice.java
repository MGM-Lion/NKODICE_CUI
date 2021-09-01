import java.util.Arrays;
import java.util.Scanner;

public class PlayNkoDice {
    private static final Scanner typeScan = new Scanner(System.in);
    public static void main(String[] args) {
        String[] diceResult = NkoDice.DiceRoll(5);          //ダイスの数を調整出来ます
        try {
            Thread.sleep(1000);                             //待機時間(ミリ秒)
        } catch(InterruptedException e) {}
        String[] role = NkoDice.GetResultRole(diceResult);  //成立役の判定
        System.out.print(Arrays.toString(role));            //成立役の表示
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
		
		// --- uechan edit
		System.out.print("\nShake a Dice? y/other key : ");
        String continueORexit = "";
        continueORexit = typeScan.nextLine();
		String[] diceResult2 = null;
        if(continueORexit.equals("y")) {
            System.out.println();
            diceResult2 = NkoDice.DiceRoll(5); 
			role = NkoDice.GetResultRole(diceResult2);  //成立役の判定
			System.out.print(Arrays.toString(role));    //成立役の表示
        } 
		
		// ---
		
        System.out.print("\ncontinue? y/other key : ");
        continueORexit = "";
        continueORexit = typeScan.nextLine();
        if(!continueORexit.equals("y")) {
            typeScan.close();
        } else {
            System.out.println();
            main(args);
        }
    }
}