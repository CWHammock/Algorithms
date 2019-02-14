# Algorithms


## Some of the work done for Algorithms class and additional exercises. 
___
CS520_HW1:
PowerOfDemonstration.cs: Develop two programs, one using an iterative and another using a recursive algorithm that raise x to
the n-th power, where both x, n ∈ N .

Program.cs: Insert 10, 5, 15, 10, 9, 7, 2, 1, 4, 3, 8 (as read) into an originally empty binary search tree (BST). Once
the BST is populated, perform a delete(5) operation. To receive credit, you must show both how the tree looks
after each insertion and after the delete(5) operation.

Program1.cs: Insert 18, 10, 14, 9, 2, 7, 11, 12 (as read) into an empty min-heap. Show how the heap looks after each
insertion. Once the min-heap is constructed, perform a delete-top operation.

____
CS520_HW2:

HW2.1: Fractional and Zero/One implementation of Knapsack Problem. Output File for validation included. 
HW2.3: Implementation of a greedy algorithm.  Output File for validation included.
___

HW520_HW3:

DFS: DepthFirstSearch
IterativeDeepening

___

CS520_HW4:

Application of the Horner Alogrithm: Traditionally, to compute the value for x in the polynomial f(x) = 5x4+7x3+3x2+2x+3, you would get the value for x and multiply the coefficient by the variable raised to the power of the exponent.  The number of multiplications needed for our original method is 5*x*x*x*x + 7*x*x*x + 3*x*x + 2*x + 3, which is 10 multiplications and 4 additions.  Horner’s method ingeniously keeps factoring out x to cut down on the number of multiplications.  This would leave the pervious problem looking like: x(x(x(5x+7)+3)+2)+3.  This makes the number of multiplications 4, down from 10.  The additions will not change. 
 
