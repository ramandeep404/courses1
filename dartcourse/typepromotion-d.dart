void main(){
// result is a String
String result;
// result is promoted to a non-nullable type String
if(DateTime.now().hour < 12) {
  result = "Good Morning";
} else {
  result = "Good Afternoon";
}
// display the result
print("Result is $result");
print("Length of result is ${result.length}");
}