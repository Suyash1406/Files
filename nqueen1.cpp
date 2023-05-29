#include<iostream>
using namespace std;

bool issafe(int **board,int x,int y,int n)
{
    //specific row
     
    for(int row=0;row<x;row++)
    {
        if(board[row][y]==1)
        {
            return false;
        }
    }
    int row=x;
    int col=y;
    //upper digonal
    while(row>=0 && col>=0)
    {
        if(board[row][col]==1)
        {
            return false;
        }
        row--;
        col--;
    }
    row=x;
    col=y;
    //lower digonal
    while(row>=0 && col<n)
    {
        if(board[row][col]==1)
        {
            return false;
        }
        row--;
        col++;
    }
    return true;
}
bool placeQueen(int **board,int x,int n)
{
    if(x>=n) 
    return true;
    
    for(int col=0;col<n;col++)
    {
        if (issafe(board,x,col,n))
        {
            board[x][col]=1;
            if(placeQueen(board,x+1,n))
            {
                return true;
            }
            board[x][col]=0;
        }
    }
    return false;
      
}


int main()
{
   
    int n;
    cout<<"Enter the n value: ";
    cin>>n;
    int **board=new int*[n];
    
    for(int i=0;i<n;i++)
    {
        board[i]=new int[n];
    }
                             // |     |
    for(int i=0;i<n;i++)     // X 0 0 0
    {                        // 0 X 0 0 
        for(int j=0;j<n;j++) // X X Q 0
        {                    // 0 X 0 0
            board[i][j]=0;
        }
    }

    if(placeQueen(board,0,n))
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cout<<board[i][j]<<" ";
            }
            cout<<endl;
        }
    }
    else
    {
        cout<<"No solution!!!";
    }
}