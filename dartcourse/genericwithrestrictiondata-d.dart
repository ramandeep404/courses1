// Define generic class with bounded type
class Data<T extends num> {
  T data;
  Data(this.data);
}

void main() {
  // create an object of type int and double
  Data<int> intData = Data<int>(10);
  Data<double> doubleData = Data<double>(10.5);
  // print the data
  print("IntData: ${intData.data}");
  print("DoubleData: ${doubleData.data}");
  // Not Possible
  // Data<String> stringData = Data<String>("Hello");
}