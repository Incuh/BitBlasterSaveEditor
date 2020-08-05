import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;

public class decoder {
    public decoder(){
        //Add stuff here
    }
    public static String get_save_path(){
        String OS = System.getProperty("os.name");
        if (OS.startsWith("Windows")) {
            return System.getProperty("user.home") + "\\AppData\\LocalLow\\Nickervision Studios\\Bit Blaster XL\\";
        }
        else{
            return "nosupport";
        }
    }

    public static byte[] get_file(String path){
        try {
            File save = new File(path + "dat01.bbxl");
            byte[] final_byte = Files.readAllBytes(save.toPath());
            return final_byte;
        }
        catch (Exception E){
            //Fuck U java
            return new byte[]{};
        }
    }

    public static int read_coins(byte[] bytes){
        return bytes[16];
    }

    public static void write_data(byte[] bytes) {
        try {
            File save = new File(get_save_path() + "dat01.bbxl");
            Files.write(save.toPath(), bytes);
        }
        catch (Exception E){
            System.out.println("bruh");
            E.printStackTrace();
        }
    }

    public static byte[] strnt_to_byte(String strnt){
        final int int_temp = Integer.parseInt(strnt);
        final BigInteger byteint = BigInteger.valueOf(int_temp);
        return byteint.toByteArray();
    }
}
