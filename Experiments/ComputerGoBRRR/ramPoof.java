package ComputerGoBRRR;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class ramPoof
{
    Timer timer;

    public ramPoof()
    {
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true)
                        {
                        }
                    }
                });
                thread.start();
            }
            });
         timer.start();
    }

    public static void main(String[] args)
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i = Integer.MIN_VALUE; i<Integer.MAX_VALUE; i++)
        {
            String s = "a";
            for (int j = 0; j < 25; j++) {
                s += (char)(Math.random() * 256);
                s += s;
            }
            System.out.println(i);
            arrayList.add(s);
        }
    }


}
