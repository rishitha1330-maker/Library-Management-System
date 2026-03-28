package dsProject;

class ReviewNode
{
    Books data;
    ReviewNode link;

    public ReviewNode(Books data)
    {
        this.data = data;
        this.link = null;
    }
}

public class LibraryReview
{
    ReviewNode front;
    ReviewNode rear;

    public LibraryReview()
    {
        front = null;
        rear = null;

        for(int i = 0; i < Books.books.length; i++)
        {
            enqueue(Books.books[i]);
        }
    }

    public void enqueue(Books book)
    {
        ReviewNode newNode = new ReviewNode(book);

        if(front == null || book.review > front.data.review)
        {
            newNode.link = front;
            front = newNode;

            if(rear == null)
                rear = newNode;
        }
        else
        {
            ReviewNode temp = front;

            while(temp.link != null &&
                  temp.link.data.review >= book.review)
            {
                temp = temp.link;
            }

            newNode.link = temp.link;
            temp.link = newNode;

            if(newNode.link == null)
                rear = newNode;
        }
    }

    public void displayReviews()
    {
        ReviewNode temp = front;

        if(temp == null)
        {
            System.out.println("No books in review queue");
            return;
        }

        System.out.println("\nBooks Sorted by Review:");

        while(temp != null)
        {
            System.out.println(
                temp.data.bookName + "-" +
                temp.data.volume +
                " | Review: " + temp.data.review
            );

            temp = temp.link;
        }
    }
}