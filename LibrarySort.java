package dsProject;

public class LibrarySort
{
    public void sortBySubject(String subject)
    {
        mergeSort(Books.books, 0, Books.books.length - 1, subject);

        System.out.println("Sorted Books:");

        for(int i = 0; i < Books.books.length; i++)
        {
            if(Books.books[i].subject.equalsIgnoreCase(subject))
            {
                System.out.println(
                    Books.books[i].bookName +
                    " Volume-" + Books.books[i].volume +
                    " BookId-" + Books.books[i].bookId +
                    " Count-" + Books.books[i].count
                );
            }
        }
    }

    public void mergeSort(Books arr[], int left, int right, String subject)
    {
        if(left < right)
        {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid, subject);
            mergeSort(arr, mid + 1, right, subject);

            merge(arr, left, mid, right, subject);
        }
    }

    public void merge(Books arr[], int left, int mid, int right, String subject)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Books L[] = new Books[n1];
        Books R[] = new Books[n2];

        for(int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for(int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2)
        {
            if(L[i].subject.equalsIgnoreCase(subject) &&
               R[j].subject.equalsIgnoreCase(subject))
            {
                if(L[i].count >= R[j].count)
                    arr[k++] = L[i++];
                else
                    arr[k++] = R[j++];
            }
            else
            {
                arr[k++] = L[i++];
            }
        }

        while(i < n1)
            arr[k++] = L[i++];

        while(j < n2)
            arr[k++] = R[j++];
    }
}