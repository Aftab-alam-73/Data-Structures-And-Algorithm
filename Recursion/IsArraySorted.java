public class IsArraySorted {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
         System.out.println(isSorted(array,0));
    }
    static boolean isSorted(int[] array ,int index) {
           if(index==array.length-1)
           {
             return true;
           }
           if(array[index]>array[index+1]){
            return false;
           }
           return isSorted(array, index+1);

    }
}
