import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
 * @file: Parser.java
 * @description: This program opens the BattingData csv and input.txt files and ultimately creates the output.txt file with the results from the data and the commands
 * @author: Andrew Young
 * @date: September 25th 2024
 */

//@Class: Parser - class that parses the data and uses the two input files to create the output file
public class Parser {

    // Create a BST tree of your class type (Note: Replace "Object" with your class type)
    private BST<BaseballBatter> mybst = new BST<BaseballBatter>();

    // Parser constructor that takes in the specified input.txt file specified in the command line
    public Parser(String filename, ArrayList<BaseballBatter> inputData) throws FileNotFoundException {
        process(new File(filename), inputData);
    }

    // Implement the process method
    // Remove redundant spaces for each input command
    public void process(File input, ArrayList<BaseballBatter> inputData) throws FileNotFoundException {
        // Use an ArrayList so the length can be adjusted based on the file input
        ArrayList<String> convertedInput = new ArrayList<>();
        int i = 0;

        Scanner scanner = new Scanner(input);
        // While loop that executes until there is nothing left to read from the input file
        while (scanner.hasNextLine()){
            String line  = scanner.nextLine();
            if (line.isEmpty()) continue; // Skip line if it is empty
            //Update the convertedInput array with the most recent String addition
            line = line.trim();
            line = line.replaceAll("\\s+", " ");
            convertedInput.add(line);
            i++;
        }

        //call operate_BST method;
        operate_BST(convertedInput, inputData);
    }

    // Implement the operate_BST method, which reads the commands from the input.txt file and executes them accordingly
    // Determine the incoming command and operate on the BST
    public void operate_BST(ArrayList<String> command, ArrayList<BaseballBatter> batterData) {
        String searchMasterID = "empty";
        int masterIndex;
        String[] currLine;
        String printOutput; // Declare a group of supporting variables to help the function execute
        String[] fullPrintBST;
        BaseballBatter helperPlayer;
        // loop that executes for each command that was read in from the input file
        for (int j = 0; j < command.size(); j++) {

            currLine = command.get(j).split(" "); // Split the current line in order to get the command and the node value
            printOutput = "";
            // Extract the command from the line if it is in the proper format
            if (currLine.length != 1){
                searchMasterID = currLine[1]; // masterID will be placed second in the input.txt file
            }
            // Handle if the command is print
            else if (currLine[0].equals("print")){
                searchMasterID = "print";
            }
            // Handle if the command is not valis
            else{
                searchMasterID = "invalid";
            }
            System.out.println(searchMasterID);
            switch (currLine[0]) {
                // add the cases here
                case "insert": /// Going to need to use a loop here to find the values
                    // Loop through the list and find the index of the object with the matching masterID
                    for (int i = 0; i < batterData.size(); i++) {
                        if (batterData.get(i).getMasterID().equals(searchMasterID)) {
                            mybst.insert(batterData.get(i));  // Insert the object into your BST
                            printOutput = "insert " + searchMasterID; // make this for given name instead?
                            writeToFile(printOutput, "./src/result.txt");

                            break;  // Exit after finding the object
                        }
                    }
                    break;

                case "search": /// Adapt this code to actually fit search
                    // Loop through the list and find the index of the object with the matching masterID
                    for (int i = 0; i < batterData.size(); i++) {
                        if (batterData.get(i).getMasterID().equals(searchMasterID)) {
                            helperPlayer = mybst.search(batterData.get(i));  // Insert the object into your BST

                            if (helperPlayer != null){ // Conditionally change the writing output if the node is found or not
                                printOutput = "search " + searchMasterID; // make this for given name instead?, no duplicates issue
                                writeToFile(printOutput, "./src/result.txt");
                                break;  // Exit after finding the object
                            }

                            else{
                                writeToFile("search failed", "./src/result.txt");
                                break; // Exit after finding the object
                            }
                        }
                    }
                    break;

                case "remove": // Adapt this code to actually perform remove
                    // Loop through the list and find the index of the object with the matching masterID
                    for (int i = 0; i < batterData.size(); i++) {
                        if (batterData.get(i).getMasterID().equals(searchMasterID)) {
                            helperPlayer = mybst.remove(batterData.get(i));  // Remove the object from your BST

                            if (helperPlayer != null){ // Conditionally change the writing output if the node is found or not
                                printOutput = "remove " + searchMasterID; // make this for given name instead?
                                writeToFile(printOutput, "./src/result.txt");
                                break;  // Exit after finding the object
                            }

                            else{
                                writeToFile("remove failed", "./src/result.txt");
                                break; // Exit after finding the object
                            }
                        }
                    }
                    break;

                case "print": // Need to make this print in order of their Hits on the season
                    Iterator<BaseballBatter> iterator = mybst.iterator();
                    printOutput = "";

                    while (iterator.hasNext()){ // Continue to iterate while there are more players still in the tree
                        printOutput = printOutput + iterator.next() + " ";
                    } // Here the players are sorted in ascending order by how many hits they had in the season

                    printOutput = printOutput.trim();
                    System.out.println(printOutput);
                    writeToFile(printOutput, "./src/result.txt");
                    break;
                // do nothing if a line of null somehow sneaks through previous checks
                case null:
                    break;

                // default case for Invalid Command
                default:
                    writeToFile("Invalid Command", "./src/result.txt");
            }
        }
    }

    // Implement the writeToFile method
    // Generate the result file
    public void writeToFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            writer.write(content);
            writer.newLine();
        }
        catch (IOException e){ // Error handling
            e.printStackTrace();
        }
    }
}
