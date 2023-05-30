#include <iostream>
using namespace std;

double max(double x, double y) {
  if (x > y) {
    return x;
  }
  else {
    return y;
  }
}

int main() {
  double a, b;
  //cout << "enter two float numbers" << "\n";
  //cin >> a >> b;
  a = 55.1f;
  b = 29.6f;
  cout << max(a, b) << "\n";

  //string dummy;
  //cout << "press any key + enter to close" << "\n"
  //cin >> dummy;
  
return -1;
}
