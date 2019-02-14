using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
/*
Create by: Warren Hammock
Date: 1/26/18
Purpose: A utility class to read and write information to and from files.
 */
namespace BST
{
    public static class IOData
    {
        //reads input from file into string array
        public static string[] ReadIntoStringArray(string filename)
        {
            string content = "";
            try
            {
                using (StreamReader read = File.OpenText(filename))
                {
                    while ((!read.EndOfStream))
                    {
                        content = read.ReadToEnd();
                    }
                }
                string[] result = content.Split(new char[] { ',', '\n' }, StringSplitOptions.RemoveEmptyEntries);
        
                return result;
            }
            catch(Exception e)
            {
                Console.WriteLine(e);
            }
            return null;
        }
        
        //reads input from file into an int array.
        public static int[] ReadIntoIntArray(string filename)
        {
            string path = filename;
            FileStream stream = new FileStream(path, FileMode.Open);
            string content = "";
         
            try
            {
                using (StreamReader read = new StreamReader(stream, true))
                {
                    while ((!read.EndOfStream))
                    {
                        content = read.ReadToEnd();
                    }
                }
                string[] resultString = content.Split(new char[] { ',', '\n' }, StringSplitOptions.RemoveEmptyEntries);
                int[] resultInt = new int[resultString.Length];
                int counter = 0;
                foreach (string item in resultString)
                {
                    resultInt[counter] = Int32.Parse(item);
                    counter++;
                }
                return resultInt;
            }
            catch(Exception e)
            {
                Console.WriteLine(e);
            }
            return null;
        }

        //writes output to file. 
        public static void WriteToFile(params string[] input)
        {
            Console.WriteLine("Enter a filename to store data: ");
            string filename = Console.ReadLine();
            try
            {
                if (File.Exists(filename)) File.Delete(filename);
                else
                {
                    using (StreamWriter streamWriter = File.CreateText(filename))
                    {
                        foreach (string item in input){
                            streamWriter.WriteLine(item);
                        }
                    }
                }

            }
            catch(Exception e)
            {
                Console.WriteLine(e);
            }
        }
    }
}
