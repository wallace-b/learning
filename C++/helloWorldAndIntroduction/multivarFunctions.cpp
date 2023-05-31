#include <iostream>
using namespace std;

double max(double x1, double x2) {
  if (x1 > x2) {
    return x1;
  }
  else {
    return x2;
  }
}

// function overloading
int max(int x1, int x2) {
  if (x1 > x2) {
    return x1;
  }
  else {
    return x2;
  }
}

// the true O(n) form of max functions, ignore array creation it makes it O(2n), but we drop multipliers
double max(double x1, double x2, double x3) {
  double arr[] = {x1, x2, x3};
  cout << "size of array: " << size(arr) << "\n";
  double max;
  for (int i=0; i<size(arr); i++){
    if (i==0){
      max = arr[i];
    }
    else {
      if(max <= arr[i]){
        max = arr[i];
      }
    }
  }
  return max;
}

int max(int x1, int x2, int x3) {
  int arr[] = {x1, x2, x3};
  //cout << "size of array: " << size(arr) << "\n";
  int max;
  for (int i=0; i<size(arr); i++){
    if (i==0){
      max = arr[i];
    }
    else {
      if(max <= arr[i]){
        max = arr[i];
      }
    }
  }
  return max;
}

int main() {
  double a, b, c;
  //cout << "enter two float numbers" << "\n";
  //cin >> a >> b >> c;
  a = 1555;
  b = 1857;
  c = 1984;
  cout << max(a, b) << "\n";
  cout << max(a, b, c) << "\n";

  //string dummy;
  //cout << "press any key + enter to close" << "\n"
  //cin >> dummy;
  
return -1;
}
