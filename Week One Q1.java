/*Dizinin en yüksek elemanını bulan uygulama*/
class Q1 {
static int[] arr ={-5,1,5,0,-7};
    static int largest() {
        int i;
        int max = arr[0];
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];

        }
        return max;
    }

     public static void main(String[] args) {
         System.out.println(largest());
     }
}
