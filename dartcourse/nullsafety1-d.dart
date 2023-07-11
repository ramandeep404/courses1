/*
Null safety is a feature in the Dart programming language that helps developers to avoid null errors. 
This feature is called Sound Null Safety in dart.
With dart sound null Safety, you cannot provide a null value by default. 
If you are 100% sure to use it, then you can use ? operator after the type declaration.
*/
void main(){
// Declaring a nullable variable by using ?
String? name;
// Assigning John to name
name = "John";
// Assigning null to name
name = null;
}