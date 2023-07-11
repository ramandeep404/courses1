// dart program to delete file
import 'dart:io';

void main() {
  // open file
  File file = File('c:\\darttest\\darttest\\test1.txt');
  // delete file
  file.deleteSync();
  print('File deleted.');
}