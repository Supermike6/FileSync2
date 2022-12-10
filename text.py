import random
import time
#Monsters
monster1 = " Beholder"
monster2 = " Troll"
#Intro
print("Have you ever played the wonderful table top role playing game known as dungeons and dragons? Well, this program enables you to simulate a randomized battle against a monster of your choosing.")
#Monster choice
monster_choice=input("Which monster do you wish to fight?\nYour choices are:\n1."+monster1+"\n2."+monster2+"\nType the number corresponding to your choice: ")
#Level choice
level_choice = int(input("Now that you have chosen to fight monster #"+monster_choice+" you can choose your level. Your stats will be randomized, and, since I am too lazy to code each dnd class, race, and subclass, you will be playing as a human fighter with the champion archetype. What level do you want to play as? (You can pick a number from 1 to 20): "))
print("Good level choice! While we will preditermine almost all of your class features (ability scores, fighting styles, etc.), your stats will be rolled.")
#Phisical space of the encounter(ft)
player_location=100
monster_location=1
# def boundry_check(location,x):
#   if player_location==10 or player_location==20 or player_location==30 or player_location==40 or player_location==50 or player_location==60 or player_location==70 or player_location==80 or player_location==90 or
#Stat randomization
#Strenth
x=0
stats=[]
sum=0
for i in range (4):
  x=random.randint(1,6)
  stats.append(x)
  sum=sum+x
smallest=min(stats)
strength = sum-smallest
if strength==1:
  str_Modifier =-5
if strength>1 and strength<4:
  str_Modifier =-4
if strength>3 and strength<6:
  str_Modifier =-3
if strength>5 and strength<8:
  str_Modifier =-2
if strength>7 and strength<10:
  str_Modifier =-1
if strength>9 and strength<12:
  str_Modifier =0
if strength>11 and strength<14:
  str_Modifier =1
if strength>13 and strength<16:
  str_Modifier =2
if strength>15 and strength<18:
  str_Modifier =3
if strength>17 and strength<20:
  str_Modifier =4
if strength>19 and strength<22:
  str_Modifier =5
if strength>21 and strength<24:
  str_Modifier =6
#Dexterity
x=0
stats=[]
sum=0
for i in range (4):
  x=random.randint(1,6)
  stats.append(x)
  sum=sum+x
smallest=min(stats)
dex =sum-smallest
if dex==1:
  dex_Modifier =-5
if strength>1 and dex<4:
  dex_Modifier =-4
if dex>3 and dex<6:
  dex_Modifier =-3
if dex>5 and dex<8:
  dex_Modifier =-2
if dex>7 and dex<10:
  dex_Modifier =-1
if dex>9 and dex<12:
  dex_Modifier =0
if dex>11 and dex<14:
  dex_Modifier =1
if dex>13 and dex<16:
  dex_Modifier =2
if dex>15 and dex<18:
  dex_Modifier =3
if dex>17 and dex<20:
  dex_Modifier =4
if dex>19 and dex<22:
  dex_Modifier =5
if dex>21 and dex<24:
  dex_Modifier =6
#Constitution
x=0
stats=[]
sum=0
for i in range (4):
  x=random.randint(1,6)
  stats.append(x)
  sum=sum+x
smallest=min(stats)
con =sum-smallest
if con==1:
  con_Modifier =-5
if con>1 and con<4:
  con_Modifier =-4
if con>3 and con<6:
  con_Modifier =-3
if con>5 and con<8:
  con_Modifier =-2
if con>7 and con<10:
  con_Modifier =-1
if con>9 and con<12:
  con_Modifier =0
if con>11 and con<14:
  con_Modifier =1
if con>13 and con<16:
  con_Modifier =2
if con>15 and con<18:
  con_Modifier =3
if con>17 and con<20:
  con_Modifier =4
if con>19 and con<22:
  con_Modifier =5
if con>21 and con<24:
  con_Modifier =6
#Inteligence
x=0
stats=[]
sum=0
for i in range (4):
  x=random.randint(1,6)
  stats.append(x)
  sum=sum+x
smallest=min(stats)
int =sum-smallest
if int==1:
  int_Modifier =-5
if int>1 and int<4:
  int_Modifier =-4
if int>3 and int<6:
  int_Modifier =-3
if int>5 and int<8:
  int_Modifier =-2
if int>7 and int<10:
  int_Modifier =-1
if int>9 and int<12:
  int_Modifier =0
if int>11 and int<14:
  int_Modifier =1
if int>13 and int<16:
  int_Modifier =2
if int>15 and int<18:
  int_Modifier =3
if int>17 and int<20:
  int_Modifier =4
if int>19 and int<22:
  int_Modifier =5
if int>21 and int<24:
  int_Modifier =6
#Wisdom
x=0
stats=[]
sum=0
for i in range (4):
  x=random.randint(1,6)
  stats.append(x)
  sum=sum+x
smallest=min(stats)
wis =sum-smallest
if wis==1:
  wis_Modifier =-5
if wis>1 and wis<4:
  wis_Modifier =-4
if wis>3 and wis<6:
  wis_Modifier =-3
if wis>5 and wis<8:
  wis_Modifier =-2
if wis>7 and wis<10:
  wis_Modifier =-1
if wis>9 and wis<12:
  wis_Modifier =0
if wis>11 and wis<14:
  wis_Modifier =1
if wis>13 and wis<16:
  wis_Modifier =2
if wis>15 and wis<18:
  wis_Modifier =3
if wis>17 and wis<20:
  wis_Modifier =4
if wis>19 and wis<22:
  wis_Modifier =5
if wis>21 and wis<24:
  wis_Modifier =6
#Charisma
x=0
stats=[]
sum=0
for i in range (4):
  x=random.randint(1,6)
  stats.append(x)
  sum=sum+x
smallest=min(stats)
chr =sum-smallest
if chr==1:
  chr_Modifier =-5
if chr>1 and chr<4:
  chr_Modifier =-4
if chr>3 and chr<6:
  chr_Modifier =-3
if chr>5 and chr<8:
  chr_Modifier =-2
if chr>7 and chr<10:
  chr_Modifier =-1
if chr>9 and chr<12:
  chr_Modifier =0
if chr>11 and chr<14:
  chr_Modifier =1
if chr>13 and chr<16:
  chr_Modifier =2
if chr>15 and chr<18:
  chr_Modifier =3
if chr>17 and chr<20:
  chr_Modifier =4
if chr>19 and chr<22:
  chr_Modifier =5
if chr>21 and chr<24:
  chr_Modifier =6
print("\nYour strength is "+str(strength)+" with a modifier of "+str(str_Modifier)+".\nYour dexterity is "+str(dex)+" with a modifier of "+str(dex_Modifier)+".\nYour constitution is "+str(con)+" with a modifier of "+str(con_Modifier)+".\nYour inteligence is "+str(int)+" with a modifier of "+str(int_Modifier)+".\nYour wisdom is "+str(wis)+" with a modifier of " +str(wis_Modifier))
#Health randomization
health=10+con_Modifier
if level_choice>=2:
  health=health+random.randint(1,10)
if level_choice>=3:
  health=health+random.randint(1,10)
if level_choice>=4:
  health=health+random.randint(1,10)
if level_choice>=5:
  health=health+random.randint(1,10)
if level_choice>=6:
  health=health+random.randint(1,10)
if level_choice>=7:
  health=health+random.randint(1,10)
if level_choice>=8:
  health=health+random.randint(1,10)
if level_choice>=9:
  health=health+random.randint(1,10)
if level_choice>=10:
  health=health+random.randint(1,10)
if level_choice>=11:
  health=health+random.randint(1,10)
if level_choice>=12:
  health=health+random.randint(1,10)
if level_choice>=13:
  health=health+random.randint(1,10)
if level_choice>=14:
  health=health+random.randint(1,10)
if level_choice>=15:
  health=health+random.randint(1,10)
if level_choice>=16:
  health=health+random.randint(1,10)
if level_choice>=17:
  health=health+random.randint(1,10)
if level_choice>=18:
  health=health+random.randint(1,10)
if level_choice>=19:
  health=health+random.randint(1,10)
if level_choice==20:
  health=health+random.randint(1,10)
print("You have a maximum of "+str(health)+" hitpoints.")
#If the enemy is a Beholder
if monster_choice=="1":
  monster_health=180
  monster_movement=20
  initiative_modifier=2

#The actual fight
print("Rolling player initiative...")
time.sleep(1)
player_roll=random.randint(1,20)
player_roll=player_roll+dex_Modifier
print("You rolled a "+str(player_roll)+".")
print("Rolling enemy initiative...")
time.sleep(1)
monster_roll=random.randint(1,20)
monster_roll=monster_roll+initiative_modifier
print("The monster rolled a "+str(monster_roll)+".")
if monster_roll>player_roll:
  first=0
  print("The monster goes first.")
if player_roll>monster_roll:
  first=1
  print("You go first.")
if player_roll==monster_roll:
  first=1
  print("You tied, but you get to go first because why not?")
#When the player starts
if first==1:
  end=False
  print()
  while end==False:
    if player_location+10==monster_location or monster_location+10==player_location or monster_location+1==player_location or player_location+1==monster_location:
      in_range=True
      print()
#Player's turn
    move_choice=input("What do you want to do? You can\n1. Move\n2.3. Attack the enemy\n4. Do nothing\nWhat do you choose?: ")
    #If the player chose to move
    if move_choice=="1":
      direction_choice=input("What direction do you want to move? Right (r), left (l), up (u), or down (d)?:")
      distance=input("How far do you want to go? You can only move up to 30 feet:")
      if int(distance)>30 or int(distance)<0:
        distance=0
      if direction_choice=="r" and player_location!=10 and player_location!=20 and player_location!=30 and player_location!=40 and player_location!=50 and player_location!=60 and player_location!=70 and player_location!=80 and player_location!=90 and player_location!=100:
        player_location
        
#       if direction_choice=="l":
#       if direction_choice=="u":
#       if direction_choice=="d":
# #When the monster starts
# if first==0:
#   while end==False:
#     print("") 