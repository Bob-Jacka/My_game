package Main;

import java.io.File;

public final class SaveFile extends File {

    private static final String saveDirectory = "/home/kirill/IdeaProjects/My_game/src/Saving_Files/";
    private static final String saveExtension = ".txt";

    public SaveFile(String save_Name) {
        super(saveDirectory + save_Name + saveExtension);
    }
}
