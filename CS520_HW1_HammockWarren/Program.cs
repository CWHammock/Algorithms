using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
Developed by: Warren Hammock
Date: 1/25/18
Purpose: take input and create a Binary Search Tree.
 */
namespace BST
{
    class Node
    {
        public int Data { get; set; }
        public Node rightNode = null;
        public Node leftNode = null;

        public Node(int value)
        {
            this.Data = value;
        }

        public override string ToString()
        {
            return ("Data for this node is: " + this.Data);
        }
    }

    class BinarySearchTree
    {
        public Node Root { get; set; }

        public BinarySearchTree(int[] inputArray)
        {
            int length = inputArray.Length;
            string path = "text_bst.txt";
            try
            {
                for(int i = 0; i < length; i++)
                {
                    //Takes int from array and uses it to create a Node.  The Node is added to tree.
                    AddNode(new Node(inputArray[i]));

                    //Creates seperation between outputs
                    using (StreamWriter stream = File.AppendText(path))
                        {
                            stream.WriteLine("BST after Addition of Node: " + Convert.ToString(inputArray[i]));
                        }

                    //due to design, I have to have a O(npowerof2).  Didnt have time to modify
                    WriteNodesToFile(Root, path);
                }

                //delete node with value of 5
                int deleteValue = 5;
                DeleteNode(deleteValue);

                //write new node tree to file
                using (StreamWriter stream = File.AppendText(path))
                {
                    stream.WriteLine("BST after Deletion of Node: " + Convert.ToString(deleteValue));
                }
                WriteNodesToFile(Root, path);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }

        //does evaluation of nodes and creates new node where evaluation is complete
        private void AddNode(Node newNode)
        {
            //checks if root is null.  if it is, simply make new node the root.
            if (Root == null) Root = newNode;
            else
            {
                //an iterator to iterate thru the linked list
                Node iterator = Root;
                while (true)
                {
                    if (newNode.Data < iterator.Data)
                    {
                        //if the leftnode is empty, simply make this node the left
                        if (iterator.leftNode == null)
                        {
                            iterator.leftNode = newNode;
                            break;
                        }
                        else
                        {
                            //continues the iteration until we reach leafless node
                            iterator = iterator.leftNode;
                        }
                    }
                    else
                    {
                        //if the rightnode is empty, simply make this node the right
                        if (iterator.rightNode == null)
                        {
                            iterator.rightNode = newNode;
                            break;
                        }
                        else
                        {
                            //continues the iteration until we reach leafless node
                            iterator = iterator.rightNode;
                        }
                    } 
                }
            }            
        }

        public void DeleteNode(int nodeValue)
        {
            Node iterator = Root;
            Node parentNode = Root;

            while (iterator.Data != nodeValue)
            {
                if (nodeValue < iterator.Data)
                {
                    parentNode = iterator;
                    iterator = iterator.leftNode;
                }
                else
                {
                    parentNode = iterator;
                    iterator = iterator.rightNode;
                }
                if (iterator == null)
                {
                    Console.WriteLine("Value " + nodeValue + " was not found.");
                }
            }
            //Test info
            //Console.WriteLine(iterator.ToString());
            //Console.WriteLine(parentNode.ToString());

            //delete a leaf node
            if (iterator.leftNode == null && iterator.rightNode == null)
            {
                if (iterator == Root) Root = null;
                else if (parentNode.leftNode == iterator) parentNode.leftNode = null;
                else parentNode.rightNode = null;
            }

            //delete node with left child only
            else if (iterator.leftNode != null && iterator.rightNode == null)
            {
                if (iterator == Root) Root = iterator.leftNode;
                if (iterator == parentNode.leftNode)
                {
                    parentNode.leftNode = iterator.leftNode;
                }
                else
                {
                    parentNode.rightNode = iterator.leftNode;
                }
            }

            //delete node with right child only
            else if (iterator.rightNode != null && iterator.leftNode == null)
            {
                if (iterator == Root) Root = iterator.rightNode;
                if (iterator == parentNode.leftNode)
                {
                    parentNode.leftNode = iterator.rightNode;
                }
                else
                {
                    parentNode.rightNode = iterator.rightNode;
                }
            }

            //delete node with right and left children
            else
            {
                //get node to replace the existing node
                Node newNode = TwoChildNode(iterator);
                if (iterator == Root) Root = newNode;
                else if (parentNode.leftNode == iterator) parentNode.leftNode = newNode;
                else parentNode.rightNode = newNode;
                newNode.leftNode = iterator.leftNode;
            }

        }
        //keeps BST complete while replacing node
        public Node TwoChildNode(Node oldNode)
        {
            Node parentNode = oldNode;
            Node newNode = oldNode;
            Node iterator = oldNode.rightNode;

            //iterate down tree to locate replacement node
            while(iterator != null)
            {
                parentNode = newNode;
                newNode = iterator;
                iterator = iterator.leftNode;
            }
            if (newNode != oldNode.rightNode)
            {
                parentNode.leftNode = newNode.rightNode;
                newNode.rightNode = oldNode.rightNode;
            }
            //return replacement node
            return newNode;
        }

        //Recursively outputs value of every node in tree and writes to file.  Starts from smallest -> largest.  
        public void WriteNodesToFile(Node node, string path)
        {
            if (node == null) return;
            if (node != null)
            {
                WriteNodesToFile(node.leftNode, path);
                using (StreamWriter stream = File.AppendText(path))
                {
                    stream.WriteLine(node.Data);
                }
                WriteNodesToFile(node.rightNode, path);
            }
        }
    }

    //creates input file and driver
    class Driver
    {
        static void Main(string[] args)
        {
            
            IOData.WriteToFile("10, 5, 15, 9, 7, 2, 1, 4, 3, 8");
            int[] newArray = IOData.ReadIntoIntArray("test.txt");
            BinarySearchTree searchTree = new BinarySearchTree(newArray);
  
            Console.ReadKey();

        }
    }
}
