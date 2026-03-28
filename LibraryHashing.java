package dsProject;

class HashNode
{
    Books data;
    HashNode next;

    public HashNode(Books data)
    {
        this.data=data;
        this.next=null;
    }
}

public class LibraryHashing
{
    int size=10;
    HashNode table[];

    public LibraryHashing()
    {
        table = new HashNode[size];
    }

    int hashFunction(String subject)
    {
        int sum=0;

        for(int i=0;i<subject.length();i++)
            sum += subject.charAt(i);

        return sum%size;
    }

    public void insert(Books book)
    {
        int index = hashFunction(book.subject);

        HashNode node = new HashNode(book);

        if(table[index]==null)
            table[index]=node;

        else
        {
            HashNode temp = table[index];

            while(temp.next!=null)
                temp=temp.next;

            temp.next=node;
        }

        System.out.println("Book stored in Hash Table");
    }

    public void display()
    {
        for(int i=0;i<size;i++)
        {
            HashNode temp = table[i];

            while(temp!=null)
            {
                System.out.println(
                temp.data.subject+" "+
                temp.data.bookName+
                " BookId-"+temp.data.bookId);

                temp=temp.next;
            }
        }
    }
}
