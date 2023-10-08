import java.util.Scanner;
import java.security.SecureRandom;
public class PasswordGenerator 
{
        public static String generatePassword(int length,int complexity)
        {
             String lowerChars="abcdefghijklmnopqrstuvwxyz";
             String upperChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
             String numberChars="0123456789";
             String specialChars="!@#$%^&*()-_+=<>?";
             String allChars=lowerChars;

             if(complexity>=2)
             {
                allChars+=upperChars;
             }
             if(complexity>=3)
             {
                allChars+=numberChars+upperChars+specialChars;
             }
             SecureRandom random=new SecureRandom();
             StringBuilder password=new StringBuilder(length);

             for(int i=0;i<length;i++)
             {
               int randomIndex=random.nextInt(allChars.length());
               password.append(allChars.charAt(randomIndex));
             }
             return password.toString();

        }
        public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the password length");
        int length=sc.nextInt();
        System.out.println("Enter the complexity for password(1 for simple,2 for medium,3 for strong)");
        int complexity=sc.nextInt();

        String password=generatePassword(length,complexity);
        System.out.println("Generated Password is:"+password);
    }
    
}
