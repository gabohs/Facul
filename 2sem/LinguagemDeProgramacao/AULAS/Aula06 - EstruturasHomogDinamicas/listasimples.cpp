#include <iostream>

struct Node
{
    int data;   // dado, informação. Conteúdo do node de fato
    Node* prox; // ponteiro para o proximo node
};

struct NodeList
{
    Node* inicio = nullptr;

    void insere(int data) // insere novo node no inicio da lista
    {
        Node* novo = new Node {data, inicio}; // cria novo node (aloca mem. com new) e atualiza os dados com 'data'
        inicio = novo; //  e o ponteiro com o inicio
    }

    void insereFim(int data)
    {
        Node* novo = new Node;
        novo->data = data;

        if (inicio == nullptr)
        {
            novo->prox = inicio;
            inicio = novo;

            return;
        }
        // se o ultimo n for o do inicio, precisaremos encontrá-lo
        
        Node* ultimo = inicio;
        while (ultimo->prox != nullptr) // inserindo no fim da lista
        {
            ultimo = ultimo->prox;
        }
        novo->prox = ultimo->prox;
        ultimo->prox = novo;
    }

    void removeInicio() // remove o primeiro elemento
    {
        if (inicio != nullptr)
        {
            Node* temp = inicio;
            inicio = inicio->prox;

            delete temp;
        }
    }

    void mostra() // printa a lista
    {
        if (inicio == nullptr)
        {
            std::cout << "Lista vazia" << std::endl;
        }
        else 
        {
            Node* elemento = inicio;
            while (elemento != nullptr)
            {
                std::cout << elemento->data << " ";
                elemento = elemento->prox;
            }
            std::cout << std::endl;
        }
    }
};

int main()
{
    NodeList minhaLista;

    minhaLista.insere(12);
    minhaLista.insere(6);

    minhaLista.insereFim(99);
    minhaLista.mostra();

    minhaLista.removeInicio();

    minhaLista.mostra();

    return 0;
}