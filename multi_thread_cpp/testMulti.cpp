#include <iostream>
#include <thread>
#include <exception>
void hello()
{
    std::cout << "Hello world!!!!" << std::endl;
}

int main()
{
    std::cout << "In Main\n";
    std::thread t(hello);
    t.join();
    return 0;
}
