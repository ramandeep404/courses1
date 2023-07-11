// dart program to write to file
import 'dart:io';

void main() {
  // open file
  File file = File('c:\\darttest\\darttest\\test1.txt');
  // write to file
  file.writeAsStringSync('Welcome to test1.txt file.');
  print('File written.');
}