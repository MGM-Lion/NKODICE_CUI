import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NkoDice {
    private static final String[] DiceList = {"お","ん", "こ", "う", "ま", "ち"};
    private static final String[][] DiceRoleList = {
        {"お","ち","ん","ち","ん"},
        {"ち","ん","ち","ん"},
        {"お","ま","ん","こ"},
        {"ち","ん","こ"},
        {"ま","ん","こ"},
        {"う","ん","こ"},
        {"う","ん","ち"},
    };
    private static final String[] AlphaRoleList = {
        "OCHINCHIN",
        "CHINCHIN",
        "OMANKO",
        "CHINKO",
        "MANKO",
        "UNKO",
        "UNCHI"
    };

    public static String[] DiceRoll(int count) {
        String[] ret = new String[count];
        for(int i=0; i<count; i++){
            int val = (int)(Math.random() * (DiceList.length));
            ret[i] = DiceList[val];
            System.out.print(DiceList[val] + "\t");
        }
        System.out.print("\n");   
        return ret;
    }
	
	//--- uechan edit
	public static String[] ShakeDice(int count,String[] ret) {
		Random r = new Random();
		int val = 0;
        for(int i=0; i<count; i++){
			int rnd = r.nextInt(2);
			if (rnd == 0){
				val = searchDiceList(ret[i]);
				val = (val + r.nextInt(6)) % 6;
				ret[i] = DiceList[val];
			}
            System.out.print(DiceList[val] + "\t");
        }
        System.out.print("\n");   
        return ret;
    }
	
	
	public static int searchDiceList(String str){
		int i = 0;
		int j = 0;
		while(j < DiceList.length){
			if (DiceList[j] == str){
				i = j;
				break;
			}
			j++;
		}
		
		return i;
	}
    
	//---
	
    public static String[] GetResultRole(String[] diceResult) {
        List<String> result = new ArrayList<String>();
        for(int i=0; i<DiceRoleList.length; i++){
            if(existResult(DiceRoleList[i], diceResult)) {
                result.add(AlphaRoleList[i]);
            }
        }
        if(result.size() == 0) { 
            result.add("なし"); 
        }
        return result.toArray(new String[0]);
    }
    
    private static boolean existResult(String[] role, String[] result) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(result));
        boolean ret = true;
        for(int i=0; i<role.length; i++){
            boolean continueFlag = false;
            for(int j=0; j<list.size(); j++){
                if(role[i] == list.get(j)) {
                    list.remove(j);
                    continueFlag = true;
                    break;
                }
            }
            if(!continueFlag) {
                ret = false;
                break;
            }
        }
        return ret;
    }
}