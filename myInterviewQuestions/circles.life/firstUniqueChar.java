class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0){
            return -1;
        }
        Map<Character, Integer> uniqueCharMap = new HashMap<Character, Integer>();
        char [] charArr = s.toCharArray();
        for(char c: charArr) {
            System.out.print(c + " ");
        }
        System.out.println();
        for(char c: charArr){
            if(uniqueCharMap.containsKey(c)){
                int count = uniqueCharMap.get(c);
                uniqueCharMap.put(c,count+1);
            } else {
                uniqueCharMap.put(c,1);  
            }     
        }
        for(char c : uniqueCharMap.keySet()) {
            System.out.println("Key: " + c + " Value: " + uniqueCharMap.get(c));
        }
        
        for(int i=0; i<charArr.length; i++){
            if(uniqueCharMap.get(charArr[i]) == 1){
                return (i);
            }
        }
        return -1;
    }
}
