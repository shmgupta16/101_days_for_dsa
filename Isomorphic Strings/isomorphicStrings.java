*************SOLUTION USING HASHMAP**************

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        HashMap<Character,Character> sToTMap = new HashMap<>();
        HashMap<Character,Character> tToSMap = new HashMap<>();

        for(int i=0;i<n;i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if(!sToTMap.containsKey(s1)){
                sToTMap.put(s1,t1);
            }

            if(!tToSMap.containsKey(t1)){
                tToSMap.put(t1,s1);
            }

            if(sToTMap.get(s1) != t1 || tToSMap.get(t1) != s1){
                return false;
            }
        }

        return true;
    }
}

************SOLUTION USING ARRAY AND MAKING USE OF ASCII *************
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] sToT = new int[128];
        int[] tToS = new int[128];
        //Initializing both the arrays to -1
        Arrays.fill(sToT , -1);
        Arrays.fill(tToS , -1);

        for(int i=0;i<n;i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if(sToT[s1] == -1){
                sToT[s1] = t1;
            }

            if(tToS[t1] == -1){
                tToS[t1] = s1;
            }

            if(sToT[s1] != t1 || tToS[t1] != s1){
                return false;
            }
        }

        return true;
    }
}
