#include <iostream>
using namespace std;

class displayMonitor{   
    public:
    displayMonitor(int h, int w, int res);

    void pixelCount(){
        cout << height*width << " pixels" << "\n";
    };

    private:
    const int height;
    const int width;
    const int resolution;

};

displayMonitor::displayMonitor(int h, int w, int res):height(h), width(w), resolution(h) {
    cout << height << "\n";
    cout << width << "\n";
    cout << resolution << "\n";
};

int main() {
    displayMonitor lgHyper(2560, 1440, 1440);
    lgHyper.pixelCount();

}