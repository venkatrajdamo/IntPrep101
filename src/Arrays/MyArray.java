//Write a Java program to find the maximum element in an array.
package Arrays;
public class MyArray{
    private int[] numbers;
    public MyArray(int[] nums){
        this.numbers = nums;
    }

    public int getMax(){
        int max = 0;
        for (int number : this.numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public int getSum(){
        int sum = 0;
        for (int number : this.numbers) {
            sum += number;
        }
        return sum;
    }

    public long getAverage(){
        if(this.numbers == null || this.numbers.length == 0)
            return 0;
        int sum = this.getSum();

        if(sum == 0)
            return 0;
        return (long) ((sum*1.0)/this.numbers.length);
    }
}

class Tester{

}