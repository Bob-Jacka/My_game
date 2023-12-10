package ru.kirill.games;

import Dictionary.Levels;
import Heroes.Hero;
import Items.Armor.ClothArmor;
import Items.Armor.IronArmor;
import Items.Armor.LeatherArmor;
import Items.Weapons.MeleeCombatWeapon.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static ru.kirill.games.GameEngine.*;

class FileSystem {

    /**
     * This method save game and hero data
     *
     * @returns Save file
     * @since 0.0.2
     */
    static void do_Save() {

        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(Player.get_SaveFile()));
            Player.get_SaveFile().setWritable(true);
            ////Parameters to save
            bf.write(Player.get_Person().getName());  //0
            bf.write(' ');

            bf.write(String.valueOf(Player.get_Person().getHealth()));  ///1
            bf.write(' ');

            bf.write(String.valueOf(Player.get_Person().getArmor())); //2
            bf.write(' ');

            bf.write(String.valueOf(Player.get_Person().getAttack()));  //3
            bf.write(' ');

            if (Player.get_Person().getMagic()) {     ///save magic boolean  //4
                bf.write(String.valueOf(true));
                bf.write(' ');
            } else if (Player.get_Person().getMagic() == false) {
                bf.write(String.valueOf(false));
                bf.write(' ');
            }
            bf.write(String.valueOf(Player.get_Person().getResistance()));  //5
            bf.write(' ');

            bf.write(String.valueOf(Player.get_Person().getMana()));  //6
            bf.write(' ');

            bf.write(String.valueOf(Player.get_Person().getExperience()));  //7
            bf.write(' ');

            bf.write(String.valueOf(Levels.decode(String.valueOf(Player.get_Person().getClass()).substring(13))));

            if (Player.get_Person().getActiveQuest() == null) {   ///Active quest save
                bf.newLine();
                bf.write("null");
            } else if (Player.get_Person().getActiveQuest() != null) {
                bf.newLine();
                bf.write(Player.get_Person().getActiveQuest());
            }

            if (Player.get_Person().getQuestListSimple().isEmpty()) {  ///Quest list save
                bf.newLine();
                bf.write("null");
            } else if (Player.get_Person().getQuestListSimple().size() != 0) {
                String QuestList = String.valueOf(Player.get_Person().getQuestListSimple());
                bf.newLine();
                bf.write(QuestList.substring(1, QuestList.length() - 1));
            }

            if (Player.get_Person().getActiveArmor().isEmpty()) {  ///ARMOR
                bf.newLine();
                bf.write("null");
            } else {
                bf.newLine();
                bf.write(Player.get_Person().getActiveArmor().get(0).getItemName());
                bf.write(' ');
                bf.write(((String.valueOf(Player.get_Person().getActiveArmor().get(0).getArmorDef()))));
                bf.write(' ');
                bf.write(((String.valueOf(Player.get_Person().getActiveArmor().get(0).getTypeOfArmor()))));
            }

            if (Player.get_Person().getActiveWeapon().isEmpty()) {  ///WEAPON
                bf.newLine();
                bf.write("null");
            } else {
                bf.newLine();
                bf.write(Player.get_Person().getActiveWeapon().get(0).getItemName());
                bf.write(' ');
                bf.write((String.valueOf(Player.get_Person().getActiveWeapon().get(0).getAttack())));
                bf.write(' ');
                bf.write(((String.valueOf(Player.get_Person().getActiveWeapon().get(0).getTypeOfWeapon()))));
            }
            bf.newLine();
            bf.write(String.valueOf(Player.get_IsAutoSave()));  //запись параметра автосохранения

            bf.newLine();
            bf.write(String.valueOf(MapWidth));

            bf.newLine();
            bf.write(String.valueOf(Player.get_SaveFile()).substring(SaveFile.getSaveDirectoryLength()));  //Save file path

            /////COORDINATES
            bf.newLine();
            bf.write(String.valueOf(Player.get_HeroLocation())); // Hero coordinates
            /////COORDINATES

            ///Map
            for (int i = 0; i < MAP.size() - 1; i++) {
                bf.newLine();
                String stringMap = Arrays.toString(MAP.get(i));
                bf.write(stringMap.substring(1, stringMap.length() - 1));
            }
            bf.close();   ////close file stream
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println("There are problems on saving data");
            Player.get_SaveFile().setWritable(false);
        }
        Player.get_SaveFile().setWritable(false);
        System.out.println("File saved");
    }

    /**
     * This method makes load of the game by reading save file, line by line
     *
     * @returns {@link Hero} с параметрами считанными из файла сохранения
     * @since 0.0.2
     */
    static void do_Load(File fileToLoad) {
        final boolean accept = _Accept();
        if (accept) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileToLoad));
                //What parameters to load
                String[] HeroParams = br.readLine().split(" ");  //All hero params
                String activeQuest = br.readLine();
                String questList = br.readLine();
                String[] activeArmor = br.readLine().split(" ");
                String[] activeWeapon = br.readLine().split(" ");

                ///Game options
                String isAutoSaveTheGame = br.readLine();
                String mapArea = br.readLine();
                String gameSaveFileName = br.readLine();
                short heroPosition = Short.parseShort(br.readLine());
                ///Game options

                Player.set_Person(Integer.parseInt(HeroParams[8]));

                int doubleMapArea = Integer.parseInt(mapArea) * Integer.parseInt(mapArea);  //mapArea * mapArea
                final ArrayList<int[]> afterLoadMap = new ArrayList<>(doubleMapArea);
                for (short i = 0; i < doubleMapArea; i++) {

                    int[] emptyBlock = new int[]{0, 0, 0, 0};
                    String[] nextBlock = br.readLine().split(", ");  // прочитанная строка из сохранения

                    for (String str : nextBlock) {
                        int index = Arrays.stream(nextBlock).toList().indexOf(str);
                        if (str.equals("1") && index == 3) {  //для битых блоков карты
                            emptyBlock[index] = 0;

                        } else if (str.equals("1")) {
                            emptyBlock[index] = 1;

                        } else {
                            emptyBlock[index] = 0;
                        }
                    }
                    afterLoadMap.add(emptyBlock);
                }
                afterLoadMap.get(heroPosition)[3] = 1;  ///проставление позиции героя после загрузки

                ///Hero Params
                if (activeArmor.equals("null") != true) {
                    switch (activeArmor[2]) {
                        case "Cloth":
                            Player.get_Person().putOnArmor(new ClothArmor(activeArmor[0],
                                    Integer.parseInt(activeArmor[1])));
                            break;
                        case "Iron":
                            Player.get_Person().putOnArmor(new IronArmor(activeArmor[0],
                                    Integer.parseInt(activeArmor[1])));
                            break;
                        case "Leather":
                            Player.get_Person().putOnArmor(new LeatherArmor(activeArmor[0],
                                    Integer.parseInt(activeArmor[1])));
                            break;
                    }
                }
                if (activeWeapon.equals("null") != true) {
                    switch (activeWeapon[2]) {
                        case "Bo":
                            Player.get_Person().putOnWeapon(new Bo(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Cathars":
                            Player.get_Person().putOnWeapon(new Cathars(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Chakram":
                            Player.get_Person().putOnWeapon(new Chakram(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Knife":
                            Player.get_Person().putOnWeapon(new Knife(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Mace":
                            Player.get_Person().putOnWeapon(new Mace(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Sword":
                            Player.get_Person().putOnWeapon(new Sword(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                    }
                }
                if (!activeQuest.equals("null")) {
                    Player.get_Person().setActiveQuest(activeQuest);
                }
                if (!questList.equals("null")) {
                    Player.get_Person().addToQuestList(questList);
                }
                Player.get_Person().setName(HeroParams[0]);  // name
                Player.get_Person().setHealth(Integer.parseInt(HeroParams[1]));
                Player.get_Person().setArmor(Integer.parseInt(HeroParams[2]));       //Armor
                Player.get_Person().setAttack(Integer.parseInt(HeroParams[3]));
                if (HeroParams[4].equals("true")) {
                    Player.get_Person().setMagic(true);
                } else {  ///Magic
                    Player.get_Person().setMagic(false);
                }
                Player.get_Person().setResistance(Integer.parseInt(HeroParams[5]));
                Player.get_Person().setMana(Integer.parseInt(HeroParams[6]));
                Player.get_Person().setExperience(Integer.parseInt(HeroParams[7]));

                ///Game params
                MapWidth = Integer.parseInt(mapArea);
                MAP = afterLoadMap;
                Player.set_SaveFile(gameSaveFileName);
                Player.set_IsAutoSave(Boolean.parseBoolean(isAutoSaveTheGame));

                ///heroPosition
                Player.set_HeroLocation(heroPosition);
                br.close();

            } catch (IOException e) {
                e.getStackTrace();
                System.out.println("Load failed");
            }
            System.out.println("File loaded");
        }
    }
}
