public class TimeTester {
    public static void main(String[] args) {
        Time time1 = new Time(8,9,58);
        System.out.println("EXPECTED RESULT: [08:09:58]");
        System.out.println(time1);
        time1.tick();
        System.out.println("EXPECTED RESULT: [08:09:59]");
        System.out.println(time1);
        time1.tick();
        System.out.println("EXPECTED RESULT: [08:10:00]");
        System.out.println(time1);
        time1.tick();
        System.out.println("EXPECTED RESULT: [08:10:01]");
        System.out.println(time1);
        time1.tick();
        System.out.println("EXPECTED RESULT: [08:10:02]");
        System.out.println(time1);
        time1.tick();
        time1.tick();
        time1.tick();
        time1.tick();
        time1.tick();
        time1.tick();
        time1.tick();
        time1.tick();
        System.out.println("EXPECTED RESULT: [08:10:10]");
        System.out.println(time1);

        Time time2 = new Time(15,59,58);
        System.out.println("EXPECTED RESULT: [15:59:58]");
        System.out.println(time2);
        time2.tick();
        System.out.println("EXPECTED RESULT: [15:59:59]");
        System.out.println(time2);
        time2.tick();
        System.out.println("EXPECTED RESULT: [16:00:00]");
        System.out.println(time2);
        time2.tick();
        System.out.println("EXPECTED RESULT: [16:00:01]");
        System.out.println(time2);

        Time time3 = new Time(23,59,59);
        System.out.println("EXPECTED RESULT: [23:59:59]");
        System.out.println(time3);
        time3.tick();
        System.out.println("EXPECTED RESULT: [00:00:00]");
        System.out.println(time3);
        time3.tick();
        System.out.println("EXPECTED RESULT: [00:00:01]");
        System.out.println(time3);

        Time time4 = new Time(10,14,43);
        System.out.println("EXPECTED RESULT: [10:14:43]");
        System.out.println(time4);
        Time time5 = new Time(8,30,29);
        System.out.println("EXPECTED RESULT: [08:30:29]");
        System.out.println(time5);
        time4.add(time5);
        System.out.println("EXPECTED RESULT: [18:45:12]");
        System.out.println(time4);
        System.out.println("EXPECTED RESULT: [08:30:29]");
        System.out.println(time5);

        Time time6 = new Time(7,20,0);
        System.out.println("EXPECTED RESULT: [07:20:00]");
        System.out.println(time6);
        time4.add(time6);
        System.out.println("EXPECTED RESULT: [02:05:12]");
        System.out.println(time4);
    }
}
