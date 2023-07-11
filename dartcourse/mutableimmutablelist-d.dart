void main(){ 
  List<String> names = ["Raj", "John", "Rocky"]; // Mutable List
names[1] = "Bill"; // possible
names[2] = "Elon"; // possible
    
const List<String> names1 = ["Raj", "John", "Rocky"]; // Immutable List
names1[1] = "Bill"; // not possible
names1[2] = "Elon"; // not possible
}