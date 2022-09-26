/**
 * @author  Mariana and Sarah
 * @version 2022.09.25
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Tips tips = new Tips();
    private Key key = new Key();
    private Integer num_Key = key.getKey();

    
    /**
     *
     */
    public void printTips() {
        //int num_Key = key.getKey();
        tips.Tips1(num_Key);
        System.out.println();
        System.out.println("Dica: ");
        System.out.println(tips.getR());
        System.out.println();
    }

    public void Local(Integer num_Key, Room currentRoom) {
        
        switch (num_Key) {
            case 0: 
                if ((currentRoom.getShortDescription()).equalsIgnoreCase("na Didática")){ 
                    Saindo();
                }
                break;
            case 1:
                if ((currentRoom.getShortDescription()).equalsIgnoreCase("na Didática")){ 
                    Saindo();
                }
                break;
            case 2:
                if ((currentRoom.getShortDescription()).equalsIgnoreCase("no Dcomp")){ 
                    Saindo();
                }
                break;
            case 3:
                if ((currentRoom.getShortDescription()).equalsIgnoreCase("no Centro de Vivência")){ 
                    Saindo();
                }
                break;
            case 4:
                if ((currentRoom.getShortDescription()).equalsIgnoreCase("no CCEB")){ 
                    Saindo();
                }
                break;
            case 5:
                if ((currentRoom.getShortDescription()).equalsIgnoreCase("no CCET")){ 
                    Saindo();
                }
                break;
            case 6:
                if ((currentRoom.getShortDescription()).equalsIgnoreCase("na Reitoria")){ 
                    Saindo();
                }   
                break;
            case 7: 
                if ((currentRoom.getShortDescription()).equalsIgnoreCase("no Resun")){ 
                    Saindo();
                }
                break;
            case 8:
                if ((currentRoom.getShortDescription()).equalsIgnoreCase("na Bicen")){ 
                    Saindo();
                }
                break;
            default:
                System.out.println("Erro na associação da chave aos locais!");
        }
    }

    public void Saindo(){
        //Room currentRoom;
        System.out.println("A chave estava "+currentRoom.getShortDescription()+". \nParabéns, você encontrou a chave!!!!!!!!!");
        System.out.println();
        System.out.println("------------------|Fim de Jogo.|-------------------");
        System.out.println();
        System.exit(0);
    }

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        //new Tips();
        new Key();
        createRooms();
        parser = new Parser();
        
    }
    /**
     * Create all the rooms and link their exits together.
     */

    private void createRooms()
    {
        Room entrada, dcomp, centViven, cceb, ccte, did, reit, res, bicen;

        // create the rooms
        entrada = new Room("na entrada da UFS");
        did = new Room("na Didática");
        dcomp = new Room("no Dcomp");
        centViven = new Room("no Centro de Vivência");
        cceb = new Room("no CCEB");
        ccte = new Room("no CCET");
        reit = new Room("na Reitoria");
        res = new Room("no Resun");
        bicen = new Room("na Bicen");   
        
        
        //saida = new Room("Para");
        // initialise room exits
        entrada.setExit("sul", did);
        entrada.setExit("leste",dcomp);

        did.setExit("leste", centViven);
        did.setExit("oeste", res);
        did.setExit("sul", reit);
        did.setExit("norte", entrada);

        dcomp.setExit("leste", entrada);
        dcomp.setExit("sul", centViven);

        centViven.setExit("norte", dcomp);
        centViven.setExit("sul", cceb);
        centViven.setExit("oeste", did);

        cceb.setExit("norte", centViven);
        cceb.setExit("sul",ccte);
        cceb.setExit("oeste", reit);       
        
        ccte.setExit("norte", cceb);
        
        reit.setExit("norte", did);
        reit.setExit("leste",cceb);
        reit.setExit("oeste", bicen);

        res.setExit("leste", did);
        res.setExit("sul",bicen);

        bicen.setExit("norte",res);
        bicen.setExit("leste",reit);

        currentRoom = entrada;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            printTips();
            Local(num_Key, currentRoom);
            System.out.println();
        }
        System.out.println();
        System.out.println("------------------|Fim de Jogo.|-------------------");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------|Seja bem-vindo!|-------------------");
        System.out.println();
        System.out.println("Este jogo da procura da chave é uma tremenda aventura.");
        System.out.println("Procurando a chave nas didáticas da UFS!");
        System.out.println();
        System.out.println("Digite '" + CommandWord.HELP + "' se você precisar sair.");
        System.out.println();
        System.out.println("Comandos do jogo:");
        parser.showCommands();

        printTips();

        System.out.println(currentRoom.getLongDescription());
        System.out.println();
        System.out.println("------------------------------------------------------");
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Não estou entendendo, tente novamente!");
                exit();

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    private void exit() {
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println();
        System.out.println("Você está perdido?");
        System.out.println("A universidade realmente é um labirinto!");
        System.out.println();
        System.out.println("Abaixo alguns comandos que podem ajudar:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println();
            System.out.println("Não é possível ir para esta direção!");
            System.out.println("Atente-se ao mapa do jogo!");
            System.out.println();
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Deseja sair?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
