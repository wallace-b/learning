#include <iostream>
using namespace std;

class weapon{
    private:
    int damageAmount;
    
    public:
    // constructor
    weapon(int x){
        setDamageAmount(x);
        cout << "Weapon created with" << x << " quality." << "\n";
    };
    
    // setter
    void setDamageAmount(int arg){
        damageAmount = arg;
    };

    // getter
    int getDamageAmount(){
        if(damageAmount >= 800){
            cout << "This weapon is of excellent quality." << "\n";
        }
        return damageAmount;
    };
};

int main(){
    int damageAmountInput;
    cin >> damageAmountInput;
    //damageAmountInput = 1000;

    weapon myWeapon;
    myWeapon.setDamageAmount(damageAmountInput);
    int weaponDamage = myWeapon.getDamageAmount();
    cout << weaponDamage << "\n";
    
    return -1;
};
