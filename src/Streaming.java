import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/** This class was built to read the input of the program and write its result,
 *  both in .txt files.
 */
public class Streaming {

    /**
     * Constructor
     */
    public Streaming(){
    }

    /** This method reads the input.txt file and save the informations so
     * they can be used by the encrypter or decrypter.
     * @return a HashMap with the option(key) and the message(value).
     */
    public Map<String, String> read() {
        Map<String,String> input = new HashMap<String,String>();
        String[] linhas = new String[100];
        int numLinhas = 0;
        Path filePath = Paths.get("public/input.txt");

        //reading
        try (BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                linhas[numLinhas] = line;
                numLinhas++;
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: input.txt", e);
        }

        //validating the number of lines
        if(numLinhas > 2){
            System.err.format("Não é possível ler mais que 1 mensagem e opção por vez ");
        } else if(numLinhas < 2){
                System.err.format("Você deve incluir tanto a mensagem quanto a opção no arquivo, em linhas separadas !");
               } else{
                    String msg = linhas[0];
                    String option = linhas[1];
                    if(option.equals("0")||option.equals("1")){
                        input.put(option,msg);
                    }else{
                        System.err.format("Uma opção inválida foi inserida!");
                    }
                }
        return input;
    }

    /** This method saves the result of the encryption or decryption in a .txt file
     * @param msg, with the result of the encryption or decryption
     */
    public void write(String msg){
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("public/result.txt"));
            buffWrite.append(msg);
            buffWrite.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

