'''
Created on Jan 22, 2018
purpose: to create a recursive and iterative function to raise interger to power of n and produce graphs of output
@author: c. warren hammock
'''
import time
import matplotlib.pyplot as graph
import numpy as npy
import random

def main():
    
    #user input for power and base
    user_number_base = input("Enter a base number: ")
    user_number_power = input("Enter a power to the base: ")
    filename_recursive = ("testPowerOfRecursion{}_{}.txt".format(user_number_base, user_number_power))
     
    filename_iterative = ("testPowerOfIterative{}_{}.txt".format(user_number_base, user_number_power))
    #filename = "testPowerOfRecursion.txt"
    #file = open(filename, "a")
    #file.write("#recursive output per iteration from 1=>{} for number {}\n".format(user_number_power, user_number_base))
    #file.close
    recursive_answer = power_of_recursive(int(user_number_power), int(user_number_base), filename_recursive)
    print()
    #filename = "testPowerOfIteration.txt"
    #file = open(filename, "a")
    #file.write("#iterative output per iteration from 1=>{} for number {}\n".format(user_number_power, user_number_base))
    #file.close
    iterative_answer = power_of_iterative(int(user_number_power), int(user_number_base), filename_iterative)
    graph_iterative(filename_iterative)
    graph_recursive(filename_recursive)
    print("Recursive answer is: " + str(recursive_answer))
    print("Iterative answer is: " + str(iterative_answer))    

#calls recursive function which returns the power of a base number
# variables needed:
# base_number: number to multiply by itself
# power_of: number of times base number is multiplied by itself
# filename: name of the file to output writes to   
def power_of_recursive(power_of, base_number, filename):
    file = open(filename, "a")
    start_time = time.perf_counter()
    if power_of == 0:
        return(1)
    else:
        recursive_answer = base_number * power_of_recursive(power_of - 1, base_number, filename)
        end_time = time.perf_counter()
        timer = (end_time - start_time)
        file.write(str(timer) + "\n")
        #print("recursive power of " + str(power_of) + " timing is " + str(timer))
    file.close()
    return recursive_answer
    
        
#calls iterative function which returns the power of a base number
# variables needed:
# base_number: number to multiply by itself
# power_of: number of times base number is multiplied by itself
# filename: name of the file to output writes to  
def power_of_iterative(power_of, base_number, filename):
    iterative_answer = base_number
    file = open(filename, "a")
    counter = 1
    file.write("0.0 \n")
    start_time = time.perf_counter() 
    while power_of != counter:
        iterative_answer *= base_number
        counter += 1
        end_time = time.perf_counter()
        timer = (end_time - start_time)
        file.write(str(timer) + "\n")
        #print("iterative power of " + str(counter) + " timing is " + str(timer))
    file.close()
    return iterative_answer

#graph results of the speed test for iterative function
def graph_iterative(file):
    
    iteration_list = []
    number_list = []
    with open(file, "r") as f:
        readin_list = f.readlines()

    #take off the carriage return
    for i in range(len(readin_list)):
        iteration_list.append(readin_list[i].rstrip('\n'))
    
    
        
    #create array for x axis
    counter = 0
    for i in iteration_list:
        number_list.append(counter)
        counter = counter + 1
    
    #change each array to numpy for increased precision 
    number_array = npy.array(number_list)
    iteration_array = npy.array(iteration_list)
    
    #create actual graph
    graph.plot(number_array,iteration_array)
    graph.xlabel("calculations")
    graph.ylabel("ms")
    graph.title("Iteration Graph")
    graph.show()

#graph results of the speed test for recursive function
def graph_recursive(file):
    
    recursive_list = []
    number_list = []
    with open(file, "r") as f:
        readin_list = f.readlines()

    #take off the carriage return
    for i in range(len(readin_list)):
        recursive_list.append(readin_list[i].rstrip('\n'))
    
    
        
    #create array for x axis
    counter = 0
    for i in recursive_list:
        number_list.append(counter)
        counter = counter + 1
    
    #change each array to numpy for increased precision 
    number_array = npy.array(number_list)
    recursive_array = npy.array(recursive_list)
    
    #create actual graph
    graph.plot(number_array,recursive_array)
    graph.xlabel("calculations")
    graph.ylabel("ms")
    graph.title("Recursive Graph")
    graph.show()

    
if __name__ == '__main__':
    main()