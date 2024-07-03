
public class SimpleTesting {

    private static final String PASS = "Successful";
    private static final String FAIL = "Failed";
    private static final String NON_EXISTENT = "Minas Tirinth";
    public static void main(String[] args) {
        // Create a small train line and add a few stations to it with names
        // drawn from a String[]
        TrainLine redLineSB = new TrainLine();
        String[] stationNames = { "Howard", "Jarvis", "Morse",
                "Loyola", "Granville", "Thorndale" };
        for (String name : stationNames) {
            redLineSB.addStation(name);
        }
        // Test sequence
        boolean sequence = true;
        for (int i = 0; i < stationNames.length; i++) {
            sequence = sequence && (redLineSB.indexOf(stationNames[i]) == i);
        }
        System.out.printf("\n\nSequence test: %s", (sequence ? PASS : FAIL));
        // Test non existent
        boolean nonExisting = (redLineSB.indexOf(NON_EXISTENT) == -1);
        System.out.printf("\n\nSequence test: %s", (nonExisting ? PASS : FAIL));

        TrainLine nextLine = new TrainLine();
        String[] nextStationNames = { "Bryn Mawr", "Argyle", "Wilson"};
        for (String name : nextStationNames) {
            nextLine.addStation(name);
        }

        redLineSB.append(nextLine);

        String[] newStationNames = {"Howard", "Jarvis", "Morse", 
                                "Loyola", "Granville", "Thorndale",
                                "Bryn Mawr", "Argyle", "Wilson"};
        
        boolean appendSequence = true;
        for(int i = 0; i < newStationNames.length; i++) {
            appendSequence = (redLineSB.indexOf(newStationNames[i]) == i);
            i++;
        }
        System.out.printf("\n\nAppend sequence test: %s", (appendSequence ? PASS : FAIL));
        


    }
}
