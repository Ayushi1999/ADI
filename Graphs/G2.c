#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    struct node* *arr;  //array of pointers.
    int data;
    struct node* next;
}node;

node* initialise(node* head, int n)
{
    head->arr=(node**)malloc(sizeof(struct node*)*n);
    for(int i=0;i<n;i++)
    {
        head->arr[i]=NULL;
    }
    return head;
}

//insetion at the beggining.
void insert(int x,int y,node** head)
{
    node* nn=(node*)malloc(sizeof(node));
    nn->data=y;
    nn->next=(*head)->arr[x];
    (*head)->arr[x]=nn;
}

void print(int n,node* head)
{
    int i;
    for(i=0;i<n;i++)
    {
        //printf("%d----->",i);
 
        while(head->arr[i] != NULL) 
        {
            printf("%d------->%d",i,head->arr[i]->data);
            head->arr[i]=head->arr[i]->next;
        }
       printf("\n");
    }
}
int main()
{
    struct node* head =(node*)malloc(sizeof(node));
    head=initialise(head,5);
    insert(1,10,&head);
    insert(1,20,&head);
    insert(2,30,&head);
    insert(3,20,&head);
    insert(4,10,&head);
    insert(4,40,&head);
    print(5,head);
}

