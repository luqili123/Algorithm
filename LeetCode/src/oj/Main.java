package oj;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int N=sc.nextInt();
//        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int N = 1;
        sc.nextLine();
        while (N-- > 0) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
//            String str1 = "1A2BD3G4H56JK";
//            String str2 = "23EFG4I5J6K7";
            twostring(str1, str2);
//            System.out.println(digitcount(str));
        }
    }

    public static void twostring(String str1,String str2){
        int[][] route=new int[str1.length()+1][str2.length()+1];
        ArrayList<String>[][] routes=new ArrayList[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++){
            for(int j=0;j<=str2.length();j++){
                routes[i][j]=new ArrayList<String>();
            }
        }
        List<String> result=new ArrayList<>();
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    route[i][j]=route[i-1][j-1]+1;
                    if(route[i-1][j-1]!=0){
                        for(int z=0;z<routes[i-1][j-1].size();z++){
                            routes[i][j].add(routes[i-1][j-1].get(z)+""+str1.charAt(i-1));
                        }
                    }else{
                        routes[i][j].add(str1.charAt(i-1)+"");
                    }
                    if(result.size()==0||result.get(0).length()==routes[i][j].get(0).length()){
                        result.addAll(routes[i][j]);
                    }else if(result.get(0).length()<routes[i][j].get(0).length()){
                        result.clear();
                        result.addAll(routes[i][j]);
                    }
                }else{
                    if(route[i-1][j]>route[i][j-1]){
                        route[i][j]=route[i-1][j];
                        routes[i][j]=routes[i-1][j];
                    }else if(route[i-1][j]<route[i][j-1]){
                        route[i][j]=route[i][j-1];
                        routes[i][j]=routes[i][j-1];
                    }else{
                        route[i][j]=route[i][j-1];
                        if(routes[i][j-1]!=routes[i-1][j]) {
                            routes[i][j].addAll(routes[i][j - 1]);
                            routes[i][j].addAll(routes[i - 1][j]);
                        }else{
                            routes[i][j].addAll(routes[i][j - 1]);
                        }
                    }
                }
            }
        }
        Collections.sort(result);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}