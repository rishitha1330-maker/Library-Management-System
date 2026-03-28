package dsProject;

class StackNode
{
    Books data;
    StackNode next;

    public StackNode(Books data)
    {
        this.data = data;
        this.next = null;
    }
}

public class LibraryStack
{
    StackNode top = null;

    public void push(Books book)
    {
        StackNode node = new StackNode(book);
        node.next = top;
        top = node;
    }

    public Books pop()
    {
        if(top == null)
        {
            return null;  
        }

        Books book = top.data;
        top = top.next;
        book.count++;  
        return book;   
    }
}