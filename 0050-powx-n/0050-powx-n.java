class Solution {
    public double myPow(double x, int n) {
        if(x < 0){
            double result = Math.exp(n*Math.log(-x));
            return (n % 2 == 0) ? result : -result;
        }else
            return Math.exp(n*Math.log(x));
    }
}