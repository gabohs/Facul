#include <iostream>

struct Node
{
    int data;   // dado, informação. Conteúdo do node de fato
    Node* prox; // ponteiro para o proximo node
};

struct ListaOrdenada
{
    Node* inicio = nullptr;

    void insere(int data) // insere novo node no inicio da lista
    {
        Node* novo = new Node;
        novo->data = data;

        if (inicio == nullptr) // verifica se a lista esta vazia
        {
            inicio = novo;
            inicio->prox = nullptr;
        }
        else
        {
            Node* atual = inicio;

            if (atual->data > novo->data) // novo elemento eh o menor de todos. Deve ser inserido no inicio
            {
                novo->prox = atual;
                inicio = novo;
            }
            else
            {
                while( atual->prox != nullptr && atual->prox->data < novo->data )
                {
                    atual = atual->prox;
                } 

                novo->prox = atual->prox;
                atual->prox = novo;
            }
        }
    }

    // remoção: ainda n foi feita, vai ser enviada ead
};

int main()
{

    return 0;
}