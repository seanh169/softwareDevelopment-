import java.util.ArrayList;
import java.lang.ArrayIndexOutOfBoundsException;

public class BasicJava{
    public void oneTo255(){
        for(int i=1;i<=255;i++){
            System.out.println(i);
        }
    }

    public void oddTo255(){
        for(int i=1;i<=255;i++){
            if(i%2 == 1){
                System.out.println(i);
            }
        }
    }

    public void printSum(){
        int sum = 0;

        for(int i=1;i<=255;i++){
            System.out.println("New number: "+i+" Sum: "+sum);
            sum += i;
        }
    }

    public void iterArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public void findMax(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(max < arr[i]){max = arr[i];}
        }
        System.out.println(max);
    }

    public void getAvg(int[] arr){
        if(arr.length < 1){return;}
        int avg = 0;
        for(int i=0;i<arr.length;i++){
            avg += arr[i];
        }
        avg /= arr.length;
        System.out.println(avg);
    }

    public void arrOdd(){
        ArrayList<Integer> y = new ArrayList<>();

        for(int i=1;i<=255;i++){
            if(i%2 == 1){
                y.add(i);
            }
        }
    }

    public int greaterThanY(int[] arr,int y){
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > y){
                cnt++;
            }
        }
        return cnt;
    }

    public int[] squareVals(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]*arr[i];
        }
        
        return arr;
    }

    public int[] noNeg(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0){
                arr[i] = 0;
            }
        }

        return arr;
    }

    public int[] maxMinAvg(int[] arr){
        int max = arr[0];
        int min = arr[0];
        int avg = 0;
        int[] newArr = new int[3];

        for(int i=0;i<arr.length;i++){
            if(max < arr[i]){max = arr[i];}
            if(min > arr[i]){min = arr[i];}
            avg += arr[i];
        }
        avg /= arr.length;

        newArr[0] = max;
        newArr[1] = min;
        newArr[2] = avg;

        return newArr;
    }

    public int[] shiftVals(int[] arr){
        for(int i=0;i<arr.length;i++){
            try{
                arr[i] = arr[i+1];
            }catch(ArrayIndexOutOfBoundsException e){
                arr[i] = 0;
            }
        }

        return arr;
    }
}