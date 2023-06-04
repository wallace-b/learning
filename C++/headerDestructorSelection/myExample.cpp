#include <iostream>
using namespace std;

class myVehicle
{
    public:
    myVehicle();
    void myPrint();
};

myVehicle::myVehicle(){    
}
void myVehicle::myPrint(){
    cout << "hello world." << "\n";
};

int main(){
    myVehicle car;
    myVehicle *carPtr = &car;
    carPtr->myPrint();
}

