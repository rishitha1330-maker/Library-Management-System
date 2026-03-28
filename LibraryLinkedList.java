package dsProject;

class Node
{
    Books data;
    Node link;

    public Node(Books data)
    {
        this.data=data;
        this.link=null;
    }
}

public class LibraryLinkedList
{
    Node head=null;

    public void addBook(Books book)
    {
        Node newNode = new Node(book);

        if(head==null)
            head=newNode;

        else
        {
            Node temp=head;

            while(temp.link!=null)
                temp=temp.link;

            temp.link=newNode;
        }

        Books newArray[] = new Books[Books.books.length+1];

        int i=0;
        int j=0;

        while(i<Books.books.length &&
              Books.books[i].bookId < book.bookId)
        {
            newArray[j++] = Books.books[i++];
        }

        newArray[j++] = book;

        while(i<Books.books.length)
        {
            newArray[j++] = Books.books[i++];
        }

        Books.books = newArray;

        System.out.println("Book added successfully.");
    }
}