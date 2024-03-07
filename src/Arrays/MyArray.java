//Write a Java program to find the maximum element in an array.
package Arrays;
public class MyArray{
    private int[] numbers;
    public MyArray(int[] nums){
        this.numbers = nums;
    }

    public int getMax(){
        int max = 0;
        for(int i=0; i< this.numbers.length; i++){
            if(this.numbers[i] > max){
                max = this.numbers[i];
            }
        }
        return max;
    }
}

class Tester{

}