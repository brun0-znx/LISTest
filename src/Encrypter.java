public class Encrypter {
    /**
     * Constructor
     */
    public Encrypter(){
    }
    /** This method runs the encrypter, it receives a string and formats it, then add all its characters
     * to the matrix that has enough size to receive that number of characters. After this, the method get
     * the characters in the right order to build the encrypted string.
     * @param msg, with the string that was in the input file.
     * @return an encrypted string, it will be used by the streaming class.
     */
    public String run(String msg){
        double msgLength, matrixSize, rowNumber, columnNumber, decimal;
        String result = "";
        int verifyMatrix;

        //formatting the string - deleting all spaces and special characters
        msg = msg.replaceAll("[!@#$%^&*()\',.?\":{}|<>]","");
        msg = msg.replaceAll("\\s","");

        //calculates the matrix size
        msgLength = msg.length();
        matrixSize = Math.sqrt(msgLength);

        //verifying matrix size if the decimal part is bigger than 5, if its true it will add 1 more row
        verifyMatrix = (int)matrixSize;
        decimal = matrixSize - verifyMatrix;
        decimal = decimal*10;
        if(decimal>5.00){
            rowNumber = Math.floor(matrixSize) +1;
        } else{
            rowNumber = Math.floor(matrixSize);
        }
        columnNumber = Math.ceil(matrixSize);
        char[][] matrix = new char[(int)rowNumber][(int)columnNumber];

        //adding all String characters to the matrix
        int cont = 0;
        for(int i=0; i<rowNumber; i++){
            for(int j=0; j<columnNumber; j++){
                if(cont<msgLength)
                {
                    matrix[i][j] = msg.charAt(cont);
                    cont++;
                }
                else{
                    matrix[i][j] = '#';
                }
            }
        }

        //getting all matrix characters to the encrypted string
        for(int i=0; i<columnNumber; i++){
            for(int j=0; j<rowNumber; j++){
                    result = result + matrix[j][i];
            }
            result = result + " ";
        }
        result = result.replaceAll("#","");
        return result;
    }
}
