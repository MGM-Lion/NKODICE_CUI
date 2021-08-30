import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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