/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Mariana and Sarah
 * @version 2022.09.25
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("ir"), QUIT("sair"), HELP("ajuda"), UNKNOWN("?");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
