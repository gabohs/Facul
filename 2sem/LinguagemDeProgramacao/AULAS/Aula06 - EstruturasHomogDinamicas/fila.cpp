#include <iostream>

struct Node
{
    int data;   
    Node* prox; 
};

struct Fila
{
    Node* cabeca = nullptr;
    Node* cauda  = nullptr;

    void enqueue(int data) 
    {
        Node* novo = new Node;
        novo->data = data;
        novo->prox = nullptr;

        // se a fila estiver vazia:
        if (cabeca == nullptr)
        {
            cabeca = novo;
            cauda = novo;

            return;
        }

        // se n estiver vazia:
        cauda->prox = novo;
        cauda = cauda->prox;
    }

    int dequeue() 
    {   
        Node* temp = cabeca;

        if (cabeca == cauda) // significa que so tem um elemento na fila
        {
            cabeca = nullptr;
            cauda  = nullptr;
        }
        else
        {
             cabeca = cabeca->prox;
        }

        int data = temp->data;
        delete temp;

        return data;
    }

    int peek()
    {
        if (cabeca != nullptr)
            return cabeca->data; 
    }
};

int main()
{
    Fila minhaFila;

    minhaFila.enqueue(12);
    minhaFila.enqueue(56);
    minhaFila.enqueue(99);

    std::cout << minhaFila.dequeue() << " ";
    std::cout << minhaFila.dequeue() << " ";
    std::cout << minhaFila.dequeue() << " " << std::endl;

    return 0;
}