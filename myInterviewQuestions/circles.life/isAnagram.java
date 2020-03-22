class Solution {
    public HashMap<Character,Integer> convertToHashMap(String s) {
        HashMap<Character, Integer> stringMap  = new HashMap<Character, Integer> ();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(stringMap.containsKey(c)){
                int count = stringMap.get(c);
                stringMap.put(c,count+1);
            } else {
                stringMap.put(c, 0);
            }
        }
        return stringMap;
    }
    
    public void printHashMap(HashMap<Character, Integer> hashmap) {
        for(char c: hashmap.keySet()){
            System.out.println("Key: " + c + " Value: " + hashmap.get(c));
        }
    }
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        sMap = convertToHashMap(s);
        tMap = convertToHashMap(t);
        System.out.println("*******S*******");
        printHashMap(sMap);
        System.out.println("*******t*******");
        printHashMap(tMap);
        
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(tMap.containsKey(a)) {
                int temp1 = sMap.get(a);
                int temp2 = tMap.get(a);
                if(temp1 == temp2) {
                    continue;
                } else {
                    System.out.println("I am here");
                    return false;
                }
            } else {
                return false;
            }
        }
        
        for(int i=0; i<t.length(); i++){
            char a = t.charAt(i);
            if(sMap.containsKey(a)) {
                int temp1 = sMap.get(a);
                int temp2 = tMap.get(a);
                if(temp1 == temp2) {
                    continue;
                } else {
                    System.out.println("I am here");
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
}
