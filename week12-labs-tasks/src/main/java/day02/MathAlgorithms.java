package day02;

public class MathAlgorithms {
    public int lnko(int a, int b){
        int greater=a;
        int smaller=b;
        if(b>a){
            greater=b;
            smaller=a;
        }
        int temp;
        while(smaller!=0){
            temp=smaller;
            smaller=(greater-(greater/smaller)*smaller);
            greater=temp;
        }
        return greater;
    }

    public static void main(String[] args) {
        MathAlgorithms mathAlgorithms= new MathAlgorithms();
        int a=100;
        int b=80;
        System.out.println("("+a+","+b+") => "+mathAlgorithms.lnko(a,b));

        a=100;
        b=75;
        System.out.println("("+a+","+b+") => "+mathAlgorithms.lnko(a,b));

        a=1230;
        b=1290;
        System.out.println("("+a+","+b+") => "+mathAlgorithms.lnko(a,b));

        a=2586;
        b=1293;
        System.out.println("("+a+","+b+") => "+mathAlgorithms.lnko(a,b));

    }
}
