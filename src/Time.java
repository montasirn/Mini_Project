import java.text.DecimalFormat;

/**
 * Represents a moment in Time
 * Decimal format so that all times are padded with left zeros: 9:5:10 -> 09:05:10
 */
public class Time {
    private String hours;
    private String minutes;
    private String seconds;
    private String time;
    private final DecimalFormat df = new DecimalFormat("00");


    /**
     * Gets the hours in the Time object
     * @return a two digit string of the hours variable
     */
    private String getHours() {
        return hours;
    }

    /**
     * Gets the seconds in the Time object
     * @return a two digit string of the seconds variable
     */
    private String getSeconds() {
        return seconds;
    }

    /**
     * Gets the minutes in the Time object
     * @return a two digit string of the minutes variable
     */
    private String getMinutes() {
        return minutes;
    }

    /**
     * Creates a Time object with h hours, m minutes, and s seconds
     * @param h an integer that is formatted to be the hours of the object
     * @param m an integer that is formatted to be the minutes of the object
     * @param s an integer that is formatted to be the seconds of the object
     */
    public Time(int h, int m, int s){
        hours = (df.format(h));
        minutes = (df.format(m));
        seconds = (df.format(s));

        time = hours + ":" + minutes + ":" + seconds;
    }

    /**
     * increments seconds by one, if seconds reaches the threshold of 60, minutes is incremented then seconds is set to 00
     * if minutes reaches the threshold of 60, hours is incremented and minutes is set to 00
     * if hours reaches the threshold of 24, hours set to 00
     * sets time to the formatted version of hours, minutes, and seconds
     */
    public void tick(){
        seconds = Integer.parseInt(seconds) + 1 + "";
        seconds = df.format(Integer.valueOf(seconds));
        if (seconds.equals("60")){
            seconds = "00";
            minutes = Integer.parseInt(minutes) + 1 + "";
            minutes = df.format(Integer.valueOf(minutes));
            if (minutes.equals("60")){
                minutes = "00";
                hours = Integer.parseInt(hours) + 1 + "";
                hours = df.format(Integer.valueOf(hours));
                if (hours.equals("24")){
                    hours = "00";
                }
            }
        }
        time = hours + ":" + minutes + ":" + seconds;
    }

    /**
     * Returns time as a string
     * @return time as a string ##:##:##
     */
    public String toString(){
        return time;
    }

    /**
     * Adds the time of another Time object to another Time object
     * if seconds is over the threshold of 60, add the remainder of seconds/60 to minutes and
     * decrement seconds by 60 until seconds is less than 60.
     * if minutes is over the threshold of 60, add the remainder of minutes/60 to hours and
     * decrement minutes by 60 until minutes is less than 60.
     * if hours is over the threshold of 24, decrement hours by 24 until less than 24
     * set Time to formatted values of updated hours, minutes, and seconds variables
     * @param n another Time object
     */
    public void add(Time n) {
        seconds = Integer.parseInt(seconds) + Integer.parseInt(n.getSeconds()) + "";
        if (Integer.parseInt(seconds) >= 60){
            minutes = (Integer.parseInt(seconds) / 60) + Integer.parseInt(minutes) + "";
            while (Integer.parseInt(seconds) >= 60){
                seconds = Integer.parseInt(seconds) - 60 + "";
            }
        }
        minutes = Integer.parseInt(minutes) + Integer.parseInt(n.getMinutes()) + "";
        if (Integer.parseInt(minutes) >= 60){
            hours = (Integer.parseInt(minutes) / 60) + Integer.parseInt(hours) + "";
            while (Integer.parseInt(minutes) >= 60){
                minutes = Integer.parseInt(minutes) - 60 + "";
            }
        }
        hours = Integer.parseInt(hours) + Integer.parseInt(n.getHours()) + "";
        if (Integer.parseInt(hours) >= 24){
            hours = (Integer.parseInt(minutes) / 60) + Integer.parseInt(hours) + "";
            while (Integer.parseInt(hours) >= 24){
                hours = Integer.parseInt(hours) - 24 + "";
            }
        }
        seconds = df.format(Integer.parseInt(seconds));
        minutes = df.format(Integer.parseInt(minutes));
        hours = df.format(Integer.parseInt(hours));

        time = hours + ":" + minutes + ":" + seconds;
    }
}
