public class BookInfo {

  public static void main(String[] args) {
    Book book01 = new Book();
    Book book02 = book01;;
    book01.setTitle("홍길동전");
    book02.setTitle("심청전");
    String b01Title = book01.getTitle();
    String b02Title = book02.getTitle();
    System.out.println(b01Title + "===" + b02Title);
  }
}
