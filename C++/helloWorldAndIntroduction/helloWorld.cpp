#include <iostream>
#include <cstdio>
#include <vector>
#include <string>

using namespace std;

// two int value swapping functions, requires a temporary store for #1 & #2
void swap1(int *a, int *b)
{
    int tmp = *a;
    *a = *b;
    *b = tmp;
};

void swap2(int a, int b, int arr[])
{
    int tmp = a;
    a = b;
    b = tmp;
    // cout << "a:" << a << ", b:" << b << "\n";
    arr[0] = a;
    arr[1] = b;    
}

/* basic algebra reveals a way to not use a temporary store
START. x1 = a,  x2 = b
1. x1 = a + x2 = a + b,  x2 =  b
    x1 = a + b, x2 = b
2. x1 = a + b, x2 = x1 - b = (a + b) - b = a
    x1 = a + b, x2 = a
3. x1 = a + b - x2 = (a + b) - a = b,   x2 = a
END. x2 = b,  x2 = a
*/ 

void swap3(int *x1, int *x2)
{
    *x1 += *x2;
    *x2 = *x1 - *x2;
    *x1 -= *x2;
}

int main()
{
    vector<string> msg {"Hello", "C++", "World", "from", "VS Code", "and the C++ extension!"}; // vector

    for (const string word: msg) // loop through vector using ':' in operator 
    {
        cout << word << " ";
    }
    cout << endl;

    cout << endl << "---Pointer introduction #1---" << endl;  
    string food = "holy bologna";
    cout << "food is (using var): " << food << "\n"; // "\n" or endl is synonymous
    cout << "pointer of food is (using deref &): " << &food << "\n"; 

    string *ptr = &food;
    cout << "food is (using ptr): " << *ptr << "\n"; // "\n" or endl is synonymous
    cout << "pointer of food is (using ptr): " << ptr << "\n";

    cout << endl << "---Swapping values---" << endl;  
    int x = 55;
    // int* ptr_x = &x; 
    int y = 99;
    // int* ptr_y = &y;

    printf("x is %i, y is %i\n", x, y); // printf( ) for f-strings
    
    swap1(&x, &y);
    printf("swap1: x is %i, y is %i\n", x, y);

    int arr[1];

    swap2(x, y, arr);
    x = arr[0];
    y = arr[1]; 
    printf("swap2: x is %i, y is %i\n", x, y);

    swap3(&x, &y);
    printf("swap3: x is %i, y is %i\n", x, y);

    
    cout << endl << "---Pointer introduction #2---" << endl;  
    int size = 3;
    int arr_int[size] = {100, 300, 500};
    
    cout << "The current array: \n";
    for (int i = 0; i < size; i++) {
        printf("%i\n", arr_int[i]);
    }

    // let us have the address of the first element in the array
    int *ptr_arr_int = &arr_int[0];
    int *ptr_arr_int_alt = arr_int; // actually, since arrays are densely packed, the address of the array is the first element already, no deref required
    cout << "first address is :" <<  ptr_arr_int << " == " << ptr_arr_int_alt << "\n";

    printf("The size of an int is: %i \n", sizeof(int)); 
    cout << "The current array memory: \n";
    for (int i = 0; i < size; i++) {
        *ptr_arr_int += 123;
        cout << ptr_arr_int << "\n";
        ptr_arr_int++; // the pointer moves one memory address value to the right
        // '++' appears to automatically know to move 4 bytes to account for int size, perhaps pointer arithmetic considers type~!
    }

    cout << "The new array after pointer arithmetic, and adding +123 to each index: \n";
    for (int i = 0; i < size; i++) {
        printf("%i\n", arr_int[i]);
    }

    return -1;

}
