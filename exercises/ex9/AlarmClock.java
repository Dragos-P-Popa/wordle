public class AlarmClock extends Clock {
    public int alarmHours, alarmMinutes;

    public AlarmClock(){
        Clock clock = new Clock();
    }

    public AlarmClock(int h, int m){
        Clock clock = new Clock(h,m);
    }

    public AlarmClock(int h, int m, int s){
        Clock clock = new Clock(h,m,s);
    }

    public int getAlarmHours(){
        return alarmHours;
    }

    public int getAlarmMinutes(){
        return alarmMinutes;
    }

    public void setAlarm(int h, int m){
        if (h <= 24){
            alarmHours = h;
        }
        else{
            throw new IllegalArgumentException("invalid alarm hours");
        }

        if (m <= 60){
            alarmMinutes = m;
        }
        else{
            throw new IllegalArgumentException("invalid alarm minutes");
        }
    }

    public boolean isRinging(){
        if (alarmHours == getHours() && alarmMinutes == getMinutes()){
            return true;
        }
        else{
            return false;
        }
    }

    public void display(){
        if (isRinging() && getSeconds() <= 15){
            System.out.println(toString() + " - WAKE UP!");
        }
        else {
            System.out.println(toString());
        }

    }
}