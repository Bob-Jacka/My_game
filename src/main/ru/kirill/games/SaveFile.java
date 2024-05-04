package ru.kirill.games;

import java.io.File;

final class SaveFile extends File {

    private static final String saveDirectory = "/home/kirill/IdeaProjects/My_game/src/Saving_Files/";

    SaveFile(String save_Name) {
        super(saveDirectory + save_Name);
    }

    static int getSaveDirectoryLength() {
        return saveDirectory.length();
    }

    static String getSaveDirectory() {
        return saveDirectory;
    }
}