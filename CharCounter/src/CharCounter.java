public class CharCounter {

    /*
    Project: Letter Distribution
    Partner: Timothy J. Djang (but we made separate programs so oops)
    My Name: Emeline Sears
    Other Notes: Princeton Standard Library is used
    */

    public static void main(String[] args) {

        //String test = "this is a test."; // t3 h1 i2 s3 a1 e1
        //printTable(countChars(test));

        In file = new In("speed.txt");
        String test2 = file.readAll(); //reads the whole file and puts it into a string

        //counts characters in test text and prints out a count of each letter
        printTable(countChars(test2)); //in a table
        printGraph(countChars(test2)); //in a graph
    }

    public static int[] countChars(String text) //counts the characters in a string
    {
        int[] alphabet = new int[26]; //stores count of each character
        text = text.toLowerCase();
        for(int i = 0; i < text.length(); i++) //traverses every character in the string
        {
            if(Character.isLetter(text.charAt(i))) //if the character is a letter at the current position
            {
                //+1 to the corresponding place in the array
                //(alphabet[Character.getNumericValue(text.charAt(i)) - 10]++, if it was an a alphabet[10-10]++)
                alphabet[Character.getNumericValue(text.charAt(i)) - 10]++;
            }
        }
        return alphabet;
    }

    public static void printTable(int[] data) //prints array in nice "A: ##" format
    {
        for(int i = 0; i < data.length; i++)
        {
            StdOut.println(((char)(i+65)) + ": " + data[i]);
        }
    }

    public static void printGraph(int[] data) //prints a graph of data collected
    {
        int highest = 0;
        for(int i = 0; i < data.length; i++)
        {
            if(highest < data[i])
            {
                highest = data[i];
            }
        }
        StdDraw.setXscale(0.0, 31.0);
        StdDraw.setYscale(0.0, highest+4);

        StdDraw.setPenRadius(0.05);
        StdDraw.filledRectangle(14.5, 1.0, 13.5, 0.5); //x-axis line
        StdDraw.filledRectangle(1.0, (highest+2.0)/2, 0.5, (highest+1.0)/2); //y-axis line
        StdDraw.text(29.0, 1.0, "X"); //x-axis label
        StdDraw.text(1.0, highest+2.5, "Y"); //y-axis label

        StdDraw.setPenRadius(0.01);
        for(int i = 0; i < (highest+1); i++) {
            StdDraw.line(1.0, i+1.5, 0.2, i+1.5); //y-axis unit markers
        }
        for(int i = 0; i < 27; i++) {
            StdDraw.line(i+1.5, 1.0, i+1.5, 0.2); //x-axis unit markers
        }

        for(int i = 0; i < data.length; i++)
        {
            StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
            StdDraw.filledRectangle(i+2.0, (data[i]+3.0)/2, 0.25, (data[i]+0.0)/2);
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
            StdDraw.text(i+2.0, data[i]+2.0, ("" + data[i])); //number of a letter
            StdDraw.text(i+2.0, data[i]+3.0, ("" + (char)(i+65))); //which letter
        }
    }

}
