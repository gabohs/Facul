#include <iostream>

struct Node
{
    int data;   
    Node* prox; 
};

struct Stack
{
    Node* topo = nullptr;

    void push(int data) 
    {
        Node* novo = new Node {data, topo};
        topo = novo;
    }

    int pop() 
    {   
        if (topo != nullptr)
        {
            Node* temp = topo;
            topo = topo->prox;

            int data = temp->data;
            delete temp;

            return data;
        }
    }

    int peek()
    {
        if (topo != nullptr)
            return topo->data; 
    }
};

int main()
{
    Stack pilha;

    pilha.push(12);
    pilha.push(56);
    pilha.push(99);

    std::cout << pilha.pop() << std::endl;
    std::cout << pilha.pop() << std::endl;
    std::cout << pilha.pop() << std::endl;

    return 0;
}