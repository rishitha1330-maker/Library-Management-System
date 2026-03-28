package dsProject;

import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    public static void writeToFile()
    {
        try
        {
            FileWriter fw = new FileWriter("books.txt");

            for(int i = 0; i < Books.books.length; i++)
            {
                Books b = Books.books[i];

                fw.write(
                    b.subject + "," +
                    b.bookName + "," +
                    b.author + "," +
                    b.volume + "," +
                    b.bookId + "," +
                    b.count + "," +
                    b.review + "," +
                    b.issued + "\n"
                );
            }

            fw.close();
        }
        catch(IOException e)
        {
            System.out.println("Error writing file");
        }
    }

    public static void readFromFile()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("books.txt"));
            ArrayList<Books> list = new ArrayList<>();

            String line;

            while((line = br.readLine()) != null)
            {
                String parts[] = line.split(",");

                Books b = new Books(
                    parts[0], parts[1], parts[2],
                    Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    Integer.parseInt(parts[6])
                );

                b.issued = Integer.parseInt(parts[7]);
                list.add(b);
            }

            br.close();

            Books.books = list.toArray(new Books[list.size()]);
        }
        catch(IOException e)
        {
            System.out.println("Using default data");
        }
    }
}
