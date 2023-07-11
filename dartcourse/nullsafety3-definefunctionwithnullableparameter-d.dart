// address is a nullable string
void printAddress(String? address) {
  print(address);
}
void main() {
  // Passing null to printAddress
  printAddress(null); // Works
}