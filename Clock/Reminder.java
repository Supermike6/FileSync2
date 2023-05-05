package Clock;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.text.DateFormatter;

public class Reminder
{
    public String start;
    public String desc;
    public String end;

    public Reminder(String start, String desc, String end) {
        this.start = start;
        this.desc = desc;
        this.end = end;
    }

    
    @Override
    public String toString() {
        return "{" +
            " start='" + getStart() + "'" +
            ", desc='" + getDesc() + "'" +
            ", end='" + getEnd() + "'" +
            "}";
    }


    public String getStart() {
        return start;
    }


    public void setStart(String start) {
        this.start = start;
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getEnd() {
        return end;
    }


    public void setEnd(String end) {
        this.end = end;
    }

    public static Reminder getCurrent(ArrayList<Reminder> rems)
    {
        LocalTime lt = LocalDateTime.now(ZoneId.systemDefault()).toLocalTime();
        for(Reminder rem : rems)
        {
            if(!lt.isAfter(LocalTime.parse(toLocalTimeFormat(rem.end))))
                return rem;
        }
        return new Reminder("000000", "", "000000");
    }

    public static String toLocalTimeFormat(String s)
    {
        String out = "";
        out+=s.substring(0,2)+":"+s.substring(2,4)+":"+s.substring(4,6)+".000000";
        return out;
    }
    public static void main(String[] args)
    {

    }
}
