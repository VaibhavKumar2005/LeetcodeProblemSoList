class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> res = new ArrayList<>();
        for(String w : words){
            String word = w.toLowerCase();
            boolean r1 = true, r2 = true, r3 = true;

            for(char c : word.toCharArray()){
            if(row1.indexOf(c)== -1) r1 = false;
            if(row2.indexOf(c)== -1) r2 = false;
            if(row3.indexOf(c) == - 1) r3 = false;
        }
        
        if(r1 || r2 || r3){
            res.add(w);
        }
        }
        return res.toArray(new String[0]);
    }
}
