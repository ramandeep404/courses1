void main(){
Object name = "Pratik";
// print(name.length) will not work because Dart doesn't know that name is a String

if(name is String) {
// name promoted from Object to String
  print("The length of name is ${name.length}");
}
}