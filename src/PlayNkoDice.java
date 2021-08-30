import java.util.Arrays;

public class PlayNkoDice {
    public static void main(String[] args) {
        String[] diceResult = NkoDice.DiceRoll(5);          //ダイスの数を調整出来ます
        try {
            Thread.sleep(2000);                             //待機時間(ミリ秒)
        } catch(InterruptedException e) {}
        String[] role = NkoDice.GetResultRole(diceResult);  //成立役の判定
        System.out.print(Arrays.toString(role));            //成立役の表示
    }
}