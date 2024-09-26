import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* Changes to batting csv to note
 * Added given name column for display purposes
 * Added masterID column to make row have a unique identifier
 * Removed all data with NAs, fewer than 50 At Bats, and before the year 1980 due to file size and run time issues
 */

public class Proj1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if(args.length != 1){
            System.err.println("Argument count is invalid: " + args.length);
            System.exit(0);
        }

        // Read in the csv data

        // For file input
        String fileName;
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream("./src/Batting.csv");
        inputFileNameScanner = new Scanner(inputFileNameStream); //

        // ignore first line
        inputFileNameScanner.nextLine();

        // Create an ArrayList to store the BaseballBatter data
        ArrayList<BaseballBatter> batterData = new ArrayList<BaseballBatter>();
        BaseballBatter currentBatter;

        // Declare all the variables outside here
        String playerID;
        String yearID;
        int stint;
        String teamID;
        String lgID;
        int G;
        int AB;
        int R;
        int H;
        int Doubles;
        int Triples;
        int HR;
        int RBI;
        int SB;
        int CS;
        int BB;
        int SO;
        int IBB;
        int HBP;
        int SH;
        int SF;
        int GIDP;
        String nameGiven;
        String masterID;

        // Read the file line by line
        while (inputFileNameScanner.hasNext()) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(","); // split the string into multiple parts
            // Create the new baseball batter, and determine the inputs
            playerID = parts[0];
            yearID = parts[1];
            stint = Integer.parseInt(parts[2]);
            teamID = parts[3];
            lgID = parts[4];
            G = Integer.parseInt(parts[5]);
            AB = Integer.parseInt(parts[6]);
            R = Integer.parseInt(parts[7]);
            H = Integer.parseInt(parts[8]);
            Doubles = Integer.parseInt(parts[9]);
            Triples = Integer.parseInt(parts[10]);
            HR = Integer.parseInt(parts[11]);
            RBI = Integer.parseInt(parts[12]);
            SB = Integer.parseInt(parts[13]);
            CS = Integer.parseInt(parts[14]);
            BB = Integer.parseInt(parts[15]);
            SO = Integer.parseInt(parts[16]);
            IBB = Integer.parseInt(parts[17]);
            HBP = Integer.parseInt(parts[18]);
            SH = Integer.parseInt(parts[19]);
            SF = Integer.parseInt(parts[20]);
            GIDP = Integer.parseInt(parts[21]);
            nameGiven = parts[22];
            masterID = parts[23];


            currentBatter = new BaseballBatter(playerID, yearID, stint, teamID, lgID, G, AB, R, H, Doubles, Triples, HR, RBI, SB,
                    CS, BB, SO, IBB, HBP, SH, SF, GIDP, nameGiven, masterID);

            batterData.add(currentBatter);
        }
        inputFileNameStream.close(); // because I care too

        new Parser(args[0], batterData);
    }
}