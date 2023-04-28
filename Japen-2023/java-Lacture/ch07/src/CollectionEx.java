import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JPopupMenu.Separator;

public class CollectionEx {

  public static void main(String[] args) {
    LinkedList<String> myList = new LinkedList<>();
    myList.add("김지은");
    myList.add("김남진");
    myList.add("백명현");
    myList.add("권인호");
    myList.add("장성호");
    //Collections.sort(myList);=>정렬
    //Collections.reverse(myList);=>뒤집기

    int idx = Collections.binarySearch(myList, "김지은");
    System.out.println(idx);

    // Iterator<String> iterator = myList.iterator();
    // while (iterator.hasNext()) {
    //   String seperator;
    //   if (iterator.hasNext()) {
    //     seperator = "=>";
    //   } else {
    //     seperator = "\n";
    //   }
    //   String element = iterator.next();
    //   System.out.print(element + seperator);
    // }
  }
}
