public class Decrypter {
    /**
     * Constructor
     */
    public Decrypter(){
    }
    /** This method runs the decrypter, it receives a string and separate it in a string vector using
     * spaces between words to split, checks the biggest word in the vector so can be used by stopping condition and then
     * goes through the vector getting the characters of the words in it, in order. I tryed to decrypt using the same idea
     * of the encrypting method, but I found some difficulties so I decided to do it in another way.
     * @param msg, with the string that was in the input file.
     * @return a decrypted string, it will be used by the streaming class.
     */
    public String run(String msg){
        String result = "";
        String[] vector = msg.split(" ");
        int biggest = 0;
        int cont = 0;

        //identify the biggest word in vector
        for (int i=0; i<vector.length; i++){
            if (vector[i].length() > biggest){
                biggest = vector[i].length();
            }
        }

        //looping to get the characters in order
        while (true) {
            for (int i = 0; i<vector.length; i++) {
                try {
                    result = result + vector[i].charAt(cont);
                } catch (Exception ArrayIndexOutOfBoundsException) {
                    result = result + "";
                }
            }
            cont++;

            //stop loop condition
            if (cont >= biggest) {
                break;
            }
        }
        return result;
    }
}

