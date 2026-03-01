// Student ID: 64230065
// Name Surname:İsra Kılıç
import java.util.Scanner;
public class CaesarCipher {
   
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
     System.out.println("Enter 1 to encrypt, 2 to decrypt the message:");
      int TaskType=input.nextInt();
      
      input.nextLine();
      
      System.out.println("Enter the message:");
      String message=input.nextLine();
      
      System.out.println("Enter the key:");
      int key=input.nextInt();
      
      if(validateInput(TaskType,message,key)){
          if(TaskType==1){
              String result=encrypt(message,key);
              System.out.println("Encrypted Message: "+result);
           }else{
              String result=decrypt(message,key);
              System.out.println("Decrypted Message: "+result);
          }
      }
      
    }

    /*
        This method should check the user inputs according to 
        the rules mentioned in the homework.
    */
    public static boolean validateInput(int taskType, String message, int key){
       if(taskType!=1&&taskType!=2){
           System.out.print("Task Type is invalid!");
           return false;
       }
       if(key<=0){
           System.out.print("Key is invalid!");
        return false;
       }
       return true; 
    }

    /*
        This method should return the encrypted message 
        according to the key and the cipher mentioned in the homework.
    */
    
    public static String encrypt(String message, int key){
        String cipher="";
        for(int i=0;i<message.length();i++){
           char next=message.charAt(i);
            
         next= shiftChar(next, key);
          cipher=cipher+next;
        }
        return cipher;
    }

    /*
        This method should return the decrypted message 
        according to the key and the cipher mentioned in the homework.
    */
    public static String decrypt(String message, int key){
        String word="";
       for(int i=0;i<message.length();i++){
           char next=message.charAt(i);
           
          next= shiftChar(next,-key);
           word=word+next;
       } 
        return word;
    }

    /*
        This method should shift the char a according to the x value 
        and return the new character.
        If x >= 0, ch should be shifted left to right
        i.e., ch: A, x: 2, shiftedCh: C
        If x < 0, ch should be shifted right to left 
        i.e., ch: E, x: -1, shiftedCh: D
        Check the homework document for the allowed range for characters.
    */
    public static char shiftChar(char ch, int x){
      if(!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) ){ //tried a simple check for spaces or numbers
        return ch;
        }
       
      x=x%26;    
     char shift=(char) (ch+x);
     
     if(ch>='A'&&ch<='Z'){
         if(shift>'Z'){
             shift=(char)(shift-26);
             
         }else if(shift<'A'){
             shift=(char) (shift+26);
         }
     }else if(ch>='a'&&ch<='z'){
         if(shift>'z'){
             shift=(char)(shift-26);
             
         }else if(shift<'a'){
           shift=(char)(shift+26);  
         }
         
     }
     return shift;
         
     
    
    }
    
}
