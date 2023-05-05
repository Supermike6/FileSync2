public class Constants
{
    final static double roboSpeed = 4.3;
    final static double joystickMult = 0.8;
    
    public static class arm
    {
        final static int motor1Can = 40;
        final static int motor2Can = 41;

        public static class wrist
        {
            final static int wheelspeed = 2;
            final static double p = 2;
            final static double i = 2;
            final static double d = 2;
            final static double ff = 2;



            public static void printThing()
            {
                System.out.println("thing");
            }
        }
    }

    public class neumatics
    {
        final static int compressorCan = 30;
        final static int pistonVol = 31;
    }
    
}


