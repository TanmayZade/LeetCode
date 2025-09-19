class Spreadsheet {
    int sheet[][];
    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < 26;j++){
                sheet[i][j] = 0;
            }
        }
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;

        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;

        sheet[row][col] = 0; 
    }
    
    public int getValue(String formula) {
        int n = formula.length();

        // if(n == 6) return sheet[Character.getNumericValue(formula.charAt(2)) - 1][formula.charAt(1) - 'A'] + sheet[Character.getNumericValue(formula.charAt(5)) - 1][formula.charAt(4) - 'A'];

        // if(n == 5){
        //      if(Character.isLetter(formula.charAt(1))) return sheet[Character.getNumericValue(formula.charAt(2)) - 1][formula.charAt(1) - 'A'] + Character.getNumericValue(formula.charAt(4));
        //     else return Character.getNumericValue(formula.charAt(2)) + sheet[Character.getNumericValue(formula.charAt(4)) - 1][formula.charAt(3) - 'A'];
        // } 



        // else{
            int firstN = 0, secondN = 0;
            int startIdx = 0;
            int endIdx = 0;
            int arr[] = new int[2];
            if(Character.isLetter(formula.charAt(1))){
                arr = getCellValue(formula, 1,2);
                firstN = arr[0];
                endIdx = arr[1];
                endIdx++;
                    if(Character.isLetter(formula.charAt(endIdx))){
                    arr = getCellValue(formula, endIdx,endIdx + 1);
                    secondN = arr[0];
                    return firstN + secondN;                   
                    }else{
                        secondN = Integer.parseInt(formula.substring(endIdx, n));
                        return firstN + secondN;
                    }
            }
            else{
                for(int i = 1;i < n;i++){
                    if(!Character.isDigit(formula.charAt(i))){
                        endIdx = i;
                        break;
                    }
                }
                firstN = Integer.parseInt(formula.substring(1,endIdx));
                endIdx++;
                if(Character.isDigit(formula.charAt(endIdx))){
                    secondN = Integer.parseInt(formula.substring(endIdx, n));
                    return firstN + secondN;
                }else{
                    arr = getCellValue(formula, endIdx, endIdx + 1);
                    return firstN + arr[0];
                }
            }
        // }
    }

    private int[] getCellValue(String formula, int letIdx, int stIdx){
        int n = formula.length();
        int endIdx = n;
            for(int i = stIdx;i < n;i++){
                    if(!Character.isDigit(formula.charAt(i))){
                        endIdx = i;
                        break;
                    }
                }
    int row = Integer.parseInt(formula.substring(stIdx, endIdx)) - 1;
    int col = formula.charAt(letIdx) - 'A';
    int firstN = sheet[row][col];

        return new int[]{firstN, endIdx};
    }
}
/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */