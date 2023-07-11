import 'dart:io';

void main() {
  // creating file object
  File file = File('c:\\darttest\\darttest\\test.txt');
  // read file
  String contents = file.readAsStringSync();
  // print file
  print(contents);
}