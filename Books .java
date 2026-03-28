package dsProject;

public class Books
{
    String subject;
    String bookName;
    String author;
    int volume;
    int bookId;
    int count;
    int review;
    int issued;

    public Books(String subject,String bookName,String author,int volume,int bookId,int count,int review)
    {
        this.subject = subject;
        this.bookName = bookName;
        this.author = author;
        this.volume = volume;
        this.bookId = bookId;
        this.count = count;
        this.review = review;
        this.issued = 0;
    }

    public static Books books[] =
    {
        new Books("DSA","Data Structures","Mark Allen",1,101,4,9),
        new Books("DSA","Data Structures","Mark Allen",2,102,9,7),
        new Books("DSA","Data Structures","Mark Allen",3,103,0,6),
        new Books("JAVA","Java Programming","James Gosling",1,201,5,8),
        new Books("JAVA","Java Programming","James Gosling",2,202,0,10),
        new Books("C","Programming in C","Dennis Ritchie",1,301,6,10),
        new Books("C","Programming in C","Dennis Ritchie",2,302,2,7),
        new Books("C++","Programming in C++","Bjarne Stroustrup",1,401,8,8),
        new Books("WEB","Web Development","Jon Duckett",1,501,5,7),
        new Books("OS","Operating Systems","Silberschatz",1,1001,3,9)
    };
}