package org.example.arrays;

public class ArrayExamples {
    public static int mode02(int[] arr){
        if(arr.length == 0) {
            return Integer.MAX_VALUE;
        }
        int[][] map = new int[arr.length][2];

        for(int i=0;i<arr.length;i++){
            add(arr[i],map);
        }
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println(java.util.Arrays.deepToString(map));
        int pos=0;
        int maxFreq = map[0][1];
        for(int i=1; i < map.length; i++) {
            if(map[i][1] > maxFreq) {
                maxFreq = map[i][1];
                pos = i;
            }
        }
        return map[pos][0];
    }

    public static void add(int target,int[][] map){

        boolean found = false;
        for(int i=0;i<map.length;i++){
            int[] line = map[i];
            if(line[0] == target){
                line[1]++;
                found=true;
                break;
            }
        }
        if(!found){
            for(int i=0;i<map.length;i++){
                int[] line = map[i];
                if(line[1] == 0){
                    line[0]=target;
                    line[1]=1;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,0,3,6,0,0,3,87,43,3};
        System.out.println(mode02(arr));
    }
}
