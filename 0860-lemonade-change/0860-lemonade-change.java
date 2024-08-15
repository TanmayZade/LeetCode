class Solution {
    public boolean lemonadeChange(int[] bills) {
        int changes[] = new int[3];

        for(int i = 0; i < bills.length;i++){
            if(bills[i] == 5)
                changes[0]++;
            else if(bills[i] == 10)
                changes[1]++;
            else
                changes[2]++;
            
            if(bills[i] == 10){
                if(changes[0] != 0)
                changes[0]--;
                else 
                return false;
            }
            else if(bills[i] == 20){
                if(changes[1] != 0 && changes[0] != 0 ){
                    changes[1]--;
                    changes[0]--;
                }
                else if(changes[0] >= 3)
                    changes[0] -= 3;
                else 
                    return false;
                
            }
        }

        return true;
    }
}