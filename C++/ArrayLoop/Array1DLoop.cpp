#include <iostream>
using namespace std;

int main()
{
    int ages[] = {1, 2, 3, 7, 10, 14, 15, 16, 18, 26};
    int size = sizeof(ages)/sizeof(ages[0]);
    cout << "size of array is: " << size << endl;

    int sum = 0;

    for (int i=0; i<size; i++){
        auto *x = ages+i;
        cout << "index " << i << " of array: " << *x << endl;
        sum += *x;
    }

    float ave = (float)sum/size; // C++ will not coerce integer math into float automatically
    cout << "average age is: " << ave << endl;
}
