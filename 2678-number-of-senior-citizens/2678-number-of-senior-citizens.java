class Solution {
    public int countSeniors(String[] details) {
        int counter = 0;
        for(int i = 0;i < details.length;i++){
            if(details[i].charAt(11) >= '6')
               if(details[i].charAt(11) == '6'){
                    if(details[i].charAt(12) > '0')
                counter++;
                }
            else
                counter++;

        }

        return counter;
    }
}