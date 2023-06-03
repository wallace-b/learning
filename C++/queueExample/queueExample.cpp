#include <iostream>
using namespace std;

class Queue {
    /* Queue class creates an array object that shows a queue of ints going left to right. 
    Leftmost int entry is next in line.
    */
    private:
    int size; // memory storage i.e. X ints
    int length; // length of queue
    int* queue; // array pointer address == array

    // constructor - array of argSize, initiliazed with no length
    public:
    Queue(int argSize=100){
        size = argSize; //if non-provided, default size is 100
        length = 0; // no queue length i.e. empty queue
        queue = new int[argSize];
    };

    void remove(){
        if (size == 0) {
            cout << "Queue is empty" << "\n";
            return; 
        }
        else {
            for (int i=0; i<size-1; i++) {
                queue[i] = queue[i+1]; // i.e. delete the first entry in the queue and shift all entries in the queue array to the left
            }
            size--; // reduce size by 1
            length--; // reduce length by 1
        }
    };

    void add(int argInt){
        queue[length]=argInt; // assign new value to current next index (which is length when accounting for 0 indexing)
        length++; // increase length by 1
        if (length == size) {
            cout << "Queue is full. Please allocate more memory or reduce queue size." << "\n";
        }
    };

    void print() {
        if (size == 0) {
            cout << "Queue is empty" << "\n";
            return; 
        }
        else {
            for (int i=0; i<length; i++) {
                cout << queue[i] << "<--";
            }
            cout << "\n";
        }        
    };
};

int main() {
    Queue q1(3);
    q1.add(57); q1.add(5555); q1.add(66);
    q1.print();
    q1.remove();
    q1.print();

    cout << "--------------------" << "\n";

    Queue q2(5);
    q2.add(142); q2.add(3); q2.add(2); q2.add(99); q2.add(133);
    q2.print();

    return -1;
}