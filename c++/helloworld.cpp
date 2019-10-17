// A hello world program in C++

	#include<iostream>
	using namespace std;

	int add(int x, int y)
{
    return x + y;
}

int main()
{
    int example = 5;
    std::cout << add(example, ++example);
    // std::cout << "Hello";
}

//could either be 5+6 = 11
//or it could be 6 + 6 = 12