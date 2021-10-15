import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class FileHandle {
	public static void main(String[] args) throws IOException 
	{  
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src/a.txt"));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src/b.txt"));
        
        PrintWriter printWriter = new PrintWriter("src/c.txt");
     
        String line1 = bufferedReader1.readLine();
        String line2 = bufferedReader2.readLine();
        while (line1 != null || line2 !=null)
        {
            if(line1 != null)
            {
                printWriter.println(line1);
                line1 = bufferedReader1.readLine();
            }
              
            if(line2 != null)
            {
                printWriter.println(line2);
                line2 = bufferedReader2.readLine();
            }
        }

        printWriter.flush();
        bufferedReader1.close();
        bufferedReader2.close();    
        System.out.println("Merging done... Lines from a.txt and b.txt have been copied alternatively to c.txt file. ");
    }
}