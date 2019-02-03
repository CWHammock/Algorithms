Horner’s Rule algorithm (polynomial evaluation)
By C. Warren 
Date: 4/26/18
Purpose: Uses the Horner Method/Alogorithm to solve polynomials
Two class files: HornerAlgorithm.class, HornerDriver.class
One input text file: inputFile.txt
    input file is structure is the following:
    First number is the value of x.
    Following numbers is an integer followed by coefficents with x+1 exponents
    One line of numbers with comma and no whitespace seperating the comma/numbers
        E.G. 2,3,4,5,6 will be represented as x = 2, 
            3,
            4 and x to power of 1,
            5 and x to power of 2,
            6 and x to power of 3.
The output file shows the value of each level in descending power of x.  Due to the nature of the 
calculation ((x(6x + 5)+4)+3), I was not sure how to represent the algorithm in the reverse order.  


to run program, locate the HornerDriver.class folder.  Type the command
javac HornerAlgorithm.class and enter.  Next type javac HornerDriver.class
and enter.  Type java HornerDriver and the results should output to a file named
outputFile.txt.  Make sure the java jre 1.8 is installed before execution. 