/*
 * @file: BaseballBatter.java
 * @description: This program creates the class that is the object for batters in baseball. These are sourced from the Batting.csv file
 * @author: Andrew Young
 * @date: September 25th 2024
 */

//@Class: BaseballBatter - see above, but this defines the custom data type that will be used in the bst for this project
public class BaseballBatter implements Comparable<BaseballBatter> {

    // Declare the attributes for the class
    String playerID; // Player ID
    String yearID; // Year of season for player, maybe make int? Depends on how you want to use
    int stint; // Numbered stint with a team within that season
    String teamID; // ID of team a player is playing for
    String lgID; // Name of league that a player's team is in
    int G; // Amount of games the batter appeared in this year
    int AB; // Amount of At Bats the batter recorded within the season/stint
    int R; // Amount of Runs the batter recorded within the season/stint
    int H; // Amount of Hits the batter recorded within the season/stint
    int Doubles; // Amount of Doubles the batter recorded within the season/stint
    int Triples; // Amount of Triples the batter recorded within the season/stint
    int HomeRuns; // Amount of Home Runs the batter recorded within the season/stint
    int RBI; // Amount of runs batted in the batter recorded within the season/stint
    int SB; // Amount of stolen bases the batter recorded within the season/stint
    int CS; // Amount of caught stealing the batter recorded within the season/stint
    int BB; // Amount of walks the batter recorded within the season/stint
    int SO; // Amount of strikeouts the batter recorded within the season/stint
    int IBB; // Amount of intentional walks the batter recorded within the season/stint
    int HBP; // Amount of hit by pitches the batter recorded within the season/stint
    int SH; // Amount of sacrifice hits the batter recorded within the season/stint
    int SF; // Amount of sacrifice flies the batter recorded within the season/stint
    int GIDP; // Amount of grounded into double plays the batter recorded within the season/stint
    String nameGiven;
    String masterID;

    // Implement default constructor
    public BaseballBatter(){
        this.playerID = null;
        this.yearID = null;
        this.stint = 0;
        this.teamID = null;
        this.lgID = null;
        this.G = 0;
        this.AB = 0;
        this.R = 0;
        this.H = 0;
        this.Doubles = 0;
        this.Triples = 0;
        this.HomeRuns = 0;
        this.RBI = 0;
        this.SB = 0;
        this.CS = 0;
        this.BB = 0;
        this.SO = 0;
        this.IBB = 0;
        this.HBP = 0;
        this.SH = 0;
        this.SF = 0;
        this.GIDP = 0;
        this.nameGiven = null;
        this.masterID = null;
    }

    // Implement the parameterized constructor
    public BaseballBatter(String xPlayerID, String xYearID, int xStint, String xTeamID, String xLgID, int xG, int xAB,
                          int xR, int xH, int xDoubles, int xTriples, int xHomeRuns, int xRBI, int xSB, int xCS, int xBB,
                          int xSO, int xIBB, int xHBP, int xSH, int xSF, int xGIDP, String nameGiven, String masterID
    ){
        this.playerID = xPlayerID;
        this.yearID = xYearID;
        this.stint = xStint;
        this.teamID = xTeamID;
        this.lgID = xLgID;
        this.G = xG;
        this.AB = xAB;
        this.R = xR;
        this.H = xH;
        this.Doubles = xDoubles;
        this.Triples = xTriples;
        this.HomeRuns = xHomeRuns;
        this.RBI = xRBI;
        this.SB = xSB;
        this.CS = xCS;
        this.BB = xBB;
        this.SO = xSO;
        this.IBB = xIBB;
        this.HBP = xHBP;
        this.SH = xSH;
        this.SF = xSF;
        this.GIDP = xGIDP;
        this.nameGiven = nameGiven;
        this.masterID = masterID;
    }

    // Implement the copy constructor
    public BaseballBatter( BaseballBatter other){
        this.playerID = other.playerID;
        this.yearID = other.yearID;
        this.stint = other.stint;
        this.teamID = other.teamID;
        this.lgID = other.lgID;
        this.G = other.G;
        this.AB = other.AB;
        this.R = other.R;
        this.H = other.H;
        this.Doubles = other.Doubles;
        this.Triples = other.Triples;
        this.HomeRuns = other.HomeRuns;
        this.RBI = other.RBI;
        this.SB = other.SB;
        this.CS = other.CS;
        this.BB = other.BB;
        this.SO = other.SO;
        this.IBB = other.IBB;
        this.HBP = other.HBP;
        this.SH = other.SH;
        this.SF = other.SF;
        this.GIDP = other.GIDP;
        this.nameGiven = other.nameGiven;
        this.masterID = other.masterID;
    }

    // Implement getters and setters?
    public String getPlayerID(){
        return this.playerID;
    }

    public String getYearID(){
        return this.yearID;
    }

    public String getTeamID(){
        return this.teamID;
    }

    public String getLgID(){
        return this.lgID;
    }

    public int getStint(){
        return this.stint;
    }

    public int getG(){
        return this.G;
    }

    public int getAB(){
        return this.AB;
    }

    public int getR(){
        return this.R;
    }

    public int getH(){
        return this.H;
    }

    public int getDoubles(){
        return this.Doubles;
    }

    public int getTriples(){
        return this.Triples;
    }

    public int getHomeRuns(){
        return this.HomeRuns;
    }

    public int getRBI(){
        return this.RBI;
    }

    public int getSB(){
        return this.SB;
    }

    public int getCS(){
        return this.CS;
    }

    public int getBB(){
        return this.BB;
    }

    public int getSO(){
        return this.SO;
    }

    public int getIBB(){
        return this.IBB;
    }

    public int getHBP(){
        return this.HBP;
    }

    public int getSH(){
        return this.SH;
    }

    public int getSF(){
        return this.SF;
    }

    public int getGIDP(){
        return this.GIDP;
    }

    public String getNameGiven(){
        return this.nameGiven;
    }

    public String getMasterID(){
        return this.masterID;
    }

    // Now implement all of the setters
    public void setPlayerID(String playerID){
        this.playerID = playerID;
    }

    public void setYearID(String yearID){
        this.yearID = yearID;
    }

    public void setTeamID(String teamID){
        this.teamID = teamID;
    }

    public void setLgID(String lgID){
        this.lgID = lgID;
    }

    public void setStint(int stint){
        this.stint = stint;
    }

    public void setG(int G){
        this.G = G;
    }

    public void setAB(int AB){
        this.AB = AB;
    }

    public void setR(int R){
        this.R = R;
    }

    public void setH(int H){
        this.H = H;
    }

    public void setDoubles(int Doubles){
        this.Doubles = Doubles;
    }

    public void setTriples(int Triples){
        this.Triples = Triples;
    }

    public void setHomeRuns(int HomeRuns){
        this.HomeRuns = HomeRuns;
    }

    public void setRBI(int RBI){
        this.RBI = RBI;
    }

    public void setSB(int SB){
        this.SB = SB;
    }

    public void setCS(int CS){
        this.CS = CS;
    }

    public void setBB(int BB){
        this.BB = BB;
    }

    public void setSO(int SO){
        this.SO = SO;
    }

    public void setIBB(int IBB){
        this.IBB = IBB;
    }

    public void setHBP(int HBP){
        this.HBP = HBP;
    }

    public void setSH(int SH){
        this.SH = SH;
    }

    public void setSF(int SF){
        this.SF = SF;
    }

    public void setGIDP(int GIDP){
        this.GIDP = GIDP;
    }

    public void setNameGiven(String nameGiven){
        this.nameGiven = nameGiven;
    }

    public void setMasterID(String masterID){
        this.masterID = masterID;
    }

    // Implement the toString method, if you have bind the file over with full name so that you can use that instead
    @Override
    public String toString(){
        /* Old toString return
        return "Player: " + this.nameGiven + ", Year: " + this.yearID + ", Team:" + this.teamID + ", Stint:" + this.stint + ", League: " +
                this.lgID + ", Games: " + this.G + ", At Bats: " + this.AB + ", Runs: " + this.R + ", Hits: " + this.H + ", Doubles: " + this.Doubles +
                ", Triples: " + this.Triples + ", Home Runs: " + this.HomeRuns + ", Runs Batted In: " + this.RBI + ", Stolen Bases: " + this.SB +
                ", Caught Stealing: " + this.CS + ", Walks: " + this.BB + ", Strikeouts: " + this.SO + ", Intentional Walks: " + this.IBB +
                ", Hit By Pitch: " + this.HBP + ", Sacrifice Hits: " + this.SH + ", Sacrifice Flies: " + this.SF + ", GIDP: " + this.GIDP +
                ", Player ID: " + this.playerID + ", Master ID: " + this.masterID;

         */
        return "Player: " + this.nameGiven + ", Year: " + this.yearID + ", Team:" + this.teamID + ", Hits: " + this.H + " /// ";
    }

    public boolean equals(BaseballBatter compareBatter){
        if (this == compareBatter) return true;

        if (compareBatter == null || getClass() != compareBatter.getClass()) return false;

        BaseballBatter player = (BaseballBatter) compareBatter;
        // Now check if they are equal on every single attribute level
        return playerID.equals(player.playerID) &&
                yearID.equals(player.yearID) &&
                stint == player.stint &&
                teamID.equals(player.teamID) &&
                lgID.equals(player.lgID) &&
                G == player.G &&
                AB == player.AB &&
                R == player.R &&
                H == player.H &&
                Doubles == player.Doubles &&
                Triples == player.Triples &&
                HomeRuns == player.HomeRuns &&
                RBI == player.RBI &&
                SB == player.SB &&
                CS == player.CS &&
                BB == player.BB &&
                SO == player.SO &&
                IBB == player.IBB &&
                HBP == player.HBP &&
                SH == player.SH &&
                SF == player.SF &&
                GIDP == player.GIDP &&
                nameGiven.equals(player.nameGiven) &&
                masterID.equals(player.masterID);
    }

    // Implement the compareTo method, but compareTo based on what? make H for now with playerID as tie breaker
    public int compareTo(BaseballBatter otherBatter){

        if (this.H != otherBatter.H){
            return Integer.compare(this.H, otherBatter.H);
        }
        // Initially compare by Hits number and if not compare by masterID
        return this.masterID.compareTo(otherBatter.masterID);
    }
}
