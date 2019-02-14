using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
Developed by: Warren Hammock
Created on: 1/28/18
Purpose: Create a min heap from input.  After complete, delete top.
*/
namespace Heap
{
    
    class MinHeap
    {
        List<int> _heap;
        public readonly int _root = 1;

        public MinHeap()
        {
            _heap = new List<int>();
            _heap.Add(-1);
        }

        //takes number and adds it to the list.  uses HeapifyUp to 
        //balance heap.
        public void insert(int number)
        {
            _heap.Add(number);
            HeapifyUp(number);
        } 

        //checks if parent is greater than child, if so, swap the two values.
        private void HeapifyUp(int number)
        {
            if (_heap.Count == 2) return;
            else
            {
                while(true)
                {
                    int numberIndex = _heap.IndexOf(number);
                    int parentIndex = GetIndexParent(number);
                    if (_heap[numberIndex] < _heap[parentIndex])
                    {
                        Swap(numberIndex, parentIndex);
                    }
                    else break;
                }
            }
        }

        //deletes the top value, lowest in heap, also index[1].  replaces index[1] with 
        //index[length of heap -1].  Uses HeapifyDown to balance tree.
        public void DeleteTop()
        {
            if(_heap.Count == 2)
            {
                _heap.Remove(_heap[1]);
                return;
            }
            //make top node == last node.  delete last node
            int listSize = _heap.Count - 1;
            Swap(_root, listSize);
            _heap.Remove(_heap[listSize]);
            
            //evaluate top node against list with heapifydelete
            HeapifyDown(_heap[_root]);
        }

        //evaluates each parent with child.  if parent is less than greater than child, swap two values. 
        private void HeapifyDown(int mainNumber)
        {
            while (true)
            {
                int indexMain = _heap.IndexOf(mainNumber);
                int indexLeft = GetIndexLeftChild(mainNumber);
                if (indexLeft > _heap.Count - 1) indexLeft = -1;
                int indexRight = GetIndexRightChild(mainNumber);
                if (indexRight > _heap.Count - 1) indexRight = -1;
                
                //handles cases where the index evaulation is out of bounds of array.
                if (indexLeft != -1 && indexRight != -1)
                {
                    //if both children are less than parent
                    if (_heap[indexMain] > _heap[indexLeft] && _heap[indexMain] > _heap[indexRight])
                    {
                        if (_heap[indexLeft] < _heap[indexRight])
                        {
                            int tempIndex = indexLeft;
                            Swap(indexMain, indexLeft);
                        }
                        else
                        {
                            int tempIndex = indexRight;
                            Swap(indexMain, indexRight);
                        }
                    }
                    //if the left child is less than parent
                    else if (_heap[mainNumber] > _heap[indexLeft])
                    {
                        int tempIndex = indexLeft;
                        Swap(indexMain, indexLeft);
                    }
                    //if right child is less than parent
                    else if (_heap[mainNumber] > _heap[indexRight])
                    {
                        int tempIndex = indexRight;
                        Swap(indexMain, indexRight);
                    }
                }
                //if both children evaluation are out of bounds of array
                else if (indexLeft == -1 && indexRight == -1)
                {
                    break;
                }
                //if right child evaluation is out of bounds.
                else if (indexRight != -1)
                {
                    if (_heap[mainNumber] > _heap[indexLeft])
                    {
                        int tempIndex = indexLeft;
                        Swap(indexMain, indexLeft);
                    }
                }
            }
        }

        //check if the heap is empty
        public bool IsEmpty()
        {
            return (_heap.Count == 1);
        }

        //get index of the parent value
        private int GetIndexParent(int number)
        {
                int currentIndex = _heap.IndexOf(number);
                return (currentIndex / 2);
        }

        //get the index of the parent left child number
        private int GetIndexLeftChild(int number)
        {
            int currentIndex = _heap.IndexOf(number);
            return (currentIndex * 2);

        }

        //get the index of the parent of the right child number
        private int GetIndexRightChild(int number)
        {
            int currentIndex = _heap.IndexOf(number);
            return ((currentIndex * 2) + 1);
        }

        //print heap
        public void PrintHeap()
        {
            string path = "output_heap.txt";
            using (StreamWriter stream = File.AppendText(path))
            {
                stream.WriteLine("After Action, the Heap Looks Like: ");
                foreach(int item in _heap)
                {
                    
                    stream.WriteLine(item);
                }
            }
        }

        //swap values
        public void Swap(int numberIndex, int otherIndex)
        {
            int number = _heap[numberIndex];
            int parentNumber = _heap[otherIndex];
            _heap[numberIndex] = parentNumber;
            _heap[otherIndex] = number;
            
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            IOData.WriteToFile("18, 10, 14, 9, 2, 7, 11, 12");
            int[] newArray = IOData.ReadIntoIntArray("test.txt");
            MinHeap minHeap = new MinHeap();
            
            //inserts each item of array into the heap and writes to file.
            for(int i = 0; i < newArray.Length; i++)
            {
                minHeap.insert(newArray[i]);
                minHeap.PrintHeap();
            }
            
            //deletes the top, smallest, item.
            minHeap.DeleteTop();
            
            //seperates data in the output file. 
            string path = "output_heap.txt";
            using (StreamWriter stream = File.AppendText(path))
            {
                stream.WriteLine("After Doing A DeleteTop, This Is What The Heap Looks Like: ");
            }
            minHeap.PrintHeap();
            Console.ReadKey();

        }
    }
}
