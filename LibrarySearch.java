package dsProject;

public class LibrarySearch
{
    int issueDay[] = new int[200];

    public void displaySubjects()
    {
        System.out.println("\nAvailable Subjects:");
        for(int i = 0; i < Books.books.length; i++)
        {
            boolean printed = false;
            for(int j = 0; j < i; j++)
            {
                if(Books.books[i].subject.equalsIgnoreCase(Books.books[j].subject))
                {
                    printed = true;
                    break;
                }
            }
            if(!printed)
                System.out.println("- " + Books.books[i].subject);
        }
    }

    public int checkBook(int key)
    {
        int low = 0;
        int high = Books.books.length - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(Books.books[mid].bookId == key)
                return mid;
            else if(key > Books.books[mid].bookId)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public void issueBook(Books book, int issueDayInput)
    {
        if(book.count > 0)
        {
            book.count--;
            book.issued++;
            issueDay[checkBook(book.bookId)] = issueDayInput;
            System.out.println("Book Issued Successfully: " + book.bookName);
        }
        else
        {
            System.out.println("Book Not Available: " + book.bookName);
        }
    }

    public void returnBook(Books book, int returnDay)
    {
        int index = checkBook(book.bookId);
        int daysUsed = returnDay - issueDay[index];

        if(daysUsed > 7)
        {
            int fine = (daysUsed - 7) * 5;
            System.out.println("Late Fine: " + fine);
        }

        book.count++;
        System.out.println("Book Returned Successfully: " + book.bookName);
    }

    public void sortByBookId()
    {
        for(int i = 0; i < Books.books.length - 1; i++)
        {
            for(int j = i + 1; j < Books.books.length; j++)
            {
                if(Books.books[i].bookId > Books.books[j].bookId)
                {
                    Books temp = Books.books[i];
                    Books.books[i] = Books.books[j];
                    Books.books[j] = temp;
                }
            }
        }
    }
}