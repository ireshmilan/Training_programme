import java.util.Scanner;
class Test{

public static void main (String arg[]){

Scanner sc = new Scanner(System.in);

int n,result=0;
System.out.println("Enter Numbers");
for(n=sc.nextInt();n!=0;){

result=result*10;
result=result+n%10;
n=n/10;

}
System.out.println(result);

}
}
