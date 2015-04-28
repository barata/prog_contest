/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10074 JAVA "" */

import java.io.IOException;
import java.util.StringTokenizer;

class Main  {

       static int[] array;

       public static void main(String[] args) {

               String line = ReadLn(255);
               while(!line.startsWith("0 0")) {

                       StringTokenizer stk = new StringTokenizer(line);
                       int M = Integer.parseInt(stk.nextToken());
                       int N = Integer.parseInt(stk.nextToken());
                       array = new int[N];
                       int result = 0;

                       for (int i = 0; i < M; i++) {
                               stk = new StringTokenizer(ReadLn(255));

                               for (int j = 0; j < N; j++) {
                                       int num = Integer.parseInt(stk.nextToken());
                                       if(num == 1) array[j] = 0;
                                       else array[j]++;
                               }

                               for (int k = 0; k < N; k++) {
                                       int largura = 0;
                                       int min = Integer.MAX_VALUE;
                                       for (int j = k; j >= 0; j--) {
                                               if(array[j]==0) break;
                                               largura++;
                                               if(array[j] < min) min = array[j];
                                               if(result<(largura*min)) result=largura *min;

                                       }

                               }

                       }
                       System.out.println(result);
                       line= ReadLn(255);
               }

       }

       static String ReadLn (int maxLg)  // utility function to read from stdin
               {
                       byte lin[] = new byte [maxLg];
                       int lg = 0, car = -1;
                       String line = "";

                       try
                       {
                               while (lg < maxLg)
                               {
                                       car = System.in.read();
                                       if ((car < 0) || (car == '\n')) break;
                                       lin [lg++] += car;
                               }
                       }
                       catch (IOException e)
                       {
                               return (null);
                       }

                       if ((car < 0) && (lg == 0)) return (null);  // eof
                       return (new String (lin, 0, lg)).trim();
               }

}
/* @END_OF_SOURCE_CODE */