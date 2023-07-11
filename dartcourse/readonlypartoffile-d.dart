// dart program to read from file
import 'dart:io';

void main() {
  // open file
  File file = new File('c:\\darttest\\darttest\\test.txt');
  // read only first 10 characters
  String contents = file.readAsStringSync().substring(0, 10);
  // print file
  print(contents);
}