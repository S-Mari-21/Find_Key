/**
 * @author  Mariana and Sarah
 * @version 2022.09.25
 */
import java.util.Random;
public class Key {
    //private Room currentRoom;
    
    //Gerando o local da chave:
    Random numKey = new Random();
    int posicao = numKey.nextInt(8);

    //Get
    public Integer getKey() {
        return posicao;
    }

}
