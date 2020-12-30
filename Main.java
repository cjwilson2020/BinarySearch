import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[] arr = { 1, 3, 6, 7, 11, 13, 21, 23, 30, 33, 46, 47, 51, 63, 71, 73, 83 };
    int testsPassed = 0;
    for(int i = 0; i < arr.length; i++){
      int target = arr[i];
      if (binarySearch(arr, target) > 0){
        testsPassed++;
        System.out.println(target + " found");
      }else{
        System.out.println(target + " not found");
      }
      
    }

    System.out.println(testsPassed + " tests passed with a success rate of " + testsPassed*100/(float)arr.length + "%");
  }

  static int binarySearch(int[] arr, int target) {
    int found = 0;
    print(arr);
    int len = arr.length;
    //System.out.println("Length: " + len);
    if (len > 0) {
      int pivotIndex = len / 2;
      //System.out.println("pivotIndex: " + pivotIndex);
      int pivot = arr[pivotIndex];
      //System.out.println("pivot: " + pivot);
      //System.out.println("target: " + target);
      if (target == pivot) {
        found = 1;
      } else if (target < pivot ) {
        int[] left = Arrays.copyOfRange(arr, 0, pivotIndex);

      //  print(left);
        found = binarySearch(left, target);
      } else if (target > pivot) {
        int[] right = Arrays.copyOfRange(arr, pivotIndex, len);
      //  print(right);
        found = binarySearch(right, target);
      }

    }
    return found;
  }

  static void print(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(" " + arr[i]);
    }
    System.out.print("]\n");
  }
}