package dsProject;

public class LibraryHeap
{
    public void displayMostIssuedBooks(int k)
    {
        Books arr[] = Books.books.clone();

        int n = arr.length;

        for(int i = n/2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        System.out.println("Top " + k + " Most Issued Books:");

        for(int i = 0; i < k; i++)
        {
            Books temp = arr[0];
            arr[0] = arr[n - 1];
            arr[n - 1] = temp;

            System.out.println(
                temp.bookName + "-" + temp.volume +
                " Issued: " + temp.issued
            );

            n--;
            heapify(arr, n, 0);
        }
    }

    private void heapify(Books arr[], int n, int i)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < n && arr[left].issued > arr[largest].issued)
            largest = left;

        if(right < n && arr[right].issued > arr[largest].issued)
            largest = right;

        if(largest != i)
        {
            Books temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}