public class UpcastingEx {

  public static void main(String[] args) {
    Person person;
    Student student = new Student("김지은");
    person = student;
    System.out.println(person.name);
    System.out.println(person.id);

    //overloading
    //override
    //type casting을 쓰는 이유 메서드의 매개변수 타입을 좀더 효율적
    //으로 받기 위해서 쓴다.
    //interface
    //instanceof

    Person person02 = new Student("김남진");
    //Student student02 = (Student) person02;


    System.out.println(person02 instanceof Person);
    System.out.println(person02 instanceof Student);

    System.out.println("java" instanceof String);
  }
}
