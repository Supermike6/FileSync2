const int SPEAKERPIN=6;
double IBms=1;
const int BPM=220;
const double eigthNote=1.0/2.0;
const double sixteenNote=1.0/4.0;
const double quarterNote=1.0;

void setup()
{ 
    
    row1();
    row2();
    row3();
    row4();
    row5();
    row6();
    row7();
    row8();
    

}

void loop()
{
  
}

void playNote(String note, int octave, double beats, double noteImbTimems)
{
  const int notes = 13;
  
  String noteKey[notes] = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B","Rest"};
  
  int notesheet[][notes] = {
    {16,  17,  18,  19,  21,  22,  23,  25,  26,  28,  29,  31},
    {33,  35,  37,  39,  41,  44,  46,  49,  52,  55,  58,  62},
    {65,  69,  73,  78,  82,  87,  93,  98,  104, 110, 117, 124},
    {131, 139, 147, 156, 165, 175, 185, 196, 208, 220, 233, 247},
    {262, 277, 294, 311, 330, 349, 370, 392, 415, 440, 466, 494},
    {523, 554, 587, 622, 659, 699, 740, 784, 831, 880, 932, 988},
    {1047,1109,1175,1245,1319,1397,1480,1568,1661,1760,1865,1976},
    {2093,2217,2349,2489,2637,2794,2960,3136,3322,3520,3729,3951},
    {4186,4435,4699,4978,5274,5588,5920,6272,6645,7040,7459,7902}
  };
    String wantedval = note;
    int wantedpos=0;
    for (int i=0; i<notes; i++) {
       	if (wantedval.equals(noteKey[i])) {
           	wantedpos = i;
        	break;
     	}
    }
    if(wantedpos==12)
    {
      delay(beats*60000/BPM-noteImbTimems);
      delay(noteImbTimems);
    } else {
      int noteFrequency = notesheet[octave][wantedpos];
      tone(SPEAKERPIN,noteFrequency);
      delay(beats*60000/BPM-noteImbTimems);
      noTone(SPEAKERPIN);
      delay(noteImbTimems);
    }

}

//make a method for each measure

void measure1()
{
    playNote("Rest",4,4.0,IBms);
}

void measure2()
{
    playNote("E", 2,3.0,IBms);
    playNote("E", 2,1.0,IBms);
}

void measure3()
{
    playNote("C", 1,4.0,IBms);
    
}   

void measure4()
{
    playNote("D", 2,4.0,IBms);
    
}

void measure5()
{
    playNote("A", 2,4.0,IBms);
}

void measure6()
{
    measure2();
}

void measure7()
{
    measure3();
}

void measure8()
{
    measure4();
}   

void measure9()
{
    measure5();
}   

void measure10()
{
    measure2();
}   

void measure11()
{
    measure3();
}   

void measure12()
{
    measure4();
}   

void measure13()
{
    measure5();
}   

void measure14()
{
    measure2();
}   

void measure15()
{
    measure3();
}

void measure16()
{
    measure4();
}

void measure17()
{
    playNote("A", 2,eigthNote*1.5,IBms);
    playNote("A", 2,sixteenNote,IBms);
    playNote("G", 2,quarterNote,IBms);
    playNote("F#",2,quarterNote,IBms);
    playNote("E",2,quarterNote,IBms);
    
}

void measure18()
{
    playNote("C", 1,3.0,IBms);
    playNote("C", 1,1.0,IBms);
}

void measure19()
{
    playNote("C", 1,4.0,IBms);
}

void measure20()
{
    playNote("D", 2,4.0,IBms);
}

void measure21()
{
    playNote("D", 2,4.0,IBms);
}
void measure22()
{
    playNote("E", 2,3.0,IBms);
    playNote("E", 2,1.0,IBms);
}

void measure23()
{
    playNote("E", 2,4.0,IBms);
}

void measure24()
{
    playNote("G", 2,4.0,IBms);
}

void measure25()
{
    playNote("G", 2,4.0,IBms);
}

void measure26()
{
    measure18();
}

void measure27()
{
    playNote("C", 1,4.0,IBms);
}

void measure28()
{
    playNote("C#", 1,4.0,IBms);
}

void measure29()
{
    measure28();

}

void measure30()
{
    playNote("D", 2,3.0,IBms);
    playNote("D", 2,1.0,IBms);
}

void measure31()
{
    playNote("D", 2,4.0,IBms);
}

void measure32()
{
    playNote("D", 2,eigthNote,IBms);
    playNote("Rest", 5,eigthNote,IBms);
    playNote("D", 2,eigthNote,IBms);
    playNote("Rest", 5,eigthNote,IBms);
    playNote("D", 2,eigthNote,IBms);
    playNote("Rest", 5,eigthNote,IBms);
    playNote("D", 2,eigthNote,IBms);
    playNote("Rest", 5,eigthNote,IBms);
}

void measure33()
{
    playNote("D#", 2,eigthNote,IBms);
    playNote("Rest", 5,eigthNote,IBms);
    playNote("Rest", 5,quarterNote,IBms);
    playNote("Rest", 5,2.0,IBms);
    
}

void row1()
{
    measure1();
    measure2();
    measure3();
    measure4();
    measure5();
}

void row2()
{
    measure6();
    measure7();
    measure8();
    measure9();
    measure10();
}

void row3()
{
    measure11();
    measure12();
    measure13();
    measure14();
    measure15();
}

void row4()
{
    measure16();
    measure17();
    measure18();
    measure19();
    measure20();
    measure21();
}

void row5()
{
	measure22();
    measure23();
    measure24();
    measure25();
    measure26();
}
void row6()
{
    measure27();
    measure28();
    measure29();
    measure30();
    measure31();
}

void row7()
{
    measure32();
    measure33();
}
void row8()
{
    measure2();
    measure3();
    measure4();
    measure5();
    row2();
    row3();
    row4();
    row5();
    row6();
    row7();
}
