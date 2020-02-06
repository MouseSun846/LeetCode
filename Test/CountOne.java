import org.junit.Test;

public class CountOne {
    double PowerWithUnsignedExponent(double base,int exponent){
    if (exponent == 0)
        return 1;
    if (exponent == 1)
        return base;

        double result = PowerWithUnsignedExponent(base,exponent>>1);
        result *= result;
        if ((exponent&1)==1){
            result *= base;
        }
        return result;
    }

    @Test
    public void testCountOne(){
        double res = PowerWithUnsignedExponent(2,-5);
        System.out.println("res = "+res);
    }
}
