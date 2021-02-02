import java.util.Map;

/** This class runs the program, it uses the message and option from the streamming class and runs the
 * corresponding option in the program.
 */
public class Main {

    public static void main(String args[]){
        Streaming streaming = new Streaming();
        Encrypter encrypter = new Encrypter();
        Decrypter decrypter = new Decrypter();

        //using HashMap information to run the program
        Map input = streaming.read();
        if(input.containsKey("0")){
            String msg = (String) input.get("0");
            streaming.write(encrypter.run(msg));
        }
        if(input.containsKey("1")){
            String msg = (String) input.get("1");
            streaming.write(decrypter.run(msg));
        }
    }
}
