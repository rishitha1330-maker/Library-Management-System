package dsProject;

import java.util.Scanner;

public class LibraryMain
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        FileHandler.readFromFile();

        LibrarySearch search = new LibrarySearch();
        search.sortByBookId();

        LibrarySort sort = new LibrarySort();
        LibraryLinkedList list = new LibraryLinkedList();
        LibraryReview reviewQueue = new LibraryReview();
        LibraryHeap heap = new LibraryHeap();
        LibraryStack stack = new LibraryStack();

        int choice;

        do
        {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Books Menu");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Reviews");
            System.out.println("6. Most Issued Books");
            System.out.println("7. Add New Book");
            System.out.println("8. Undo Last Issue");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    search.displaySubjects();
                    System.out.print("Enter Subject: ");
                    String sub = sc.nextLine();
                    sort.sortBySubject(sub);
                    break;

                case 2:
                    search.sortByBookId();
                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();
                    int idx = search.checkBook(searchId);

                    if(idx != -1)
                    {
                        System.out.println("Book Found");
                        System.out.println("Name: " + Books.books[idx].bookName);
                        System.out.println("Volume: " + Books.books[idx].volume);
                        System.out.println("Available: " + Books.books[idx].count);
                    }
                    else
                    {
                        System.out.println("Book Not Found");
                    }
                    break;

                case 3:
                    search.sortByBookId();
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    int iIdx = search.checkBook(issueId);

                    if(iIdx == -1)
                    {
                        System.out.println("Book Not Found");
                    }
                    else if(Books.books[iIdx].count == 0)
                    {
                        System.out.println("Book Not Available");
                    }
                    else
                    {
                        System.out.print("Enter Issue Day: ");
                        int day = sc.nextInt();
                        search.issueBook(Books.books[iIdx], day);
                        stack.push(Books.books[iIdx]);
                        FileHandler.writeToFile();
                    }
                    break;

                case 4:
                    search.sortByBookId();
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    int rIdx = search.checkBook(returnId);

                    if(rIdx != -1)
                    {
                        System.out.print("Enter Return Day: ");
                        int day = sc.nextInt();
                        search.returnBook(Books.books[rIdx], day);
                        FileHandler.writeToFile();
                    }
                    else
                    {
                        System.out.println("Book Not Found");
                    }
                    break;

                case 5:
                    reviewQueue.displayReviews();
                    break;

                case 6:
                    heap.displayMostIssuedBooks(5);
                    break;

                case 7:
                    System.out.print("Enter Subject: ");
                    String s = sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Volume: ");
                    int vol = sc.nextInt();

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Count: ");
                    int count = sc.nextInt();

                    System.out.print("Enter Review Rating: ");
                    int rev = sc.nextInt();

                    Books newBook = new Books(s, name, author, vol, id, count, rev);

                    list.addBook(newBook);
                    reviewQueue.enqueue(newBook);
                    search.sortByBookId();
                    FileHandler.writeToFile();
                    break;

                case 8:
                    Books b = stack.pop();

                    if(b != null)
                    {
                        System.out.println("Undo successful for: " + b.bookName);
                        search.sortByBookId();
                        FileHandler.writeToFile();
                    }
                    else
                    {
                        System.out.println("Nothing to undo");
                    }
                    break;

                case 9:
                    FileHandler.writeToFile();
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 9);

        sc.close();
    }
}