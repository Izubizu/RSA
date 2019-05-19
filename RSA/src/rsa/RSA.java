/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author IZA
 */

import java.util.*;
import java.math.*;
 
class RSA {
    
    public static void main(String args[]) {
        
        Scanner sc=new Scanner(System.in);
        int p,q,n,fi,d=0,e,i;
        System.out.println("Szám: ");
        int msg=sc.nextInt();
        double c;
        BigInteger msgback; 
        System.out.println("Első primszám (p):");
        p=sc.nextInt();
        System.out.println("Második primszám (q):");
        q=sc.nextInt();
 
        n=p*q;
        fi=(p-1)*(q-1);
        System.out.println("fi értéke = "+fi); 
 
        for(e=2;e<fi;e++)
        {
            if(lnko(e,fi)==1)
            { 
                break;
            }
        }
        
        System.out.println("Nyilvános kulcs exponense = "+e); 
        for(i=0;i<=fi;i++)
        {
            int x=1+(i*fi);
            if(x%e==0)
            {
                d=x/e; 
                break;
            }
        }
        
        System.out.println("Titkos kulcs exponense = "+d); 
        c=(Math.pow(msg,e))%n;
        System.out.println("Titkositott üzenet : ");
        System.out.println(c);
                
        BigInteger N = BigInteger.valueOf(n);
     
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Feloldott üzenet : ");
        System.out.println(msgback);
 }
 
    static int lnko(int e, int z)
    {
    if(e==0)
    return z; 
    else
    return lnko(z%e,e);
    }
   }

