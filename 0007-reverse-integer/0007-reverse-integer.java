class Solution {
    public int reverse(int x) {
        int result = 0;
        ArrayList<Integer> arr = new ArrayList();
        boolean isNegative = false;
        if(x < 0){
            isNegative = true;
            x = Math.abs(x);
        } 

        while(x > 0){
            arr.add(x % 10);
            x /= 10; 
        }

        int tenthPlace = arr.size()-1;
        for(int i = 0;i < arr.size();i++){
            int currIdx = arr.get(i);
            double power = Math.pow(10, tenthPlace);
            double temp = result + (currIdx * power);

            // Overflow check before casting to int
            if (temp > Integer.MAX_VALUE) return 0;

            result += (int)(currIdx * power);
            tenthPlace--;
        }

        if(isNegative) result = -result;
        if(result <= Integer.MIN_VALUE || result >= Integer.MAX_VALUE)
            return 0;
        return  result;
    }
}