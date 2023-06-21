package Main;

import java.io.File;

public final class SaveFile extends File {

    private static final String saveDirectory = "/home/kirill/IdeaProjects/My_game/src/Saving_Files/";
    private static String saveFileName = null;

    SaveFile(String save_Name) {
        super(saveDirectory + save_Name);
        saveFileName = save_Name;
    }

    static int getSaveDirectoryLength() {
        return saveDirectory.length();
    }
    static String getSaveDirectory() {return saveDirectory;}

    static int getSaveNameLength() {
        return saveFileName.length();
    }
}