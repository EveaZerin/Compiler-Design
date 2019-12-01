import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Lab04{
  public static void main(String [] args) throws FileNotFoundException{
    
    File f = new File("C:\\Users\\evea_\\Desktop\\420\\lab4\\inputString.txt");
    
    Scanner sc=new Scanner(f);
    
    List<String> listOfString= new ArrayList<String>();    
    List<String> newListOfString= new ArrayList<String>();
    List<String> newTypes= new ArrayList<String>();
    
    String s;
    while(sc.hasNextLine()){
       s=sc.nextLine();
      
      if(s.length()>2){
        
        int x = s.indexOf('(');
        int end= s.indexOf(')');
        int indexEnd=-1;
        int indexBegin = -1;
        
        String makeString = "";
        
        if(x!=-1 && end!=-1){
        //  int typeIndexEnd=-1;
          for(int i=x;i>=0; i--){
            
            if(s.charAt(i) != ' '){
              if(s.charAt(i) != '.'){
                makeString = Character.toString(s.charAt(i)) + makeString;
              //  typeIndexEnd=i-2;
              }else{
                break;
              }
            }else{
              break;
            }
            
          }
          
       /*   int typeIndexStart=-1;
          for(int i=typeIndexEnd; i>=0; i--){
            if(s.charAt(i)==' '){
              typeIndexStart=i+1;
              break;
            }
          }*/
         // listOfString.add(makeString);
          for(int i=x+1;i<=end; i++){
                makeString =  makeString+ Character.toString(s.charAt(i));
              
          }
          
//          String type = s.substring(typeIndexStart, typeIndexEnd);
//          newTypes.add(type);
          
          
          
          
          
          if(makeString.startsWith("print") || makeString.startsWith("main")){
            
          }else{
            listOfString.add(makeString);
            
            
            
            indexEnd=s.indexOf(makeString);
          
          for(int z=indexEnd-2; z>=0;z--){
            if(s.charAt(z)==' '){
              break;
            }else{
              indexBegin=z;
            }
          }
          
          String type = s.substring(indexBegin, indexEnd);
          newTypes.add(type);
            
          }
          
          
          
        }
        
      }else{
        
      }
      
       
      
    }
    
    sc.close();
    //System.out.println(listOfString);
    for(int c=0; c<listOfString.size(); c++){
      String hold= listOfString.get(c);    
        newListOfString.add(hold);   
    }
    
//    System.out.println(newListOfString);
//    System.out.println(newTypes);
    
    System.out.println("Methods:");
    for(int i=0;i<newListOfString.size(); i++){
      
      System.out.println(newListOfString.get(i)+", return type : "+newTypes.get(i));
    }
    
  }
}