// https://leetcode.com/problems/sort-characters-by-frequency

class CharacterFrequencySort {
    public String frequencySort(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        //below will sort map based on values in map<key,value> 
    List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

    // Sort the list by values in descending order
        Collections.sort(entryList, (a, b) -> b.getValue().compareTo(a.getValue()));
    
    String ans = "";
    //Lastly, we have to preserve the order,so linkedhashmap will be used   
        LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : entryList) {
            int freq = entry.getValue();
            if(freq>1){
                Character ch = entry.getKey();
                for(int i=0;i<freq;i++){
                    ans = ans+ch;
                }
            }else{
                ans = ans+entry.getKey();
            }
            sortedMap.put(entry.getKey(), entry.getValue());
        }  
       return ans;
 
    }
}