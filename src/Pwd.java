import java.io.*;

public class Pwd {

    public static void main(String[] args) throws IOException{
        String fname = "mypwd.txt";
        try(
                InputStream pwdStream = Pwd.class.getResourceAsStream("/password.txt");
                BufferedReader passwordReader = new BufferedReader(new InputStreamReader(pwdStream));
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                ) {
                    String pwd = passwordReader.readLine();
                    while (true){
                        System.out.println("Enter password or 'q'");
                        String temp = consoleReader.readLine();
                        if(temp.equals("q")){
                            break;
                        }
                try(
                        BufferedWriter tempWriter = new BufferedWriter(new FileWriter(fname,false));
                        BufferedReader tempReader = new BufferedReader(new FileReader(fname));
                        ){
                    tempWriter.write(temp + "\n");
                    tempWriter.close();
                    temp = tempReader.readLine();
                    tempReader.close();
                    if(pwd.equals(temp)){
                        System.out.println("OK!");
                        break;
                    }
                }
            }
        }
    }
}
