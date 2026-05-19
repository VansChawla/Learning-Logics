class KeyboardRow {
    public String[] findWords(String[] words) {
        String firstRow = "qwertyuiopQWERTYUIOP";
        String secondRow = "asdfghjklASDFGHJKL";
        String thirdRow = "zxcvbnmZXCVBNM";

        ArrayList<String> res = new ArrayList<>();
        for(String word : words){
            boolean row1 = false;
            boolean row2 = false;
            boolean row3 = false;
            for(char c : word.toCharArray()){
                if(firstRow.indexOf(c) != -1){
                    row1 = true;
                }
                if(secondRow.indexOf(c) != -1){
                    row2 = true;
                }
                if(thirdRow.indexOf(c) != -1){
                    row3 = true;
                }
            }
            if((row1 == true && row2 == false && row3 == false) ||
            (row1 == false && row2 == true && row3 == false) ||
            (row1 == false && row2 == false && row3 == true)){
                res.add(word);
            }
        }

        String[] array = res.toArray(new String[0]);
        return array;
    }
}