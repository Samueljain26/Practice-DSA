class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top =0,left =0, bottom = matrix.length-1, right =matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        while(top<=bottom && left <= right){

            //top row
            for(int i= left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;

            //right column

            for(int i= top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;

            //bottom
            if(top<=bottom){
                for(int i= right ;i>= left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //left column
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}