#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

// Read an array with provided dim size, and print in reverse
int main() {    
    int n;
    cin >> n;
    int arr[n];
    for (int i=0; i<n; i++) {
        cin >> arr[i]; 
    };
    for (int i=n-1; i>=0; i--) {
        cout << arr[i] << " ";
    }
    return 0;
}
