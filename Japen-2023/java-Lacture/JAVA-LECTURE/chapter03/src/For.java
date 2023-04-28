public class For {
    public static void main(String[] args) {
      int sum = 0;
      for (int i = 1; i <= 1000; i++) {
        sum = sum + i;
        System.out.println(i);
        if(i<10) {
          System.out.print("+");
        } else {
          System.out.print("=");
        }
      }
      System.out.println(sum);
    }
  }
