// abstract class as interface
abstract class Person {
    // properties
  String? name;
  // abstract method
  void run();
  void walk();
}

class Student implements Person {
    // properties
  String? name;
 
 // implementation of run()
 @override
  void run() {
    print('Student is running');
  }
  // implementation of walk()
  @override
  void walk() {
    print('Student is walking');
  }
}

void main() {
  var student = Student();
  student.name = 'John';
  print(student.name);
  student.run();
  student.walk();
}