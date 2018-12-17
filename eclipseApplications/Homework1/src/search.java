class  search

{

           public  void select_Sort(int[] arr)

{

   for (int i = 0; i < arr.length-1; i++)//loop ar.length for calculate the size of array

   {

      int minimum = i; //assume first element is smallest

      for (int j = i + 1; j < arr.length; j++)

      {

         if (arr[j] < arr[minimum])

           {

            minimum = j;

           }

      }

      // Swap smallest element into position

      int temp = arr[i];

      arr[i] = arr[minimum];

      arr[minimum] = temp;

   }

for(int i=0;i<arr.length;i++)

{

            System.out.println(arr[i]);

}

}

public static void main(String args[])

{

            search s=   new search();

int a[]= {243,151,16,78,8,9,3,97};

s.select_Sort(a)           ;

}

}


